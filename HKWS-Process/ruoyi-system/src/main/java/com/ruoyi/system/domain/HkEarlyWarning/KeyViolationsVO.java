package com.ruoyi.system.domain.HkEarlyWarning;

public class KeyViolationsVO {
    private String title;
    private Integer count;
    private Integer sum;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getAccounted() {
        return accounted;
    }

    public void setAccounted(String accounted) {
        this.accounted = accounted;
    }

    private String accounted;
}
