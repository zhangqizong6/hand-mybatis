package com.zqz.handmybatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @ClassName: MapperProxy
 * @author: zqz
 * @date: 2023/9/13 23:08
 */

/**
 * 通过实现 InvocationHandler#invoke 代理类接口，封装操作逻辑的方式，对外接口提供数据库操作对象
 *
 * @param <T>
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    //序列号
    private static final long serialVersionUID = -6424540398559729838L;

    private Map<String, String> sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return "你的被代理了！" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
