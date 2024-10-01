/**
 * Represents a reward value that can be expressed in both cash and miles.
 * This class provides functionality to convert between cash and miles representations.
 *
 * Key features and design considerations:
 * - Precision: Cash values are rounded to two decimal places in the constructor to avoid floating-point precision issues.
 * - Consistency: Miles-to-cash conversion is performed in the miles constructor, ensuring consistent behavior across the class.
 * - Equality and Hashing: Implements equals() and hashCode() methods for correct behavior in collections and comparisons.
 * - String Representation: Includes a toString() method for easier debugging and logging.
 * - Immutability: The class is immutable, promoting thread safety and predictable behavior.
 * - Rounding: getMilesValue() uses Math.round() to ensure accurate integer conversion from cash to miles.
 */

package main.java;

public class RewardValue {
    private static final double MILES_TO_CASH_RATE = 0.0035;
    private final double cashValue;

    // Constructor that accepts a cash value
    public RewardValue(double cashValue) {
        this.cashValue = Math.round(cashValue * 100.0) / 100.0; // Round to 2 decimal places
    }

    // Constructor that accepts a value in miles
    public RewardValue(int milesValue) {
        this(milesValue * MILES_TO_CASH_RATE);
    }

    // Method to get the cash value
    public double getCashValue() {
        return cashValue;
    }

    // Method to get the miles value
    public int getMilesValue() {
        return (int) Math.round(cashValue / MILES_TO_CASH_RATE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardValue that = (RewardValue) o;
        return Double.compare(that.cashValue, cashValue) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(cashValue);
    }

    @Override
    public String toString() {
        return String.format("RewardValue{cashValue=%.2f, milesValue=%d}", cashValue, getMilesValue());
    }
}
