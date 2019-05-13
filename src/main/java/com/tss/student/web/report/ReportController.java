package com.tss.student.web.report;

import com.github.pagehelper.PageInfo;
import com.tss.basic.site.argumentresolver.JsonParam;
import com.tss.basic.site.user.annotation.StudentLoginUser;
import com.tss.basic.site.user.annotation.StudentUser;
import com.tss.student.interfaces.report.ReportInterface;
import com.tss.student.interfaces.report.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author: MQG
 * @date: 2018/12/3
 */
@Api(value = "实验报告模块", tags = "ReportController", description = "实验报告模块")
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportInterface reportInterface;

    @ApiOperation(value = "学生查询报告列表", notes = "学生查询报告列表")
    @RequestMapping(value = "/getStudentReportList", method = RequestMethod.POST)
    public PageInfo<StudentReportRespVO> getStudentReportList(@JsonParam(validation = true) StudentReportReqVO param, 
                                                              @ApiIgnore @StudentLoginUser StudentUser loginUser) {
        param.setStudentId(loginUser.getStudentId());
        return reportInterface.getStudentReportList(param);
    }

    @ApiOperation(value = "上传报告", notes = "上传报告")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Long getStudentReportList(@JsonParam(validation = true) StudentUploadReportReqVO param,
                                     @ApiIgnore @StudentLoginUser StudentUser loginUser) {
        param.setStudentId(loginUser.getStudentId());
        param.setStudentName(loginUser.getStudentName());
        param.setStudentNo(loginUser.getStudentNo());
        param.setClassId(loginUser.getClassId());
        param.setClassName(loginUser.getClassName());
        return reportInterface.studentUploadReport(param);
    }

    @ApiOperation(value = "根据实验任务id获取报告详情", notes = "根据实验任务id获取报告详情（新增页面）")
    @RequestMapping(value = "/getDetailByTaskId", method = RequestMethod.POST)
    public GetStudentReportDetailByTaskIdRespVO getReportDetailByTaskId(@JsonParam(validation = true) GetStudentReportDetailByTaskIdReqVO param,
                                                                        @ApiIgnore @StudentLoginUser StudentUser loginUser) {
        param.setStudentId(loginUser.getStudentId());
        param.setStudentName(loginUser.getStudentName());
        param.setStudentNo(loginUser.getStudentNo());
        param.setClassId(loginUser.getClassId());
        param.setClassName(loginUser.getClassName());
        return reportInterface.getReportDetailByTaskId(param);
    }

    @ApiOperation(value = "根据报告id查询报告详情", notes = "根据报告id查询报告详情（编辑、详情页面）")
    @RequestMapping(value = "/getDetailByReportId/{reportId}", method = RequestMethod.GET)
    public GetStudentReportDetailByReportIdRespVO getReportDetailByReportId(@PathVariable Long reportId, 
                                                                            @ApiIgnore @StudentLoginUser StudentUser loginUser) {
        return reportInterface.getReportDetailByReportId(reportId);
    }
}
