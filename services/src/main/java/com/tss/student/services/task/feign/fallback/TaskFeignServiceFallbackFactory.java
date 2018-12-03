package com.tss.student.services.task.feign.fallback;

import com.github.pagehelper.PageInfo;
import com.tss.student.interfaces.task.vo.StudentTaskReqVO;
import com.tss.student.interfaces.task.vo.StudentTaskRespVO;
import com.tss.student.services.task.feign.TaskFeignService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TaskFeignServiceFallbackFactory implements FallbackFactory<TaskFeignService> {
    private static final Logger LOG = LoggerFactory.getLogger(TaskFeignServiceFallbackFactory.class);

    @Override
    public TaskFeignService create(Throwable cause) {
        return new TaskFeignService() {
            
            @Override
            public PageInfo<StudentTaskRespVO> getStudentTaskList(StudentTaskReqVO param) {
                cause.printStackTrace();
                return null;
            }
        };
    }
}
