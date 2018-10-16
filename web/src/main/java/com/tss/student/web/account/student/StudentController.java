package com.tss.student.web.account.student;

import com.tss.student.interfaces.account.student.StudentInterface;
import com.tss.student.interfaces.account.student.vo.UserBaseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "学生模块", tags = "StudentController", description = "学生模块")
@RestController
public class StudentController {
    private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentInterface studentInterface;

    @ApiOperation(value = "获取用户基本信息", notes = "获取用户基本信息")
    @RequestMapping(value = "/getUserBaseInfoById/{id}", method = RequestMethod.GET)
    public UserBaseInfo getUserBaseInfo(@PathVariable Long id) {
        return studentInterface.getUserBaseInfoById(id);
    }


}
