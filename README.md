# **Fleet Management System**
---

## **Project Overview**
This Fleet Management System is designed to manage a comprehensive set of features including vehicle registration, tracking, driver management, insurance monitoring, and financial reporting. This Java-based application leverages the Temporal workflow engine to handle complex business processes and ensure reliability and scalability.

## **Features**
- **Vehicle Management**: Create, update, and delete vehicle records.
- **Driver Management**: Manage driver information and associate drivers with vehicles.
- **Financial Tracking**: Monitor income, expenses, and generate financial reports such as balance sheets and trial balances.
- **Insurance Monitoring**: Notify stakeholders when insurance policies are nearing expiration.
- **Loan Repayment**: Manage and track vehicle loan repayment schedules.
  
## **Technologies Used**
- **Java**: Primary programming language. [Install JDK 11 or later](https://adoptopenjdk.net/)
- **Temporal**: Workflow management for asynchronous tasks. [Temporal Documentation](https://docs.temporal.io/docs)
- **JUnit**: Framework for unit testing.
- **Maven**: Build and dependency management. [Maven Installation Guide](https://maven.apache.org/install.html)
- **IntelliJ IDEA**: Recommended IDE for development. [Setup IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- **Docker**: Containerization of the Temporal server. [Install Docker](https://docs.docker.com/get-docker/)
- **Git**: Version control system. [Install Git](https://git-scm.com/downloads)
  
## **Getting Started**
---
#### **Prerequisites**
Ensure you have the following installed:
- Java Development Kit (JDK) 11 or later
- IntelliJ IDEA (Community or Ultimate Edition)
- Docker Desktop
- Maven
- Git
  
#### **Setup Instructions**
---
1. **Clone the repository**
   ```sh
   git clone https://github.com/yourusername/fleet-management-system.git
   cd fleet-management-system

2. **Install Dependencies**
    Start the Temporal server using Docker:
    ```sh
    docker-compose up -d

3. **Configure IntelliJ IDEA**
- Open IntelliJ IDEA and select 'Open Project'. Navigate to the cloned directory.
- Configure Maven by navigating to Settings > Build, Execution, Deployment > Build Tools > Maven.
- Ensure Docker is integrated by adding the Docker plugin and connecting your Docker daemon in Settings > Build, Execution, Deployment > Docker.

4. **Build the Project**
- Build the project using IntelliJ's Maven Projects sidebar or by running:
    ```sh
    mvn clean install

5. Run the Application
- Run the application via IntelliJ by finding the main class and clicking 'Run'.
- Alternatively, execute using Maven:
    ```sh
    mvn exec:java -Dexec.mainClass="com.yourcompany.MainClass"

## Contribution Guidelines
---
### Reporting Issues
- Issues can be reported via the GitHub issue tracker. Please provide a detailed description, expected outcomes, actual outcomes, steps to reproduce, and screenshots if possible.

### Submitting Patches
- Detailed steps are provided in the repository for creating branches, making changes, testing, and submitting patches through pull requests.

## Acknowledgments
---
- Special thanks to all the contributors, mentors, and organizations who have supported this project. Your contributions are highly appreciated!

## License
---
- This project is licensed under the MIT License - see the LICENSE file for details.







