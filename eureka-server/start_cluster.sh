cd build/libs
java -jar -Dspring.profiles.active=primary eureka-server-0.0.1-SNAPSHOT.jar &
java -jar -Dspring.profiles.active=secondary eureka-server-0.0.1-SNAPSHOT.jar & 
java -jar -Dspring.profiles.active=tertiary eureka-server-0.0.1-SNAPSHOT.jar
