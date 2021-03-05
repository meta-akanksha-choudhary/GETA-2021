

public class InfixEval implements Stack {
    private int top;
    private final int size=100;
    private String arr[];
    InfixEval(){
    	top=-1;
    	arr=new String[size];
    }
    public void push(String x){
    	if(this.top>=size-1){
    		System.out.println("Stack is full");
    		return;
    	}
    	this.top++;
    	this.arr[this.top]=x;
    }
    public  boolean empty(){
    	if(this.top==-1)
    			return true;
    	return false;
    }
    public  String peek(){
    	if(this.top==-1){
    		System.out.println("Stack is empty");
    		return "-1";
    	}
    	return this.arr[this.top];
    }
    public String pop(){
    	if(this.top==-1){
    		System.out.println("Stack is empty");
    		return "#";
    	}
    	String x=arr[this.top];
    	this.top--;
    	return x;
    }
    public String evaluate(String exp){
    	InfixEval values=new InfixEval();
    	InfixEval ops=new InfixEval();
    	for(int i=0;i<exp.length();i++){
    		if(exp.charAt(i)==' ')
    			continue;
    		if(exp.charAt(i)>='0' && exp.charAt(i)<='9'){
    			String temp="";
    			while(i<exp.length() && exp.charAt(i)>='0' && exp.charAt(i)<='9'){
    				temp=temp+exp.charAt(i);
    				i++;
    			}
    			values.push(temp);
    			i--;
    		}
    		else if(exp.charAt(i)=='(')
    			ops.push("(");
    		else if(exp.charAt(i)==')'){
    			while(ops.peek()!="(")
    				values.push(evalOp(ops.pop(),Integer.parseInt(values.pop()),Integer.parseInt(values.pop())));
    			ops.pop();
    			
    		}
    		else if(exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*'
    				|| exp.charAt(i)=='/'){
    			while(!ops.empty() && (precedence(Character.toString(exp.charAt(i)))>=precedence(ops.peek())))
    				values.push(evalOp(ops.pop(),Integer.parseInt(values.pop()),Integer.parseInt(values.pop())));
    			ops.push(Character.toString(exp.charAt(i)));
    		}
    	}
    	while(!ops.empty())
    		values.push(evalOp(ops.pop(),Integer.parseInt(values.pop()),Integer.parseInt(values.pop())));
    	return values.pop();
    		
    }
    
    public static  int precedence(String op1){
    	if(op1=="(" || op1==")")
    		return 7;
    	if(op1=="*" || op1=="/")
    		return 6;
    	if(op1=="+" || op1=="-")
    		return 5;
    	if(op1=="<" || op1==">" || op1=="<=" || op1==">=")
    		return 4;
    	if(op1=="==" || op1=="!=")
    		return 3;
    	if(op1=="&&")
    		return 2;
    	if(op1=="||")
    		return 1;
    	else
    		return -1;
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
    		      
    		      
    	case "==" : return Boolean.toString(a==b);
    	case ">" : return Boolean.toString(a>b);
    	case ">=" : return Boolean.toString(a>=b);
    	case "<=" : return Boolean.toString(a<=b);
    	case "<" : return Boolean.toString(a<b);
    	case "!=" : return Boolean.toString(a!=b);
    	//case "&&" : return Boolean.toString(a&&b);
    	//case "||" : return Boolean.toString(a||b);
		  }
    	return "#";
    }
    public static void main(String args[]){
    	InfixEval f=new InfixEval();
    	System.out.println(f.evaluate("(10+2)==(6+6)"));
    	
    }
}