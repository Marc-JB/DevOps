package nl.avans.devops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExampleTest {
    @Test
    void exampleUnitTest() {
        // Arrange
        boolean myBool = true;

        // Act
        myBool = false;

        // Assert
        Assertions.assertFalse(myBool);
    }
}
