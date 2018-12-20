#!/bin/bash

cat << _EOL_

docker network create mynetwork

# RabbitMQ
docker run -d -p 5672:5672 -p 15672:15672 --network mynetwork --hostname my-rabbit --name some-rabbit rabbitmq:3.7.8-management-alpine

# eins
docker run -d -p 8081:8080                --network mynetwork --hostname eins      --name funke-eins dhoffi/funkeeins:0.1.1

#zwei
docker run -d -p 8082:8080                --network mynetwork --hostname zwei      --name funke-zwei dhoffi/funkezwei:0.1.1

_EOL_