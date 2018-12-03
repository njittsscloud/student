package com.tss.student.interfaces.report.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@ApiModel("根据实验任务id查询学生报告详情查询参数")
public class GetStudentReportDetailByTaskIdReqVO {

    @ApiModelProperty(value = "实验任务id", example = "1")
    @NotNull(message = "实验任务id不能为空")
    private Long taskId;
    
    @ApiModelProperty(value = "学生id", example = "1", hidden = true)
    private Long studentId;

    @ApiModelProperty(value = "学生姓名", example = "张三", hidden = true)
    private String studentName;

    @ApiModelProperty(value = "学号", example = "20181130001", hidden = true)
    private String studentNo;

    @ApiModelProperty(value = "班级id", example = "1", hidden = true)
    private Long classId;

    @ApiModelProperty(value = "班级名称", example = "测试班级", hidden = true)
    private String className;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
