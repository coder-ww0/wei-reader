package com.wei.reader.service;

import com.wei.reader.mapper.TestMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wei
 * @date 2021/10/21 15:22
 * @description: TODO
 */
@Service
public class TestService {
    @Resource
    public TestMapper testMapper;
    @Transactional
    public void batchImport() {
        for (int i = 0; i < 5; i++) {
//            if (i == 3) {
//                throw new RuntimeException("没有想到的异常");
//            }
            testMapper.insert();
        }
    }
}
