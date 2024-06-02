# nagp-2024-k8s-final-assignment

This project is the completed assignment for NAGP 2024 Batch 3 K8S sessions. This is a Spring Boot Maven application that connects to a MySQL database and performs basic CRUD operations.

The code repository is available at this [GitHub](https://github.com/RajatSinghal2507/nagp-2024-batch-3-k8s) link. 
The repo contains the following:
1. 4 K8S YAML files.
   1. namespace.yaml
   2. final-mysql.yaml
   3. final-application.yaml
   4. final-rollingupdate.yaml
2. Explanations related to these yaml files could be found at this [Drive](https://drive.google.com/file/d/1_eoO3l0Fnm41tIGaXZKmVmY2ibwGyH-B/view?usp=sharing) link.
3. The service API has the below mappings:
   1. `/demo`: GET :  A String 'TEST COMPLETED' will be displayed in the browser to assert that the application is running.
   2. `/demo/all`: GET:  List of all the users saved in the `user` table of `nagp` DB.
   3. `/demo/add?name=rajat&email=rajat@gmail.com`: POST: add a row in the `user` table of `nagp` DB with specified `name` and `email` column values.
4. The images of the application could be found on [DockerHub](https://hub.docker.com/repository/docker/rajatsinghal2507/nagp-2024-k8s-assignment/general)
## Features

- Spring Boot application
- MySQL database integration
- Basic CRUD operations
- Docker and Kubernetes deployment

## Installation Instructions

### Windows

#### Prerequisites:

1. Git
2. Maven
3. JDK-17
4. MySQL

#### Steps:

1. Clone the repository to your local system.
    ```cmd
    git clone https://github.com/RajatSinghal2507/nagp-2024-batch-3-k8s.git
    ```
2. Navigate to the root of the project and run:
    ```cmd
    mvn clean install
    ```
3. Once finished, run:
    ```cmd
    java -jar nagp-2024-final-assignment-1.0-SNAPSHOT.jar --spring.datasource.url=<jdbc connection string>/<db name>?createDatabaseIfNotExist=true --spring.datasource.username=<mysql username> --spring.datasource.password=<mysql user password>
    ```
   An example could be:
    ```cmd
    java -jar nagp-2024-final-assignment-1.0-SNAPSHOT.jar --spring.datasource.url=jdbc:mysql://localhost:3306/nagp?createDatabaseIfNotExist=true --spring.datasource.username=root --spring.datasource.password=password
    ```
4. The application will be running at port 8080 of your IP.
5. Run the following command to confirm if the application is successfully running:
    ```cmd
    curl http://<ip address of your machine>:8080/demo
    ```

### Kubernetes

#### Prerequisites:

1. kubectl

#### Steps:

1. Apply the namespace configuration:
    ```cmd
    kubectl apply -f namespace.yaml
    ```
2. Deploy MySQL:
    ```cmd
    kubectl apply -f final-mysql.yaml
    ```
3. Deploy the application:
    ```cmd
    kubectl apply -f final-assignment.yaml
    ```
4. Verify the deployment:
    ```cmd
    kubectl get all -n rajatsinghal-3171075
    kubectl get po -n rajatsinghal-3171075
    ```

## Usage

This is a very simple project. The best use case of this project is that anyone can learn the basics of Docker, YAML, and Spring Boot application development from these project files.

## Contributing

You can contribute by forking this repository and raising a Pull Request. Please mark `rajatsinghal2507` as the assignee.

## Contact Information

For further queries, please contact [Rajat Singhal](mailto:gm.rajat.singhal@gmail.com).

## Dependencies

This project depends on Maven and Java 17. The developer must have these two software installed on their machine.

## Authors

- Rajat Singhal ([gm.rajat.singhal@gmail.com](mailto:gm.rajat.singhal@gmail.com)) - Initial work

## Acknowledgments

Thanks a lot to NAGP for giving me the opportunity to learn and develop using Docker and Kubernetes. This could not have been possible so soon without your support. Also, I would like to thank ChatGPT for constant support and clarification of multiple queries.
