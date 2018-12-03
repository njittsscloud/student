package com.tss.student.services.task.feign.fallback;

import com.github.pagehelper.PageInfo;
import com.tss.basic.common.util.JsonUtil;
import com.tss.student.interfaces.task.vo.StudentTaskReqVO;
import com.tss.student.interfaces.task.vo.StudentTaskRespVO;
import com.tss.student.services.task.feign.TaskFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskFeignServiceFallback implements TaskFeignService {
    private static final Logger LOG = LoggerFactory.getLogger(TaskFeignServiceFallback.class);

    @Override
    public PageInfo<StudentTaskRespVO> getStudentTaskList(StudentTaskReqVO param) {
        LOG.error("getStudentTaskList fail, param={}", JsonUtil.obj2json(param));
        return new PageInfo<>();
    }
}
