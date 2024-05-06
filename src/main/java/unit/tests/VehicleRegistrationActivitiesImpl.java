package unit.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VehicleRegistrationActivitiesImpl implements VehicleRegistrationActivities{
    private final Connection connection;

    public VehicleRegistrationActivitiesImpl() throws SQLException {
        // Establishing a database connection
        this.connection = DriverManager.getConnection("");
    }
}
