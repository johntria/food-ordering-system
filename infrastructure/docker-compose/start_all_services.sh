#!/bin/bash
#Start Postgres SQL &&
docker compose -f common.yml -f postgres.yml up --build

# Start Zookeeper
docker compose -f common.yml -f zookeeper.yml up --build
echo "Zookeeper started successfully!"

# Start Kafka Cluster
docker compose -f common.yml -f kafka_cluster.yml up --build
echo "Kafka Cluster started successfully!"

# Start init_kafka
docker compose -f common.yml -f init_kafka.yml up --build
echo "Initialization kafka  started successfully!"