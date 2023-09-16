package com.zqz.handmybatis.builder;


import com.zqz.handmybatis.session.Configuration;

/**
 * @ClassName: BaseBulider
 * @author: zqz
 * 构建器的基类，建造者模式
 * @date: 2023/9/16 16:11
 */

public class BaseBuilder {
    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
