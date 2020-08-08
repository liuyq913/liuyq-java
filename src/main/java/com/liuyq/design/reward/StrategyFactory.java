package com.liuyq.design.reward;

import org.apache.poi.ss.formula.functions.T;

/**
 * @description: 返奖策略工厂
 * @auther: liuyuqing
 * @Date: 2020/4/13 22:01
 */
public abstract class StrategyFactory {

    abstract RewardStrategy createStrategy(Class<T> c);
}
