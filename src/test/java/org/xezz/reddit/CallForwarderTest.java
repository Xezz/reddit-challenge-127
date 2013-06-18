package org.xezz.reddit;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: Xezz
 * Date: 18.06.13
 * Time: 19:25
 */
public class CallForwarderTest {

    private CallForwarder testee;

    @Before
    public void setUp() {
        final List<PhoneForward> forwards = new ArrayList<PhoneForward>();
        forwards.add(ForwardingParser.parsePhoneForward("0000 0001 1 3"));
        forwards.add(ForwardingParser.parsePhoneForward("0001 4964 2 1"));
        forwards.add(ForwardingParser.parsePhoneForward("4964 0005 2 3"));
        forwards.add(ForwardingParser.parsePhoneForward("0005 1234 2 3"));
        forwards.add(ForwardingParser.parsePhoneForward("1234 9874 2 3"));
        forwards.add(ForwardingParser.parsePhoneForward("9874 1999 2 3"));

        forwards.add(ForwardingParser.parsePhoneForward("0012 2354 2 6"));
        forwards.add(ForwardingParser.parsePhoneForward("2354 9899 2 6"));

        forwards.add(ForwardingParser.parsePhoneForward("9555 9556 2 6"));
        forwards.add(ForwardingParser.parsePhoneForward("5555 6666 2 6"));
        testee = new CallForwarder(forwards);
    }

    @Test
    public void testGetTotalForwardingsByDay() throws Exception {
        final int totalForwardingsByDay = testee.getTotalForwardingsByDay(2);
        assertThat("Expected amount of forwards did not match", 10, is(totalForwardingsByDay));
    }

    @Test
    public void testGetLongestChainByDay() throws Exception {
        final int longestChainByDay = testee.getLongestChainByDay(2);
        assertThat("Expected chain length did not match", 6, is(longestChainByDay));
    }

    @Test
    public void testLaterDay() throws Exception {
        final int totalForwardingsByDay = testee.getTotalForwardingsByDay(7);
        final int longestChainByDay = testee.getLongestChainByDay(7);
        assertThat("Expected amount of forwards did not match", 4, is(totalForwardingsByDay));
        assertThat("Expected chain lenght did not match", 2, is(longestChainByDay));
    }
}
