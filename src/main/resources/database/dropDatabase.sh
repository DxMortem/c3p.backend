SUFFIX="/src/main/resources/database"
PWD="$(pwd)"
TARGET="${PWD%"$SUFFIX"}"/target
echo "$TARGET"

echo "Stopping C3PPostgreSQL Container"
docker stop C3PPostgreSQL

echo "Removing C3PPostgreSQL Container"
docker rm -v C3PPostgreSQL

echo "Deleting data from volume ${TARGET}/psql"
rm -rf "${TARGET}"/psql

echo "Drop database script finished :)"

if docker network ls --format '{{.Name}}' | grep -w C3PNetwork &> /dev/null;
then
  if ! docker inspect -f '{{range $n, $conf := .Containers}} {{$conf}} {{end}}' C3PNetwork | grep 'C3PPostgreSQL\|C3PGrafana' &> /dev/null;
  then
    echo "Removing Network..."
    docker network rm C3PNetwork
  fi
fi
