import java.io.*;
import java.util.*;
public class ImPoly {
	private final int coefficient[];
	private final int degre;
	public ImPoly(int[] deg,int[] coeff){
		coefficient=new int[101];
		int degree=0;
		for(int i=0;i<deg.length;i++){
		coefficient[deg[i]]+=coeff[i];
		if(deg[i]>degree)
			degree=deg[i];
		}
		degre=degree;
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
	public ImPoly addPoly(ImPoly p2){
		int n=Math.max(this.degre, p2.degre);
		int coef[]=new int[n];
		int deg[]=new int[n];
		int j=0;
		for(int i=0;i<=this.degre;i++){
			if(this.coefficient[i]!=0){
			coef[j]=this.coefficient[i];
			deg[j]=i;
			j++;
			}
		}
		for(int i=0;i<=p2.degre;i++){
			if(p2.coefficient[i]!=0){
				coef[j]=p2.coefficient[i];
				deg[j]=i;
				j++;
			}
		}
		ImPoly p=new ImPoly(deg,coef);
		return p;
	}
	
	public ImPoly mulPoly(ImPoly p2){
		int n=this.degre*p2.degre;
		int coef[]=new int[100];
		int deg[]=new int[100];
		int k=0;
		for(int i=0;i<=this.degre;i++){
			for(int j=0;j<=p2.degre;j++){
				coef[k]=this.coefficient[i]*p2.coefficient[j];
				deg[k]=i+j;
				k++;
			}
		}
		ImPoly p=new ImPoly(deg,coef);
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
		int c1[]={5,8,4};
		int c2[]={3,2,1};
		int d1[]={2,5,1};
		int d2[]={2,3,7};
		ImPoly p1=new ImPoly(d1,c1);
		ImPoly p2=new ImPoly(d2,c2);
		ImPoly p3=p1.mulPoly(p2);
		ImPoly p4=p1.addPoly(p2);
		p1.printPoly();
		p2.printPoly();
		System.out.println("Evaluate p2 for x=1 is"+" "+p2.evaluate(1));
		System.out.println("The multiplication of p1 and p2");
		p3.printPoly();
		System.out.println("The addition of p1 and p2");
		p4.printPoly();
		
		
	}

}
