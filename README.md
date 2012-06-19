# Beginning Java EE 7 Platform with GlassFish 4: From Novice to Professional

* [Antonio Goncalves](http://http://www.antoniogoncalves.org)
* Apress Java EE 7 Book
* Download code on GitHub

# Structure of the book

Section 1 - Introduction

* Chapter 1 - Java EE 7 Environment

Section 2 - Cross concerns

* Chapter 2 - Context & dependency injection
* Chapter 3 - Resources & injection
* Chapter 4 - Interceptors, decorators and events
* Chapter 5 - Bean Validation

Section 3 - Building a domain model

* Chapter 6 - Java Persistence
* Chapter 7 - Object-Relational Mapping
* Chapter 8 - Querying Objects
* Chapter 9 - Callbacks and Listeners

Section 4 - Implementing business logic

* Chapter 10 - Enterprise Java Beans
* Chapter 11 - Session Beans
* Chapter 12 - Callback & Timer Service
* Chapter 13 - Transactions and security

Section 5 - Adding a web & user interface

* Chapter 14 - Servlets
* Chapter 15 - Java Server Faces
* Chapter 16 - Pages and components
* Chapter 17 - Navigation

Section 6 - Interoperability

* Chapter 18 - JMS & MDB
* Chapter 19 - SOAP Web Services
* Chapter 20 - RESTful Web Service

Section 7 - Putting it all together

* Chapter 21 - Developping a web application
* Chapter 22 - Testing
* Chapter 23 - Extensions


# Structure of the code and Maven modules

The code used in the book is defined in the following sub-directories :

* Chapter02 : Introduction to JPA 2.0
* Chapter03 : JPA Mapping
* Chapter04 : JPA Entity Manager and JPQL
* Chapter05 : JPA Lifecycle and Listeners
* Chapter06 : Introduction to EJB 3.1
* Chapter07 : Session beans
* Chapter08 : EJB Lifecycle and Interceptors
* Chapter09 : Transactions and security
* Chapter10 : Introduction to JSF 2.0
* Chapter11 : JSF Pages and components
* Chapter12 : Processing & JSF Navigation
* Chapter13 : JMS Sender
* Chapter13-MDB : JMS Message Driven Bean
* Chapter14-Consumer : SOAP Web service consumer
* Chapter14-Service : SOAP Web service
* Chapter15-Resource : RESTful Web service

To compile, package and execute the code you need the following software :

* Java SE 7 : http://java.sun.com/javase/downloads
* Derby 1.5 : http://db.apache.org/derby
* Maven 2 : http://maven.apache.org
* GlassFish v3 : http://glassfish.org

# Java EE 7 Specifications

## Java Enterprise Edition Specification

* Java EE 7.0 - [JSR 342](http://http://jcp.org/en/jsr/detail?id=342)
* Web Profile 7.0 - [JSR 342](http://http://jcp.org/en/jsr/detail?id=342)

## Web Services Specifications

* JAX-RPC 1.1 - [JSR 101](http://jcp.org/en/jsr/detail?id=101)
* JAX-WS 2.2 - [JSR 224](http://jcp.org/en/jsr/detail?id=224)
* JAXB 2.2 - [JSR 222](http://jcp.org/en/jsr/detail?id=222)
* JAXM 1.0 - [JSR 67](http://jcp.org/en/jsr/detail?id=67)
* StAX 1.0 - [JSR 173](http://jcp.org/en/jsr/detail?id=173)
* Web Services 1.2 - [JSR 109](http://jcp.org/en/jsr/detail?id=109)
* Web Services Metadata 1.1 - [JSR 181](http://jcp.org/en/jsr/detail?id=181)
* JAX-RS 2.0 - [JSR 339](http://jcp.org/en/jsr/detail?id=339) - [Project](http://java.net/projects/jax-rs-spec) - [Jersey](http://jersey.java.net/) - [@gf_jersey](https://twitter.com/gf_jersey) - [Code on GitHub](https://github.com/jersey/jersey)
* JAXR 1.1 - [JSR 93](http://jcp.org/en/jsr/detail?id=93)

## Web Specifications

* JSF 2.2 - [JSR 344](http://jcp.org/en/jsr/detail?id=344)
* JSP 2.2 - [JSR 245](http://jcp.org/en/jsr/detail?id=245)
* JSTL (JavaServer Pages Standard Tag Library) 1.2 - [JSR 52](http://jcp.org/en/jsr/detail?id=52)
* Servlet 3.1 - [JSR 340](http://jcp.org/en/jsr/detail?id=340)
* Expression Language 3.0 - [JSR 341](http://jcp.org/en/jsr/detail?id=341)

## Enterprise Specifications

* EJB 3.2 - [JSR 345](http://jcp.org/en/jsr/detail?id=345)
* JAF 1.1 - [JSR 925](http://jcp.org/en/jsr/detail?id=925)
* JavaMail 1.4 - [JSR 919](http://jcp.org/en/jsr/detail?id=919)
* JCA 1.6 - [JSR 322](http://jcp.org/en/jsr/detail?id=322)
* JMS 2.0 - [JSR 343](http://jcp.org/en/jsr/detail?id=343)
* JPA 2.1 - [JSR 338](http://jcp.org/en/jsr/detail?id=338)
* JTA 1.1 - [JSR 907](http://jcp.org/en/jsr/detail?id=907) - [Project](http://java.net/projects/jta-spec/)

## Management, Security, and other specifications

* CDI 1.1 - [JSR 346](http://jcp.org/en/jsr/detail?id=346)
* JACC 1.1 - [JSR 115](http://jcp.org/en/jsr/detail?id=115)
* Bean Validation 1.1 - [JSR 349](http://jcp.org/en/jsr/detail?id=349)
* Common Annotations 1.0 - [JSR 250](http://jcp.org/en/jsr/detail?id=250)
* Java EE Application Deployment 1.2 - [JSR 88](http://jcp.org/en/jsr/detail?id=88)
* Java EE Management 1.1 - [JSR 77](http://jcp.org/en/jsr/detail?id=77)
* Java Authentication Service Provider Interface for Containers 1.0 - [JSR 196](http://jcp.org/en/jsr/detail?id=196)
* Debugging Support for Other Languages 1.0 - [JSR 45](http://jcp.org/en/jsr/detail?id=45)
* JCache 1.0 - [JSR 107](http://jcp.org/en/jsr/detail?id=107)

# Other

Book - Beginning Java EE 6 with Glassfish
Antonio Goncalves
--
--
The test clases of this chapter, by default, use the Embedded mode of Derby (JavaDB). That means that the persistence.xml file defines a persistent unit with the folowing JDBC Driver

    <property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.EmbeddedDriver"/>
    <property name="javax.persistence.jdbc.url" value="jdbc:derby:chapter05DB;create=true"/>

Embedded mode is good for testing, but it means that no database is really created, so you can't browse its structure with a tool. If you can to be able to browse the database structure, you need to change the embedded mode to a client/server implementation that uses the Derby Network Server. For that, you'll have to do the following steps :

1. Install Derby. You must download the distribution and extract the package (http://db.apache.org) into DERBY_HOME directory. Add %DERBY_HOME%\bin to your PATH and run the sysinfo command line to display information about your Java environment and your version of Derby.
2. Start Derby server with the following command : java -jar %DERBY_HOME%\lib\derbyrun.jar server start (or startNetworkServer.bat)
3. Change the JDBC driver and url in your persistence.xml file :

    <property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.ClientDriver"/>
    <property name="javax.persistence.jdbc.url" value="jdbc:derby://localhost:1527/chapter05DB;create=true"/>

4. Run the test with Maven : mvn clean test
5. Once finished, shutdown the database with : java -jar %DERBY_HOME%\lib\derbyrun.jar server shutdown (or stopNetworkServer.bat)
