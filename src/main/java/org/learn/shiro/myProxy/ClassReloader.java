package org.learn.shiro.myProxy;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author: yxk
 * @date: 2019-04-04 17:26
 */
public class ClassReloader extends ClassLoader {

    private String classPath;

    String className = "Heap";

    public ClassReloader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass("org.learn.shiro.heap" + "." +className, classData, 0, classData.length);
        }
    }

    private byte[] getData(String className) {
        String path = classPath + className;
        try {
            InputStream is = new FileInputStream(path);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int num;
            while ((num = is.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, num);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        try {
            String path = "D:\\javacode\\target\\classes\\org\\learn\\shiro\\heap\\";
            ClassReloader classReloader = new ClassReloader(path);
            Class<?> r = classReloader.findClass("Heap.class");
            System.out.println(r.newInstance());
            // ClassReloader classReloader1 = new ClassReloader(path);
            Class<?> r2 = classReloader.findClass("Heap.class");
            System.out.println(r2.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
