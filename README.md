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
git clone https://github.com/TryingOutSomething/DXC-Technology-Assignment.git
```

### 2. Install Java 17

Ensure that you have Java 17 installed on your machine. You can download it
from [here](https://www.oracle.com/java/technologies/downloads/#java17). Also, set the JAVA_HOME environment
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

You have three options to start the server:

<details>
  <summary><b>Option 1: Command Line</b></summary>

- **Option 1a: Command Line (Bash)**
  Navigate to the project root and run the following Gradle command:

    ```bash
    ./gradlew bootRun
    ```

- **Option 1b: Command Line (Windows)**
  Navigate to the project root and run the following Gradle command:

  ```cmd
  gradlew.bat bootRun
  ```

</details>

<details>

<summary><b>Option 2: IntelliJ IDEA</b></summary>

If you prefer to run the server from IntelliJ, follow these steps:

1. **Open IntelliJ IDEA**
    - Launch IntelliJ IDEA and open your project.

2. **Ensure Gradle Plugin is Installed**
    - Make sure the Gradle plugin is installed in IntelliJ. You can check this in `File` -> `Settings` (
      or `IntelliJ IDEA` -> `Preferences` on macOS) -> `Plugins`. Look for "Gradle" in the list of installed plugins.

3. **Create a Run Configuration**
    - To create a custom run configuration:
        - Navigate to `Run` -> `Edit Configurations`.
        - Click on the `+` icon in the top-left corner and choose `Gradle`.
        - Set the `Name` to a meaningful value.
        - In the `Gradle project` field, select your project.
        - In the `Tasks` field, enter `bootRun`.
        - Click `OK` to save the configuration.
        -
4. **Run the Application**
    - You can now run the application using the created Gradle run configuration:
        - Click on the green `Run` icon in the top-right corner.
        - Select the Gradle run configuration you just created.
        - Click `Run`.

</details>

<details>
<summary><b>Option 3: Eclipse with Gradle</b></summary>

If you prefer to run the server from Eclipse using Gradle, follow these steps:

1. **Open Eclipse**
    - Launch Eclipse and open your project.

2. **Ensure Buildship (Gradle Integration) is Installed**
    - Make sure the Buildship plugin (Gradle Integration for Eclipse) is installed in Eclipse. You can check this by
      going to `Help` -> `Eclipse Marketplace` and searching for "Buildship". Install it if not already installed.

3. **Import Gradle Project**
    - Right-click in the `Project Explorer` or `Navigator` view and choose `Import`.
    - Select `Gradle` -> `Existing Gradle Project`.
    - Browse to the root directory of your Gradle project and click `Finish`.

4. **Run `bootRun` Task**
    - In the `Gradle Tasks` view, open `your-project` -> `Tasks` -> `application` -> `bootRun`.
    - Double-click on `bootRun` to run the application.

5. **Create a Run Configuration (Optional)**
    - To create a custom run configuration:
        - Right-click on your project and choose `Run As` -> `Run Configurations`.
        - In the left panel, right-click on `Gradle Project` and choose `New Configuration`.
        - Set the `Name` to a meaningful value.
        - In the `Gradle Tasks` tab, enter `bootRun` in the `Gradle Tasks` field.
        - Click `Apply` and `Run`.

6. **Run the Application**
    - You can now run the application using the created Gradle run configuration:
        - Click on the green `Run` icon in the top toolbar.
        - Select the Gradle run configuration you just created.
        - Click `Run`.

</details>

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
