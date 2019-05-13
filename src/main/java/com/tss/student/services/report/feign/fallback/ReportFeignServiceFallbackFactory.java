package com.tss.student.services.report.feign.fallback;

import com.github.pagehelper.PageInfo;
import com.tss.student.interfaces.report.vo.*;
import com.tss.student.interfaces.task.vo.StudentTaskReqVO;
import com.tss.student.interfaces.task.vo.StudentTaskRespVO;
import com.tss.student.services.report.feign.ReportFeignService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ReportFeignServiceFallbackFactory implements FallbackFactory<ReportFeignService> {
    private static final Logger LOG = LoggerFactory.getLogger(ReportFeignServiceFallbackFactory.class);

    @Override
    public ReportFeignService create(Throwable cause) {
        return new ReportFeignService() {

            @Override
            public PageInfo<StudentTaskRespVO> getStudentTaskList(StudentTaskReqVO param) {
                cause.printStackTrace();
                return null;
            }

            @Override
            public PageInfo<StudentReportRespVO> getStudentReportList(StudentReportReqVO param) {
                cause.printStackTrace();
                return null;
            }

            @Override
            public Long studentUploadReport(StudentUploadReportReqVO param) {
                cause.printStackTrace();
                return -1L;
            }

            @Override
            public GetStudentReportDetailByTaskIdRespVO getReportDetailByTaskId(GetStudentReportDetailByTaskIdReqVO param) {
                cause.printStackTrace();
                return null;
            }

            @Override
            public GetStudentReportDetailByReportIdRespVO getReportDetailByReportId(Long reportId) {
                cause.printStackTrace();
                return null;
            }
        };
    }

}
