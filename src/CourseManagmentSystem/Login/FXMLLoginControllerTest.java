package CourseManagmentSystem.Login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import model.Api;
import static org.mockito.Mockito.*;

class FXMLLoginControllerTest {
    @Mock
    private TextField usernameField;

    @Mock
    private PasswordField passwordField;

    private FXMLLoginController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new FXMLLoginController();
        // Inject mocked fields
        controller.usernameField = usernameField;
        controller.passwordField = passwordField;
    }

    @Test
    void testSuccessfulLogin() throws SQLException {
        // Arrange
        when(usernameField.getText()).thenReturn("validUser");
        when(passwordField.getText()).thenReturn("validPass");

        // Mock the API call
        try (MockedStatic<Api> mockedApi = mockStatic(Api.class)) {
            mockedApi.when(() -> Api.searchUser("validUser", "validPass"))
                    .thenReturn("Yes");

            // Act
            controller.handleLogin();

            // Assert
            mockedApi.verify(() -> Api.searchUser("validUser", "validPass"));
        }
    }

    @Test
    void testFailedLogin() throws SQLException {
        // Arrange
        when(usernameField.getText()).thenReturn("invalidUser");
        when(passwordField.getText()).thenReturn("invalidPass");

        // Mock the API call
        try (MockedStatic<Api> mockedApi = mockStatic(Api.class)) {
            mockedApi.when(() -> Api.searchUser("invalidUser", "invalidPass"))
                    .thenReturn("No");

            // Act
            controller.handleLogin();

            // Assert
            mockedApi.verify(() -> Api.searchUser("invalidUser", "invalidPass"));
        }
    }

    @Test
    void testHandleCancel() {
        // Act
        controller.handleCancel();

        // Assert
        verify(usernameField).clear();
        verify(passwordField).clear();
    }
}