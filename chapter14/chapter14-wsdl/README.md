To run these examples you must have GlassFish running

After building with Maven, deploy the webservice with the following command
> asadmin deploy --force target/chapter14-service-1.0.war

If the deployment is successful, the following command should return the name of the deployed jar
> asadmin list-components

Go to the index.html page : http://localhost:8080/chapter14-service-1.0/