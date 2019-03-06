package bankingapp;
import com.revature.model.Account;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class BankAppTest {
	@Test
	public void withdrawTooMuchTest() {
		Account temp = new Account(1,40.45,55.23);
		assertEquals(false,temp.withdrawFunds(58.50, 'c'));
	}
	@Test
	public void withdrawGoodAmountTest() {
		Account temp = new Account(1,40.45,55.23);
		assertEquals(true,temp.withdrawFunds(54.23, 's'));
	}
	@Test
	public void withdrawNegativTest() {
		Account temp = new Account(1,40.45,55.23);
		assertEquals(false,temp.withdrawFunds(-40, 'c'));
	}
	@Test
	public void withdrawFromInvalidTypeTest() {
		Account temp = new Account(1,40.45,55.23);
		assertEquals(false,temp.withdrawFunds(40, 'a'));
	}
	@Test
	public void depositNegativTest() {
		Account temp = new Account(1,40.45,55.23);
		assertEquals(false,temp.depositFunds(-40, 'c'));
	}
	@Test
	public void depositGoodAmountTest() {
		Account temp = new Account(1,40.45,55.23);
		assertEquals(true,temp.depositFunds(60, 's'));
	}
	@Test
	public void depositToInvalidTypeTest() {
		Account temp = new Account(1,40.45,55.23);
		assertEquals(false,temp.depositFunds(20, 'b'));
	}
	

}
