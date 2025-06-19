package com.comcast.crm.Listner_utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListnerimp implements IRetryAnalyzer
{
	int count=0;
	int limitcount=5;

	
	public boolean retry(ITestResult result) {
		if(count<limitcount) {
		count++;
		return true;}
		
		return false;
	}

}
