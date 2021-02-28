package Zoo;


class Lion extends Mammal{
	    public String type="Lion";
        static int lion_count=0;
        public Lion(String name,int age,int weight){
        super(name,age,weight);
        lion_count=lion_count+1;
      }

        String getSound(){
             return "roars";

        }

}

