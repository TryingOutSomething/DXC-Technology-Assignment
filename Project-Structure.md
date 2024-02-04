## Overview

This tree-like structure provides a visual representation of the organization of files and directories in the project.
Each directory and file is presented in a hierarchical format to convey the relationships between different components
of the project.

```
.
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── tryingoutsomething/
│ │ │   └── loginapp/
│ │ │     ├── config - Localisation and web security configurations for the spring boot server
│ │ │     ├── model  - Entities to map to the database and their relations
│ │ │     ├── repositories - Defines the database query
│ │ │     ├── service - Handles the authentication by querying the user information in the database 
│ │ │     ├── utils - Utility classes to store commonly used constants
│ │ │     ├── web
│ │ │     │ └── controller - Provides the data to display in the view for routes
│ │ │     ├── JavaLoginAppApplication.java
│ │ │     └── ServletInitializer.java
│ │ └── resources/
│ │   ├── db - Contains sql data to initialise data on first run
│ │   ├── languages - Contains the localised messages to display on web pages
│ │   ├── static - Contains css styles and javascript logics for web pages
│ │   ├── templates
│ │   └── application.properties
│ └── test/

```