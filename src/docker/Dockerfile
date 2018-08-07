FROM java:8-jre

RUN mkdir -p /opt/demo/
WORKDIR /opt/demo/

COPY ./springboot-mybatis-demo-0.0.1-SNAPSHOT.jar .
COPY ./start.sh .

EXPOSE 8088

ENTRYPOINT ./start.sh