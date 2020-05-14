package com.example.springbootmybatis;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * description : todo
 * author : tao.liu
 * email : tao.liu@uurobot.cn
 * date : 2020/5/14
 * version : v1.0
 */
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-------init()--------");
        int i = MyBatisHelper.getInstance().createtable();
        System.out.println("创建数据库表"+i);
        //MyBatisHelper.getInstance().alterTable();
        //MyBatisHelper.getInstance().addColumn();
        //MyBatisHelper.getInstance().updateColumn();
        MyBatisHelper.getInstance().updateColumn2();
    }
}
