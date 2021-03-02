package nl.avans.devops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    @Test
    public void exampleUnitTest() {
        // Arrange
        boolean myBool = true;

        // Act
        myBool = false;

        // Assert
        Assertions.assertFalse(myBool);
    }
}
