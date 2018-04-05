#!/bin/bash


#code path in /opt/jboss_src
#javac -classpath /opt/jboss_src/WEB-INF/lib/* ./src/Hello.java
javac -classpath /opt/jboss_src/WEB-INF/lib/javax.servlet.jar:/opt/jboss_src/WEB-INF/lib/mysql-connector-java-5.1.44.jar  ./src/Hello.java 

cp ./src/Hello.class  /opt/jboss_src/WEB-INF/classes/mypackage/ -rf

cd /opt/jboss_src

jar -cvf hello.war *

rm /usr/local/jboss/standalone/deployments/hello.war  /usr/local/jboss/standalone/deployments/hello.war.deployed -rf 

mv hello.war  /usr/local/jboss/standalone/deployments/


