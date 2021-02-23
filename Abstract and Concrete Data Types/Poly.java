import java.io.*;
import java.util.*;
public class Poly {
	private int coefficient[];
	private int degre;
	public Poly(){
		degre=0;
		coefficient=new int[101];
		for(int i=0;i<100;i++)
			coefficient[i]=0;
	}
	public void takeInput(int deg,int coeff){
		coefficient[deg]=coeff;
		if(deg>degre)
			degre=deg;
	}
	public int degree(){
		return degre;
	}
	public double evaluate(float var){
		double ans=0;
		for(int i=0;i<=degre;i++){
			if(coefficient[i]!=0){
			ans=ans+(coefficient[i]*Math.pow(var,i));
			}
		}
		return ans;
	}
	public Poly addPoly(Poly p1,Poly p2){
		Poly p=new Poly();
		p.degre=Math.max(p1.degre, p2.degre);
		for(int i=0;i<=p1.degre;i++){
			if(p1.coefficient[i]!=0){
			p.coefficient[i]+=p1.coefficient[i];
			}
		}
		for(int i=0;i<=p2.degre;i++){
			if(p2.coefficient[i]!=0){
			p.coefficient[i]+=p2.coefficient[i];
			}
		}
		return p;
	}
	
	public Poly mulPoly(Poly p1,Poly p2){
		Poly p=new Poly();
		p.degre=p1.degre+p2.degre;
		for(int i=0;i<=p1.degre;i++){
			for(int j=0;j<=p2.degre;j++){
				p.coefficient[i+j]+=(p1.coefficient[i]*p2.coefficient[j]);
			}
		}
		
		return p;
	}
	public void printPoly(){
		for(int i=degre;i>0;i--){
			if(coefficient[i]!=0){
				if(coefficient[i]>0)
					System.out.print("+");
				else
					System.out.print("-");
				System.out.print(Math.abs(coefficient[i])+"x^"+i);
			}
			
		}
		System.out.println();
	}
	public static void main(String[] args){
		Poly p1=new Poly();
		Poly p2=new Poly();
		Poly p3=new Poly();
		Poly p4=new Poly();
		p1.takeInput(2,5);
		p1.takeInput(5,8);
		p1.takeInput(1,4);
		p1.printPoly();
		p2.takeInput(2,3);
		p2.takeInput(3,2);
		p2.takeInput(7,1);
		p2.printPoly();
		System.out.println("Evaluate p2 for x=1"+" "+p2.evaluate(1));
		p3=p3.mulPoly(p1, p2);
		p3.printPoly();
		p4=p4.addPoly(p1, p2);
		p4.printPoly();
		
		
	}

}
