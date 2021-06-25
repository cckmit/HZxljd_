package com.ruoyi.system.domain.platform.unifiedAdress.tongAdress;

/**
 * @author FanKaibiao
 * @date 2021-06-18-20:26
 */

import java.util.List;

/**
 * Auto-generated: 2021-06-18 20:23:41
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class ZheDate {

    private long hits;
    private int count;
    private List<ZheAddrList> addrList;
    public void setHits(long hits) {
        this.hits = hits;
    }
    public long getHits() {
        return hits;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

    public List<ZheAddrList> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<ZheAddrList> addrList) {
        this.addrList = addrList;
    }
}