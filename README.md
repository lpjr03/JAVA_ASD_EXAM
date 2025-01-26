Car Management System

This Java-based application is designed to manage cars, their owners, and vehicle registrations. It allows users to register vehicles, link them to their respective owners, and optionally add them to a list of cars for scrapping.
Tools Used

    Java: The main programming language used for the project.
    Maven: A build automation tool used for managing project dependencies and building the project.

Static Analysis Tools

    Checkstyle: A tool for ensuring the code adheres to coding standards and conventions. It checks for issues like naming conventions, indentation, and more.
    SpotBugs: An open-source static analysis tool for detecting bugs in Java programs. It helps identify potential issues like null pointer dereferences, infinite loops, and performance problems.
    PMD: A static code analyzer that finds common coding flaws, such as unused variables, unnecessary object creation, and more, to improve the code quality.

Testing and Code Coverage Tools

    JUnit: A widely used testing framework for Java, which ensures that individual components of the application work as expected.
    JaCoCo: A code coverage tool that integrates with JUnit to measure the test coverage of the codebase and provides reports for further analysis.

Development Tools

    Lombok: A Java library that automatically generates boilerplate code, such as getters, setters, equals, hashCode, and toString methods, reducing the need for repetitive code.
    Javadoc: A tool that generates API documentation directly from the source code, making it easier for developers to understand how to use the application and its components.

Deployment with Docker

The project has been deployed using Docker, with a custom Dockerfile and a docker-compose.yml file.
Steps to deploy the application:

    Navigate to the project directory:

cd path/to/your/project

    Build the Docker image:

To build the Docker image from the provided Dockerfile, run the following command in the project directory:

docker build -t car-management-system .

    Run the Docker container:

After building the image, run the Docker container using the following command. This will start the container and attach the terminal to the container's standard input:

docker run -it car-management-system

Alternatively, you can use Docker Compose to simplify container management:

    Start the container using Docker Compose:

To launch the container with Docker Compose, use the following command:

docker-compose up