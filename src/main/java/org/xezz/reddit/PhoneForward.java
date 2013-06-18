package org.xezz.reddit;

/**
 * User: Xezz
 * Date: 18.06.13
 * Time: 15:55
 */
public class PhoneForward {

    private final int startDay;
    private final int duration;
    private final PhoneChain chain;

    public PhoneForward(PhoneChain chain, int startDay, int duration) {
        this.duration = duration;
        this.startDay = startDay;
        this.chain = chain;
    }

    public boolean isDayInVacation(final int day) {
        return day >= startDay && day <= startDay + duration;
    }

    public PhoneChain getChain() {
        return chain;
    }

    public int getDuration() {
        return duration;
    }

    public int getStartDay() {
        return startDay;
    }

    public PhoneNumber getOwnNumber() {
        return chain.getOwnNumber();
    }

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
