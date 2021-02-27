import java.util.Scanner;
public class Marksheet {
	static float grades[]=new float[100];
	static int n;
	
	/**
	 * Find maximum grade in the array.
	 * @return maximum grade of grades array in float
	 */
	public static float maxGrade(){
		float max=(float)0.0;
		for(int i=0;i<n;i++){
			if(grades[i]>max)
				max=grades[i];
		}
		return max;
	}
	
	/**
	 * Find minimum grade in the array.
	 * @return minimum grade of grades array in float
	 */
	public static float minGrade(){
		float min=grades[0];
		for(int i=1;i<n;i++){
			if(grades[i]<min)
				min=grades[i];
		}
		return min;
	}
	
	/**
	 * Find average of grade in the array.
	 * @return average grade of grades array in float
	 */
	public static float avgGrade(){
		float sum=(float)0.0;
		for(int i=0;i<n;i++){
			sum=sum+grades[i];
		}
		return (sum/n);
	}
	
	/**
	 * Find percentage of passed students.
	 * @return percentage of passed students in float
	 */
	public static float passPerStud(){
		int pass=0;
		for(int i=0;i<n;i++){
			if(grades[i]>=40)
				pass++;
		}
		float percent=(pass/n)*100;
		return percent;
	}
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter number of students");
		n=sc.nextInt();
		System.out.println("Enter grades of students");
		for(int i=0;i<n;i++)
			grades[i]=sc.nextFloat();
		System.out.println("Max grade is"+" "+maxGrade());
		System.out.println("Min grade is"+" "+minGrade());
		System.out.println("Avg grade is"+" "+avgGrade());
		System.out.println("Percentage of students passed is"+" "+passPerStud()+"%");
	}
	

}
