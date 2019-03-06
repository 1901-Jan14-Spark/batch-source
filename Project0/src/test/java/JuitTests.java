import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.dao.Bank_AccountDAO_Impl;
public class JuitTests {
	



@Test
public void testValueWasdeposited() {
	assertEquals(80.0, Bank_AccountDAO_Impl.increaseBalance(50.0,30.0), 0.01);
}

@Test
public void testLargeNumbers() {
	assertEquals(5050.0, Bank_AccountDAO_Impl.increaseBalance(50.0,5000.0), 0.01);
}


@Test
public void testNegativeValue() {
	assertEquals(50.0, Bank_AccountDAO_Impl.increaseBalance(50.0,-30.0), 0.01);
}


@Test
public void testValueWasWithdrawn() {
	assertEquals(20.0, Bank_AccountDAO_Impl.decreaseBalance(50.0,30.0), 0.01);
}

@Test
public void testNegativeWithdrawal() {
	assertEquals(50.0, Bank_AccountDAO_Impl.decreaseBalance(50.0,-30.0), 0.01);
}

@Test
public void testBalanceLessThanWithdrawal() {
	assertEquals(50.0, Bank_AccountDAO_Impl.decreaseBalance(50.0,80.0), 0.01);
}
}
