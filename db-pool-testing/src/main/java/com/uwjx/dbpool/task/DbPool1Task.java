package com.uwjx.dbpool.task;

import com.uwjx.dbpool.entity.DbPool;
import com.uwjx.dbpool.mapper_db1.DbPool1Mapper;
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
public class DbPool1Task {

    @Autowired
    DbPool1Mapper dbPool1Mapper;

    @Async
    @Scheduled(fixedRate =  200)
    public void run(){
        log.warn("执行 DbPool1Task 测试");
        for (int i = 0; i < 2; i++) {
            DbPool dbPool = new DbPool();
            dbPool.setName("测试名称:" + i);
            dbPool1Mapper.insertSelective(dbPool);
        }
    }

    @Async
    @Scheduled(fixedRate = 100)
    public void query1(){
        log.warn("执行 DbPool1Task query1 测试");
        List<DbPool> dbPools = dbPool1Mapper.query();
        int size = dbPools.size();
        Random random = new Random();
        int index = random.nextInt(size);
        dbPool1Mapper.deleteByPrimaryKey(index);
    }

    @Async
    @Scheduled(fixedRate = 100)
    public void query2(){
        log.warn("执行 DbPool1Task query2 测试");
        List<DbPool> dbPools = dbPool1Mapper.query();
        int size = dbPools.size();
        Random random = new Random();
        int index = random.nextInt(size);
        dbPool1Mapper.deleteByPrimaryKey(index);
    }

    @Async
    @Scheduled(fixedRate = 100)
    public void query3(){
        log.warn("执行 DbPool1Task query3 测试 : ");
        List<DbPool> dbPools = dbPool1Mapper.query();
        int size = dbPools.size();
        Random random = new Random();
        int index = random.nextInt(size);
        dbPool1Mapper.deleteByPrimaryKey(index);
    }
}
