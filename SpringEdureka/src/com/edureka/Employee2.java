package com.edureka;

//Bean , POJO or model
public class Employee2 {

    private String name;
    private int age;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee2()
    {

    }

    public Employee2(Address address)
    {
        this.address = address;
    }

    public Employee2(String name, int age, Address address)
    {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public void myInit()
    {
        System.out.println("***Employee Bean initialised***");
    }

    public void myDestroy()
    {
        System.out.println("***Employee Bean destroyed***");
    }
}
