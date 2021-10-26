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
     * @param categoryId 分类id
     * @param order 排序规则
     * @param 页号
     * @param 每页记录数
     * @return 分页对象
     */
    public IPage<Book> paging(Long categoryId, String order, Integer page, Integer rows);

    /**
     * 根据图书编号查询图书对象
     * @param bookId 图书id
     * @return
     */
    public Book selectById(Long bookId);

    /**
     * 更新图书评分/评价数量
     */
    public void updateEvaluation();
}
