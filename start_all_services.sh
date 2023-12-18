#!/bin/bash
#Start Postgres SQL
cd infrastructure/docker-compose

docker compose -f common.yml -f postgres.yml up -d
echo "Postgres started successfully!"

# Start Zookeeper
docker compose -f common.yml -f zookeeper.yml up -d
echo "Zookeeper started successfully!"

#We have to add sleep in order to zookeper start successfully.
##TODO add depends on with include yml file .
sleep 30

# Start Kafka Cluster
docker compose -f common.yml -f kafka_cluster.yml up -d
echo "Kafka Cluster started successfully!"

# Start init_kafka
docker compose -f common.yml -f init_kafka.yml up -d
echo "Initialization kafka  started successfully!"

#Print all running containers
docker ps