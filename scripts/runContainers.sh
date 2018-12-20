#!/bin/bash

cat << _EOL_

# RabbitMQ
docker run -d -p 5672:5672 -p 15672:15672 --hostname my-rabbit --name some-rabbit rabbitmq:3.7.8-management-alpine

# eins
docker run -d -p 8081:8080 -name funke-eins funkeeins:0.1.1

#zwei
docker run -d -p 8082:8080 -name funke-zwei funkezwei:0.1.1

_EOL_