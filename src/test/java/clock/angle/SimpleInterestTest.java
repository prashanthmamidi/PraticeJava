package clock.angle;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_EVEN;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleInterestTest {

    /*
    Principal [1-1000] - rate 0.5%
    eg. p=500 -> 500*1*0.5/100
    Principal [1001-2000] - rate 1.5%
    Principal [2001+] - rate 2%
     */
    private final SimpleInterest simpleInterest = new SimpleInterest();
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void calculateInterest_throwsInvalidPrincipalAmountException_givenInvalidPrincipalAmount() throws Exception {
        expectedException.expect(InvalidPrincipalAmountException.class);
        expectedException.expectMessage("Invalid principal amount 0.00 should be greater than 0.00");
        simpleInterest.calculateInterest(value(0.00));
    }

    @Test
    public void calculateInterest_throwsInvalidPrincipalAmountException_givenNegativePrincipalAmount() throws Exception {
        expectedException.expect(InvalidPrincipalAmountException.class);
        expectedException.expectMessage("Invalid principal amount -500.00 should be greater than 0.00");
        simpleInterest.calculateInterest(value(-500.00));
    }

    @Test
    public void calculateInterest_returnsTwoPoundsFiftyPence_givenPrincipalAmountIs500Pounds() throws Exception {
        BigDecimal interestAmount = simpleInterest.calculateInterest(value(500.00));
        assertThat(interestAmount, is(value(2.50)));
    }


    @Test
    public void calculateInterest_returnsTwentyTwoPoundsFiftyPence_givenPrincipalAmountIs1500Pounds() throws Exception {
        BigDecimal interestAmount = simpleInterest.calculateInterest(value(1500.00));
        assertThat(interestAmount, is(value(22.50)));
    }

    @Test
    public void calculateInterest_returnsFiftyPoundsFiftyPence_givenPrincipalAmountIs2500Pounds() throws Exception {
        BigDecimal interestAmount = simpleInterest.calculateInterest(value(2500.00));
        assertThat(interestAmount, is(value(50.00)));
    }

    private static BigDecimal value(double val) {
        return valueOf(val).setScale(2, ROUND_HALF_EVEN);
    }


}
