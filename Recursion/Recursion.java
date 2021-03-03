
public class Recursion {
	
	/**
	 * Find gcd of two numbers
	 * @param number 1 and number 2 -integer value
	 * @param positive number
	 * @return gcd of two number - integer value
	 */
	public static int gcd(int a,int b){
		if(a==0)
			return b;
		if(b==0)
			return a;
		if(a==b)
			return a;
		if(a>b)
			return(gcd(a-b,b));
		return(gcd(a,b-a));
	}
	/**
	 * Find lcm of two numbers
	 * @param number 1 and number 2 -integer value
	 * @param positive number
	 * @return lcm of two number - integer value
	 */
	public static int lcm(int a,int b){
		return((a/gcd(a,b))*b);
	}
	
	/**
	 * Search element in array using linear search
	 * @param integer array containing element to be searched only once
	 * @param x - element to be searched
	 * @param l - starting index of array
	 * @param r - ending index of array
	 * @return index of element to be searched - integer value
	 *         otherwise return -1
	 */
	public static int linearSearch(int arr[],int l,int r,int x){
		if(r<l)
			return -1;
		if(arr[l]==x)
			return l;
		if(arr[r]==x)
			return r;
		return linearSearch(arr,l+1,r-1,x);
	}
	/**
	 * Search element in array using binary search
	 * @param integer sorted array containing element to be searched only once
	 * @param x - element to be searched
	 * @param l - starting index of array
	 * @param r - ending index of array
	 * @return index of element to be searched - integer value
	 *         otherwise return -1
	 */
	public static int binarySearch(int arr[],int l,int r,int x){
		if(r>=l && l<arr.length-1){
			int mid=l+(r-1)/2;
			if(arr[mid]==x)
				return mid;
			if(arr[mid]>x)
				return binarySearch(arr,l,mid-1,x);
			return binarySearch(arr,mid+1,r,x);
		}
		return -1;
	}
	public static void main(String arg[]){
		System.out.println("The gcd of 10 and 15 is "+gcd(10,15));
		System.out.println("The lcm of 10 and 15 is "+lcm(10,15));
		int arr[]={5,10,6,9,15};
		int arr1[]={5,10,15,20,21};
		int x=20;
		int a=linearSearch(arr,0,arr.length-1,x);
		if(a==-1)
			System.out.println("The element "+x+" is not present in linear search");
		else
			System.out.println("The element "+x+" is present in linear search at index "+a);
		int b=binarySearch(arr1,0,arr1.length-1,x);
		if(b==-1)
			System.out.println("The element "+x+" not present in binary search");
		else
			System.out.println("The element "+x+" is present in linear search at index "+b);
	}

}
