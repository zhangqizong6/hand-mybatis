package com.zqz.handmybatis.session;

public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSqlSession();

}
