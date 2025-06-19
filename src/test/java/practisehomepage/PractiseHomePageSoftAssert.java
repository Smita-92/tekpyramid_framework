package practisehomepage;

import org.testng.Assert;




	import static org.testng.Assert.assertTrue;

	import java.lang.reflect.Method;
	import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

	public class PractiseHomePageSoftAssert {
		@Test

		public void homepageatest(Method mtd) {
			System.out.println(mtd.getName() + "Test Start");
			SoftAssert assertobj=new SoftAssert();
			
			System.out.println("Step-1");
			System.out.println("Step-2");
			assertobj.assertEquals("home", "home-page");
			System.out.println("Step-3");
			assertobj.assertEquals("home-crm", "home-crm");
			System.out.println("Step-4");

			System.out.println(mtd.getName() + "Test end");

		}

		@Test

		public void verifylogo(Method mtd) {
			SoftAssert assertobj=new SoftAssert();
			
			System.out.println(mtd.getName() + "Test Start");
			System.out.println(mtd.getName() + "Test Start");
			System.out.println("Step-1");
			System.out.println("Step-2");
			assertobj.assertTrue(true);
			System.out.println("Step-3");

			System.out.println("Step-4");
			assertobj.assertAll();

			System.out.println(mtd.getName() + "Test end");
		}
	}

