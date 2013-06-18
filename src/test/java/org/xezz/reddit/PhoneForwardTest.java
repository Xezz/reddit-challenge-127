package org.xezz.reddit;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * User: Xezz
 * Date: 18.06.13
 * Time: 15:58
 */
public class PhoneForwardTest {
    @Test
    public void testIsDayInVacation() throws Exception {
        final int duration = 7;
        final PhoneNumber ownNumber = new PhoneNumber("0001");
        final PhoneNumber targetNumber = new PhoneNumber("0002");
        final PhoneChain chain = new PhoneChain(ownNumber, targetNumber);
        final int startDay = 15;
        final PhoneForward testee = new PhoneForward(chain, startDay, duration);
        assertThat("Startday should have been inside", true, is(testee.isDayInVacation(startDay)));
        assertThat("Lastday should have been inside", true, is(testee.isDayInVacation(startDay + duration)));
        assertThat("Day before startday should not be inside", false, is(testee.isDayInVacation(startDay - 1)));
        assertThat("Day after endday should not be inside", false, is(testee.isDayInVacation(startDay + duration + 1)));
    }
}
