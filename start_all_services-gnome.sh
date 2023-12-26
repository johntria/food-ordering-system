#!/bin/bash

# Array to store gnome-terminal PIDs
gnome_pids=()

# Function to clean up and close all windows
cleanup() {
    echo "Cleaning up and closing all windows..."
    
    # Stop all running containers
    docker compose -f common.yml -f postgres.yml down
    docker compose -f common.yml -f zookeeper.yml down
    docker compose -f common.yml -f kafka_cluster.yml down
    docker compose -f common.yml -f init_kafka.yml down
    
    # Kill all gnome-terminal processes opened by the script
    for pid in "${gnome_pids[@]}"; do
        kill "$pid"
    done
    
    exit 1
}

# Set up trap to catch interrupt signal (Ctrl+C)
trap cleanup INT

cd infrastructure/docker-compose

# Start Postgres SQL
gnome-terminal --title="postgres" -- bash -c "docker compose -f common.yml -f postgres.yml up --build; exec bash" &
gnome_pids+=($!)

echo "Postgres started successfully!"

# Start Zookeeper
gnome-terminal --title="zookeeper" -- bash -c "docker compose -f common.yml -f zookeeper.yml up --build; exec bash" &
gnome_pids+=($!)

echo "Zookeeper started successfully!"

# Add sleep to allow Zookeeper to start successfully.
sleep 30

# Start Kafka Cluster
gnome-terminal --title="kafka_cluster" -- bash -c "docker compose -f common.yml -f kafka_cluster.yml up --build; exec bash" &
gnome_pids+=($!)

echo "Kafka Cluster started successfully!"

# Start init_kafka
gnome-terminal --title="init_kafka" -- bash -c "docker compose -f common.yml -f init_kafka.yml up --build; exec bash" &
gnome_pids+=($!)

echo "Initialization kafka  started successfully!"

# Print all running containers
docker ps

# Wait for user to manually close windows
echo "Press Ctrl+C to close all windows and stop the containers."
sleep infinity