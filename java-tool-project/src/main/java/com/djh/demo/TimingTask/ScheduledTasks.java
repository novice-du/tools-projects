package com.djh.demo.TimingTask;

//定时任务

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Configurable
public class ScheduledTasks {

    //每五秒执行一次
    //报当前时间
    @Scheduled(fixedRate = 1000 * 5)
    public void reportCurrenTime(){
        System.out.println("当前时间是："+dateFormat().format(new Date()));
    }

    //每天11点6-7分的每秒执行一次
    //cron表达式可以百度搜索了解
    @Scheduled(cron = "* 6-7 11 * * ?")
    public void reportCurrenTimeByCron(){
        System.out.println("定时刷新的当前时间是："+dateFormat().format(new Date()));
    }
    //DateFormat类：
    //功能：将系统默认的时间格式转化为自定义的格式，或者将自定义的格式转化为系统格式
    //注意：这是一个抽象类，所以我们使用的时候要创建它的子类对象--SimpleDateFormat类
    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat("HH:mm:ss");
    }

}
