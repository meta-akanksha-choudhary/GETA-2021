
import java.util.*;
class FCFS{
  static int arr[][]=new int[100][2] ;
  static int waitingTime[]=new int[100];
  static int completionTime[]=new int[100];
  static int TAT[]=new int[100];
  static int n;
    public static void calCompletionTime(){
      int i;
      completionTime[0]=arr[0][0]+arr[0][1];
      for(i=1;i<n;i++){
        if(arr[i][0]>completionTime[i-1])
        completionTime[i]=arr[i][0]+arr[i][1];
        else
        completionTime[i]=arr[i][1]+completionTime[i-1];
        }
    }

    public static void calTAT(){
      int i;
      for(i=0;i<n;i++){
          TAT[i]=completionTime[i]-arr[i][0];
      }
    }
    public static void calWaitingTime(){
      int i;
      for(i=0;i<n;i++){
          waitingTime[i]=TAT[i]-arr[i][1];
      }
    }

   public static float avgWaitingTime(){
     float sum=(float)0.00;
     for(int i=0;i<n;i++){
       sum=sum+waitingTime[i];
     }
     return sum/n;
   }
   public static int maxwaitingTime(){
     int max=0,i;
     for(i=0;i<n;i++){
       if(waitingTime[i]>max)
       max=waitingTime[i];
     }
     return max;
   }

    public static void main(String[] args){
      Scanner sc= new Scanner(System.in);
      int i,j;
      System.out.println("Enter number of process");
      n=sc.nextInt();
      System.out.println("Enter process details(Arrival Time , Burst Time)");
      for(i=0;i<n;i++){
        for(j=0;j<2;j++)
        arr[i][j]=sc.nextInt();
      }
      calCompletionTime();
      calTAT();
      calWaitingTime();
      
      System.out.println("Process_no"+" "+"Completion_Time");
      for(i=0;i<n;i++){
        System.out.println((i+1)+"            "+ completionTime[i]);
      }
      System.out.println("Process_no"+" "+"Waiting_Time");
      for(i=0;i<n;i++){
        System.out.println((i+1)+"           "+ waitingTime[i]);
      }
      System.out.println("Process_no"+" "+"TAT");
      for(i=0;i<n;i++){
        System.out.println((i+1)+"           "+ TAT[i]);
      }
      System.out.println("The maximun waiting time is"+" "+maxwaitingTime());
      System.out.println("The average waiting time is"+" "+avgWaitingTime());
      }

}

