package com.tss.student.services.account;

import com.tss.basic.common.util.ModelMapperUtil;
import com.tss.basic.site.user.item.CookieName;
import com.tss.student.interfaces.account.StudentInterface;
import com.tss.student.interfaces.account.vo.LoginUserInfoRespVO;
import com.tss.student.interfaces.account.vo.LoginUserInfoVO;
import com.tss.student.interfaces.account.vo.UserIdentityVO;
import com.tss.student.services.account.feign.StudentFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class StudentService implements StudentInterface {
    private static final Logger LOG = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentFeignService studentFeignService;

    @Override
    public LoginUserInfoRespVO doLogin(HttpServletResponse response, UserIdentityVO userIdentity) {
        LoginUserInfoVO loginUserInfo = studentFeignService.doLogin(userIdentity);
        this.setCookie(response, loginUserInfo.getCookieInfo());
        return ModelMapperUtil.strictMap(loginUserInfo, LoginUserInfoRespVO.class);
    }

    // 浏览器不存储cookie
    private void setCookie(HttpServletResponse response, LoginUserInfoVO.CookieInfo cookieInfo) {
        Cookie cookie = new Cookie(cookieInfo.getCookieName(), cookieInfo.getCookieValue());
        cookie.setPath(cookieInfo.getCookiePath());
        cookie.setDomain(cookieInfo.getCookieDomain());
        response.addCookie(cookie);
    }

//    @Override
//    public UserBaseInfo getUserBaseInfoById(Long id) {
//        return this.studentIao.getUserBaseInfoById(id);
//    }
}
