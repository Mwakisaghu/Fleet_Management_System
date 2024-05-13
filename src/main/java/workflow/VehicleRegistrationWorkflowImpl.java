package workflow;

import activities.impl.VehicleRegistrationActivities;
import io.temporal.workflow.Workflow;

public class VehicleRegistrationWorkflowImpl implements VehicleRegistrationWorkflow {

    private final VehicleRegistrationActivities activities = Workflow.newActivityStub(VehicleRegistrationActivities.class);

    @Override
    public void registerVehicle(String make, String model, int year, String updatedModel) {
        // Input vehicle details
        activities.inputVehicleDetails(make, model, year);

        // Verify information
        boolean isInfoValid = activities.verifyInformation(make, model, year);
        if (isInfoValid) {
            System.out.println("Vehicle information exists.");
        } else {
            System.out.println("Vehicle information does not exist.");
            // Stops workflow if verification fails
            return;
        }

        // Save updated model to database
        activities.saveToDb(make, updatedModel);
        System.out.println("Vehicle model updated successfully.");
    }
}
