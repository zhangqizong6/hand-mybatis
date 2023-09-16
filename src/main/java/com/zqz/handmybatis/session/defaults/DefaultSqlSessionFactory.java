package com.zqz.handmybatis.session.defaults;

import com.zqz.handmybatis.binding.MapperRegistry;
import com.zqz.handmybatis.session.Configuration;
import com.zqz.handmybatis.session.SqlSession;
import com.zqz.handmybatis.session.SqlSessionFactory;

/**
 * @ClassName: DefaultSqlSessionFactory
 * @author: zqz
 * @date: 2023/9/16 15:48
 */

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSqlSession() {
        return new DefaultSqlSession(configuration);
    }
}
