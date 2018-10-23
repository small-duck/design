package com.zy.design.delegate.demo;

/**
 * @ClassName ProgrammerOne
 * @Description 员工1号
 * @Author Benny
 * @Date 2018/8/2 0002 17:17
 * @Version 1.0
 **/
public class ProgrammerOne implements IType {
    @Override
    public void doingString(String doName) {
        System.err.println("i am programmerOne ,I do login");

    }
}
