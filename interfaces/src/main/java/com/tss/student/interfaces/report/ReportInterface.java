package com.tss.student.interfaces.report;

import com.github.pagehelper.PageInfo;
import com.tss.student.interfaces.report.vo.*;

/**
 * @author: MQG
 * @date: 2018/12/3
 */
public interface ReportInterface {
    PageInfo<StudentReportRespVO> getStudentReportList(StudentReportReqVO param);

    Long studentUploadReport(StudentUploadReportReqVO param);

    GetStudentReportDetailByTaskIdRespVO getReportDetailByTaskId(GetStudentReportDetailByTaskIdReqVO param);

    GetStudentReportDetailByReportIdRespVO getReportDetailByReportId(Long reportId);
}
