package Zoo;


public class Peacock extends Bird{
	public String type="Peacock";
	static int peacock_count=0;
    public Peacock(String name,int age,int weight){
    super(name,age,weight);
    peacock_count=peacock_count+1;
   }

    String getSound(){
         return "pihu pihu";
   }

}
