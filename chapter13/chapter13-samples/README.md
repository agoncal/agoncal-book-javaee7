!!! Warning !!!
These examples use the new lookup attribute of the @Resource annotation (Commons Annotation 1.1). Because the 1.0 is bundled into the JDK, you need to endorse it :
copy the %M2_REPO%\org\glassfish\javax.annotation\${glassfish-version}\javax.annotation-${glassfish-version}.jar to the %JAVA_HOME%\lib\endorsed (in the JRE_HOME if needed too)


To run these examples you must have GlassFish running and create the following administered objects :

To manage JMS connection factories using the command-line utility, use create-jms-resource, list-jms-resources, or delete-jms-resource command

> asadmin create-jms-resource --restype javax.jms.ConnectionFactory jms/javaee7/ConnectionFactory
> asadmin create-jms-resource --restype javax.jms.Queue jms/javaee7/Queue
> asadmin create-jms-resource --restype javax.jms.Topic jms/javaee7/Topic

> asadmin list-jms-resources
jms/javaee7/Queue
jms/javaee7/Topic
jms/javaee7/ConnectionFactory

Run the examples with the appclient commannd :
> appclient -client chapter13-1.0.jar

If you need to empty a destination (flush all messages), this is what you need to do (the name of the destination is the physical name, not the JNDI name) :
> asadmin flush-jmsdest --desttype queue jms_javaee6_Queue
> asadmin flush-jmsdest --desttype topic jms_javaee6_Topic
