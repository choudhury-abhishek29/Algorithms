package prep.interview;

import java.util.regex.Pattern;

public class ValidateEmail {
	
	public static void main(String[] args) {
		String emailAddress = "a@b@c.com";
		
	    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	    
	    Pattern emailPattern = Pattern.compile(regexPattern); 
	    
	    System.out.println(emailPattern.matcher(emailAddress).matches());
	}
}
