package com.wei.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.reader.entity.Book;
import com.wei.reader.mapper.BookMapper;
import com.wei.reader.service.BookService;
import javafx.scene.control.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author wei
 * @date 2021/10/23 15:56
 * @description: TODO
 */
@Service("bookService")  //指定beanId
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
    /**
     * 分页查询图书
     * @param categoryId  分类id
     * @param order  按热度、按评分
     * @param page 页号
     * @param rows
     * @return 分页对象
     */
    @Override
    public IPage<Book> paging(Long categoryId, String order, Integer page, Integer rows) {
        Page<Book> p = new Page<Book>(page, rows);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<Book>();
        if (categoryId != null && categoryId != -1) {
            queryWrapper.eq("category_id", categoryId);
        }
        if (order != null) {
            if ("quantity".equals(order)) {
                queryWrapper.orderByDesc("evaluation_quantity");
            } else if ("score".equals(order)) {
                queryWrapper.orderByDesc("evaluation_score");
            }
        }
        IPage<Book> pageObject = bookMapper.selectPage(p, queryWrapper);
        return pageObject;
    }


}
