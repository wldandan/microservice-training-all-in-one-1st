FROM java:8

RUN mkdir /app
WORKDIR /app

ADD wait-for-it.sh /usr/local/bin/wait-for-it
RUN chmod +x /usr/local/bin/wait-for-it

ADD build/libs/event-composite-service-0.0.1-SNAPSHOT.jar /app
RUN ln -sf event-composite-service-0.0.1-SNAPSHOT.jar event-composite-service-latest.jar
CMD java -jar /app/event-composite-service-latest.jar