package Zoo;
import java.util.*;

public class Cage {
	 final static int total_capacity_zone=1;
	 final static int total_capacity_cage=2;
	 public static HashMap<String,Zone> animals=new HashMap<String,Zone>();
	 Iterator<Map.Entry<String,Zone>> itr = animals.entrySet().iterator();
	 public static int mammal_zone=1;
	 public static int reptile_zone=1;
	 public static int bird_zone=1;
	 public static int cage_number=1;
   
     public static String addCage(String type,String category){
    	 if(animals.containsKey(type)){
    		 Zone zone1=animals.get(type);
    		 if(zone1.cage>total_capacity_cage){
    			 if(zone1.zone>total_capacity_zone){
    				 cage_number=1;
    				 return "No animals can be added";
    			 }
    			 else{
    				 zone1.category=category;
    				 zone1.cage=cage_number;
    				 cage_number++;
    				 if(category=="mammal"){
    					 mammal_zone++;
    					 zone1.zone=mammal_zone;
    					 
    				 }
    				 else if(category=="reptile"){
    					 reptile_zone++;
    					 zone1.zone=reptile_zone;
    					 
    				 }
    					 
    				 else if(category=="bird"){
    					 bird_zone++;
    					 zone1.zone=bird_zone;
    				 }
    				 animals.put(type,zone1);
    			 }
    		 }
    		 else{
    			 zone1.category=category;
    			 zone1.cage=cage_number;
    			 if(category=="mammal"){
					 mammal_zone++;
					 zone1.zone=mammal_zone;
					 
				 }
				 else if(category=="reptile"){
					 reptile_zone++;
					 zone1.zone=reptile_zone;
					 
				 }
					 
				 else if(category=="bird"){
					 bird_zone++;
					 zone1.zone=bird_zone;
				 }
    			 animals.put(type,zone1);
    			 cage_number++;
    		 }
    	 }
    	 else{
    		 Zone zone=new Zone();
    		 zone.category=category;
			 zone.cage=cage_number;
			 if(category=="mammal"){
				 mammal_zone++;
				 zone.zone=mammal_zone;
				 
			 }
			 else if(category=="reptile"){
				 reptile_zone++;
				 zone.zone=reptile_zone;
				 
			 }
				 
			 else if(category=="bird"){
				 bird_zone++;
				 zone.zone=bird_zone;
			 }
			 animals.put(type,zone);
			 cage_number++;
    	 }
    	 return "Added successfuly";
   }
     public static void deleteCage(String category,String type){
    	 Zone zone=animals.get(type);
    	 int cage=zone.cage;
    	 cage--;
    	 zone.cage=cage;
    	 animals.put(type,zone);
     }
}
