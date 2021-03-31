package example;

import java.util.logging.Logger;

public class MessageUtil {
	
	private String message;
	private static final Logger logger1 = Logger.getLogger(MessageUtil.class.getName());
	   //Constructor
	   //@param message to be printed
	   public MessageUtil(String message){
	      this.message = message;
	   }
	      
	   // prints the message
	   public String printMessage(){
	      logger1.info(message);
	      return message;
	   }   

}
