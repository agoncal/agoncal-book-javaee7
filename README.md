# Beginning Java EE 7

* [Antonio Goncalves](http://http://www.antoniogoncalves.org)
* [Java EE 7 Book](http://www.amazon.com/gp/product/143022889X/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=143022889X&linkCode=as2&tag=antgonblo-20)
* [Download code on GitHub](https://github.com/agoncal/agoncal-book-javaee7)

# Structure of the book

Section 1 - Introduction

* Chapter 1 - Java EE 7 Environment

Section 2 - Cross concerns

* Chapter 2 - Context & Dependency Injection
* Chapter 3 - Bean Validation

Section 3 - Building a domain model

* Chapter 4 - Persistence
* Chapter 5 - Object-Relational Mapping
* Chapter 6 - Managing Persistent Object

Section 4 - Implementing business logic

* Chapter 7 - Enterprise Java Beans
* Chapter 8 - Callback & Timer Service
* Chapter 9 - Transactions

Section 5 - Adding a web & user interface

* Chapter 10 - JavaServer Faces
* Chapter 11 - Processing & Navigation

Section 6 - Interoperability

* Chapter 12 - XML & JSON
* Chapter 13 - Messaging
* Chapter 14 - SOAP Web Services
* Chapter 15 - RESTful Web Service

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
* Chapter19 : JMS Sender
* Chapter19-MDB : JMS Message Driven Bean
* Chapter21-Consumer : SOAP Web service consumer
* Chapter21-Service : SOAP Web service
* Chapter22-Resource : RESTful Web service

To compile, package and execute the code you need the following software :

* Java SE 7 : http://java.sun.com/javase/downloads
* Derby 10.9 : http://db.apache.org/derby
* Maven 3 : http://maven.apache.org
* GlassFish v4 : http://glassfish.org

# Java EE 7 Specifications

## Java Enterprise Edition Specification

* Java EE 7.0 - [JSR 342](http://http://jcp.org/en/jsr/detail?id=342) - [Project](http://java.net/projects/javaee-spec) - [JIRA](http://java.net/jira/browse/JAVAEE_SPEC) - [Mailing lists](http://java.net/projects/javaee-spec/lists)
* Web Profile 7.0 - [JSR 342](http://http://jcp.org/en/jsr/detail?id=342) - [Project](http://java.net/projects/javaee-spec) - [Mailing lists](http://java.net/projects/javaee-spec/lists)
* Managed Beans 1.0 - [JSR 342](http://http://jcp.org/en/jsr/detail?id=342) - [Project](http://java.net/projects/javaee-spec) - [Mailing lists](http://java.net/projects/javaee-spec/lists)

## Web Services Specifications

* (Prunned) JAX-RPC 1.1 - [JSR 101](http://jcp.org/en/jsr/detail?id=101) - [Project](http://java.net/projects/jax-rpc)
* JAX-WS 2.2a - [JSR 224](http://jcp.org/en/jsr/detail?id=224) - [Project](http://java.net/projects/jax-ws) - [Mailing lists](http://java.net/projects/jax-ws/lists)
* JAXB 2.2 - [JSR 222](http://jcp.org/en/jsr/detail?id=222) - [Project](http://jaxb.java.net/) - [Mailing lists](http://java.net/projects/jaxb/lists/)
* Web Services 1.4 - [JSR 109](http://jcp.org/en/jsr/detail?id=109)
* Web Services Metadata 2.1 - [JSR 181](http://jcp.org/en/jsr/detail?id=181)
* JAX-RS 2.0 - [JSR 339](http://jcp.org/en/jsr/detail?id=339) - [Project](http://java.net/projects/jax-rs-spec) - [Mailing lists](http://java.net/projects/jax-rs-spec/lists) - [Jersey](http://jersey.java.net/) - [@gf_jersey](https://twitter.com/gf_jersey) - [Code on GitHub](https://github.com/jersey/jersey)
* JSON-P 1.0 - [JSR 353](http://jcp.org/en/jsr/detail?id=353) - [Project](http://java.net/projects/json-processing-spec) - [Mailing lists](http://java.net/projects/json-processing-spec/lists) - [JIRA](http://java.net/jira/browse/JSON_PROCESSING_SPEC)
* (Prunned) JAXR 1.0 - [JSR 93](http://jcp.org/en/jsr/detail?id=93)

## Web Specifications

* JSF 2.2 - [JSR 344](http://jcp.org/en/jsr/detail?id=344) - [Project](http://javaserverfaces.java.net/) - [Mailing lists](http://java.net/projects/javaserverfaces-spec-public/lists)
* JSP 2.3 - [JSR 245](http://jcp.org/en/jsr/detail?id=245) - [Project](http://java.net/projects/jsp) - [Mailing lists](http://java.net/projects/jsp/lists)
* Debugging Support for Other Languages 1.0 - [JSR 45](http://jcp.org/en/jsr/detail?id=45)
* JSTL (JavaServer Pages Standard Tag Library) 1.2 - [JSR 52](http://jcp.org/en/jsr/detail?id=52)
* Servlet 3.1 - [JSR 340](http://jcp.org/en/jsr/detail?id=340) - [Project](http://java.net/projects/servlet-spec/) - [Mailing lists](http://java.net/projects/servlet-spec/lists)
* WebSocket 1.0 - [JSR 356](http://jcp.org/en/jsr/detail?id=356) - [Project](http://java.net/projects/websocket-spec) - [Mailing lists](http://java.net/projects/websocket-spec/lists)
* Expression Language 3.0 - [JSR 341](http://jcp.org/en/jsr/detail?id=341) - [Project](http://java.net/projects/el-spec) - [Mailing lists](http://java.net/projects/el-spec/lists)

## Enterprise Specifications

* EJB 3.2 - [JSR 345](http://jcp.org/en/jsr/detail?id=345) - [Project](http://java.net/projects/ejb-spec) - [Mailing lists](http://java.net/projects/ejb-spec/lists)
* Interceptor 1.2 - [JSR 318](http://jcp.org/en/jsr/detail?id=318) - [Project](http://java.net/projects/interceptors-spec) - [Mailing lists](http://java.net/projects/interceptors-spec/lists)
* JavaMail 1.5 - [JSR 919](http://jcp.org/en/jsr/detail?id=919)
* JCA 1.7 - [JSR 322](http://jcp.org/en/jsr/detail?id=322)
* JMS 2.0 - [JSR 343](http://jcp.org/en/jsr/detail?id=343) - [Project](http://java.net/projects/jms-spec) - [Mailing lists](http://java.net/projects/jms-spec/lists) - [JIRA|http://java.net/jira/browse/JMS_SPEC]
* JPA 2.1 - [JSR 338](http://jcp.org/en/jsr/detail?id=338) - [Project](http://java.net/projects/jpa-spec) - [Mailing lists](http://java.net/projects/jpa-spec/lists)
* JTA 1.2 - [JSR 907](http://jcp.org/en/jsr/detail?id=907) - [Project](http://java.net/projects/jta-spec/) - [Mailing lists](http://java.net/projects/jta-spec/lists) - [JIRA|http://java.net/jira/browse/JTA_SPEC]

## Management, Security, and other specifications

* DI 1.0 - [JSR 330](http://jcp.org/en/jsr/detail?id=330)
* CDI 1.1 - [JSR 346](http://jcp.org/en/jsr/detail?id=346) - [Mailing lists](http://seamframework.org/Community/MailingLists) - [Documentation](http://docs.jboss.org/cdi/spec/1.1/cdi-spec.html) - [JIRA](https://issues.jboss.org/browse/CDI)
* JACC 1.4 - [JSR 115](http://jcp.org/en/jsr/detail?id=115)
* Bean Validation 1.1 - [JSR 349](http://jcp.org/en/jsr/detail?id=349) - [Mailing lists](https://lists.jboss.org/mailman/listinfo/beanvalidation-dev) - [Web site](http://beanvalidation.org/)
* (Prunned) Java EE Application Deployment 1.2 - [JSR 88](http://jcp.org/en/jsr/detail?id=88)
* Java EE Management 1.1 - [JSR 77](http://jcp.org/en/jsr/detail?id=77)
* JASPIC 1.0 - [JSR 196](http://jcp.org/en/jsr/detail?id=196)
* Batch 1.0 - [JSR 352](http://jcp.org/en/jsr/detail?id=352) - [Project](http://java.net/projects/jbatch) - [Mailing lists](http://java.net/projects/jbatch/lists)
* Concurrency Utilities for Java EE 1.0 - [JSR 236](http://jcp.org/en/jsr/detail?id=236)

# Related Enterprise Technologies in Java SE 7

* Java IDL - [IDL To Java Language Mapping Specification](http://www.omg.org/cgi-bin/doc?ptc/2000-01-08) - [Java Language To IDL Mapping Specification](http://www.omg.org/cgi-bin/doc?ptc/2000-01-06)
* JDBC 4.1 - [JSR 221](http://jcp.org/en/jsr/detail?id=221)
* RMI-IIOP
* JNDI 1.2 - [Guide](http://docs.oracle.com/javase/7/docs/technotes/guides/jndi/index.html)
* JAXP 1.3 - [JSR 206](http://jcp.org/en/jsr/detail?id=206)
* StAX 1.0 - [JSR 173](http://jcp.org/en/jsr/detail?id=173) - [Project](http://java.net/projects/sjsxp)
* JAAS 1.0 - [Guide](http://docs.oracle.com/javase/7/docs/technotes/guides/security/jaas/JAASRefGuide.html)
* JMX 1.2 - [JSR 3](http://jcp.org/en/jsr/detail?id=3)
* JAX-WS 2.2a - [JSR 224](http://jcp.org/en/jsr/detail?id=224) - [Project](http://java.net/projects/jax-ws) - [Mailing lists](http://java.net/projects/jax-ws/lists)
* JAXB 2.2 - [JSR 222](http://jcp.org/en/jsr/detail?id=222) - [Project](http://jaxb.java.net/) - [Mailing lists](http://java.net/projects/jaxb/lists/)
* JAF 1.1 - [JSR 925](http://jcp.org/en/jsr/detail?id=925)
* SAAJ 1.3 - [Project](http://java.net/projects/saaj/)
* Common Annotations 1.2 - [JSR 250](http://jcp.org/en/jsr/detail?id=250)

# Licensing

<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">Creative Commons Attribution-ShareAlike 3.0 Unported License</a>.

Book - Beginning Java EE 6 with Glassfish
Antonio Goncalves
--
--

# Other

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
