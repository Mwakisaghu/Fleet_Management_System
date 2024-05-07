package unit.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleRegistrationActivitiesImpl implements VehicleRegistrationActivities {

    private final Connection connection;

    public VehicleRegistrationActivitiesImpl() throws SQLException {
        // Establishing a database connection
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
    }

    @Override
    public void inputVehicleDetails() {
        // Vehicles creation input activities
        try {
            String sql = "INSERT INTO vehicles(make, model, year) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Toyota");
            statement.setString(2, "Camry");
            statement.setInt(3, 1990);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle or rethrow the exception as needed
        }
    }
}
