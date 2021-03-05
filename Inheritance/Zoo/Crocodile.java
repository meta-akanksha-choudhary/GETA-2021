package Zoo;


public class Crocodile extends Reptile {
	public String type="Crocodile";
	static int cro_count=0;
    public Crocodile(String name,int age,int weight){
        super(name,age,weight);
        cro_count=cro_count+1;
     }

    String getSound(){
         return "co co";

    }
}
