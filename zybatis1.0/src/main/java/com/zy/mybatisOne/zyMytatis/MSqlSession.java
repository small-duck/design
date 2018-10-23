package com.zy.mybatisOne.zyMytatis;

/**
 * @ClassName MSqlSession
 * @Description sqlsession
 * @Author Benny
 * @Date 2018/8/11 0011 20:47
 * @Version 1.0
 **/
public class MSqlSession {

    private MConfigtion configtion;
    private Mexcutor mexcutor;

    public MSqlSession(MConfigtion mConfigtion, Mexcutor mexcutor) {
        this.configtion = mConfigtion;
        this.mexcutor = mexcutor;
    }

    public <T> T  getMappser(Class<T> clazz) {
        return configtion.getMapper(clazz,this);
    }

    /**
     *
     * @param statement sql 语句
     * @param parameter sql 参数
     * @param <T>
     * @return
     */
    public <T> T selectOne(String statement, String parameter) {
        return mexcutor.query(statement, parameter);
    }

}
