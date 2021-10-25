package com.wei.reader.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wei.reader.entity.Book;
import com.wei.reader.entity.Category;
import com.wei.reader.service.BookService;
import com.wei.reader.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wei
 * @date 2021/10/23 14:57
 * @description: TODO
 */
@Controller
public class BookController {
    @Resource
    private CategoryService categoryService;
    @Resource
    private BookService bookService;
    /**
     * 显示首页
     * @return
     */
    @GetMapping("/")
    public ModelAndView showIndex() {
        ModelAndView mav = new ModelAndView("/index");
        List<Category> categoryList = categoryService.selectAll();
        mav.addObject("categoryList", categoryList);
        return mav;
    }

    /**
     * 分页查询图书列表
     * @param p 页数
     * @return
     */
    @GetMapping("/books")
    @ResponseBody
    public IPage<Book> selectBook(Long categoryId, String order, Integer p) {
        if (p == null) {
            p = 1;
        }
        IPage<Book> pageObject = bookService.paging(categoryId, order ,p, 10);
        return pageObject;
    }

}
