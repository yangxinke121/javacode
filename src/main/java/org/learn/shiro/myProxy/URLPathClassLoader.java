package org.learn.shiro.myProxy;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author: yxk
 * @date: 2019-04-04 16:22
 */
public class URLPathClassLoader extends URLClassLoader {

    public URLPathClassLoader(URL[] classPath, ClassLoader classLoader) {
        super(classPath, classLoader);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass != null) {
            return loadedClass;
        }
        String packageName = "com.xinKe";
        if (!packageName.startsWith(name)) {
            return super.findClass(name);
        } else {
            return findClass(name);
        }
    }
}
