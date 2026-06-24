import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        // Arrange (Setup Test Fixture)
        account = new BankAccount(100.0);
        System.out.println("Set up: BankAccount initialized with 100.0 balance.");
    }

    @After
    public void tearDown() {
        // Teardown
        account = null;
        System.out.println("Tear down: BankAccount reference set to null.");
    }

    @Test
    public void testDeposit() {
        // Act
        account.deposit(50.0);

        // Assert
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        // Act
        account.withdraw(40.0);

        // Assert
        assertEquals(60.0, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithdrawInsufficientFunds() {
        // Act
        account.withdraw(150.0);
    }
}
