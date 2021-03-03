package nl.avans.devops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExampleTest {
    @Test
    void exampleUnitTest() {
        // Arrange
        var myBool = true;

        // Act
        myBool = false;

        // Assert
        //noinspection ConstantConditions
        Assertions.assertFalse(myBool);
    }

    @Test
    void exampleUnitTestWithMock() {
        // Arrange
        class LuckyNumberGenerator {
            @SuppressWarnings("FieldCanBeLocal")
            private final int luckyNumber = 5;

            int getLuckyNumber() {
                return luckyNumber;
            }
        }

        final var luckyNumberGenerator = mock(LuckyNumberGenerator.class);
        when(luckyNumberGenerator.getLuckyNumber()).thenReturn(2);

        // Act
        final var myLuckyNumber = luckyNumberGenerator.getLuckyNumber();

        // Assert
        Assertions.assertEquals(2, myLuckyNumber);
    }
}
