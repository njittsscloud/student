package com.tss.student.services.account.feign.callback;

import com.tss.basic.common.util.JsonUtil;
import com.tss.student.interfaces.account.vo.LoginUserInfoVO;
import com.tss.student.interfaces.account.vo.UserIdentityVO;
import com.tss.student.services.account.feign.StudentFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentFeignServiceCallback implements StudentFeignService {
    private static final Logger LOG = LoggerFactory.getLogger(StudentFeignServiceCallback.class);

    @Override
    public LoginUserInfoVO doLogin(UserIdentityVO param) {
        LOG.error("student login fail, param={}", JsonUtil.obj2json(param));
        return null;
    }
}
