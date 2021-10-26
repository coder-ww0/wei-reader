package com.wei.reader.task;

import com.wei.reader.service.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wei
 * @date 2021/10/26 14:22
 * @description: 完成每本图书的星星评分更新(完成自动计算任务)
 */
@Component
public class ComputerTask {
    @Resource
    private BookService bookService;

    @Scheduled(cron = "0 * * * * ?")  // 任务调度
    public void updateEvaluation() {
        bookService.updateEvaluation();
        System.out.println("已更新所有图书评分");
    }
}
