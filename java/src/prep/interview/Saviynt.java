package prep.interview;

//https://onecompiler.com/

public class Saviynt {
	private boolean isValidPassword(String password){
	      String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String numbers = "0123456789";
	      String spcl_chars = "!@#$%^&*";
	      int alpha_count=0;
	      int num_count=0;
	      int sc_count=0;
	      //16-32
	        int length = password.length();
	        if(length<16 || length>32)
	          return false;
	        
	        
	      //3 alphabets
	      for(char c : password.toCharArray()){
	          if(alphabets.contains(String.valueOf(c)))
	            alpha_count++;
	          
	          if(numbers.contains(String.valueOf(c)))
	            num_count++;
	          
	          if(spcl_chars.contains(String.valueOf(c)))
	            sc_count++;
	      }
	      
	      if(alpha_count<3 || num_count<3 || sc_count<1)
	        return false;
	      
	      
	      return true;
	    }
	    public static void main(String[] args) {
	    	Saviynt m = new Saviynt();
	    	System.out.print(m.isValidPassword("abcdEFGh123fcr&yuhb"));
	  }
}

//SQL
/*
-- create
CREATE TABLE EMPLOYEE (
  empId INTEGER PRIMARY KEY,
  name TEXT NOT NULL,
  dept TEXT NOT NULL
);

CREATE TABLE PAYCHECK (
  empId INTEGER,
  month TEXT NOT NULL,
  netpay DOUBLE NOT NULL
);

INSERT INTO PAYCHECK VALUES (0001, 'March', 1);
INSERT INTO PAYCHECK VALUES (0001, 'April', 2);
INSERT INTO PAYCHECK VALUES (0002, 'March', 5);
INSERT INTO PAYCHECK VALUES (0002, 'April', 7);
INSERT INTO PAYCHECK VALUES (0003, 'March', 8);
INSERT INTO PAYCHECK VALUES (0003, 'April', 6);


-- insert
INSERT INTO EMPLOYEE VALUES (0001, 'Clark', 'Sales');
INSERT INTO EMPLOYEE VALUES (0002, 'Dave', 'Accounting');
INSERT INTO EMPLOYEE VALUES (0003, 'Ava', 'Sales');
INSERT INTO EMPLOYEE VALUES (0004, 'John', 'Sales');


-- fetch 

select e.empId, IFNULL(sum(p.netpay), 0) as total
from employee e  
left join paycheck p
on e.empId = p.empId
group by e.empId
order by total
limit 1
;

*/
