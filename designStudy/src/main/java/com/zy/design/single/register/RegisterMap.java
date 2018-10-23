package com.zy.design.single.register;

import com.sun.deploy.util.StringUtils;
import org.omg.stub.java.rmi._Remote_Stub;

import javax.jws.Oneway;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterMap {
    private RegisterMap() {

    }


    private static Map<String, Object> objectMap = new ConcurrentHashMap<String, Object>();

    public static RegisterMap getInintion(String name) {
        if (name == null) {
            name = RegisterMap.class.getName();
        }
        if (objectMap.get(name) == null) {
            objectMap.put(name, new RegisterMap());
        }
        return (RegisterMap) objectMap.get(name);
    }
}
