package org.serializationtest;

import java.io.*;

public class TransientTest {

    public static void main(String[] args) {

        User user = new User();

        user.setName("zhangsan");
        user.setPassword("123");

        System.out.println("序列化前");
        System.out.println("name:" + user.getName());
        System.out.println("password:" + user.getPassword());

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("file.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            User user2 = (User) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("序列化后：");
            System.out.println("name:" + user2.getName());
            System.out.println("password:" + user2.getPassword());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

class User implements Serializable{

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
