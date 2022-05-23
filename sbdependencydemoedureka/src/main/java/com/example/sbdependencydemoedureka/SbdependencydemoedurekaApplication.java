package com.example.sbdependencydemoedureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SbdependencydemoedurekaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SbdependencydemoedurekaApplication.class, args);
        //You can also use the below line.
        //ConfigurableApplicationContext context = SpringApplication.run(SbdependencydemoedurekaApplication.class, args);
        /*
        ApplicationContext: This the most powerful Container, compare to Bean-factory (Core container).
        VS
        ConfigurableApplicationContext: One of the implementation of the ApplicationContext container.
        This container is used for Event Handling proposes such as lifecycle management - initialisation and destruction.
         */
        Customers c = context.getBean(Customers.class); // Class found in the project based on the annotation
        c.display();
    }

}
