package activities.impl;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface VehicleRegistrationActivities {
    @ActivityMethod
    void inputVehicleDetails();

    @ActivityMethod
    void verifyInformation();

    @ActivityMethod
    void saveToDb();
}
