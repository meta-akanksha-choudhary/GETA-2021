package Zoo;

abstract class Animal {
	 int age;
     String name;
     int weight;
     int animal_id;
     static int id=100;

     Animal(String name,int age,int weight){
             this.name=name;
             this.age=age;
             this.weight=weight;
             animal_id=id;
             id=id+1;

     }

     abstract String getSound();
}


