
public class JUnit {
	/**
	 * Find length of longest mirror section in array
	 * @param array of positive number to find longest mirror section
	 * @return length of longest mirror section
	 */
	public static int maxMirror(int arr[]){
		if(arr.length<=0){
			throw new AssertionError("Empty array");
		}
		int n=arr.length;
		int maxCount =1;
		boolean flag=false;
		for(int i=0;i<n;i++){
			int tempCount=1;
			int count=i;
			for(int j=n-1;j>=0 && (count<n);j--){
				if(arr[count]==arr[j]&&!flag){
					flag=true;
					count++;
					continue;
				}
				if(arr[count]==arr[j]&&flag){
					tempCount++;
					count++;
					maxCount=(tempCount>maxCount)?tempCount:maxCount;
					continue;
				}
				if(arr[i]!=arr[j] && flag){
					flag=false;
					count=i;
					tempCount=1;
					continue;
				}
				if(j==count || (j-count)==1){
					flag=false;
					break;
				}
			}
		}
		return maxCount;
	}
	/**
	 * Find number of clumps in array
	 * @param array of positive number to count clumps
	 * @return number of clumps in integer
	 */
	public static int countClumps(int arr[]){
		if(arr.length<=0){
			throw new AssertionError("Empty array");
		}
		int flag=1,ans=0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]==arr[i-1]){
				flag++;
				if(flag==2)
					ans++;
			}
			else
				flag=1;
		}
		return ans;
	}
	/**
	 * Rearrange array such that x is always followed by y
	 * @param array of positive number to rearrange , x and y
	 * @return rearranged array
	 */
	public static int[] fixXY(int arr[],int x,int y){
		if(arr.length<=0){
			throw new AssertionError("Empty array");
		}
		int n=arr.length;
		int yarr[]=new int[n/2];
		int j=0,k=0;
		for(int i=0;i<n;i++){
			if(arr[i]==y)
				yarr[j++]=i;
		}
		j--;
		for(int i=0;i<n-1;i++){
			if(arr[i]==x && arr[i+1]!=y && arr[i+1]!=x){
				if(k<=j){
				   arr[yarr[k++]]=arr[i+1];
				   arr[i+1]=y;
				}
				else
					throw new AssertionError("Unequal number of x and y");
				
			}
			else if(arr[i]==x && arr[i+1]==x)
				throw new AssertionError("Two adjacent x's");
			}
		if(arr[n-1]==x)
			throw new AssertionError("x at last index");
		return arr;
	}
	/**
	 * Find index whose both side sum is same
	 * @param array of positive number to find index
	 * @return index to array element whose both side sum is same
	 */
	public static int splitArray(int arr[]){
		if(arr.length<=0){
			throw new AssertionError("Empty array");
		}
		int n=arr.length;
		int prefix[]=new int[n];
		int suffix[]=new int[n];
		prefix[0]=0;
		for(int i=1;i<n;i++)
			prefix[i]=prefix[i-1]+arr[i-1];
		suffix[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--)
			suffix[i]=suffix[i+1]+arr[i];
		for(int i=0;i<n;i++){
			if(prefix[i]==suffix[i])
				return i;
		}
		return -1;
	}
	
  public static void main(String args[]){
	  int arr[]={1,2,2,2,3,4,4};
	  int arr1[]={1, 4, 1, 5};
	  int arr2[]={10,10};
	  System.out.println("Longest mirror section in array is "+maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
	  System.out.println("Number of clumps in array are "+countClumps(arr));
	  int ans[]=fixXY(arr1,4,5);
	  System.out.println("The rearranged array is");
	  for(int i=0;i<ans.length;i++)
		  System.out.print(ans[i]+" ");
	  System.out.println();
	  System.out.println("Index to split the array is "+splitArray(arr2));
  }
}
