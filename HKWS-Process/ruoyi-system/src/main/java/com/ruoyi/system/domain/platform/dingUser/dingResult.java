package com.ruoyi.system.domain.platform.dingUser;

/**
 * Copyright 2021 json.cn
 */
        import java.io.Serializable;
        import java.util.List;

/**
 * Auto-generated: 2021-05-24 15:31:49
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class dingResult implements Serializable {

    private boolean has_more;
    private List<dingUserList> list;
    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }
    public boolean getHas_more() {
        return has_more;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public List<dingUserList> getList() {
        return list;
    }

    public void setList(List<dingUserList> list) {
        this.list = list;
    }
}
