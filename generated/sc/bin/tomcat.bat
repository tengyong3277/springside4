@echo off
echo [INFO] Use maven jetty-plugin run the project.

cd %~dp0
cd ..

set MAVEN_OPTS=%MAVEN_OPTS% -XX:MaxPermSize=128m
call mvn tomcat:run -Dmaven.tomcat.port=8088

cd bin
pause 