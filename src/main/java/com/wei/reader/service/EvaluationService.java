package com.wei.reader.service;

import com.wei.reader.entity.Evaluation;

import java.util.List;

/**
 * @author wei
 * @date 2021/10/25 13:31
 * @description: TODO
 */
public interface EvaluationService {
    public List<Evaluation> selectByBookId(Long bookId);
}
