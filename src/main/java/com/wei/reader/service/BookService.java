package com.wei.reader.service;

import com.wei.reader.entity.Book;
import com.baomidou.mybatisplus.core.metadata.IPage;
/**
 * @author wei
 * @date 2021/10/23 15:52
 * @description: TODO
 */
public interface BookService {
    /**
     * 分页查询图书
     *
     * @param 页号
     * @param 每页记录数
     * @return 分页对象
     */
    public IPage<Book> paging(Long categoryId, String order, Integer page, Integer rows);

}
