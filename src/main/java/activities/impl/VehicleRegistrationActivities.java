package activities.impl;

public interface VehicleRegistrationActivities {
    void inputVehicleDetails(String make, String model, int year);
    boolean verifyInformation(String make, String model, int year);
    void saveToDb(String make, String updatedModel);
}
