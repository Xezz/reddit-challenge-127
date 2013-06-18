package org.xezz.reddit;

/**
 * User: Xezz
 * Date: 18.06.13
 * Time: 16:07
 */
public class PhoneChain {
    final PhoneNumber ownNumber;
    final PhoneNumber targetNumber;

    public PhoneChain(PhoneNumber ownNumber, PhoneNumber targetNumber) {
        this.ownNumber = ownNumber;
        this.targetNumber = targetNumber;
    }

    public PhoneNumber getOwnNumber() {
        return ownNumber;
    }

    public PhoneNumber getTargetNumber() {
        return targetNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneChain that = (PhoneChain) o;

        if (ownNumber != null ? !ownNumber.equals(that.ownNumber) : that.ownNumber != null) return false;
        if (targetNumber != null ? !targetNumber.equals(that.targetNumber) : that.targetNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ownNumber != null ? ownNumber.hashCode() : 0;
        result = 31 * result + (targetNumber != null ? targetNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PhoneChain{" +
                "ownNumber=" + ownNumber +
                ", targetNumber=" + targetNumber +
                '}';
    }
}
