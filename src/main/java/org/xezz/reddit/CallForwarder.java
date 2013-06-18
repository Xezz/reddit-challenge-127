package org.xezz.reddit;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Xezz
 * Date: 18.06.13
 * Time: 16:57
 * Manages the call forwarding
 */
public class CallForwarder {
    private List<PhoneForward> phoneForwards;

    public CallForwarder(List<PhoneForward> forwards) {
        this.phoneForwards = forwards;
    }

    public int getTotalForwardingsByDay(final int day) {
        return getAllForwardsByDay(day).size();
    }

    private List<PhoneForward> getAllForwardsByDay(final int day) {
        List<PhoneForward> specificForwards = new ArrayList<PhoneForward>();
        for (PhoneForward pf : phoneForwards) {
            if (pf.isDayInVacation(day)) {
                specificForwards.add(pf);
            }
        }
        return specificForwards;
    }

    /**
     * Get the longest forwarding chain for a specific day
     *
     * @param day the day to check for the chain lenght
     * @return length of the longest chain
     */
    public int getLongestChainByDay(final int day) {
        final List<PhoneForward> allForwardsByDay = getAllForwardsByDay(day);
        if (allForwardsByDay.size() == 0) {
            return 0;
        }
        int chainLength = 0;
        while (allForwardsByDay.size() >= chainLength) {
            PhoneForward p = allForwardsByDay.remove(0);
            int currentCount = 1;
            currentCount = getAmountOfPrecursorsAndRemoveThem(p, allForwardsByDay, currentCount);
            currentCount = getAmountOfSuccessorsAndRemoveThem(p, allForwardsByDay, currentCount);
            if (currentCount > chainLength) {
                chainLength = currentCount;
            }
        }
        return chainLength;
    }

    /**
     * Get recursively the amount of precursors
     *
     * @param pf           PhoneForward to check
     * @param list         List of all remaining PhoneForwards
     * @param currentCount the current count of found forwards
     * @return total amount of found forwards or currentcount if none were found
     */
    private int getAmountOfPrecursorsAndRemoveThem(PhoneForward pf, List<PhoneForward> list, int currentCount) {
        for (PhoneForward value : list) {
            if (value.getTargetNumber().equals(pf.getOwnNumber())) {
                list.remove(value);
                currentCount++;
                return getAmountOfPrecursorsAndRemoveThem(value, list, currentCount);
            }
        }
        return currentCount;
    }

    /**
     * Get recursively the amount of successors
     *
     * @param pf           PhoneForward to check
     * @param list         List of all remaining PhoneForwards
     * @param currentCount the current count of found forwards
     * @return total amount of forwards or currentcount none were found
     */
    private int getAmountOfSuccessorsAndRemoveThem(PhoneForward pf, List<PhoneForward> list, int currentCount) {
        for (PhoneForward value : list) {
            if (value.getOwnNumber().equals(pf.getTargetNumber())) {
                list.remove(value);
                currentCount++;
                return getAmountOfSuccessorsAndRemoveThem(value, list, currentCount);
            }
        }
        return currentCount;
    }
}
