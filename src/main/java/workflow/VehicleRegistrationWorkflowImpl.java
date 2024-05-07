package workflow;

import activities.impl.VehicleRegistrationActivities;
import io.temporal.workflow.Workflow;

public class VehicleRegistrationWorkflowImpl implements VehicleRegistrationWorkflow {

    private final VehicleRegistrationActivities activities = Workflow.newActivityStub(VehicleRegistrationActivities.class);

    @Override
    public void registerVehicle() {
        activities.inputVehicleDetails();
        activities.verifyInformation();
        activities.saveToDb();
    }
}
