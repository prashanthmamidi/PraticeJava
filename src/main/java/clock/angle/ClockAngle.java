package clock.angle;

public class ClockAngle {
    public Double calculateClockAngle(int hour, int minutes) {
        /*
        1. calculate hour Angle
        360 - 12 h [ 12 * 60 = 720 m]
        1 - 2 m
        0.5 - 1 m

        0.5 D * (h*60 + m)

        2. calculate minute Angle
        360 - 60m
        6 - 1m
        6 D * m

        3. Diff of Hour - minute angle
         */
        Double hourAngle = 0.5 *(hour*60 + minutes);
        Double minuteAngle = (double) (6 * minutes);
        double angle = Math.abs(hourAngle - minuteAngle);
        return Math.min(angle, 360-angle);
    }
}
