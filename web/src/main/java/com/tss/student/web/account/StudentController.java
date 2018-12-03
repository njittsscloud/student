package com.tss.student.web.account;

import com.tss.basic.site.argumentresolver.JsonParam;
import com.tss.student.interfaces.account.StudentInterface;
import com.tss.student.interfaces.account.vo.LoginUserInfoVO;
import com.tss.student.interfaces.account.vo.UserIdentityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "学生账号模块", tags = "StudentController", description = "学生账号模块")
@RestController
@RequestMapping("/account/student")
public class StudentController {
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentInterface studentInterface;

    @ApiOperation(value = "学生登录", notes = "学生登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginUserInfoVO login(@JsonParam(validation = true) UserIdentityVO userIdentity) {
        return studentInterface.doLogin(userIdentity);
    }

//    @ApiOperation(value = "获取学生基本信息", notes = "获取学生基本信息")
//    @RequestMapping(value = "/getUserBaseInfoById/{id}", method = RequestMethod.GET)
//    public UserBaseInfo getUserBaseInfo(@PathVariable Long id) {
//        return studentInterface.getUserBaseInfoById(id);
//    }
//
//    public UserBaseInfo getUserBaseInfoFallback(Long id) {
//        return new UserBaseInfo();
//    }
}
