package org.example;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import workflow.VehicleRegistrationWorkflow;

public class Main {

    public static void main(String[] args) {
        // Connecting to the Temporal service
        WorkflowServiceStubs service = WorkflowServiceStubs.newInstance();

        // Creating a client to interact with workflows
        WorkflowClient client = WorkflowClient.newInstance(service);

        // Specifying workflow options (task queue, workflow ID)
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue("vehicle-registration-tasks")
                .setWorkflowId("vehicle-registration-workflow-123")
                .build();

        // Creating a workflow stub
        VehicleRegistrationWorkflow workflow = client.newWorkflowStub(VehicleRegistrationWorkflow.class, options);

        // Starting the vehicle registration workflow
        String make = "Toyota";
        String model = "Camry";
        int year = 2022;
        String updatedModel = "Corolla";

        workflow.registerVehicle(make, model, year, updatedModel);

        // Closing the service connection
        service.shutdown();
    }
}
