package com.ruoyi.system.domain.HkEntity;


import java.io.Serializable;

/**
 * 事件上报方
 * @author: Lijiajia8
 * @date: 2020/4/30 11:10
 * @since: jdk1.8
 */
public class EventReportProviderDTO  implements Serializable {

    private ReportPerson reportPerson;

    private ReportDevice reportDevice;

    public ReportPerson getReportPerson() {
        return reportPerson;
    }

    public void setReportPerson(ReportPerson reportPerson) {
        this.reportPerson = reportPerson;
    }

    public ReportDevice getReportDevice() {
        return reportDevice;
    }

    public void setReportDevice(ReportDevice reportDevice) {
        this.reportDevice = reportDevice;
    }



    public static class ReportPerson  implements Serializable {
        /** 上报人id */
        private String reportPersonId;

        /** 上报人 */
        private String reportPersonName;

        /** 上报人真实姓名 */
        private String reportPersonRealName;

        /** 上报人手机号 */
        private String reportPersonPhone;

        public String getReportPersonId() {
            return reportPersonId;
        }

        public void setReportPersonId(String reportPersonId) {
            this.reportPersonId = reportPersonId;
        }

        public String getReportPersonName() {
            return reportPersonName;
        }

        public void setReportPersonName(String reportPersonName) {
            this.reportPersonName = reportPersonName;
        }

        public String getReportPersonRealName() {
            return reportPersonRealName;
        }

        public void setReportPersonRealName(String reportPersonRealName) {
            this.reportPersonRealName = reportPersonRealName;
        }

        public String getReportPersonPhone() {
            return reportPersonPhone;
        }

        public void setReportPersonPhone(String reportPersonPhone) {
            this.reportPersonPhone = reportPersonPhone;
        }
    }




    public static class ReportDevice  implements Serializable {
        /** 上报设备的id */
        private String cameraIndexCode;

        /** 上报设备的名称 */
        private String cameraName;

        public String getCameraIndexCode() {
            return cameraIndexCode;
        }

        public void setCameraIndexCode(String cameraIndexCode) {
            this.cameraIndexCode = cameraIndexCode;
        }

        public String getCameraName() {
            return cameraName;
        }

        public void setCameraName(String cameraName) {
            this.cameraName = cameraName;
        }
    }
}
