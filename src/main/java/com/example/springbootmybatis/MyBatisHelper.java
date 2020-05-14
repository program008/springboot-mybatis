package com.example.springbootmybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * description : TODO:类的作用
 * author : tao.liu
 * email : tao.liu@uurobot.cn
 * date : 2020/4/28 11:51
 * version : v1.0
 */
public class MyBatisHelper {
    private static volatile MyBatisHelper myBatisHelper;
    private final SqlSessionFactory sqlSessionFactory;

    public static MyBatisHelper getInstance(){
        if (myBatisHelper == null){
            synchronized (MyBatisHelper.class){
                if (myBatisHelper == null){
                    myBatisHelper = new MyBatisHelper();
                }
            }
        }
        return myBatisHelper;
    }

    private MyBatisHelper(){
        //1.读取配置文件
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.创建SqlSessionFactory工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }

    public List<User> findAllUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findAllUser");
        sqlSession.close();
        return users;
    }

    /**
     * 查询入一条数据
     * @param user
     */
    public void insertUser(User user){
        System.out.println(user);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int insert = sqlSession.insert("test.insertUser", user);
        System.out.println("insert: "+insert+", "+user);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除数据
     * @param id
     */
    public void deleteUser(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int delete = sqlSession.delete("test.deleteUserById", id);
        System.out.println("delete-->"+delete);
        sqlSession.commit();
        sqlSession.close();
    }

    public User findUserById(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findUserById",id);
        sqlSession.close();
        return user;
    }

    public int createtable(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int update = sqlSession.update("test.createtable");
        sqlSession.commit();
        sqlSession.close();
        return update;
    }

    public void alterTable(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.altertable");
        sqlSession.commit();
        sqlSession.close();
    }
    public void addColumn(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.addColumn");
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateColumn(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.updateColumn");
        sqlSession.commit();
        sqlSession.close();
    }
    public void updateColumn2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("test.updateColumn2");
        sqlSession.commit();
        sqlSession.close();
    }

}
