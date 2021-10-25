package com.wei.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.reader.entity.Test;

/**
 * @author wei
 * @date 2021/10/21 15:17
 * @description: TODO
 */
public interface TestMapper extends BaseMapper<Test> {
    public void insertSample();
}
