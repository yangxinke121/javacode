package org.learn.tree;

/**
 * @author: yxk
 * @date: 2019-04-12 16:29
 */
public class Main {


    public static void main(String[] args) {

        // http://upload.bestcjw.cn//files/file/105812511.jpg

        String s = "http://upload.bestcjw.cn//files/file/105812511.jpg";
        int files = s.indexOf("files");
        System.out.println(files);
        System.out.println(s.substring(files + 5));

        String s1 = "123";
        String[] split = s1.split(",");
        for (String s2 : split) {
            System.out.println(s2);
        }

    }
}
