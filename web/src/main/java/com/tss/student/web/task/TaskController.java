package com.tss.student.web.task;

import com.github.pagehelper.PageInfo;
import com.tss.basic.site.argumentresolver.JsonParam;
import com.tss.basic.site.user.annotation.StudentLoginUser;
import com.tss.basic.site.user.annotation.StudentUser;
import com.tss.student.interfaces.task.TaskInterface;
import com.tss.student.interfaces.task.vo.StudentTaskReqVO;
import com.tss.student.interfaces.task.vo.StudentTaskRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author: MQG
 * @date: 2018/11/28
 */
@Api(value = "实验任务模块", tags = "TaskController", description = "实验任务模块")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskInterface taskInterface;

    @ApiOperation(value = "实验任务列表", notes = "实验任务列表（分页）")
    @RequestMapping(value = "/getTaskList", method = RequestMethod.POST)
    public PageInfo<StudentTaskRespVO> getTaskList(@JsonParam(validation = true) StudentTaskReqVO param, @ApiIgnore @StudentLoginUser StudentUser studentUser) {
        return taskInterface.getStudentTaskList(param);
    }
}
