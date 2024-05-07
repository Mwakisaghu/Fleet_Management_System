package unit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import workflow.VehicleRegistrationActivitiesImpl;

import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;

public class VehicleRegistrationActivitiesTest {
    private Connection mockConnection;
    private VehicleRegistrationActivitiesImpl activities;

    @Before
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        activities = new VehicleRegistrationActivitiesImpl(mockConnection);
    }

    @After
    public void tearDown() throws SQLException {
        mockConnection.close();
    }

    @Test
    public  void testInputVehicleDetails() throws SQLException {
        // Executing the mtd being tested
        activities.inputVehicleDetails();

        // verifying that the expected SQL statement is executed
        verify(mockConnection).prepareStatement("INSERT INTO vehicles(make, model, year) VALUES(?, ?, ?)");
    }
}
