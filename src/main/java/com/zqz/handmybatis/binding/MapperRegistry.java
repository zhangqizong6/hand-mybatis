package com.zqz.handmybatis.binding;

/**
 * @ClassName: MapperRegistry
 * @author: zqz
 * @date: 2023/9/16 15:07
 */

import cn.hutool.core.lang.ClassScanner;
import com.zqz.handmybatis.session.Configuration;
import com.zqz.handmybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * MapperRegistry 提供包路径的扫描和映射器代理类注册机服务，完成接口对象的代理类注册处理。
 * <p>
 * MapperRegistry 映射器注册类的核心主要在于提供了 ClassScanner.scanPackage 扫描包路径，
 * 调用 addMapper 方法，给接口类创建 MapperProxyFactory 映射器代理类，并写入到 knownMappers 的 HashMap 缓存中。
 */
public class MapperRegistry {

    private Configuration config;

    public MapperRegistry(Configuration config) {
        this.config = config;
    }

    /**
     * 将已经添加的映射器代理加入hashmap中
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {

        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> void addMapper(Class<T> type) {
        /**
         * mapper必须是接口才可以注册
         */
        if (type.isInterface()) {
            if (hasMapper(type)) {
                //如果重复添加后 就直接抛出异常
                throw new RuntimeException("Type " + type + " is already known to the MapperRegistry.");
            }
            //注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }

    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }

    public void addMappers(String packetName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packetName);
        for (Class<?> aClass : mapperSet) {
            addMapper(aClass);
        }
    }
}
