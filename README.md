# LSD-TEST-APP

This application is a multi-module Gradle project.
Currently, the only subproject is SystemMonitor-Wkr which is a web application that uses Jersey
to provide REST services. The application provides a REST API that shows the Git hash, which indicates
the exact version of the code used in the building of the binary. In future work, a client will be
added to the code to perform integration tests as part of the pipeline.

The application is coded to use Java 8. It uses JUnit to run unit tests.
It will use TestNG to run integration tests.

The application is intended to to be run inside a Tomcat Web container.
The server.xml will have to be modified to use different ports to avoid a collision with the Jenkins server.


The application uses slf4j and logback for logging. This web site,
https://deviantony.wordpress.com/2014/04/09/manage-logging-with-logback-and-apache-tomcat/,
provided pretty simple directions on how to set Tomcat up to use that.

A summary of those directions are as follows:
Install the libraries into the ${CATALINA_HOME}/lib folder
$ sudo mv slf4j-api-1.7.5.jar $CATALINA_HOME/lib/
$ sudo mv jul-to-slf4j-1.7.5.jar $CATALINA_HOME/lib/
$ sudo mv logback-classic-1.1.3.jar $CATALINA_HOME/lib/
$ sudo mv logback-core-1.1.3.jar $CATALINA_HOME/lib/
$ sudo chown -R jenkins $CATALINA_HOME/lib

Update the file ${CATALINA_HOME}/conf/logging.properties to use the logging handler.
Create a logback configuration folder in ${CATALINA_HOME}/conf
Add the logback.xml file into that folder.

Create a setenv.sh file
The file needs to have the following content:
CLASSPATH=$CATALINA_HOME/lib/jul-to-slf4j-1.7.5.jar:$CATALINA_HOME/lib/slf4j-api-1.7.5.jar:$CATALINA_HOME/lib/logback-classic-1.1.3.jar:$CATALINA_HOME/lib/logback-core-1.1.3.jar:$CATALINA_HOME/conf/logback/
Then put this file into the $CATALINA_HOME/bin folder.