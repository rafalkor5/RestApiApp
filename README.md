# Docker(FamilyMemberApp)(FamilyApp)

### How to run this docker images?
To start the application, you need to install docker.
To begin, download the repository and unzip or clone it.
To start the container application, use the command line where you downloaded the project and use the command:

```
docker-compose up
```

That's it.

### How to open this project?
Use the pom file in Application folder.

### What is inside Postman folder?
Inside the folder you can find a postman collection.
It can be imported and rest api tested.

### What is inside a Test folder?
Inside you can find screenshots of controler tests. Unfortunately these tests only work with a local MySQL database.

### How I can run Swagger UI?
App run from docker:
```
Use http://localhost:9010/swagger-ui/index.html in your browser for FamilyMemberApp.
Use http://localhost:9020/swagger-ui/index.html in your browser for FamilyApp.
```
App run Locally:
```
Use http://localhost:9014/swagger-ui/index.html in your browser for FamilyMemberApp.
Use http://localhost:9026/swagger-ui/index.html in your browser for FamilyApp.
```
### How to run this project Locally from e.g.IntelliJ IDEA?
To run the application, you can use a database running in the docker. 
In the "local database" folder is the mysql database along with phpmyadmin.
To start the container use the command line inside "local database" folder and use the command:
```
docker-compose up
```
To use a other mysql database, configure application-local.properties inside folder 
src/main/resources and application.properties inside src/test/resources in both application.

