package com.liuyq.design.reward;

/**
 * @description:
 * @auther: liuyuqing
 * @Date: 2020/4/13 21:58
 */
public abstract class RewardStrategy {

    public abstract int reward(long userID);

    public abstract void insertRewardAndSettlement(long userId, int reward);
}
