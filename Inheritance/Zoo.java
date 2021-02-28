package Zoo;

public class Zoo {
  public static void main(String args[]){
	  Lion l1=new Lion("Lion1",10,100);
	  Lion l2=new Lion("Lion2",11,90);
	  Peacock p1=new Peacock("Peacock1",2,10);
	  Peacock p2=new Peacock("Peacock2",3,12);
	  Crocodile c1=new Crocodile("Crocodile1",4,14);
	  Crocodile c2=new Crocodile("Crocodile1",7,17);
	  System.out.println(Cage.addCage("mammal","lion"));
	  System.out.println(Cage.addCage("mammal","lion"));
	  System.out.println(Cage.addCage("mammal","lion"));
	  System.out.println(Cage.addCage("mammal","lion"));
	  System.out.println(Cage.addCage("mammal","lion"));
	  System.out.println(Cage.addCage("mammal","lion"));
  }
}
