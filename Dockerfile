FROM ycr.yonyoucloud.com/base/maven-ynpm-debian:latest
MAINTAINER licza licza@yonyou.com
ADD ./ /app/
WORKDIR /app/
RUN cd demo-test-fe/ \
    && ynpm install \
    && npm run build \
    && cd ../demo-test-be \
    && /usr/local/maven/bin/mvn clean install -U -Dmaven.test.skip=true


FROM ycr.yonyoucloud.com/base/tomcat:8-jdk8-alpine
WORKDIR /app
RUN  mkdir -p /usr/local/tomcat/webapps/demo-test-be

COPY --from=0 /app/demo-test-fe/ucf-publish/demo-test-fe /usr/local/tomcat/webapps/demo-test-fe
COPY --from=0 /app/demo-test-be/iuap-bootstrap/target/demo-test-be.war /usr/local/tomcat/webapps/demo-test-be.war
RUN unzip /usr/local/tomcat/webapps/demo-test-be.war -d /usr/local/tomcat/webapps/demo-test-be
RUN rm -f /usr/local/tomcat/webapps/demo-test-be.war
WORKDIR /usr/local/tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]
