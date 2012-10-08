To run these examples you must have GlassFish running. Once the SAOP Wen Service is up and running you need to package your web service consumer with :

  > mvn package

You will get a chapter21-consumer-1.0.jar file. And then run the application client container (ACC) of GlassFish

  > appclient -client