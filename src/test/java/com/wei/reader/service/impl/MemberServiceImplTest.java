package com.wei.reader.service.impl;

import com.wei.reader.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author wei
 * @date 2021/10/25 20:52
 * @description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MemberServiceImplTest {

    @Resource
    private MemberService memberService;

    @Test
    public void createMember() {
        memberService.createMember("s123456", "123456", "测试");
    }
}