import java.util.*;
public class StringOps {
	
	/**
	 * Compare both the strings.
	 * @param both the strings to be compared
	 * @param should be not null and case sensitive
	 * @return 1 if strings are equal else 0
	 */

    public static int compareString(String str1 , String str2){
    int l1 = str1.length();
    int l2 = str2.length();
    if(l1!=l2)
    	return 0;
    for (int i = 0; i < l1; i++) {
          int str1_ch = (int)str1.charAt(i);
          int str2_ch = (int)str2.charAt(i);
      if (str1_ch != str2_ch)
              return 0;
    
    }
    return 1;
    }
    /**
	 * Reverse the string.
	 * @param string to be reversed
	 * @param should be not null and case sensitive
	 * @return reversed string
	 */
    public static String reverse(String str){
        String rev="";
        for(int i=0;i<str.length();i++){
        	rev=str.charAt(i)+rev;
        }
        return rev;
    }
    /**
	 * Convert case of the string.
	 * @param string to convert case
	 * @param should be not null and case sensitive
	 * @return converted cased string
	 */
    public static String convertCase(String str){
        String result="";
        char str1[]=str.toCharArray();
        for(int i=0;i<str.length();i++){
        	if(str1[i]>='A' && str1[i]<='Z')
        	str1[i]=(char)((int)str1[i]+32);
        	else if(str1[i]>='a' && str1[i]<='z')
        	str1[i]=(char)((int)str1[i]-32);
        }
        for(int i=0;i<str.length();i++)
        	result=result+str1[i];
        return result;
    }
    
    /**
	 * Find longest word in the string.
	 * @param string to find longest word
	 * @param should be not null and case sensitive
	 * @return longest word of string and if more words are longest return the last one
	 */
    public static String  longestWord(String str){
        String[]words=str.split(" ");
        int max=0;
        String res="";
    	for(int i=0;i<words.length;i++){
    		if(words[i].length()>=max){
    			max=words[i].length();
    			res=words[i];
    		}
    	}
    	return res;
    }
    public static void main(String[] args){
    	String str1="hello";
    	String str2="heLLo";
    	System.out.println("The longest word in the string is"+" "+longestWord("Hello , how is everything going"));
    	System.out.println("The reverse of string 'have a nice day' is "+reverse("have a nice day"));
    	int n=compareString(str1,str2);
    	if(n==1)
    		System.out.println("Both string "+str1+" and "+str2+" are equal");
    	else
    		System.out.println("Both string "+str1+" and "+str2+" are not equal");
    	System.out.println("The opposite case of string 'HaVe A niCe dAy' is "+convertCase("HaVe A niCe dAy"));
    }
}
