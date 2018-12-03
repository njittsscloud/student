package com.tss.student.services.report.feign;

import com.github.pagehelper.PageInfo;
import com.tss.student.interfaces.report.vo.*;
import com.tss.student.interfaces.task.vo.StudentTaskReqVO;
import com.tss.student.interfaces.task.vo.StudentTaskRespVO;
import com.tss.student.services.report.feign.fallback.ReportFeignServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: MQG
 * @date: 2018/11/28
 */
@FeignClient(value = "${report.serviceId}", fallbackFactory = ReportFeignServiceFallbackFactory.class)
public interface ReportFeignService {

    @RequestMapping(value = "/report/student/getStudentReportList", method = RequestMethod.POST)
    PageInfo<StudentTaskRespVO> getStudentTaskList(StudentTaskReqVO param);

    @RequestMapping(value = "/report/student/getStudentReportList", method = RequestMethod.POST)
    PageInfo<StudentReportRespVO> getStudentReportList(StudentReportReqVO param);

    @RequestMapping(value = "/report/student/upload", method = RequestMethod.POST)
    Long studentUploadReport(StudentUploadReportReqVO param);

    @RequestMapping(value = "/report/student/getDetailByTaskId", method = RequestMethod.POST)
    GetStudentReportDetailByTaskIdRespVO getReportDetailByTaskId(GetStudentReportDetailByTaskIdReqVO param);

    @RequestMapping(value = "/report/student/getDetailByReportId/{reportId}", method = RequestMethod.GET)
    GetStudentReportDetailByReportIdRespVO getReportDetailByReportId(@PathVariable("reportId") Long reportId);
}