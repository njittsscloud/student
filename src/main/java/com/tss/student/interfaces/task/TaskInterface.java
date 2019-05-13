package com.tss.student.interfaces.task;

import com.github.pagehelper.PageInfo;
import com.tss.student.interfaces.task.vo.StudentTaskReqVO;
import com.tss.student.interfaces.task.vo.StudentTaskRespVO;

/**
 * @author: MQG
 * @date: 2018/11/28
 */
public interface TaskInterface {
    PageInfo<StudentTaskRespVO> getStudentTaskList(StudentTaskReqVO param);
}
