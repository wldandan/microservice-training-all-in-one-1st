FROM java:8

RUN mkdir /app
WORKDIR /app

ADD wait-for-it.sh /usr/local/bin/wait-for-it
RUN chmod +x /usr/local/bin/wait-for-it

ADD build/libs/event-service-0.1.0.jar /app
RUN ln -sf event-service-0.1.0.jar event-service-latest.jar

CMD java -jar app/event-service-0.1.0.jar