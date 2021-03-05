package Zoo;

public class Zoo {
  public static void main(String args[]){
	  Lion l1=new Lion("Lion1",10,100);
	  Lion l2=new Lion("Lion2",11,90);
	  Peacock p1=new Peacock("Peacock1",2,10);
	  Peacock p2=new Peacock("Peacock2",3,12);
	  Crocodile c1=new Crocodile("Crocodile1",4,14);
	  Crocodile c2=new Crocodile("Crocodile1",7,17);
	  Cage.addCage("mammal","lion");
	  Cage.addCage("mammal","lion");
	  Cage.addCage("mammal","lion");
	  Cage.addCage("mammal","lion");
	  Cage.addCage("mammal","lion");
	  System.out.println("The zone of mammals is "+Cage.currentZone[0]);
	  System.out.println("The cage of mammals is "+Cage.currentcage[0]);
	  Cage.removeAnimal("mammal","lion");
	  Cage.removeAnimal("mammal","lion");
	  System.out.println("The zone of mammals is "+Cage.currentZone[0]);
	  System.out.println("The cage of mammals is "+Cage.currentcage[0]);
	  Cage.addCage("birds","peacock");
	  Cage.addCage("reptile","crocodile");
	  Cage.addCage("reptile","crocodile");
	  System.out.println("The zone of reptiles is "+Cage.currentZone[1]);
	  System.out.println("The cage of reptiles is "+Cage.currentcage[1]);
	  System.out.println("The zone of birds is "+Cage.currentZone[2]);
	  System.out.println("The cage of birds is "+Cage.currentcage[2]);
  }
}
