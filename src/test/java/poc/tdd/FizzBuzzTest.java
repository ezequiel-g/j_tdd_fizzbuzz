package poc.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    // TODO: encapsulate String and Value into a class.
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final int FIZZ_DIVISOR = 3;
    private static final int BUZZ_DIVISOR = 5;

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(BUZZ_DIVISOR * 2 * FIZZ_DIVISOR * 2, FIZZ + BUZZ),
                Arguments.of(BUZZ_DIVISOR * FIZZ_DIVISOR, FIZZ + BUZZ),
                Arguments.of(BUZZ_DIVISOR * 2, BUZZ),
                Arguments.of(FIZZ_DIVISOR * 2, FIZZ),
                Arguments.of(BUZZ_DIVISOR, BUZZ),
                Arguments.of(FIZZ_DIVISOR, FIZZ),
                Arguments.of(2, "2"),
                Arguments.of(1, "1")
        );
    }

    private static Stream<Arguments> invalidArguments() {
        return Stream.of(
                Arguments.of(-1, IllegalArgumentException.class),
                Arguments.of(0, IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void test(final int input, final String expected) {
        assertEquals(expected, fizzBuzz.get(input));
    }

    @ParameterizedTest
    @MethodSource("invalidArguments")
    void testInvalidArguments(final int input, final Class expected) {
        assertThrows(expected, () -> fizzBuzz.get(input));
    }

}
