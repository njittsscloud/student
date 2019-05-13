package com.tss.student.interfaces.account;

import com.tss.student.interfaces.account.vo.LoginUserInfoRespVO;
import com.tss.student.interfaces.account.vo.UserBaseInfo;
import com.tss.student.interfaces.account.vo.UserIdentityVO;

import javax.servlet.http.HttpServletResponse;

public interface StudentInterface {
    LoginUserInfoRespVO doLogin(HttpServletResponse response, UserIdentityVO userIdentity);

    /**
     * 根据session获取用户信息
     *
     * @param session
     * @return
     * */
    UserBaseInfo getUserBaseInfoBySessionId(String session);
}
