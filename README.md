# Songr

A Spring app with Thymeleaf views

## Attributions

    - Chandler Puckett for card structure

## Running the App

To run the app, clone the [Github repository](https://github.com/jnelsonjava/songr) using the following command:

`git clone https://github.com/jnelsonjava/songr.git`

You'll need to create a postgresql database named "songr" and create a connection. To make the connection, navigate to the `src/main/resources/application.properties` file. Replace `<username>` and `<password>` with the postgres username and password for your local database. Example:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/songr
spring.datasource.username=yourPostgresUserNameHere
spring.datasource.password=yourPostgresPasswordHere
```

In your terminal, navigate into the *songr* directory. From there you can run the app with the following command:

`./gradle bootRun`

This will serve the app on http://localhost:8080/.

You can run the test suite from the same directory using:

`./gradlew test`

Enjoy!
