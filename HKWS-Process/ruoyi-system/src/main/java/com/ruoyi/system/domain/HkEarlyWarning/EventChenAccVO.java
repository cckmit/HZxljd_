package com.ruoyi.system.domain.HkEarlyWarning;

public class EventChenAccVO{
    private String title;
    private Integer count;
    private Integer percentage;
    private String Accounted;
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

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    public String getAccounted() {
        return Accounted;
    }

    public void setAccounted(String accounted) {
        Accounted = accounted;
    }
}
