package com.zy.design.delegate.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leader
 * @Description 项目经理角色
 * @Author Benny
 * @Date 2018/8/2 0002 17:14
 * @Version 1.0
 **/
public class leader implements IType{

    private Map<String, IType> type = new HashMap<String, IType>();
    public leader() {
        type.put("登录", new ProgrammerOne());
        type.put("others", new ProgrammerTwo());

    }

    @Override
    public void doingString(String doName) {
        type.get(doName).doingString(doName);
    }
}
