package com.zqz.handmybatis.session;

import com.zqz.handmybatis.builder.XML.XMLConfigBuilder;
import com.zqz.handmybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @ClassName: SqlSessionFactoryBuilder
 * @author: zqz
 * @date: 2023/9/16 16:08
 */

public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader){
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
