package com.tss.student.services.report;

import com.github.pagehelper.PageInfo;
import com.tss.student.interfaces.report.ReportInterface;
import com.tss.student.interfaces.report.vo.*;
import com.tss.student.services.report.feign.ReportFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: MQG
 * @date: 2018/12/3
 */
@Service
public class ReportService implements ReportInterface {
    
    @Autowired
    private ReportFeignService reportFeignService;
    
    
    @Override
    public PageInfo<StudentReportRespVO> getStudentReportList(StudentReportReqVO param) {
        return reportFeignService.getStudentReportList(param);
    }

    @Override
    public Long studentUploadReport(StudentUploadReportReqVO param) {
        return reportFeignService.studentUploadReport(param);
    }

    @Override
    public GetStudentReportDetailByTaskIdRespVO getReportDetailByTaskId(GetStudentReportDetailByTaskIdReqVO param) {
        return reportFeignService.getReportDetailByTaskId(param);
    }

    @Override
    public GetStudentReportDetailByReportIdRespVO getReportDetailByReportId(Long reportId) {
        return reportFeignService.getReportDetailByReportId(reportId);
    }
}
