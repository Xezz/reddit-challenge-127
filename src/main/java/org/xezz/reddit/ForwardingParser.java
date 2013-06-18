package org.xezz.reddit;

/**
 * User: Xezz
 * Date: 18.06.13
 * Time: 16:23
 */
public class ForwardingParser {

    public static PhoneForward parsePhoneForward(final String input) {
        final String[] splitString = input.split(" ");
        if (splitString.length != 4) {
            throw new IllegalArgumentException("Given input was not well formatted");
        }
        PhoneNumber ownNumber = new PhoneNumber(splitString[0]);
        PhoneNumber targetNumber = new PhoneNumber(splitString[1]);
        int startDay = Integer.parseInt(splitString[2]);
        int duration = Integer.parseInt(splitString[3]);
        return new PhoneForward(new PhoneChain(ownNumber, targetNumber), startDay, duration);
    }

    private ForwardingParser() {
    }
}
