package unit.tests;

import org.junit.After;
import org.junit.Before;
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
}
