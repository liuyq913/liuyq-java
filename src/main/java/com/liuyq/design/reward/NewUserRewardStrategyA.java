package com.liuyq.design.reward;

/**
 * @description:
 * @auther: liuyuqing
 * @Date: 2020/4/13 21:59
 */
public class NewUserRewardStrategyA extends RewardStrategy {
    @Override
    public int reward(long userID) {
        System.out.println("新用户反奖策略A");
        return 10;
    }

    @Override
    public void insertRewardAndSettlement(long userId, int reward) {
    }
}
