package com.wei.reader.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.reader.entity.Book;
import com.wei.reader.entity.Evaluation;
import com.wei.reader.entity.MemberReadState;
import com.wei.reader.mapper.BookMapper;
import com.wei.reader.mapper.EvaluationMapper;
import com.wei.reader.mapper.MemberReadStateMapper;
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
    @Resource
    private MemberReadStateMapper memberReadStateMapper;
    @Resource
    private EvaluationMapper evaluationMapper;

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

    /**
     * 根据图书编号查询图书对象
     * @param bookId 图书id
     * @return
     */
    @Override
    public Book selectById(Long bookId) {
        Book book = bookMapper.selectById(bookId);
        return book;
    }

    /**
     * 更新图书评分/评价数量
     */
    @Transactional
    @Override
    public void updateEvaluation() {
        bookMapper.updateEvaluation();
    }

    /**
     * 创建新的图书
     *
     * @param book
     * @return
     */
    @Transactional
    @Override
    public Book createBook(Book book) {
        bookMapper.insert(book);
        return book;
    }

    /**
     * 更新图书
     *
     * @param book
     * @return
     */
    @Transactional
    @Override
    public Book updateBook(Book book) {
        bookMapper.updateById(book);
        return book;
    }

    /**
     * 删除图书及其相关数据
     *
     * @param bookId 图书编号
     */
    @Transactional
    @Override
    public void deleteBook(Long bookId) {
        bookMapper.deleteById(bookId);
        QueryWrapper<MemberReadState> mrsQueryWrapper = new QueryWrapper<MemberReadState>();
        mrsQueryWrapper.eq("book_id", bookId);
        memberReadStateMapper.delete(mrsQueryWrapper);
        QueryWrapper<Evaluation> evaluationQueryWrapper = new QueryWrapper<Evaluation>();
        evaluationQueryWrapper.eq("book_id", bookId);
        evaluationMapper.delete(evaluationQueryWrapper);
    }
}
