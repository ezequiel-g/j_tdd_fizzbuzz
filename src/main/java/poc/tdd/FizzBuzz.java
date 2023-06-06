package poc.tdd;

public class FizzBuzz {

    // TODO: encapsulate String and Value into a class.
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final int FIZZ_DIVISOR = 3;
    private static final int BUZZ_DIVISOR = 5;

    private static final int MIN_POSITION = 1;

    public String get(final int position) {
        validate(position);

        final boolean isFizz = isDivisible(position, FIZZ_DIVISOR);
        final boolean isBuzz = isDivisible(position, BUZZ_DIVISOR);

        if (isFizz && isBuzz) return FIZZ + BUZZ;
        if (isFizz) return FIZZ;
        if (isBuzz) return BUZZ;

        return String.valueOf(position);
    }

    private void validate(final int position) {
        if (position < MIN_POSITION) throw new IllegalArgumentException();
    }

    private boolean isDivisible(final int dividend, final int divisor) {
        return dividend % divisor == 0;
    }

}
