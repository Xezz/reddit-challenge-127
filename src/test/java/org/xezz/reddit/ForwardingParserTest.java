package org.xezz.reddit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: Xezz
 * Date: 18.06.13
 * Time: 16:38
 */
public class ForwardingParserTest {
    @Test
    public void testParsePhoneForward() throws Exception {
        final String toParse = "0000 0001 1 3";
        final PhoneForward phoneForward = ForwardingParser.parsePhoneForward(toParse);
        assertThat("Own number did not match", "0000", is(equalTo(phoneForward.getOwnNumber().getNumber())));
        assertThat("Target number did not match", "0001", is(equalTo(phoneForward.getTargetNumber().getNumber())));
        assertThat("Start day did not match", 1, is(equalTo(phoneForward.getStartDay())));
        assertThat("Duration did not match", 3, is(equalTo(phoneForward.getDuration())));
        assertThat("Own number as PhoneNumber did not match", new PhoneNumber("0000"), is(equalTo(phoneForward.getChain().getOwnNumber())));
        assertThat("Target number as PhoneNumber did not match", new PhoneNumber("0001"), is(phoneForward.getChain().getTargetNumber()));
        assertThat("Own number as PhoneNumber did not match", new PhoneNumber("0000"), is(equalTo(phoneForward.getOwnNumber())));
        assertThat("Target number as PhoneNumber did not match", new PhoneNumber("0001"), is(phoneForward.getTargetNumber()));
    }
}
