import java.util.Iterator;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class main {

  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC48dbe4415aaf462551e6402fd5468085";
  public static final String AUTH_TOKEN = "129628478c5830b5bbd1dabdf4a711d8";
  public static String SEND = "+16507998047";
  public static final String FROM = "+16506009887";

  public static void main(String[] args) {
	  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	  while(true){
	   String input = "<h1>hi my guy +16507998047</h1>";
	    String parsedInput = parseHTML(input);

    if(parsedInput.substring(0,7).equals("contact")){
    	SEND = parsedInput.substring(8);
    	
    } 
    else{
    	Message message = Message.creator(new PhoneNumber(SEND),
        new PhoneNumber(FROM), 
        parsedInput).create() ;
    }
    
    	ResourceSet<Message> messages = Message.reader().read();
  	    Iterator it = messages.iterator();
   	    Message current = (Message) it.next();
   	    String k = current.getBody().toString();
   	    x(k);
        //System.out.println(x(k));

	  }
     
	  
	  
  }
  
  
  public static String listener(String k){
	  String k1 = k;
	  String a = null;
	  while(a == null){
	    	k1 = k;
	    	
	        ResourceSet<Message> messages = Message.reader().read();
	        Iterator it = messages.iterator();
	        Message current = (Message) it.next();
	       
	        k = current.getBody().toString();
	        if(k.substring(0,1).equals(" ")){
	  		  a = k;
	        }
	        
	        }
	  return a;
  }
  
  public static String x(String b){
	  String y = listener(b);
	  System.out.println(y);
	  //send y
	  return y;
  }
  
  public static String parseHTML(String s){
		s = s.replaceAll("\\<.*?\\> ?", "");
		System.out.println(s);
		return s;
	}
}
