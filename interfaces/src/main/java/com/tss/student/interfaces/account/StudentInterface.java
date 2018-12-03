package com.tss.student.interfaces.account;

import com.tss.student.interfaces.account.vo.LoginUserInfoVO;
import com.tss.student.interfaces.account.vo.UserIdentityVO;

public interface StudentInterface {
    LoginUserInfoVO doLogin(UserIdentityVO userIdentity);

//    UserBaseInfo getUserBaseInfoById(Long id);
}
