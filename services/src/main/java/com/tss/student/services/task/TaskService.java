package com.tss.student.services.task;

import com.github.pagehelper.PageInfo;
import com.tss.student.interfaces.task.TaskInterface;
import com.tss.student.interfaces.task.vo.StudentTaskReqVO;
import com.tss.student.interfaces.task.vo.StudentTaskRespVO;
import com.tss.student.services.task.feign.ReportFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: MQG
 * @date: 2018/11/28
 */
@Service
public class TaskService implements TaskInterface {
    private static final Logger LOG = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private ReportFeignService reportFeignService;
    
    @Override
    public PageInfo<StudentTaskRespVO> getStudentTaskList(StudentTaskReqVO param) {
        return reportFeignService.getStudentTaskList(param);
    }
}
