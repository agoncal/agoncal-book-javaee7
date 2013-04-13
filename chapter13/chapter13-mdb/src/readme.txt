To run these examples you must have GlassFish running and create the following administered objects :

To manage JMS connection factories using the command-line utility, use create-jms-resource, list-jms-resources, or delete-jms-resource command

> create-jms-resource --restype javax.jms.ConnectionFactory jms/javaee6/ConnectionFactory
> create-jms-resource --restype javax.jms.Queue jms/javaee6/Queue
> create-jms-resource --restype javax.jms.Topic jms/javaee6/Topic

asadmin> list-jms-resources
jms/javaee6/Queue
jms/javaee6/Topic
jms/javaee6/ConnectionFactory

After building with Maven, deploy the MDB with the following command
> asadmin deploy chapter16-MDB-1.0.jar

If the deployment is successful, the following command should return the name of the deployed jar
> asadmin list-components