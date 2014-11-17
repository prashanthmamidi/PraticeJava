import com.test.TDD.PalindromeChecker;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mami01 on 16/05/14.
 */
public class PalindromeTest {

    PalindromeChecker palindromeChecker;

    @Before
    public void setup() throws Exception {
        palindromeChecker = new PalindromeChecker();
    }
    @Test
    public void testPalindromeObject() {
        Assert.assertNotNull(palindromeChecker);
    }

    @Test
    public void testValidPalindrome() {
        Assert.assertTrue(palindromeChecker.isValidPalindrome("faaf"));
    }

    @Test
    public void testInvalidPalindrome() {
        Assert.assertFalse(palindromeChecker.isValidPalindrome("frfrfrggtg"));
    }
}
