package com.tss.student.services.account.student;

import com.tss.student.interfaces.account.student.StudentInterface;
import com.tss.student.interfaces.account.student.vo.UserBaseInfo;
import com.tss.student.services.account.student.iao.StudentIao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentInterface {
    private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentIao studentIao;

    @Override
    public UserBaseInfo getUserBaseInfoById(Long id) {
        return this.studentIao.getUserBaseInfoById(id);
    }
}
