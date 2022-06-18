This project follows the tutorial from: https://www.youtube.com/watch?v=vtPkZShrvXQ (108.00)
Docker & Postgres Tutorial: https://www.youtube.com/watch?v=aHbE3pTyG-Q (13.06)

What is Spring Boot?
-------------------
- Spring Boot is an open-source java-based framework that helps with bootstrapping the spring framework in a java application.
- It is a spring module used to simplify the use of the spring framework by creating spring powered, production grade applications.
- It is used to create standalone spring based applications we can run by removing configuration, dependencies and aims at RAD.
- Spring boot comes with auto dependency resolution embedded HTTP servers, auto-configuration and management endpoints and springboot CLI.

Features of Spring Boot
-----------------------
-Spring CLI: This allows you to enable groovy for writing spring boot application and avoids boilerplate code.
-Starter Dependency: Springboot aggregates common dependencies together and eventually improves productivity.
-Spring Initializer: This is a web application used to create an internal initial project structure for you.
-Auto-Configuration: This feature of SB helps in loading the default configurations according to the project you are working on.
-Logging and Security: This feature ensures that all the applications made using Spring Boot are properly secured without any hassle.
-Spring Actuator: This feature provides help while running Spring Boot applications.

Why do we require SB?
---------------------
- Stability
- JVM Based
- Ease of connectivity
- Cloud native
- Flexibility
- Open source

Spring Framework (sf) vs Spring Boot (sb)
-----------------------------------------
- SF takes time to have up and running while SB provides the bare necessities to get a spring application to run quickly.
- SF manages the life cycle of java while SB need not worry about configuring a data source.
- SF uses a dependency injection framework while SB uses a pre-configured set of frameworks and technologies.

Spring Boot MVC (Model View Controller)
---------------------------------------
- MVC is a design pattern which is used to help build web applications.
- By default, it implements all the basic features of a core Spring framework like IOC and dependency injection.
- MVC uses a dispatch servlet class that receives and redirects incoming requests that are mapped urls such as models, views and controllers.
- The 4 main components of the MVC are: Front Controller, Controller, Model and View.
- Model contains the core data of the application and the data can be either a single object or a group of objects.
- Controller contains the business logic of an application that will act on the core data. It uses the added Controller annotation to mark the class as a
  controller.
- View is used to represent the information in a particular format (eg. Html, JSP + JSTL) to create a view page.
- Front Controller works as a front end controller.

MVC Workflow
------------
1. An incoming http request is recieved by the dispatcher servlet which operates as the front end controller.
2. The url is retrieved from the incoming http request and mapped to the handler mapping which then forwards the request to the controller.
3. The controller returns an model and view object to the dispatch servlet.
4. Based on the returned Object from 3., the dispatch servlet invokes the specified view resolver component to return the right view.

Dependency Injection (DI)
-------------------------
- DI is simply the ability of one object to supply dependencies to another object.
- These dependencies are usually instances of classes created by the spring framework.
- eg. Imagine we have 2 classes: A and B. In order for class A to work, Class A uses methods of Class B.
- Hence an instance of Class B will need to be created and supplied to Class A. Class A is dependent on Class B.
- DI is an approach where a class uses specific functionalitites of another class.
- Typically in java, you need to create an instance of a class in order to use its functionality using the following approach: A a = new A();
- With DI, the springboot framework is responsible for creating your instances where necessary and supplying to its dependents.
- It is the process of creating an object for some other class and let the class directly using the dependency is called dependency injection.
- There are 3 types of classes being uses for DI:
1. Client class
2. Injector class
3. Service class
- Client class is the dependent class and it is dependent on the service class.
- Injector class is responsible for creating an instance of the service class and injecting it into the client class.
- Service class provides a service to the client class.

Inversion of Control (IOC)
--------------------------
- Dependency Injection is based on IOC.
- A class should not configure its dependencies statically but instead some external entity should be able to provide/supply the dependency required for the class to work.
- That external entity is the Spring framework or Spring boot.
- A class sole purpose should concentrate on fulfilling its responsibility like the flow of an application, and not on creating objects. (Cohesiveness)

Types of DI
-----------
- There are 3 types of DI.
1. Constructor Injection - dependencies are supplied to a client class constructor.
2. Setter Injection - injector method injects the dependency to the setter method exposed by the client.
3. Interface Injection - interfaces are used to provide dependency to the client class.

Benefits of DI
--------------
- DI enables an easier way to interconnect components.
- Applications can be easily extended.
- Unit Testing is made much easier.
- Reduction of boiler plate code.
