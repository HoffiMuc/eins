#!/bin/bash

cat << _EOL_

./gradlew build -x test
./gradlew dockerBuildImage

SERVER_PORT=8081 SPRING_PROFILES_ACTIVE=local \\
    ./build/libs/eins-0.1.2.SNAPSHOT.jar
SERVER_PORT=8082 SPRING_PROFILES_ACTIVE=local \\
    ./build/libs/zwei-0.1.2.SNAPSHOT.jar
_EOL_