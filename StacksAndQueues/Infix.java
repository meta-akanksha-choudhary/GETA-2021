
public class Infix implements Stack {
    private int vtop=-1,otop=-1;
    private final int size=100;
    private String values[]=new String[size];
    private String ops[]=new String[size];
  
    public void push(String arr[],String x,int top){
    	if(top>=size-1){
    		System.out.println("Stack is full");
    		return;
    	}
    	top++;
    	arr[top]=x;
    }
    public static boolean empty(String arr[],int top){
    	if(top==-1)
    			return true;
    	return false;
    }
    public static String peek(String arr[],int top){
    	if(top==-1){
    		System.out.println("Stack is empty");
    		return "-1";
    	}
    	return arr[top];
    }
    public String pop(String arr[],int top){
    	if(top==-1){
    		System.out.println("Stack is empty");
    		return "#";
    	}
    	String x=arr[top];
    	top--;
    	return x;
    }
    public String evaluate(String exp){
    	for(int i=0;i<exp.length();i++){
    		if(exp.charAt(i)==' ')
    			continue;
    		if(exp.charAt(i)>='0' && exp.charAt(i)<='9'){
    			String temp="";
    			while(i<exp.length() && exp.charAt(i)>='0' && exp.charAt(i)<='9'){
    				temp=temp+exp.charAt(i);
    				i++;
    			}
    			push(values,temp,vtop);
    			i--;
    		}
    		else if(exp.charAt(i)=='(')
    			push(ops,"(",otop);
    		else if(exp.charAt(i)==')'){
    			while(peek(ops,otop)!="(")
    				push(values,evalOp(pop(ops,otop),Integer.parseInt(pop(values,vtop)),Integer.parseInt(pop(values,vtop))),vtop);
    			pop(ops,otop);
    			
    		}
    		else if(exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*'
    				|| exp.charAt(i)=='/'){
    			while(!empty(ops,otop) && hasPrecedence(Character.toString(exp.charAt(i)),peek(ops,otop)))
    				push(values,evalOp(pop(ops,otop),Integer.parseInt(pop(values,vtop)),Integer.parseInt(pop(values,vtop))),vtop);
    			push(ops,Character.toString(exp.charAt(i)),otop);
    		}
    	}
    	while(!empty(ops,otop))
    		push(values,evalOp(pop(ops,otop),Integer.parseInt(pop(values,vtop)),Integer.parseInt(pop(values,vtop))),vtop);
    	return pop(values,vtop);
    		
    }
    
    public static  boolean hasPrecedence(String op1,String op2){
    	if(op2=="(" || op2==")")
    		return false;
    	if(op2=="*" || op2=="/" && op2=="+" || op2=="-")
    		return false;
    	else
    		return true;
    }
    public static String evalOp(String op,int b,int a){
    	switch(op){
    	case "+": int c=a+b;
    		      return Integer.toString(c);
    		      
    	case "-": int d=a-b;   
    	          return Integer.toString(d);
    	          
    	case "*": int e=a*b;
    	          return Integer.toString(e);
    	case "/":
    		      if(b==0)
    		    	  throw new UnsupportedOperationException("Cannot divide by zero");
    		      int f=a/b;
    		      return Integer.toString(f);
		  }
    	return "#";
    }
    public static void main(String args[]){
    	Infix f=new Infix();
    	System.out.println(f.evaluate("10 + 2 * 6"));
    	
    }
}