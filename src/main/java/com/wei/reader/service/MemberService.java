package com.wei.reader.service;

import com.wei.reader.entity.Evaluation;
import com.wei.reader.entity.Member;
import com.wei.reader.entity.MemberReadState;

/**
 * @author wei
 * @date 2021/10/25 20:29
 * @description: TODO
 */
public interface MemberService {
    /**
     * 会员注册，实现新会员
     * @param username
     * @param password
     * @param nickname
     * @return
     */
    public Member createMember(String username, String password, String nickname);

    /**
     * 检查登录
     * @param username
     * @param password
     * @return
     */
    public Member checkLogin(String username, String password);

    /**
     * 获取阅读的状态
     * @param memberId  会员编号
     * @param bookId  图书编号
     * @return
     */
    public MemberReadState selectMemberReadState(Long memberId, Long bookId);

    /**
     * 更新阅读状态
     * @param memberId  会员编号
     * @param bookId  图书编号
     * @param readState  阅读状态
     * @return  阅读状态对象
     */
    public MemberReadState updateMemberState(Long memberId, Long bookId, Integer readState);

    /**
     * 发布新的短评
     * @param memberId
     * @param bookId
     * @param score
     * @param content
     * @return
     */
    public Evaluation evaluate(Long memberId, Long bookId, Integer score, String content);

    /**
     * 短评点赞
     * @param evaluationId
     * @return
     */
    public Evaluation enjoy(Long evaluationId);
}
