package com.util.test.thread;

import com.util.thread.thread.BaseThread;
import org.springframework.context.annotation.Configuration;


/**
 * 测试线程
 * @author liangjinhui
 */
@Configuration
public class TestThread extends BaseThread {
    @Override
    public void execute() {
        System.out.println(1);
    }

    @Override
    public String getThreadName() {
        return "TestThread";
    }
}
