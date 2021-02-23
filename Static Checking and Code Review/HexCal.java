import java.util.*;
class HexCal{
  
  public static String decToHex(int number)
    {
    char ch[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
   int rem;
   String hexadecimal="";
   int num=Math.abs(number);
   if(num==0)
	   hexadecimal+=ch[0];
   else{
      while(num != 0)
        {
          rem=num%16;
        hexadecimal= ch[rem] + hexadecimal;
          num= num/16;
   }
   }
   if(number<0)
	   hexadecimal="-"+hexadecimal;
      return hexadecimal;

    }
    public static int hexToDec(String hex){
      String digits = "0123456789ABCDEF";
             String hexNew = hex.toUpperCase();
             int decimal = 0;
             for (int i = 0; i < hexNew.length(); i++)
             {
                 char c = hexNew.charAt(i);
                 int d = digits.indexOf(c);
                 decimal = 16*decimal + d;
             }
             return decimal;
    }
    public static String addition(String num1,String num2){
      int result=hexToDec(num1)+hexToDec(num2);
      return decToHex(result);

    }
    public static String subtraction(String num1,String num2){
      int result=hexToDec(num1)-hexToDec(num2);
      return decToHex(result);

    }
    public static String multiplication(String num1,String num2){
      int result=hexToDec(num1)*hexToDec(num2);
      return decToHex(result);

    }
    public static String division(String num1,String num2){
      int num=hexToDec(num2);
      if(num==0){
        return "Division by zero is not allowed.";
      }
      int result=hexToDec(num1)/num;
      return decToHex(result);

    }
    public static int comparison(String number1,String number2){
      String num1="";
      String num2="";
      int flag=0;
      for(int i=0;i<number1.length();i++){
    	  if(number1.charAt(i)!='0' || flag==1){
    		  num1=num1+number1.charAt(i);
    		  flag=1;
    	  }
      }
      flag=0;
      for(int i=0;i<number2.length();i++){
    	  if(number1.charAt(i)!='0' || flag==1){
    		  num2=num2+number2.charAt(i);
    		  flag=1;
    	  }
      }
      int l1 = num1.length();
      int l2 = num2.length();
      int lmin = Math.min(l1, l2);

        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)num1.charAt(i);
            int str2_ch = (int)num2.charAt(i);
        if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        }
        else {
            return 0;
        }
    }
    public static void main(String[] args){
    	Scanner sc= new Scanner(System.in);
    	System.out.println("Enter first number");
        String num1=sc.nextLine();
        System.out.println("Enter second number");
        String num2=sc.nextLine();
 
      int a=1;
      while(a!=0){
          System.out.println("Press \n 1 Addition\n 2 Subtraction\n 3 Division \n 4 Multiplication  \n 5 Comparison \n 6 HexToDec \n 7 DecToHex \n8 To Exit");
          int ans;
          System.out.println("Enter your choice");
          ans=sc.nextInt();
          switch(ans){
              case 1 : System.out.println("The result of addition is "+" "+addition(num1,num2));
                       break;
              case 2 : System.out.println("The result of subtraction is" +" "+subtraction(num1,num2));
                       break;
              case 3 : System.out.println("The result of division is" +" "+division(num1,num2));
                       break;
              case 4 : System.out.println("The result of multiplication is" +" "+multiplication(num1,num2));
                       break;
              case 5 : int b=comparison(num1,num2);
                       if(b==0)
                       System.out.println("Both numbers are equal");
                       else if(b<0)
                       System.out.println("First number is samller than second");
                       else
                       System.out.println("First number is greater than second");
                       break;
              case 6 :
            	       System.out.println("The decimal number is" +" "+hexToDec(num1));
                       break;
              case 7 : System.out.println("Enter decimal number");
                       int dec=sc.nextInt();
                       System.out.println("The hexadecimal number is" +" "+decToHex(dec));
                       break;
              case 8 : System.out.println("Thanks for using!!");
                       a=0;
                       break;
              default : System.out.println("You entered wrong choice.Please choose again");
          }

      }

    }
}

