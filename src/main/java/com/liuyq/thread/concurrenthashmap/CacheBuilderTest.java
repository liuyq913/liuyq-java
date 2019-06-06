package com.liuyq.thread.concurrenthashmap;

import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyq on 2019/6/5.
 */
public class CacheBuilderTest {
    protected final ConcurrentMap<String, Integer> overriddenInstanceStatusMap = CacheBuilder
            .newBuilder().initialCapacity(500)
            .expireAfterAccess(3, TimeUnit.SECONDS)
            .<String, Integer>build().asMap();
}
