package com.tss.student.services.account.student.iao;

import com.tss.student.interfaces.account.student.vo.UserBaseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentIao {
    private static final Logger LOG = LoggerFactory.getLogger(StudentIao.class);

    private static final String PROTOCOL_HTTP = "http";
    private static final String PROTOCOL_HTTPS = "https";

    @Value("${account.uri}")
    private String accountUri;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 获取用户基本信息
     *
     * @param id
     * @return
     * */
    public UserBaseInfo getUserBaseInfoById(Long id) {
        return restTemplate.getForObject(PROTOCOL_HTTP + "://" + accountUri + "/getUserBaseInfoById/" + id, UserBaseInfo.class);
    }
}
