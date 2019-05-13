package com.tss.student.services.account.feign;


import com.tss.student.interfaces.account.vo.LoginUserInfoVO;
import com.tss.student.interfaces.account.vo.UserBaseInfo;
import com.tss.student.interfaces.account.vo.UserIdentityVO;
import com.tss.student.services.account.feign.fallback.StudentFeignServiceCallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${account.serviceId}", path = "account", fallback = StudentFeignServiceCallback.class)
public interface StudentFeignService {

    @RequestMapping(value = "/student/account/login", method = RequestMethod.POST)
    LoginUserInfoVO doLogin(UserIdentityVO userIdentity);

    @RequestMapping(value = "/student/account/getUserBaseInfoBySessionId/{sessionId}", method = RequestMethod.GET)
    UserBaseInfo getUserBaseInfo(@PathVariable("sessionId") String sessionId);

}
