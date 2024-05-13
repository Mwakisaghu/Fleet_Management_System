package workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface VehicleRegistrationWorkflow {
    @WorkflowMethod
    void registerVehicle(String make, String model, int year, String updatedModel);
}
