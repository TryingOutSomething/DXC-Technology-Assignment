# DXC-Technology-Assignment

This repository contains the source code for the take-home assignment for DXC-Technology, where I am tasked with
creating a login application. The assignment requirements are as follows:

### Assignment Requirements:

- Create a login application with the following features:
  - Upon successful login, display a welcome page showing the user's name, username, and role (manager/user).
  - If the user has a manager role, the welcome page should include a link to access a restricted webpage.
  - The restricted webpage can only be accessed by users with a manager role and not by other user roles.
  - Implement logout functionality.

### Notes:

- If the userid or password is not valid, the user should remain at the login page with an error message stating "
  Invalid userid or password".
- All data should be stored in a database.
- The application should demonstrate the Model-View-Controller (MVC) pattern.

### Bonus Question:

- Implement the ability for the application to support at least 2 languages (e.g., English, Mandarin).

## Overview

This is a Spring Boot application that utilizes various dependencies for building a web application with PostgreSQL as
the database. The application is built with the following dependencies:

1. Spring Boot JPA
2. Spring Boot Web
3. Spring Boot Thymeleaf
4. Webjars
5. PostgreSQL
6. Gradle

## Setup Guide

Follow these steps to set up and run the project on your local machine:

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/your-project.git
```

### 2. Install Java 17

Ensure that you have Java 17 installed on your machine. You can download it
from [here](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html). Also, set the JAVA_HOME environment
variable.

### 3. Install PostgreSQL

#### Option 1: Manual Installation

Manually install PostgreSQL on your machine and create a database named `loginapp`.

#### Option 2: Using Docker (If Docker is installed)

Run the following command to set up PostgreSQL using Docker:

```bash
docker-compose up database
```

This will create a PostgreSQL container with the necessary configurations.

### 4. Create `application.properties` File

Copy `application.properties.copy` to `application.properties` and update the database connection properties according
to your setup.

```bash
cp src/main/resources/application.properties.copy src/main/resources/application.properties
```

Edit `application.properties` with your PostgreSQL connection details.

<details>

<summary>Advanced Database Configuration Guide</summary>

#### 4.1 Advanced Database Configuration Guide

If you choose to use Docker for PostgreSQL and wish to customize the database configuration, follow these advanced
steps:

##### 4.1.1 Modify Docker Compose Environment Variables

Open the `docker-compose.yml` file and locate the `environment` section. You can modify the values
of `POSTGRES_USER`, `POSTGRES_PASSWORD`, and `POSTGRES_DB` to your preferred values.

```yaml
environment:
  POSTGRES_USER: your_custom_username
  POSTGRES_PASSWORD: your_custom_password
  POSTGRES_DB: your_custom_database
```

##### 4.1.2 Update `application.properties` accordingly

If you have modified the environment values mentioned above, you must update the `application.properties` file with the
corresponding database connection properties. Replace `your_custom_database`, `your_custom_username`,
and `your_custom_password` with the values you set in the `docker-compose.yml` file.

```properties
# Replace your_custom_database with the database name defined in the docker-compose file
spring.datasource.url=jdbc:postgresql://localhost:5432/your_custom_database
spring.datasource.username=your_custom_username
spring.datasource.password=your_custom_password
```

</details>

### 5. Comment Database Initialization Properties After First Run

After the first run, comment out the following options in application.properties to avoid reinitializing the database:

```properties
#init db data
spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:db/data.sql
spring.jpa.defer-datasource-initialization=true
```

These properties **should only be run once** during the initial setup as the application will throw errors because it
will try to insert the same values into the database again.

### 6. Start the Server

You have two options to start the server:

```bash
# bash
./gradlew bootRun

# windows
gradlew.bat bootRun
```

The application will start, and you can access it at [http://localhost:8080](http://localhost:8080).

### 6. Start the Server

You have two options to start the server:

- **Option 1: Command Line**
  Navigate to the project root and run the following Gradle command:

  ```bash
  ./gradlew bootRun
  ```

- **Option 2: IntelliJ IDEA**
  If you prefer to run the server from IntelliJ, follow these steps:

    - Open IntelliJ IDEA and import the project.
    - Navigate to `Run` -> `Edit Configurations`.
    - Click on the `+` icon and choose `Spring Boot`.
    - Set the `Name` to a meaningful value.
    - Set the `Main class` to `com.yourpackage.YourApplicationClass` (replace with your actual package and application
      class).
    - Apply the changes.

  Now you can run the application from IntelliJ using the configured Spring Boot configuration.

The application will start, and you can access it at [http://localhost:8080](http://localhost:8080).

### 7. Available Accounts in the Server

The following accounts are available for testing purposes:

```
Username: user1
Password: password
Name: Jon Doe
Role: USER

Username: manager1
Password: password1
Name: Manager Doe
Role: MANAGER
```

Additionally, the server supports two types of roles:

1. **USER**
2. **MANAGER**

The application can toggle between English and Mandarin languages. You can toggle between English and Mandarin languages
using the language selector.
