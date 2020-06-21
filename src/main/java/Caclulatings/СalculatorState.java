package Caclulatings;

import java.util.*;

public enum СalculatorState {
    //todo remake calculator
    CHOOSING_FIRST_CURRENCY{
        @Override
        public void checkEnteredValue(String value) {
            first_currency=value;
        }
    },
    CHOOSING_SECOND_CURRENCY{
        @Override
        public void checkEnteredValue(String value) {

        }
    },
    ENTERING_VALUE{
        @Override
        public void checkEnteredValue(String value) {

        }
    }
    ;

    public abstract void checkEnteredValue(String value);
    private static Set<String> availableCurrencies=new HashSet<>(Arrays.asList("BYN","USD","EUR","RUB"));
    private static String first_currency;
}
