#!/usr/bin/env bash

echo "Initializing grafana..."
SUFFIX="/src/main/resources/grafana"
PWD="$(pwd)"
TARGET="${PWD%"$SUFFIX"}"/target

if ! docker network ls --format '{{.Name}}' | grep -w C3PNetwork &> /dev/null;
then
  echo "Creating Network..."
  docker network create C3PNetwork
fi

if ! docker ps --format '{{.Names}}' | grep -w C3PGrafana &> /dev/null;
then
  echo "Starting docker container..."
  docker run -d --network C3PNetwork --name C3PGrafana -p 3000:3000 -v ${PWD}/dashboards:/var/lib/grafana/dashboards -v ${PWD}/provisioning:/etc/grafana/provisioning grafana/grafana:latest
fi
