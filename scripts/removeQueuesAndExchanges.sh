#!/bin/bash

prefix='my'

# rabbitmqadmin --host=HOST --port=443 --ssl --vhost=VHOST --username=USERNAME --password=PASSWORD -f tsv -q list queues name > q.txt

queues=( $(rabbitmqadmin -f tsv -q list queues name | grep -E "^$prefix\\.") )
exchan=( $(rabbitmqadmin -f tsv -q list exchanges name | grep -E "^$prefix\\.") )

#printf 'queues: %s\n' "${queues[@]}"
#printf 'exchan: %s\n' "${exchan[@]}"

#Set the field separator to new line
IFS=$'\n'

for item in $queues; do
    echo "remove queue: $item"
    rabbitmqadmin -q delete queue name="${item}"
done

for item in $exchan; do
    echo "remove exchange: $item"
    rabbitmqadmin -q delete exchange name="${item}"
done
