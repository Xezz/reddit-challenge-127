package org.xezz.reddit;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reddit challenge 127
 * http://www.reddit.com/r/dailyprogrammer/comments/1g09qy/060913_challenge_127_intermediate_call_forwarding/
 */
public class App {
    public static void main(String[] args) {

        // Console input
        Console console = System.console();
        System.out.print("Enter the amount of datasets to scan: ");
        if (console != null) {
            Scanner scanner = new Scanner(console.reader());
            while (scanner.hasNext()) {
                String input = scanner.nextLine();
                try {
                    final int amountToRead = Integer.parseInt(input);
                    final List<PhoneForward> scannedPhoneForwards = new ArrayList<PhoneForward>(amountToRead);
                    for (int i = 0; i < amountToRead; i++) {
                        scannedPhoneForwards.add(ForwardingParser.parsePhoneForward(scanner.nextLine()));
                    }
                    System.out.print("Enter the day to look for forwardings: ");
                    final int dayToCheck = Integer.parseInt(scanner.nextLine());
                    CallForwarder callForwarder = new CallForwarder(scannedPhoneForwards);
                    System.out.println(callForwarder.getTotalForwardingsByDay(dayToCheck) + " call forwardings set up on day " + dayToCheck);
                    System.out.println(callForwarder.getLongestChainByDay(dayToCheck) + " call forwardings are the longest chain on day " + dayToCheck);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid format");
                    scanner.close();
                    System.exit(-1);
                }
            }
            scanner.close();
        } else {
            // No console found (for example starting from IDEA)
            // So show what it looks like with sample input
            final String firstLine = "0000 0001 1 3";
            final String secondLine = "0001 4964 2 1";
            final String thirdLine = "4964 0005 2 3";
            final String forth = "9555 9556 2 3";
            final String fifth = "0005 1234 2 3";
            final String sixth = "1234 9874 2 3";
            final String seventh = "9874 1999 2 3";
            final String eighth = "0012 2354 2 3";
            final String ninth = "2354 9899 2 3";
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
            forwards.add(ForwardingParser.parsePhoneForward(ninth));
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
}
