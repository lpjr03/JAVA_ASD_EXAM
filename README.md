# Car Management System

This Java-based application is designed to manage cars, their owners, and vehicle registrations. It allows users to register vehicles, link them to their respective owners, and optionally add them to a list of cars for scrapping.

## Tools Used
    Java: The main programming language used for the project.
    Maven: A build automation tool used for managing project dependencies and building the project.

## Static Analysis Tools
    Checkstyle: A tool for ensuring the code adheres to coding standards and conventions. It checks for issues like naming conventions, indentation, and more.
    SpotBugs: An open-source static analysis tool for detecting bugs in Java programs. It helps identify potential issues like null pointer dereferences, infinite loops, and performance problems.
    PMD: A static code analyzer that finds common coding flaws, such as unused variables, unnecessary object creation, and more, to improve the code quality.

## Testing and Code Coverage Tools

    JUnit: A widely used testing framework for Java, which ensures that individual components of the application work as expected.
    JaCoCo: A code coverage tool that integrates with JUnit to measure the test coverage of the codebase and provides reports for further analysis.

## Development Tools

    Lombok: A Java library that automatically generates boilerplate code, such as getters, setters, equals, hashCode, and toString methods, reducing the need for repetitive code.
    Javadoc: A tool that generates API documentation directly from the source code, making it easier for developers to understand how to use the application and its components.

## Deployment with Docker

Steps to deploy the application:
- Navigate to the project directory:
- Build the docker image with the following command:
    

    docker build -t car-management-system .

- Run the Docker container with the following command:


    docker run -it car-management-system

Alternatively, you can launch the container with Docker Compose to simplify container management:

    docker-compose up

