package com.util.thread.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liangjinhui liangjinhui
 */
@Slf4j
public abstract class BaseThread extends Thread{

    /**
     * 线程启动数量
     */
    private int threadNumber = 0;

    private boolean executed = false;

    @Override
    public void run() {
        try{
            log.info("[{}] [{} : {}] [Start] [Time : {}]",getClass().getSimpleName(),getThreadName(),threadNumber,System.currentTimeMillis());
            execute();
            log.info("[{}] [{} : {}] [End] [Time: {}]",getClass().getSimpleName(),getThreadName(),threadNumber,System.currentTimeMillis());
            this.executed = true;
        } catch (Exception e){
            log.error("[{}] [Error] [{}]",getClass().getSimpleName(),e);
        }

    }

    /**
     * 线程执行方法
     */
    public abstract void execute();

    /**
     * 获取线程名称
     * @return
     */
    public abstract String getThreadName();

    /**
     * 设置线程编号
     * @param threadNumber
     */
    public void setThreadNumber(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    /**
     * 是否已经执行完成
     * @return
     */
    public boolean isExecuted() {
        return executed;
    }

}
