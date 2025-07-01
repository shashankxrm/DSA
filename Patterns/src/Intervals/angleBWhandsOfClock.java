package Intervals;

// LC1344: Angle Between Hands of a Clock
// Given two integers hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
// The hour hand is on the hour and the minute hand is on the minute.
// The angle between the two hands is calculated as follows:
// 1. The minute hand moves 360 degrees in 60 minutes, so it moves 6 degrees per minute.
// 2. The hour hand moves 360 degrees in 12 hours, so it moves 30 degrees per hour.
// 3. The minute hand also contributes to the hour hand's position, moving 0.5 degrees for each minute (30 degrees per
// hour / 60 minutes).
// Example 1: Input: hour = 12, minutes = 30 Output: 165.0
// Example 2: Input: hour = 3, minutes = 30 Output: 75.0
public class angleBWhandsOfClock {
    public double angleClock(int hour, int minutes) { // Time: O(1), Space: O(1)
        // Normalize hour to 12-hour format
        hour = hour % 12;
        // Calculate the positions of the minute and hour hands
        double minuteAngle = minutes * 6; // 360 degrees / 60 minutes = 6 degrees per minute
        double hourAngle = (hour * 30) + (minutes * 0.5); // 360 degrees / 12 hours = 30 degrees per hour + 0.5 degrees per minute
        // Calculate the absolute difference between the two angles
        double angle = Math.abs(hourAngle - minuteAngle);
        // Return the smaller angle
        return Math.min(angle, 360 - angle);
    }
}
