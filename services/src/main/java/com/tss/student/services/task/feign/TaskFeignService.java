package com.tss.student.services.task.feign;

import com.github.pagehelper.PageInfo;
import com.tss.student.interfaces.task.vo.StudentTaskReqVO;
import com.tss.student.interfaces.task.vo.StudentTaskRespVO;
import com.tss.student.services.task.feign.fallback.TaskFeignServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: MQG
 * @date: 2018/11/28
 */
@FeignClient(value = "${report.serviceId}", fallbackFactory = TaskFeignServiceFallbackFactory.class)
public interface TaskFeignService {

    @RequestMapping(value = "/task/student/getTaskList", method = RequestMethod.POST)
    PageInfo<StudentTaskRespVO> getStudentTaskList(StudentTaskReqVO param);

}