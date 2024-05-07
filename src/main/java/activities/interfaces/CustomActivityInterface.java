package activities.interfaces;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface CustomActivityInterface {
    @ActivityMethod
    void inputVehicleDetails();

    @ActivityMethod
    void verifyInformation();

    @ActivityMethod
    void saveToDb();
}
