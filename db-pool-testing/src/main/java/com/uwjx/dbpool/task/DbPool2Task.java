package com.uwjx.dbpool.task;

import com.uwjx.dbpool.entity.DbPool;
import com.uwjx.dbpool.mapper_db2.DbPool2Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Slf4j
@EnableAsync
public class DbPool2Task {

    @Autowired
    DbPool2Mapper dbPool2Mapper;

    @Async
    @Scheduled(fixedRate =  200)
    public void run(){
        log.warn("执行 DbPool2Task 测试");
        for (int i = 0; i < 2; i++) {
            DbPool dbPool = new DbPool();
            dbPool.setName("测试名称:" + i);
            dbPool2Mapper.insertSelective(dbPool);
        }
    }

    @Async
    @Scheduled(fixedRate = 100)
    public void query1(){
        log.warn("执行 DbPool2Task query1 测试");
        List<DbPool> dbPools = dbPool2Mapper.query();
        int size = dbPools.size();
        Random random = new Random();
        int index = random.nextInt(size);
        dbPool2Mapper.deleteByPrimaryKey(index);
    }

    @Async
    @Scheduled(fixedRate = 100)
    public void query2(){
        log.warn("执行 DbPool2Task query2 测试");
        List<DbPool> dbPools = dbPool2Mapper.query();
        int size = dbPools.size();
        Random random = new Random();
        int index = random.nextInt(size);
        dbPool2Mapper.deleteByPrimaryKey(index);
    }

    @Async
    @Scheduled(fixedRate = 100)
    public void query3(){
        log.warn("执行 DbPool2Task query3 测试 : ");
        List<DbPool> dbPools = dbPool2Mapper.query();
        int size = dbPools.size();
        Random random = new Random();
        int index = random.nextInt(size);
        dbPool2Mapper.deleteByPrimaryKey(index);
    }
}
