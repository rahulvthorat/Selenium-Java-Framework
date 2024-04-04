package org.selenium.dataproviders;

import org.testng.annotations.DataProvider;

public final class LoginDataProvider {
	
	
	@DataProvider(name="InvalidData")
	public Object[][] loginData1()
	{
		return new Object[][]
				{
			{"standard_user","secret_sauc"},
			{"problem_user","secret_sauc"},
			{"performance_glitch_user","secret_sauc"},
			{"error_user","secret_sauc"},
			{"visual_user","secret_sauc"}
				};
	}
	
	@DataProvider(name="ValidData")
	public Object[][] loginData2()
	{
		return new Object[][]
				{
			{"standard_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"}
				};
	}
	
}
