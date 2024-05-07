package unit.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import workflow.VehicleRegistrationActivitiesImpl;

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
        mockConnection.close();
    }

    @Test
    public  void testInputVehicleDetails() throws SQLException {
        // Executing the mtd being tested
        activities.inputVehicleDetails();

        // verifying that the expected SQL statement is executed
        verify(mockConnection).prepareStatement("INSERT INTO vehicles(make, model, year) VALUES(?, ?, ?)");
    }

    @Test
    public void testVerifyInformation() throws SQLException {
        // Mock ResultSet and PreparedStatement
        PreparedStatement mockStatement = mock(PreparedStatement.class);
        ResultSet resultSet = mock(ResultSet.class);

        // Mock behaviour when the query is being executed
        when(mockStatement.executeQuery()).thenReturn((ResultSet) mockStatement);

        // Executing the method under test
        activities.verifyInformation();

        // Verifying that the expected SQL statement was executed
        verify(mockConnection).prepareStatement("SELECT * FROM vehicles WHERE MAKE = ? AND model = ? AND year = ?");
    }

    @Test
    public void testSaveToDb() throws SQLException {
        // Executing the method under test
        activities.saveToDb();

        // Verifying that the mtd was executed
        verify(mockConnection).prepareStatement("UPDATE vehicles SET model = ? WHERE make = ?");
    }
}
