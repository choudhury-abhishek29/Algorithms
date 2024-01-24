package prep.leetcode;

public class ValidAbbr {

//    public boolean validWordAbbreviation(String word, String abbr) {
//    	int abbrPtr=0;
//        int wordPtr=0;
//        
//        while(abbrPtr<abbr.length() && wordPtr<word.length())
//        {
//            if(Character.isDigit(abbr.charAt(abbrPtr)))
//            {
//            	if(abbr.charAt(abbrPtr)=='0') return false;
//            	int total=0;
//            	while(abbrPtr<abbr.length() && Character.isDigit(abbr.charAt(abbrPtr)))
//            	{
//            		total=total*10+abbr.charAt(abbrPtr)-'0';
//            		abbrPtr++;
//            	}
//            	wordPtr+=total;
//            }
//            else
//            {
//            	if(word.charAt(wordPtr)!=abbr.charAt(abbrPtr)) return false;
//            	wordPtr++;
//            	abbrPtr++;
//            }
//        }
//        
//        return abbrPtr==abbr.length() && wordPtr==word.length();
//    }
	
	int abbrPtr=0;
    int wordPtr=0;
    public boolean validWordAbbreviation(String word, String abbr) {
        if(abbr.length() > word.length()) return false;

        while(abbrPtr<abbr.length() && wordPtr<word.length())
        {
            if(Character.isDigit(abbr.charAt(abbrPtr)))
            {
                if(abbr.charAt(abbrPtr)=='0') return false;
                int num = getNumber(abbr);
                wordPtr+=num;
            }
            else
            {
            	if(word.charAt(wordPtr)!=abbr.charAt(abbrPtr)) return false;
            	abbrPtr++;
                wordPtr++;
            }
            
            
        }
        
        return abbrPtr==abbr.length() && wordPtr==word.length();
    }

    public int getNumber(String abbr)
    {
        StringBuffer num = new StringBuffer();
        while(abbrPtr<abbr.length() && Character.isDigit(abbr.charAt(abbrPtr)))
            num.append(abbr.charAt(abbrPtr++));

        return Integer.valueOf(num.toString());
    }
    

	public static void main(String[] args) {
		ValidAbbr va = new ValidAbbr();
		System.out.println(va.validWordAbbreviation("internationalization", "i5a11o1"));

	}

}
