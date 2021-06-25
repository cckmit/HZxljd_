package com.ruoyi.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.ruoyi.common.json.JSONObject;
import com.ruoyi.web.jwt.JWTUtil;
import com.ruoyi.web.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;


/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.config
 * @ClassName: JWTInterceptor
 * @Author: guohailong
 * @Description: 配置拦截器
 * @Date: 2021/3/13 2:22
 * @Version: 1.0
 */
public class JWTInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(JWTInterceptor.class);

    @Resource
    private JWTConfigProperties jwtConfigProperties;
    @Resource
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        logger.info("JWT拦截请求uri[{}],请求方式[{}}]", request.getRequestURI(), request.getMethod());
        /**
         * 这里是个坑，因为带请求带headers时，ajax会发送两次请求，
         * 第一次会发送OPTIONS请求，第二次才会发生get/post请求，所以要放行OPTIONS请求
         * 如果是OPTIONS请求，直接返回一个200状态码，说明可以正常访问
         */
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            // 放行OPTIONS请求
            return true;
        }
        if (jwtConfigProperties == null) {
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            jwtConfigProperties = (JWTConfigProperties) factory.getBean("JWTConfigProperties");
        }
        if (redisUtils == null) {
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
            redisUtils = (RedisUtils) factory.getBean("redisUtils");
        }
        boolean verify = false;
        //获取header中的token,前端请求Header中设置的token保持不变，校验有效性以缓存中的token为准
        String token = request.getHeader(jwtConfigProperties.getHeader());
        if (!StringUtils.isEmpty(token) && !"null".equals(token)) {
            String cacheToken = (String) redisUtils.get(jwtConfigProperties.getCachePrefix() + token);
            if (StringUtils.isEmpty(cacheToken)) {
//                logger.info("缓存中token已不存在.需重新登录");
                verify = false;
            } else {
                String userInfo = JWTUtil.getUserInfo(cacheToken);
                Algorithm algorithm = Algorithm.HMAC256(jwtConfigProperties.getSecret());
                JWTVerifier verifier = JWT.require(algorithm).build();
                try {
                    verifier.verify(cacheToken);
                    verify = true;
                } catch (TokenExpiredException tokenExpiredException) {
                    //token已过期,redis中保存的token并未过期.生成新的token更新缓存中的token,延长用户在线时间
//                    logger.info("token过期,重新生成token并更新缓存");
//                    String newToken = JWTUtil.sign(userInfo, jwtConfigProperties);
//                    redisUtils.set(jwtConfigProperties.getCachePrefix() + token, newToken, jwtConfigProperties.getExpire() * 2, TimeUnit.MILLISECONDS);
//                    verify = true;
                    verify = false;
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                    verify = false;
                }
            }
        } else {
//            logger.info("token缺失.需登录");
            verify = false;
        }
        // 验证token，如果验证失败就提示未授权需重新登录
        if (!verify) {
            //在重定向这里需要设置跨域，不然vue前端会报跨域问题
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                JSONObject res = new JSONObject();
                res.put("code", 401);
                res.put("msg", "Unauthorized");
                out = response.getWriter();
                out.append(res.toString());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(500);
                return false;
            }
        }
        return true;

    }
}
