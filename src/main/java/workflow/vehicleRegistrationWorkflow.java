package workflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface vehicleRegistrationWorkflow {
    @WorkflowMethod
    void registerVehicle();
}
