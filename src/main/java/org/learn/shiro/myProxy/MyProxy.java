package org.learn.shiro.myProxy;
import org.springframework.util.FileCopyUtils;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author: yxk
 * @date: 2019-04-02 09:53
 */
public class MyProxy {

    private static final String rt = "\r";

    public static Object newProxyInstance(MyClassLoader loader, Class<?> interfaces, MyInvocationHandler h) {
        if (h == null) {
            throw new NullPointerException();
        }
        // 根据接口构造代理类
        Method[] methods = interfaces.getMethods();
        StringBuffer proxyClassString = new StringBuffer();
        proxyClassString.append("package ")
                .append(loader.getProxyClassPackage()).append(";").append(rt)
                .append("import java.lang.reflect.Method;").append(rt)
                .append("public class $MyProxy0 implements ").append(interfaces.getName()).append("{").append(rt)
                .append("MyInvocationHandler h;").append(rt)
                .append("public $MyProxy0(MyInvocationHandler h){").append(rt).append("this.h = h;}").append(rt)
                .append(getMethodString(methods, interfaces)).append("}");

        // 写入Java 文件编译
        String fileName = loader.getDir() + File.separator + "$MyProxy0.java";
        File myProxyFile = new File(fileName);
        try {
            compile(proxyClassString, myProxyFile);
            Class<?> $MyProxy0 = loader.findClass("$MyProxy0");
            Constructor<?> constructor = $MyProxy0.getConstructor(MyInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void compile(StringBuffer proxyClassString, File myProxyFile) throws IOException {
        FileCopyUtils.copy(proxyClassString.toString().getBytes(), myProxyFile);
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(myProxyFile);
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();
        standardFileManager.close();
    }

    private static String getMethodString(Method[] methods, Class<?> interfaces) {
        StringBuffer stringBuffer = new StringBuffer();

        for (Method method : methods) {
            stringBuffer.append("public void ").append(method.getName())
                    .append("()").append("throws Throwable{ ")
                    .append("Method method1 = ").append(interfaces.getName())
                    .append(".class.getMethod(\"").append(method.getName())
                    .append("\", new Class[]{});")
                    .append("this.h.invoke(this, method1, null);}").append(rt);
        }
        return stringBuffer.toString();
    }
}
