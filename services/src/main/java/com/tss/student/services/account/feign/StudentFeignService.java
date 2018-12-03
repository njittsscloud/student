package com.tss.student.services.account.feign;


import com.tss.student.interfaces.account.vo.LoginUserInfoVO;
import com.tss.student.interfaces.account.vo.UserIdentityVO;
import com.tss.student.services.account.feign.callback.StudentFeignServiceCallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${account.serviceId}", fallback = StudentFeignServiceCallback.class)
public interface StudentFeignService {

    @RequestMapping(value = "/student/login", method = RequestMethod.POST)
    LoginUserInfoVO doLogin(UserIdentityVO userIdentity);
}
