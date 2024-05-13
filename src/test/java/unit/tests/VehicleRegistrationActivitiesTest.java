package unit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import activities.impl.VehicleRegistrationActivitiesImpl;

import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        // No need to close the mock connection
    }

    @Test
    public void testInputVehicleDetails() throws SQLException {
        // Executing the method being tested
        activities.inputVehicleDetails("Toyota", "Camry", 1990);

        // Verifying that the expected SQL statement is executed
        verify(mockConnection).prepareStatement("INSERT INTO vehicles(make, model, year) VALUES(?, ?, ?)");
    }

    @Test
    public void testVerifyInformation() throws SQLException {
        // Mock PreparedStatement
        PreparedStatement mockStatement = mock(PreparedStatement.class);

        // Mock behavior when the query is being executed
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockStatement);
        when(mockStatement.executeQuery()).thenReturn(mock(ResultSet.class));

        // Executing the method under test
        activities.verifyInformation("Toyota", "Camry", 1990);

        // Verifying that the expected SQL statement was executed
        verify(mockConnection).prepareStatement("SELECT * FROM vehicles WHERE make = ? AND model = ? AND year = ?");
    }

    @Test
    public void testSaveToDb() throws SQLException {
        // Executing the method under test
        activities.saveToDb("Toyota", "Corolla");

        // Verifying that the method was executed
        verify(mockConnection).prepareStatement("UPDATE vehicles SET model = ? WHERE make = ?");
    }
}
