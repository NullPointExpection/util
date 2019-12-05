package com.util.thread.scheduler;

import com.util.thread.properties.ThreadProperties;
import com.util.thread.thread.BaseThread;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 *
 * 线程调度器
 * @author liangjinhui
 */
@Slf4j
public class ThreadScheduler {

    @Autowired(required = false)
    private List<BaseThread> threadList;

    @Autowired
    private ThreadProperties threadProperties;

    @PostConstruct
    public void init(){
        Map<String,Integer> configMap = threadProperties.getThreadCountConfig();
        if (threadList != null && threadList.size() > 0){
            threadList.forEach(baseThread -> {
                Integer threadCount = configMap.get(baseThread.getThreadName());
                if(threadCount == null || threadCount == 0){
                    log.error("[{}] [Start Thread Error No Config] [Thread : {}] ",getClass().getSimpleName(), baseThread.getThreadName());
                } else {
                    startOneBaseThread(threadCount,baseThread);
                }
            });
        }
    }

    private void startOneBaseThread(int threadCount,BaseThread baseThread){
        for(int index = 0; index < threadCount ; index ++){
            try {
                BaseThread baseThreadCache = baseThread.getClass().newInstance();
                baseThreadCache.setThreadNumber(index);
                baseThreadCache.start();
            } catch (Exception e) {
                log.error("[{}] [Start Thread Error] [Thread : {}] [{}]",getClass().getSimpleName(), baseThread.getThreadName(),e);
            }
        }
    }



}
