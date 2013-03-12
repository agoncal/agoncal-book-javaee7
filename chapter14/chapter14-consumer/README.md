To run these examples you must have GlassFish running. Once the SAOP Wen Service is up and running you need to package your web service consumer with :

  > mvn package

You will get a chapter14-consumer-1.0.jar file. And then run the application client container (ACC) of GlassFish

  > appclient -classpath target\chapter14-consumer-1.0.jar org.agoncal.book.javaee7.chapter14.ex16.Main16
  > appclient -classpath target\chapter14-consumer-1.0.jar org.agoncal.book.javaee7.chapter14.ex23.Main23