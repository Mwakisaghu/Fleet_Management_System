package activities.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleRegistrationActivitiesImpl implements VehicleRegistrationActivities {

    private final Connection connection;

    public VehicleRegistrationActivitiesImpl(Connection mockConnection) throws SQLException {
        // Establishing a database connection
        this.connection = DriverManager.getConnection("", "username", "password");
    }

    @Override
    public void inputVehicleDetails(String make, String model, int year) {
        try {
            String sql = "INSERT INTO vehicles(make, model, year) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, make);
            statement.setString(2, model);
            statement.setInt(3, year);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting vehicle details", e);
        }
    }

    @Override
    public boolean verifyInformation(String make, String model, int year) {
        try {
            String sql = "SELECT COUNT(*) FROM vehicles WHERE make = ? AND model = ? AND year = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, make);
            statement.setString(2, model);
            statement.setInt(3, year);

            // Execute the query - returns true if matching vehicle exists
            return statement.executeQuery().next();
        } catch (SQLException e) {
            throw new RuntimeException("Error verifying the vehicle information", e);
        }
    }

    @Override
    public void saveToDb(String make, String updatedModel) {
        try {
            String sql = "UPDATE vehicles SET model = ? WHERE make = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, updatedModel);
            statement.setString(2, make);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating the vehicle information", e);
        }
    }
}
