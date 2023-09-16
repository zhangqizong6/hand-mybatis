package com.zqz.handmybatis;

import com.zqz.handmybatis.binding.MapperRegistry;
import com.zqz.handmybatis.dao.IUserDao;
import com.zqz.handmybatis.session.SqlSession;
import com.zqz.handmybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HandMybatisApplicationTests {

    @Test
    void contextLoads() {
//        //1.注册mapper
//        MapperRegistry registry = new MapperRegistry();
//        registry.addMappers("com.zqz.handmybatis.dao");
//
//        //工厂里面拿出session
//        DefaultSqlSessionFactory factory = new DefaultSqlSessionFactory(registry);
//        SqlSession sqlSession = factory.openSqlSession();
//
//        //获取映射器对象
//        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
//
//        //
//        String s = userDao.queryUserName("10001");
//        System.out.println(s);
    }

}
