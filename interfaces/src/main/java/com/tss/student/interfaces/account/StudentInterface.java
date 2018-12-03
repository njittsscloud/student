package com.tss.student.interfaces.account;

import com.tss.student.interfaces.account.vo.LoginUserInfoRespVO;
import com.tss.student.interfaces.account.vo.UserIdentityVO;

import javax.servlet.http.HttpServletResponse;

public interface StudentInterface {
    LoginUserInfoRespVO doLogin(HttpServletResponse response, UserIdentityVO userIdentity);

//    UserBaseInfo getUserBaseInfoById(Long id);
}
