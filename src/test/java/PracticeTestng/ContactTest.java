package PracticeTestng;

import org.testng.annotations.Test;

public class ContactTest {

	
		// TODO Auto-generated method stub
		@Test
		public void CreatecontactTest() {
			
			System.out.println("execute createcontact with HDFC");
		}
			
			@Test(dependsOnMethods = "CreatecontactTest")
			public void modifycontactTest() {
				System.out.println("execute modifycontact  HDFC--ICICI");
			}
		
		
			@Test(dependsOnMethods = "modifycontactTest")
			public void deletecontactTest() {
				
				System.out.println("execute deletecontact  ICICI");
		
}
		

	}


