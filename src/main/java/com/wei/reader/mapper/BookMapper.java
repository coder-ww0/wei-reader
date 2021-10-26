package com.wei.reader.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wei.reader.entity.Book;

/**
 * @author wei
 * @date 2021/10/23 15:50
 * @description: TODO
 */
public interface BookMapper extends BaseMapper<Book> {
    /**
     *更新图书评分、评价数量
     */
    public void updateEvaluation();
}
