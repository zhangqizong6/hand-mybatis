package com.zqz.handmybatis.session.defaults;

import com.zqz.handmybatis.binding.MapperRegistry;
import com.zqz.handmybatis.mapping.MappedStatement;
import com.zqz.handmybatis.session.Configuration;
import com.zqz.handmybatis.session.SqlSession;

/**
 * @ClassName: DefaultSqlSession
 * @author: zqz
 * @date: 2023/9/16 15:26
 */

public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private Configuration configuration;
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }
}
