package com.tss.student.services.account;

import com.tss.student.interfaces.account.StudentInterface;
import com.tss.student.interfaces.account.vo.LoginUserInfoVO;
import com.tss.student.interfaces.account.vo.UserIdentityVO;
import com.tss.student.services.account.feign.StudentFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentInterface {
    private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentFeignService studentFeignService;

    @Override
    public LoginUserInfoVO doLogin(UserIdentityVO userIdentity) {
        return studentFeignService.doLogin(userIdentity);
    }

//    @Override
//    public UserBaseInfo getUserBaseInfoById(Long id) {
//        return this.studentIao.getUserBaseInfoById(id);
//    }
}
