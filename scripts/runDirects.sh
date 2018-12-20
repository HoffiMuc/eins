#!/bin/bash

cat << _EOL_

./gradlew build -x test

SPRING_PROFILES_ACTIVE=local,testsetup \\
    ./build/libs/minimal_spring_cloud_stream_rabbit.jar

SERVER_PORT=8081 SPRING_PROFILES_ACTIVE=local,direct,eins \\
    ./build/libs/minimal_spring_cloud_stream_rabbit.jar \\
        --spring.application.name=minimal_spring_cloud_stream_rabbit1
SERVER_PORT=8082 SPRING_PROFILES_ACTIVE=local,direct,zwei \\
    ./build/libs/minimal_spring_cloud_stream_rabbit.jar \\
        --spring.application.name=minimal_spring_cloud_stream_rabbit2
_EOL_