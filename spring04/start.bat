@echo off
mvn package
explorer "http://localhost:8080/spring04/index.do" &
mvn jetty:run