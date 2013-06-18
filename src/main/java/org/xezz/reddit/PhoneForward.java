package org.xezz.reddit;

/**
 * User: Xezz
 * Date: 18.06.13
 * Time: 15:55
 * A full PhoneForward set up
 */
public class PhoneForward {

    private final int startDay;
    private final int duration;
    private final PhoneChain chain;

    /**
     * Create a full PhoneForward
     *
     * @param chain    The chain of phone numbers
     * @param startDay Starting day of the vacation
     * @param duration amount of days the vacation will last
     */
    public PhoneForward(PhoneChain chain, int startDay, int duration) {
        this.duration = duration;
        this.startDay = startDay;
        this.chain = chain;
    }

    public PhoneForward(PhoneNumber ownNumber, PhoneNumber targetNumber, int startDay, int duration) {
        this(new PhoneChain(ownNumber, targetNumber), startDay, duration);
    }

    /**
     * Test if a given day is part of this forward
     *
     * @param day to check
     * @return true if the forward is active on this day
     */
    public boolean isDayInVacation(final int day) {
        return day >= startDay && day <= startDay + duration;
    }

    /**
     * Get the set Chain
     *
     * @return configured phone chain
     */
    public PhoneChain getChain() {
        return chain;
    }

    /**
     * Get the Duration of the absence
     *
     * @return the amount of days this forward will be set up
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Get the start day of the absence
     *
     * @return start day of the absence
     */
    public int getStartDay() {
        return startDay;
    }

    /**
     * Get the own PhoneNumber
     *
     * @return own PhoneNumber
     */
    public PhoneNumber getOwnNumber() {
        return chain.getOwnNumber();
    }

    /**
     * Get the target PhoneNumber
     *
     * @return target PhoneNumber
     */
    public PhoneNumber getTargetNumber() {
        return chain.getTargetNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneForward that = (PhoneForward) o;

        if (duration != that.duration) return false;
        if (startDay != that.startDay) return false;
        if (chain != null ? !chain.equals(that.chain) : that.chain != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startDay;
        result = 31 * result + duration;
        result = 31 * result + (chain != null ? chain.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PhoneForward{" +
                "chain=" + chain +
                ", startDay=" + startDay +
                ", duration=" + duration +
                '}';
    }
}
