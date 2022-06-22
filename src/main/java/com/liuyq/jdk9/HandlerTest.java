package com.liuyq.jdk9;

import org.junit.Before;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * @author liuyuqing
 * @className HandlerTest
 * @description
 * @date 2022/6/22 3:32 下午
 */
public class HandlerTest {

    public class HandleTarget {
        public int count = 1;
    }
    public class VarHandleTest {
        private HandleTarget handleTarget = new HandleTarget();
        private VarHandle varHandle;
        @Before
        public void setUp() throws Exception {
            this.handleTarget = new HandleTarget();
            this.varHandle = MethodHandles
                    .lookup()
                    .findVarHandle(HandleTarget.class, "count", int.class);
        }
    }
}
