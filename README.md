# C3P Backend

### Init Database
Go to `src/main/resources/database` and execute `sh initDatabase.sh` this is going to create a docker container with the database and some dummy data.
>Take into account that make a `mvn clean install` will remove the database volume so be sure when you will initialize the database.

### Drop Database
Go to `src/main/resources/database` and execute `sh dropDatabase.sh` this will stop, and delete the container, and it's volumes.
