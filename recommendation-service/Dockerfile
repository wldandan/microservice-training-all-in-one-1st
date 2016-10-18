FROM java:8

RUN mkdir /app
WORKDIR /app

ADD build/libs/recommendation-service-0.0.1-SNAPSHOT.jar /app
RUN ln -sf recommendation-service-0.0.1-SNAPSHOT.jar recommendation-service-latest.jar

ADD wait-for-it.sh /usr/local/bin/wait-for-it
RUN chmod +x /usr/local/bin/wait-for-it

CMD java -jar recommendation-service-latest.jar