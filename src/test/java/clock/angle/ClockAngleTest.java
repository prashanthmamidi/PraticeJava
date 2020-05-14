package clock.angle;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ClockAngleTest {
    @Test
    public void calculateClockAngle_returnAngle_givenHourAndMinutes() throws Exception {
        ClockAngle clockAngle = new ClockAngle();

        Double actualAngle = clockAngle.calculateClockAngle(12, 35);

        Assert.assertThat(actualAngle, CoreMatchers.is(167.5));
    }
}
