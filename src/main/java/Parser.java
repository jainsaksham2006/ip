/**
 * Responsible for parsing user input into command components.
 */

public class Parser {

    /**
     * Splits the user input into tokens based on whitespace.
     *
     * @param input the full command entered by the user
     * @return an array of command words
     */
    public static String[] parse(String input) {
        return input.split("\\s+");
    }
}
