#!/usr/bin/env bash

echo "Stopping C3PGrafana Container"
docker stop C3PGrafana

echo "Removing C3PGrafana Container"
docker rm -v C3PGrafana

if docker network ls --format '{{.Name}}' | grep -w C3PNetwork &> /dev/null;
then
  if ! docker inspect -f '{{range $n, $conf := .Containers}} {{$conf}} {{end}}' C3PNetwork | grep 'C3PPostgreSQL\|C3PGrafana' &> /dev/null;
  then
    echo "Removing Network..."
    docker network rm C3PNetwork
  fi
fi

echo "Delete grafana script finished :)"
