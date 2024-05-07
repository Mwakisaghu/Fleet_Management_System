package activities.impl;

import java.sql.*;

public class VehicleRegistrationActivitiesImpl implements VehicleRegistrationActivities {

    private final Connection connection;

    public VehicleRegistrationActivitiesImpl(Connection mockConnection) throws SQLException {
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

    @Override
    public void verifyInformation() {
        // Implementation of verifying inputted vehicles information
        try {
            // Checks if vehicle info exists in the database
            String sql = "SELECT * FROM vehicles WHERE make = ? AND model = ? AND year = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Toyota");
            statement.setString(2, "Camry");
            statement.setInt(3, 1990);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the results
            if (resultSet.next()) {
                // Vehicle information exists in the database
                System.out.println("Vehicle information exists.");
            } else {
                // Vehicle information does not exist in the database
                System.out.println("Vehicle information does not exist.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveToDb() {
        // Implementing save to database activity
        try {
            String sql = "UPDATE vehicles SET model = ? WHERE make = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "Corolla");
            statement.setString(2, "Toyota");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
