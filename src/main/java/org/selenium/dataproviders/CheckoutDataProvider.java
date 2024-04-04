package org.selenium.dataproviders;

import org.testng.annotations.DataProvider;

public class CheckoutDataProvider {

	
	 @DataProvider(name="checkoutData")
	    public Object[][] checkoutData() {
	        return new Object[][] {
	        	{"John", "Doe", "12345"},
	            {"Jane", "Smith", "67890"},
	            {"Alice", "Johnson", "54321"},
	            {"Bob", "Williams", "98765"},
	            {"Emily", "Brown", "13579"},
	            {"Michael", "Jones", "24680"},
	            {"Sarah", "Davis", "97531"}
	        };
	    }
}
