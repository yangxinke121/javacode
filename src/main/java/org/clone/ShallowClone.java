package org.clone;

class Address implements Cloneable{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
         Address address = (Address) super.clone();
         return address;
    }
}

class Student implements Cloneable{
    private int number;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Student stu = (Student) super.clone();
        stu.address = (Address) address.clone();
        return stu;

    }
}

public class ShallowClone {

    public static void main(String[] args) {
        Student student = new Student();
        Address address = new Address();
        address.setAddress("cs");
        student.setNumber(47);
        student.setAddress(address);
        try {
            Student stu2 = (Student) student.clone();
            System.out.println("学生1"+student.getNumber() +",地址 "+student.getAddress().getAddress());
            System.out.println("学生2"+stu2.getNumber() +",地址 "+ stu2.getAddress().getAddress());
            address.setAddress("hn");
            System.out.println("学生1"+student.getNumber() +",地址 "+student.getAddress().getAddress());
            System.out.println("学生2"+stu2.getNumber() +",地址 "+ stu2.getAddress().getAddress());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
