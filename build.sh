#!/usr/bin/env bash

cd eureka-server && ./gradlew clean build && cd -
cd config-server && ./gradlew clean build && cd -
cd edge-server && ./gradlew clean build && cd -
cd turbine-server && ./gradlew clean build && cd -

cd event-composite-service && ./gradlew clean build && cd -
cd event-service && ./gradlew clean build && cd -
cd review-service && ./gradlew clean build && cd -
cd recommendation-service && ./gradlew clean build && cd -