package com.edureka;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class EmployeeClient {

    public static void main(String args[])
    {
        //Spring IOC using IOC and BeanFactory
        //BeanFactory loads the beans as and when they are required
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        Employee employee1= (Employee) beanFactory.getBean("employee1");
        System.out.println(employee1.toString());

        BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        Employee employee2 = (Employee) beanFactory2.getBean("employee2");
        System.out.println(employee2.toString());

        //Spring IOC using IOC and Application Context
        //Application context loads all beans during the startup of the application
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Employee employee3 = (Employee) context.getBean("employee3");
        System.out.println(employee3.toString());
        ClassPathXmlApplicationContext ctx = (ClassPathXmlApplicationContext) context;
        ctx.close(); // Shutdown the application context created by the Spring container

        //Dependency Injection via Constructor method
        ApplicationContext context2 = new ClassPathXmlApplicationContext("spring.xml");
        Employee2 employee4 = (Employee2) context2.getBean("employee4");
        System.out.println(employee4.toString());
        ClassPathXmlApplicationContext ctx2 = (ClassPathXmlApplicationContext) context2;
        ctx2.close(); // Shutdown the application context created by the Spring container

        //Dependency Injection via Setter method
        ApplicationContext context3 = new ClassPathXmlApplicationContext("spring.xml");
        Employee2 employee5 = (Employee2) context3.getBean("employee5");
        System.out.println(employee5.toString());
        ClassPathXmlApplicationContext ctx3 = (ClassPathXmlApplicationContext) context3;
        ctx3.close(); // Shutdown the application context created by the Spring container

    }

}
