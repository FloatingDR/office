package com.easy.office;

import com.easy.office.mapper.MeetingMapper;
import com.easy.office.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OfficeApplicationTests {

    @Resource
    MeetingMapper meetingMapper;

    @Test
    public void contextLoads() {
        System.out.println(meetingMapper.getIdByNameOrDate("java",null));
    }


    @Test
    public void test(){
        String password="123456";
        String md5= MD5Util.md5("123456");
        System.out.println(md5);
        MD5Util.verify(password,md5);
        if(StringUtils.isBlank(null)||StringUtils.isBlank("")){
            System.out.println("is all empty");
        }

    }

}
