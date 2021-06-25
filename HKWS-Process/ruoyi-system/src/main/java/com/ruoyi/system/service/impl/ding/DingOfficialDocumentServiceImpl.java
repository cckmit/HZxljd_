package com.ruoyi.system.service.impl.ding;

import com.ruoyi.system.domain.HkOfficialDocument;
import com.ruoyi.system.domain.HkUserDocument;
import com.ruoyi.system.mapper.ding.DingOfficialDocumentMapper;
import com.ruoyi.system.mapper.ding.DingUserDocumentMapper;
import com.ruoyi.system.service.ding.DingOfficialDocumentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.service.impl.ding
 * @ClassName: DingOfficialDocumentServiceImpl
 * @Author: guohailong
 * @Description: 浙政钉-公文服务
 * @Date: 2021/3/10 20:51
 * @Version: 1.0
 */
@Service
public class DingOfficialDocumentServiceImpl implements DingOfficialDocumentService {

    @Resource
    private DingOfficialDocumentMapper dingOfficialDocumentMapper;

    @Resource
    private DingUserDocumentMapper dingUserDocumentMapper;

    @Override
    public List<HkOfficialDocument> getDocumentList() {
        return dingOfficialDocumentMapper.getDocumentList();
    }


    @Override
    public HkOfficialDocument getDocumentDetail(Long id) {
        return dingOfficialDocumentMapper.getDocumentDetail(id);
    }

    /**
     * 调用接口查询存在的话,则删除当前关系.取消收藏.若不存在.则添加对应关系.收藏成功
     * 收藏成功 返回10
     * 取消成功 返回20
     *
     * @param uid
     * @param did
     * @return
     */
    @Override
    @Transactional
    public int collection(Long uid, Long did) {
        HkUserDocument userDocument = dingUserDocumentMapper.selectUserDocumentByUidAndDid(uid, did);
        try {
            if (null == userDocument) {
                HkUserDocument hkUserDocument = new HkUserDocument();
                hkUserDocument.setUserId(uid);
                hkUserDocument.setDocumentId(did);
                int result = dingUserDocumentMapper.insertHkUserDocument(hkUserDocument);
                if (result == 1) {
                    return 10;
                } else {
                    throw new RuntimeException("收藏失败");
                }
            } else {
                int result = dingUserDocumentMapper.deleteUserDocumentByUidAndDid(uid, did);
                if (result == 1) {
                    return 20;
                } else {
                    throw new RuntimeException("取消失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }
    }

    @Override
    public boolean checkIsCollect(Long uid, long did) {
        HkUserDocument userDocument = dingUserDocumentMapper.selectUserDocumentByUidAndDid(uid, did);
        if (userDocument == null) {
            return false;
        } else {
            return true;
        }
    }
}
