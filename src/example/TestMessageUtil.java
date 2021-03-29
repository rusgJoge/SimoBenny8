package example;

import org.junit.Test;
import static org.junit.Assert.*;



public class TestMessageUtil {

	private static String message = "Hello World";	
	private MessageUtil messageUtil = new MessageUtil(message);

	   @Test
	   public void testPrintMessage() {	  
	      assertEquals(message,messageUtil.printMessage());
	   }
}
