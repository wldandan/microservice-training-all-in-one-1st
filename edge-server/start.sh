#!/bin/bash
/usr/local/bin/wait-for-it elk:9200
/usr/local/bin/wait-for-it elk:5044

curl -XPUT 'http://elk:9200/_template/filebeat?pretty' -d@/etc/filebeat/filebeat.template.json
/etc/init.d/filebeat start

java -jar /app/edge-server-latest.jar