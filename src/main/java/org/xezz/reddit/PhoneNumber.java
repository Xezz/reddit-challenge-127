package org.xezz.reddit;

public class PhoneNumber {
    private final String phoneNumber;

    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PhoneNumber that = (PhoneNumber) o;

        if (phoneNumber != that.phoneNumber) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return phoneNumber != null ? phoneNumber.hashCode() : 0;
    }
}