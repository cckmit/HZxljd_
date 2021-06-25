package com.ruoyi.web.controller.common.utils;

public class TimeField{

        private String format;

        private String startTime;

        private String endTime;

        private String date;

        private Integer count;

        public TimeField(String format,String startTime,String endTime,String date){
            this.format = format;
            this.startTime = startTime;
            this.endTime = endTime;
            this.date = date;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}