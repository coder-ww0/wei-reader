package com.wei.reader.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wei.reader.entity.Book;
import com.wei.reader.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wei
 * @date 2021/10/23 19:11
 * @description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceImplTest {
    @Resource
    private BookService bookService;

    @Test
    public void paging() {
        IPage<Book> pageObject = bookService.paging(2L,"quantity",2, 10);
        List<Book> recodes = pageObject.getRecords();
        System.out.println(recodes);
        for (Book b : recodes) {
            System.out.println(b.getBookId() + ":" + b.getBookName());
        }
        System.out.println("总页数：" + pageObject.getPages());
        System.out.println("总记录数：" + pageObject.getTotal());
    }
}