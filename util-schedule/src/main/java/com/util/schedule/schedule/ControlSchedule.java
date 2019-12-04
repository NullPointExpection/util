package com.util.schedule.schedule;
import com.util.schedule.task.BaseTask;
import com.util.schedule.task.TaskResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制任务调度器
 * @author liangjinhui
 */
@Slf4j
@Configuration
public class ControlSchedule {

    @Autowired(required = false)
    private List<BaseTask> list;

    private Map<Integer,Long> timerExecuteMap = new HashMap<>();

    @Scheduled(fixedDelay = 1000)
    public void schedule(){
        if(list != null){
            list.forEach(baseTask -> {
                long startTime = System.currentTimeMillis();
                long lastExecuteTime = 0;
                if(timerExecuteMap.get(baseTask.hashCode()) != null){
                    lastExecuteTime = timerExecuteMap.get(baseTask.hashCode());
                }
                if ( (startTime - lastExecuteTime) >=
                        baseTask.getInterval()){
                    log.info("[task] [{}] [start] [start time:{}]", baseTask.getTaskName(),startTime);
                    TaskResult taskResult = null;
                    try{
                        taskResult = baseTask.execute();
                    } catch (Throwable e){
                        log.error("[task] [{}] [execute] [error] [{}]", baseTask.getTaskName(),e);
                    }
                    long endTime = System.currentTimeMillis();
                    timerExecuteMap.put(baseTask.hashCode(),endTime);
                    if(taskResult != null){
                        log.info("[task] [{}] [execute] [execute time:{}] [result:{}] [message:{}]", baseTask.getTaskName(),endTime - startTime,taskResult.isResult(),taskResult.getMessage());
                    } else {
                        log.error("[task] [{}] [execute] [execute time:{}] [execute result is null]",baseTask.getTaskName(),endTime - startTime);
                    }
                    log.info("[task] [{}] [end] [end time:{}]", baseTask.getTaskName(),endTime);
                }
            });
        } else {
            log.info("[{}] [no task]",getClass().getSimpleName());
        }
    }

}
