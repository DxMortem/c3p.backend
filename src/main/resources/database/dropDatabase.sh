SUFFIX="/src/main/resources/database"
PWD="$(pwd)"
TARGET="${PWD%"$SUFFIX"}"/target
echo "$TARGET"

echo "Stopping C3PPostgreSQL Container"
docker stop C3PPostgreSQL

echo "Removing C3PPostgreSQL Container"
docker rm -v C3PPostgreSQL

echo "Deleting data from volume ${TARGET}/psql/data"
rm -rf "${TARGET}"/psql/data

echo "Drop database script finished :)"
