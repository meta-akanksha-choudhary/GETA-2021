
public class Polynomial {
	public static Link head;
	static class NesLink{
		char var;
		int pow;
		NesLink next;
	}
	static class Link{
		int data;
		Link next;
		NesLink bottom;
	}
	public static NesLink pushNLink(char v,int p,NesLink nhead){
		NesLink l1=new NesLink();
		l1.var=v;
		l1.pow=p;
		l1.next=nhead;
		nhead=l1;
		return nhead;
	}
	public static void pushLink(int var ,int []pow,char []v){
		NesLink nhead=null;
		Link l=new Link();
		l.data=var;
		l.next=head;
		head=l;
		for(int i=0;i<pow.length;i++){
		nhead=pushNLink(v[i],pow[i],nhead);
		}
		l.bottom=nhead;
	}
	public static int degree(){
		int max=0;
		int ans;
		Link temp=head;
		while(temp!=null){
			ans=0;
			NesLink a=temp.bottom;
			while(a!=null){
				ans=ans+a.pow;
				a=a.next;
			}
			if(ans>max)
				max=ans;
			temp=temp.next;
		}
		return max;
	}
	public static void print(){
		Link temp=head;
		System.out.println("The polynomial is");
		while(temp!=null){
			System.out.print(temp.data+"*");
			NesLink a=temp.bottom;
			while(a!=null){
				System.out.print(a.var+"^"+a.pow);
				a=a.next;
			}
			System.out.print("+");
			temp=temp.next;
		}
		System.out.println();
	}
	public static void main(String args[]){
		char var1[]={'x','y'};
		int pow1[]={2,3};
		char var2[]={'y'};
		int pow2[]={3};
		char var3[]={'x','y','z'};
		int pow3[]={2,3,6};
		pushLink(3,pow1,var1);
		pushLink(1,pow2,var2);
		pushLink(2,pow3,var3);
		print();
		System.out.println("The degree of polynomial is "+degree());
		
	}

}
