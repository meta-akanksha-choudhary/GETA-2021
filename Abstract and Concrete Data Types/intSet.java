import java.util.*;
public class intSet {
	private final int set[];
	private final int len;
	public intSet(int n,int[]arr ){
		len=n;
		set=new int[n];
		for(int i=0;i<n;i++)
			set[i]=arr[i];
	}
	public boolean isMember(int x){
		for(int i=0;i<len;i++){
			if(set[i]==x)
				return true;
		}
		return false;
	}
	public int size(){
		return len;
	}
	public boolean isSubset(intSet s){
		int n=this.len;
		int m=s.len;
		if(n>m)
			return false;
		int i=0,j=0;
		while(i<n && j<m){
			if(this.set[i]==s.set[i]){
				i++;
				j++;
				if(j==m)
					return true;
			}
			else{
				i=i-j+1;
				j=0;
			}
		}
		return false;
	}
	public intSet union(intSet set2){
		int j=0;
		HashSet<Integer>hs=new HashSet<>();
		for(int i=0;i<this.len;i++)
			hs.add(this.set[i]);
		for(int i=0;i<set2.len;i++)
			hs.add(set2.set[i]);
		Iterator<Integer> i=hs.iterator();
		int arr[]=new int[hs.size()];
		while(i.hasNext()){
			arr[j]=i.next();
			j++;
		}
		intSet res=new intSet(hs.size(),arr);
		return res;
	}
	public intSet compliment(){
		int arr[]=new int[1000];
		int j=0;
		HashSet<Integer> h=new HashSet<>();
		for(int i=0;i<this.len;i++)
			h.add(this.set[i]);
		for(int i=1;i<1000;i++){
			if(!(h.contains(i))){
				arr[j]=i;
				j++;
			}
		}
		intSet cmp=new intSet(arr.length,arr);
		return cmp;
	}
	public void printSet(){
		System.out.print("The set is { ");
		for(int i=0;i<len;i++)
			System.out.print(set[i]+" ");
		System.out.print("}");
		System.out.println();
	}
	public static void main(String args[]){
		int arr1[]={1,5,8,9};
		int arr2[]={5,10,15};
	    intSet s1=new intSet(4,arr1);
	    intSet s2=new intSet(3,arr2);
	    intSet s3=s1.union(s2);
	    intSet s4=s3.compliment();
	    System.out.println("The union of s1 and s2 is s3");
	    s3.printSet();
	    System.out.println("Is 7 memeber of s1"+" "+s1.isMember(7));
	    System.out.println("Size of s2 is "+s2.size());
	    System.out.println("Is s1 subset of s2 "+s2.isSubset(s1));
	    System.out.println("complement of s3 is");
	    s4.printSet();
	    
	}

}
