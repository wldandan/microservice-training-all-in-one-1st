FROM java:8

RUN mkdir /app
WORKDIR /app
ADD ./build/libs/eureka-server-0.0.1-SNAPSHOT.jar /app
RUN ln -sf eureka-server-0.0.1-SNAPSHOT.jar eureka-server-latest.jar
CMD java -jar eureka-server-latest.jar