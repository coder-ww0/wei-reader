package com.wei.reader;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wei.reader.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.List;

/**
 * @author wei
 * @date 2021/10/21 18:16
 * @description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MybatisPlusTest {
    @Autowired
    private TestMapper testMapper;
    @Test
    public void testInsert() {
        com.wei.reader.entity.Test test = new com.wei.reader.entity.Test();
        test.setContent("111mybatis plus相关测试");
        testMapper.insert(test);
    }
    @Test
    public void testSelect() {
        QueryWrapper<com.wei.reader.entity.Test> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", 45);
        queryWrapper.gt("id", 5);
        List<com.wei.reader.entity.Test> list = testMapper.selectList(queryWrapper);
        System.out.println(list);
    }
}
