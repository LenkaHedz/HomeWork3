package ua.kpi.tef;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    // Resource Bundle Installation's
    public static final String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));  // Ukrainian
                    new Locale("en"));        // English

    // Text's constants
    public static final String EQUAL_SING = "=";
    public static final String SPACE_SING = " ";
    public static final String OPENS_SQUARE_BRACKET = "[";
    public static final String CLOSING_SQUARE_BRACKET = "]";

    public static final String INPUT_INT_DATA_KEY = "input.int.data";
    public static final String INPUT_MIN_DATA_KEY = "input.min.data";
    public static final String INPUT_MAX_DATA_KEY = "input.max.data";
    public static final String WRONG_INPUT_INT_DATA = "input.wrong.data";
    public static final String WRONG_RANGE_DATA = "input.wrong.range";
    public static final String WRONG_MIN_RANGE_DATA = "input.wrong.min";
    public static final String WRONG_MAX_RANGE_DATA = "input.wrong.max";
    public static final String CONGRATULATION = "input.congratulation";
    public static final String YOUR_WAY = "input.way";

    public void printMessage(String message){
        System.out.println(message);
    }

    public String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {
            concatString = concatString.append(v);
        }
        return new String(concatString);
    }

    String getInputMinBMessage() {
        String str = concatenationString( bundle.getString( INPUT_MIN_DATA_KEY ),
                SPACE_SING, OPENS_SQUARE_BRACKET,
                String.valueOf(GlobalConstants.PRIMARY_MIN_BARRIER), SPACE_SING,
                String.valueOf(GlobalConstants.PRIMARY_MAX_BARRIER), CLOSING_SQUARE_BRACKET,
                SPACE_SING, EQUAL_SING);
        return str;
    }

    String getInputMaxBMessage(int minBarrier) {
        String str = concatenationString( bundle.getString( INPUT_MAX_DATA_KEY ),
                SPACE_SING, OPENS_SQUARE_BRACKET,
                String.valueOf(minBarrier +2), SPACE_SING,
                String.valueOf(GlobalConstants.PRIMARY_MAX_BARRIER), CLOSING_SQUARE_BRACKET,
                SPACE_SING, EQUAL_SING);
        return str;
    }

    String getInputMessage(int minBarrier , int maxBarrier) {
        String str = concatenationString( bundle.getString( INPUT_INT_DATA_KEY ),
                SPACE_SING, OPENS_SQUARE_BRACKET,
                String.valueOf(minBarrier), SPACE_SING,
                String.valueOf(maxBarrier), CLOSING_SQUARE_BRACKET,
                SPACE_SING, EQUAL_SING);
        return str;
    }
    void printWrongMinValueInput() {
        printMessage(bundle.getString(WRONG_MIN_RANGE_DATA) +
                getInputMessage(GlobalConstants.PRIMARY_MIN_BARRIER, GlobalConstants.PRIMARY_MAX_BARRIER));
    }
    void printWrongMaxValueInput(Model model) {
        printMessage(bundle.getString(WRONG_MAX_RANGE_DATA) +
                getInputMessage(model.getMinBarrier()+2, GlobalConstants.PRIMARY_MAX_BARRIER));
    }
    void printWrongRangeInput(Model model) {
        printMessage(bundle.getString(WRONG_RANGE_DATA) +
                getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }
    void printWrongIntInput(Model model) {
        printMessage(bundle.getString(WRONG_INPUT_INT_DATA) +
                getInputMessage(model.getMinBarrier(), model.getMaxBarrier()));
    }
    void printCongratulation(Model model) {
        printMessage(bundle.getString(CONGRATULATION) +
                model.getSecretValue());
    }
    void printWay(Model model) {
        printMessage(bundle.getString(YOUR_WAY) +
                String.valueOf(model.getYourWay()));
    }
}
