package CourseManagmentSystem.Login;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.control.LabeledMatchers;
import org.junit.jupiter.api.BeforeEach;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextInputControlMatchers.hasText;

public class LoginScreenIT extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.start(stage);
    }

    @BeforeEach
    public void setUp() {
        // Clear fields before each test
        clickOn("#usernameField").write("");
        clickOn("#passwordField").write("");
    }

    @Test
    public void testLoginScreenElements() {
        // Verify that all required elements are present
        verifyThat("#usernameField", hasText(""));
        verifyThat("#passwordField", hasText(""));
        verifyThat("Login", LabeledMatchers.hasText("Login"));
        verifyThat("Cancel", LabeledMatchers.hasText("Cancel"));
    }

    @Test
    public void testCancelButton() {
        // Type some text
        clickOn("#usernameField").write("testuser");
        clickOn("#passwordField").write("testpass");

        // Click cancel
        clickOn("Cancel");

        // Verify fields are cleared
        verifyThat("#usernameField", hasText(""));
        verifyThat("#passwordField", hasText(""));
    }

    @Test
    public void testLoginAttempt() {
        // Enter credentials
        clickOn("#usernameField").write("testuser");
        clickOn("#passwordField").write("testpass");

        // Click login and expect error dialog (since we're not connected to DB)
        clickOn("Login");
        // Dialog should appear - we can add verification for this
    }
}