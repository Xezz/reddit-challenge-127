package org.xezz.reddit;

import java.util.ArrayList;
import java.util.List;

/**
 * Reddit challenge 127
 * http://www.reddit.com/r/dailyprogrammer/comments/1g09qy/060913_challenge_127_intermediate_call_forwarding/
 */
public class App {
    public static void main(String[] args) {

        final String amountOfForwards = "3";
        final String firstLine = "0000 0001 1 3";
        final String secondLine = "0001 4964 2 1";
        final String thirdLine = "4964 0005 2 3";
        final String forth = "9555 9556 2 3";
        final String fifth = "0005 1234 2 3";
        final String sixth = "1234 9874 2 3";
        final String seventh = "9874 1999 2 3";
        final String eighth = "0012 2354 2 3";
        final String nineth = "2354 9899 2 3";
        final String tenth = "5555 6666 2 3";

        final String dayToLookFor = "2";

        List<PhoneForward> forwards = new ArrayList<PhoneForward>();
        forwards.add(ForwardingParser.parsePhoneForward(firstLine));
        forwards.add(ForwardingParser.parsePhoneForward(secondLine));
        forwards.add(ForwardingParser.parsePhoneForward(thirdLine));
        forwards.add(ForwardingParser.parsePhoneForward(forth));
        forwards.add(ForwardingParser.parsePhoneForward(fifth));
        forwards.add(ForwardingParser.parsePhoneForward(sixth));
        forwards.add(ForwardingParser.parsePhoneForward(seventh));
        forwards.add(ForwardingParser.parsePhoneForward(eighth));
        forwards.add(ForwardingParser.parsePhoneForward(nineth));
        forwards.add(ForwardingParser.parsePhoneForward(tenth));
        CallForwarder cf = new CallForwarder(forwards);
        final int day = Integer.parseInt(dayToLookFor);
        final int longestChainByDay = cf.getLongestChainByDay(day);
        final int totalForwardingsByDay = cf.getTotalForwardingsByDay(day);
        System.out.println("Total Forwardings: " + totalForwardingsByDay);
        System.out.println("Longest Chain: " + longestChainByDay);

        System.out.println("Forwards for not covered day " + cf.getTotalForwardingsByDay(19));
        System.out.println("Chains for not covered day " + cf.getLongestChainByDay(19));


    }
}
