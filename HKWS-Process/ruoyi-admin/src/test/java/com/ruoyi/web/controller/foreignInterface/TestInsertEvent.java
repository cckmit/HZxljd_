package com.ruoyi.web.controller.foreignInterface;

import com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo;
import com.ruoyi.system.service.HkEarlyWarning.HkEventService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.controller.foreignInterface
 * @ClassName: TestInsertEvent
 * @Author: guohailong
 * @Description: 手动插入事件数据
 * @Date: 2021/4/23 21:10
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestInsertEvent {

    @Autowired
    private HkEventService hkEventService;

    @Test
    public void insertData(){

        for (int id = 525; id<532;id++){
            HkEventInfo eventInfo = new HkEventInfo();
            eventInfo.setId(id);
            eventInfo.setCreateTime(new Date(2021-1900,3,7,9,51));
            eventInfo.setUpdateTime(new Date(2021-1900,3,7,9,51));
            eventInfo.setReportTime("2021/04/07 09:51:07");
            eventInfo.setEventCreateTime("2021-04-07");
            String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");

            eventInfo.setEventId(uuid);
            eventInfo.setComponentId("1004");
            eventInfo.setEventIndexCode(System.currentTimeMillis()+"");
            eventInfo.setEventTitle("电瓶车充电");

            eventInfo.setEventType("4");
            eventInfo.setEventTypeName("其他类型");
            eventInfo.setEventImage("https://qhz.hhkj1688.cn:8389/file-fk/ding_img/20fd05706068147dc31f9857eb6cef9.jpg");
            eventInfo.setEventStatus(3);
            eventInfo.setEventStatusName("中心处置");
            eventInfo.setEventAlertStatus(6);
            eventInfo.setEventAlertStatusName("完结");
            eventInfo.setReportType(2);
            eventInfo.setReportTypeName("人工上报");
            eventInfo.setRiskLevel("1");

            eventInfo.setRegionIndexCode("1792996");
            eventInfo.setRegionName("鹤亭社区");
            eventInfo.setEventAddress("青山湖街道鹤亭社区168号");
            eventInfo.setLongitude("119.82320971232811");
            eventInfo.setLatitude("30.247278109453678");

            eventInfo.setEventRead(1);
            hkEventService.addHKEventInfo(eventInfo);
        }

/*

        <insert id="addHKEventInfo" parameterType="com.ruoyi.system.domain.HkEarlyWarning.HkEventInfo" >
                insert into hk_event_info
		<trim prefix="(" suffix=")" suffixOverrides=",">
			<if test="id != null  and id != ''">id,</if>
			<if test="eventId != null  and eventId != ''">event_id,</if>
			<if test="componentId != null  and componentId != ''">component_id,</if>
			<if test="eventIndexCode != null  and eventIndexCode != ''">event_index_code,</if>
			<if test="eventTitle != null  and eventTitle != ''">event_title,</if>
			<if test="reportTime != null  and reportTime != ''">report_time,</if>
			<if test="eventType != null  and eventType != ''">event_type,</if>
			<if test="eventTypeName != null  and eventTypeName != ''">event_type_name,</if>
			<if test="eventSubStatus != null  and eventSubStatus != ''">event_sub_status,</if>
			<if test="eventSubStatusName != null  and eventSubStatusName != ''">event_sub_status_name,</if>
			<if test="eventCategory != null ">event_category,</if>
			<if test="eventCategoryName != null  and eventCategoryName != ''">event_category_name,</if>
			<if test="eventSource != null ">event_source,</if>
			<if test="eventSourceName != null  and eventSourceName != ''">event_source_name,</if>
			<if test="eventImage != null  and eventImage != ''">event_image,</if>
			<if test="eventThumbnailImage != null  and eventThumbnailImage != ''">event_thumbnail_image,</if>
			<if test="storageId != null  and storageId != ''">storage_id,</if>
			<if test="eventStatus != null ">event_status,</if>
			<if test="eventStatusName != null  and eventStatusName != ''">event_status_name,</if>
			<if test="eventAlertStatus != null ">event_alert_status,</if>
			<if test="eventAlertStatusName != null  and eventAlertStatusName != ''">event_alert_status_name,</if>

			<if test="reportType != null ">report_type,</if>
			<if test="reportTypeName != null  and reportTypeName != ''">report_type_name,</if>
			<if test="lawEnforcementType != null ">law_enforcement_type,</if>
			<if test="lawEnforcementTypeName != null  and lawEnforcementTypeName != ''">law_enforcement_type_name,</if>
			<if test="isView != null ">is_view,</if>
			<if test="timeOut != null ">time_out,</if>
			<if test="riskLevel != null  and riskLevel != ''">risk_level,</if>
			<if test="currentProcessorId != null  and currentProcessorId != ''">current_processor_id,</if>
			<if test="currentProcessorName != null  and currentProcessorName != ''">current_processor_name,</if>
			<if test="eventUpdateTime != null  and eventUpdateTime != ''">event_update_time,</if>
			<if test="eventCreateTime != null  and eventCreateTime != ''">event_create_time,</if>
			<if test="geometry != null  and geometry != ''">geometry,</if>
			<if test="reportPersonId != null  and reportPersonId != ''">report_person_id,</if>
			<if test="reportPersonName != null  and reportPersonName != ''">report_person_name,</if>
			<if test="reportPersonRealName != null  and reportPersonRealName != ''">report_person_real_name,</if>
			<if test="reportPersonPhone != null  and reportPersonPhone != ''">report_person_phone,</if>
			<if test="cameraIndexCode != null  and cameraIndexCode != ''">camera_index_code,</if>
			<if test="cameraName != null  and cameraName != ''">camera_name,</if>
			<if test="cameraTypeCode != null  and cameraTypeCode != ''">camera_type_code,</if>
			<if test="responsibilitySubject != null  and responsibilitySubject != ''">responsibility_subject,</if>
			<if test="regionIndexCode != null  and regionIndexCode != ''">region_index_code,</if>
			<if test="regionName != null  and regionName != ''">region_name,</if>
			<if test="placeType != null  and placeType != ''">place_type,</if>
			<if test="placeTypeName != null  and placeTypeName != ''">place_type_name,</if>
			<if test="placeIndexCode != null  and placeIndexCode != ''">place_index_code,</if>
			<if test="placeName != null  and placeName != ''">place_name,</if>
			<if test="companyLegalPerson != null  and companyLegalPerson != ''">company_legal_person,</if>
			<if test="eventAddress != null  and eventAddress != ''">event_address,</if>
			<if test="creditUnionCode != null  and creditUnionCode != ''">credit_union_code,</if>
			<if test="companyContactInformation != null  and companyContactInformation != ''">company_contact_information,</if>
			<if test="gridName != null  and gridName != ''">grid_name,</if>
			<if test="gridMan != null  and gridMan != ''">grid_man,</if>
			<if test="patrolTeam != null  and patrolTeam != ''">patrol_team,</if>
			<if test="patrolTeamPhone != null  and patrolTeamPhone != ''">patrol_team_phone,</if>
			<if test="patrolTeam2 != null  and patrolTeam2 != ''">patrol_team2,</if>
			<if test="patrolTeam2Phone != null  and patrolTeam2Phone != ''">patrol_team2_phone,</if>
			<if test="gridCommunity != null  and gridCommunity != ''">grid_community,</if>
			<if test="gridContactInformation != null  and gridContactInformation != ''">grid_contact_information,</if>
			<if test="longitude != null  and longitude != ''">longitude,</if>
			<if test="latitude != null  and latitude != ''">latitude,</if>
			<if test="routingAddress != null  and routingAddress != ''">routing_address,</if>
			<if test="eventRemarks != null  and eventRemarks != ''">event_remarks,</if>
			<if test="extendInt1 != null ">extend_int1,</if>
			<if test="extendInt2 != null ">extend_int2,</if>
			<if test="extendInt3 != null ">extend_int3,</if>
			<if test="extendStr1 != null  and extendStr1 != ''">extend_str1,</if>
			<if test="extendStr2 != null  and extendStr2 != ''">extend_str2,</if>
			<if test="extendStr3 != null  and extendStr3 != ''">extend_str3,</if>

        create_time,
			<if test="eventAlertStatus == 6">update_time,</if>
			<if test="procdefType != null  and procdefType != ''">procdef_type,</if>
			<if test="eventRead != null ">event_read,</if>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
			<if test="id != null  and id != ''">#{id},</if>
			<if test="eventId != null  and eventId != ''">#{eventId},</if>
			<if test="componentId != null  and componentId != ''">#{componentId},</if>
			<if test="eventIndexCode != null  and eventIndexCode != ''">#{eventIndexCode},</if>
			<if test="eventTitle != null  and eventTitle != ''">#{eventTitle},</if>
			<if test="reportTime != null  and reportTime != ''">#{reportTime},</if>
			<if test="eventType != null  and eventType != ''">#{eventType},</if>
			<if test="eventTypeName != null  and eventTypeName != ''">#{eventTypeName},</if>
			<if test="eventSubStatus != null  and eventSubStatus != ''">#{eventSubStatus},</if>
			<if test="eventSubStatusName != null  and eventSubStatusName != ''">#{eventSubStatusName},</if>
			<if test="eventCategory != null ">#{eventCategory},</if>
			<if test="eventCategoryName != null  and eventCategoryName != ''">#{eventCategoryName},</if>
			<if test="eventSource != null ">#{eventSource},</if>
			<if test="eventSourceName != null  and eventSourceName != ''">#{eventSourceName},</if>
			<if test="eventImage != null  and eventImage != ''">#{eventImage},</if>
			<if test="eventThumbnailImage != null  and eventThumbnailImage != ''">#{eventThumbnailImage},</if>
			<if test="storageId != null  and storageId != ''">#{storageId},</if>
			<if test="eventStatus != null ">#{eventStatus},</if>
			<if test="eventStatusName != null  and eventStatusName != ''">#{eventStatusName},</if>
			<if test="eventAlertStatus != null ">#{eventAlertStatus},</if>
			<if test="eventAlertStatusName != null  and eventAlertStatusName != ''">#{eventAlertStatusName},</if>

			<if test="reportType != null ">#{reportType},</if>
			<if test="reportTypeName != null  and reportTypeName != ''">#{reportTypeName},</if>
			<if test="lawEnforcementType != null ">#{lawEnforcementType},</if>
			<if test="lawEnforcementTypeName != null  and lawEnforcementTypeName != ''">#{lawEnforcementTypeName},</if>
			<if test="isView != null ">#{isView},</if>
			<if test="timeOut != null ">#{timeOut},</if>
			<if test="riskLevel != null  and riskLevel != ''">#{riskLevel},</if>
			<if test="currentProcessorId != null  and currentProcessorId != ''">#{currentProcessorId},</if>
			<if test="currentProcessorName != null  and currentProcessorName != ''">#{currentProcessorName},</if>
			<if test="eventUpdateTime != null  and eventUpdateTime != ''">#{eventUpdateTime},</if>
			<if test="eventCreateTime != null  and eventCreateTime != ''">#{eventCreateTime},</if>
			<if test="geometry != null  and geometry != ''">#{geometry},</if>
			<if test="reportPersonId != null  and reportPersonId != ''">#{reportPersonId},</if>
			<if test="reportPersonName != null  and reportPersonName != ''">#{reportPersonName},</if>
			<if test="reportPersonRealName != null  and reportPersonRealName != ''">#{reportPersonRealName},</if>
			<if test="reportPersonPhone != null  and reportPersonPhone != ''">#{reportPersonPhone},</if>
			<if test="cameraIndexCode != null  and cameraIndexCode != ''">#{cameraIndexCode},</if>
			<if test="cameraName != null  and cameraName != ''">#{cameraName},</if>
			<if test="cameraTypeCode != null  and cameraTypeCode != ''">#{cameraTypeCode},</if>
			<if test="responsibilitySubject != null  and responsibilitySubject != ''">#{responsibilitySubject},</if>
			<if test="regionIndexCode != null  and regionIndexCode != ''">#{regionIndexCode},</if>
			<if test="regionName != null  and regionName != ''">#{regionName},</if>
			<if test="placeType != null  and placeType != ''">#{placeType},</if>
			<if test="placeTypeName != null  and placeTypeName != ''">#{placeTypeName},</if>
			<if test="placeIndexCode != null  and placeIndexCode != ''">#{placeIndexCode},</if>
			<if test="placeName != null  and placeName != ''">#{placeName},</if>
			<if test="companyLegalPerson != null  and companyLegalPerson != ''">#{companyLegalPerson},</if>
			<if test="eventAddress != null  and eventAddress != ''">#{eventAddress},</if>
			<if test="creditUnionCode != null  and creditUnionCode != ''">#{creditUnionCode},</if>
			<if test="companyContactInformation != null  and companyContactInformation != ''">#{companyContactInformation},</if>
			<if test="gridName != null  and gridName != ''">#{gridName},</if>
			<if test="gridMan != null  and gridMan != ''">#{gridMan},</if>
			<if test="patrolTeam != null  and patrolTeam != ''">#{patrolTeam},</if>
			<if test="patrolTeamPhone != null  and patrolTeamPhone != ''">#{patrolTeamPhone},</if>
			<if test="patrolTeam2 != null  and patrolTeam2 != ''">#{patrolTeam2},</if>
			<if test="patrolTeam2Phone != null  and patrolTeam2Phone != ''">#{patrolTeam2Phone},</if>
			<if test="gridCommunity != null  and gridCommunity != ''">#{gridCommunity},</if>
			<if test="gridContactInformation != null  and gridContactInformation != ''">#{gridContactInformation},</if>
			<if test="longitude != null  and longitude != ''">#{longitude},</if>
			<if test="latitude != null  and latitude != ''">#{latitude},</if>
			<if test="routingAddress != null  and routingAddress != ''">#{routingAddress},</if>
			<if test="eventRemarks != null  and eventRemarks != ''">#{eventRemarks},</if>
			<if test="extendInt1 != null ">#{extendInt1},</if>
			<if test="extendInt2 != null ">#{extendInt2},</if>
			<if test="extendInt3 != null ">#{extendInt3},</if>
			<if test="extendStr1 != null  and extendStr1 != ''">#{extendStr1},</if>
			<if test="extendStr2 != null  and extendStr2 != ''">#{extendStr2},</if>
			<if test="extendStr3 != null  and extendStr3 != ''">#{extendStr3},</if>
			#{createTime},
			<if test="eventAlertStatus == 6">#{updateTime},</if>
			<if test="procdefType != null  and procdefType != ''">#{procdefType},</if>
			<if test="eventRead != null ">#{eventRead},</if>
		</trim>
	</insert>
*/



    }

}
