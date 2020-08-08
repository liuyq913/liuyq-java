package com.liuyq.design.reward;

import org.apache.poi.ss.formula.functions.T;

/**
 * @description:具体的策略
 * @auther: liuyuqing
 * @Date: 2020/4/13 22:03
 */
public class FactorRewardStrategyFactory extends StrategyFactory {

    @Override
    RewardStrategy createStrategy(Class c) {
        RewardStrategy strategy = null;
        try {
            strategy = (RewardStrategy) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
        }
        return strategy;
    }
}
