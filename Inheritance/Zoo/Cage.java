package Zoo;
import java.util.*;

public class Cage{
	public static final int numberOfZone=2;
	public static int currentZone[]={0,0,0};
	public static final int numberOfCages=3;
	public static int currentcage[]={0,0,0};
	public static final int cageCapacity=2;
	public String category;
	public static String type;
	public static HashMap<String,Zone> mammal=new HashMap<>();
	public static HashMap<String,Zone> reptile=new HashMap<>();
	public static HashMap<String,Zone> birds=new HashMap<>();
	
	public static void addCage(String category,String type){
		
		if(category=="mammal"){
			if(mammal.isEmpty()){
				Zone z=new Zone(1,1,1);
				mammal.put(type, z);
				currentZone[0]=currentZone[0]+1;
				currentcage[0]=currentcage[0]+1;
			}
			else{
				if(mammal.containsKey(type)){
					Zone z=mammal.get(type);
					if(z.animalNumber+1>cageCapacity){
						if(z.cageNumber+1>numberOfCages){
							if(z.zoneNumber+1>numberOfZone){
								System.out.println("Capacity is full , no other animal can be added");
								return;
							}
							else{
								z.zoneNumber=z.zoneNumber+1;
								z.cageNumber=1;
								z.animalNumber=1;
								currentZone[0]=currentZone[0]+1;
								currentcage[0]=1;
							}
						}
						else{
							z.cageNumber=z.cageNumber+1;
							z.animalNumber=1;
							currentcage[0]=currentcage[0]+1;
						}
					}
					else{
						z.animalNumber=z.animalNumber+1;
					}
					mammal.put(type, z);
					
				}else{
				Zone z=new Zone(1,1,1);
				mammal.put(type, z);
				currentZone[0]=currentZone[0]+1;
				currentcage[0]=currentcage[0]+1;
				}
			}
		}
		
		
		
		else if(category=="reptile"){
			if(reptile.isEmpty()){
				Zone z=new Zone(1,1,1);
				reptile.put(type, z);
				currentZone[1]=currentZone[1]+1;
				currentcage[1]=currentcage[1]+1;
			}
			else{
				if(reptile.containsKey(type)){
					Zone z=reptile.get(type);
					if(z.animalNumber+1>cageCapacity){
						if(z.cageNumber+1>numberOfCages){
							if(z.zoneNumber+1>numberOfZone){
								System.out.println("Capacity is full , no other animal can be added");
								return;
							}
							else{
								z.zoneNumber=z.zoneNumber+1;
								z.cageNumber=1;
								z.animalNumber=1;
								currentZone[1]=currentZone[1]+1;
								currentcage[1]=1;
							}
						}
						else{
							z.cageNumber=z.cageNumber+1;
							z.animalNumber=1;
							currentcage[1]=currentcage[1]+1;
						}
					}
					else{
						z.animalNumber=z.animalNumber+1;
					}
					reptile.put(type, z);
					
				}else{
				Zone z=new Zone(1,1,1);
				reptile.put(type, z);
				currentZone[1]=currentZone[1]+1;
				currentcage[1]=currentcage[1]+1;
				}
			}
		}
		

		
		else if(category=="birds"){
			if(birds.isEmpty()){
				Zone z=new Zone(1,1,1);
				birds.put(type, z);
				currentZone[2]=currentZone[2]+1;
				currentcage[2]=currentcage[2]+1;
			}
			else{
				if(birds.containsKey(type)){
					Zone z=birds.get(type);
					if(z.animalNumber+1>cageCapacity){
						if(z.cageNumber+1>numberOfCages){
							if(z.zoneNumber+1>numberOfZone){
								System.out.println("Capacity is full , no other animal can be added");
								return;
							}
							else{
								z.zoneNumber=z.zoneNumber+1;
								z.cageNumber=1;
								z.animalNumber=1;
								currentZone[2]=currentZone[2]+1;
								currentcage[2]=1;
							}
						}
						else{
							z.cageNumber=z.cageNumber+1;
							z.animalNumber=1;
							currentcage[2]=currentcage[2]+1;
						}
					}
					else{
						z.animalNumber=z.animalNumber+1;
					}
					birds.put(type, z);
					
				}else{
				Zone z=new Zone(1,1,1);
				birds.put(type, z);
				currentZone[2]=currentZone[2]+1;
				currentcage[2]=currentcage[2]+1;
				}
			}
		}
		System.out.println("Added successfully");

	}
	
	
	
	public static void removeAnimal(String category,String type){
		if(category=="mammal"){
			Zone z=mammal.get(type);
			
			if(z.animalNumber-1==0){
				if(z.cageNumber-1==0){
					
					if(z.zoneNumber-1==0){
						currentZone[0]=0;
						currentcage[0]=0;
						mammal.remove(z);
						return;
					}
				else{   
					    z.zoneNumber=z.zoneNumber-1;
						z.cageNumber=numberOfCages;
						z.animalNumber=cageCapacity;
						currentcage[0]=numberOfCages;
						currentZone[0]=currentZone[0]-1;
					}
			}
				
			else{
				    z.cageNumber=z.cageNumber-1;
					z.animalNumber=cageCapacity;
					currentcage[0]=currentcage[0]-1;
				}
			}
			else{
				z.animalNumber=z.animalNumber-1;
			}
			
			mammal.put(type, z);
		}
		
		
		else if(category=="reptile"){
			Zone z=reptile.get(type);
			if(z.animalNumber-1==0){
				if(z.cageNumber-1==0){
					
					if(z.zoneNumber-1==0){
						currentZone[1]=0;
						currentcage[1]=0;
						reptile.remove(z);
						return;
					}
				else{   
					    z.zoneNumber=z.zoneNumber-1;
						z.cageNumber=numberOfCages;
						z.animalNumber=cageCapacity;
						currentcage[1]=numberOfCages;
						currentZone[1]=currentZone[1]-1;
					}
			}
				
			else{
				    z.cageNumber=z.cageNumber-1;
					z.animalNumber=cageCapacity;
					currentcage[1]=currentcage[0]-1;
				}
			}
			else{
				z.animalNumber=z.animalNumber-1;
			}
			
			
			reptile.put(type, z);
		}
		
		else if(category=="birds"){
			Zone z=birds.get(type);
			if(z.animalNumber-1==0){
				if(z.cageNumber-1==0){
					
					if(z.zoneNumber-1==0){
						currentZone[2]=0;
						currentcage[2]=0;
						birds.remove(z);
						return;
					}
				else{   
					    z.zoneNumber=z.zoneNumber-1;
						z.cageNumber=numberOfCages;
						z.animalNumber=cageCapacity;
						currentcage[2]=numberOfCages;
						currentZone[2]=currentZone[2]-1;
					}
			}
				
			else{
				    z.cageNumber=z.cageNumber-1;
					z.animalNumber=cageCapacity;
					currentcage[2]=currentcage[2]-1;
				}
			}
			else{
				z.animalNumber=z.animalNumber-1;
			}
			
			
			birds.put(type, z);
		}
	System.out.println("Removed successfully");
	}
	
}
