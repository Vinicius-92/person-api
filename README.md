[![My Linkedin Profile](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](http://www.linkedin.com/in/vinicius-92)

## Person control REST API 

### A full CRUD API for a model/entity person

A fully functional API that control person and their list of phone numbers, deployed at Heroku. Made using:

* Java 11 with Spring Boot, JPA and Maven
* H2-Database
* Lombok
* Heroku

### What I've learned: 

How to structure a Spring Boot Java application using best practices and SOLID principles, using dependencies from Maven like Lombok and Mapstruct to save time and create more readable and easy to maintain code. I've also learned how to solve de N+1 selects problem using the ORM aspect of cached information, as explained by Martin Fowler is his book 'Patterns of Enterprise Application Architecture', and last how to apply pagination to make a better response to an endpoint with multiple results.

### How to use:

You can use a API Test application, Postman or Insomnia, to test the endpoints directly at the URL in Heroku, the link is:

```
https://vinicius-personapi.herokuapp.com/
```

Or you can clone the project to your machine and run, you'll need Java 11 and Maven 3.8.1. The commands to clone and to run are the following:

Clone:
```shell script
git clone https://github.com/Vinicius-92/person-api.git
```

Run: (in the root of project directory)
```shell script
mvn spring-boot:run
```

#### Endpoints:

GET - List all persons in database:
```
/api/v1/people
```

GET - Fecth a person by ID:
```
/api/v1/people/{id}
```

DELET - Delete person by ID:
```
/api/v1/people/{id}
```

POST - Create person:
```
/api/v1/people/

```
JSON required in body:
```json
{ 
  "firstName": "Example",
  "lastName": "AnotherExample",
  "cpf": "12345678912"
}
``` 

### To-do:
* Implement Patch and Put Http methods
* ~Add more data and return values in pages (Pageable)~ -> Done
* ~Solve N+1 selects problem~ -> Done
* ~Create a basic database~ -> Done