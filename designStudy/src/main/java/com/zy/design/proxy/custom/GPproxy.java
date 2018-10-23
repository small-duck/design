package com.zy.design.proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @ClassName GPproxy
 * @Description 手写代理
 * @Author Benny
 * @Date 2018/8/1 0001 12:45
 * @Version 1.0
 **/
public class GPproxy {
    public static final String ln = "\r\n";
    public static Object newProxyInstance(GPClassLoad classLoad,Class<?>[] interfaces,GpInvocationHandler h)
    {
        try {
            //1 动态生成源代码.java文件
            String src = generateSrc(interfaces);
            //2.java文件输出磁盘
            String filePath = GPproxy.class.getResource("").getPath();
            System.out.println(filePath);
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            //把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager, null, null, null, iterable);
            task.call();
            manager.close();

            //4 编译生成.calss文件加载到jvm
            Class<?> proxyClass = classLoad.findClass("$Proxy0");
            Constructor<?> c = proxyClass.getConstructor(GpInvocationHandler.class);

            return c.newInstance(h);
        } catch (Exception e) {

        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.zy.design.proxy.custom;"+ln);
        sb.append("import com.zy.design.proxy.staticProxy.Person;"+ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);

                sb.append("GpInvocationHandler h;" + ln);
                sb.append("public $Proxy0(GpInvocationHandler h) {"+ln);
                    sb.append("this.h=h;");
                    
                 sb.append("}"+ln);

        for (Method m : interfaces[0].getMethods()) {
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "() {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" + ln);
            sb.append("this.h.invoke(this,m,null);" + ln);
            sb.append("}catch(Throwable e){" + ln);
            sb.append("e.printStackTrace();" + ln);
            sb.append("}");
            sb.append("}");
        }
        sb.append("}" + ln);
        return sb.toString();

    }
}
