package com.edureka;

//Bean , POJO or model
public class Employee {

    private String name;
    private int age;

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

    public Employee()
    {

    }

    public Employee(String name, int age)
    {
        this.age = age;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
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
