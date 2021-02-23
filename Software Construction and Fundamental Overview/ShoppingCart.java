package cart;
import java.util.*;
public class ShoppingCart {
	
	public static HashMap <String,Product> item=new HashMap<String,Product>();
	public static HashMap <String,Integer> cart = new HashMap<String,Integer>();
	    public static void viewItems(){
	        System.out.println("Items in store");
	        Iterator<Map.Entry<String, Product>> itr = item.entrySet().iterator();
	        System.out.println("Product Name Quantity Price/Quantity");
	        while(itr.hasNext()){
	            Map.Entry<String, Product> entry = itr.next();
	            System.out.println(entry.getKey()+"    "+entry.getValue().quantity+"    "+entry.getValue().price);
	        }
	    }
	    public static void viewItemsInCart(){
	        System.out.println("Items in cart");
	        Iterator<Map.Entry<String, Integer>> itr = cart.entrySet().iterator();
	        System.out.println("Product  Name    Quantity ");
	        while(itr.hasNext()){
	            Map.Entry<String, Integer> entry = itr.next();
	            System.out.println(entry.getKey()+"    "+entry.getValue());
	        }
	    }
	    public static void addItemInCart(){
	    	Scanner sc= new Scanner(System.in);
	        System.out.println("Enter product name");
	        String itemName =sc.nextLine();
	        System.out.println("Enter product quantity");
	        int quantity=sc.nextInt();
	        if(item.containsKey(itemName)){
	            Product p=new Product();
	            p = item.get(itemName);
	            if(p.quantity>=quantity){
	                cart.put(itemName,quantity);
	                p.quantity = p.quantity-quantity;
	                item.replace(itemName,p);
	            }else{
	                System.out.println("The given item is not present in that much quantity");
	            }
	        }else{
	            System.out.println("The given item is not present in the shop");
	        }
	    }
	    public static void removeItemFromCart(){
	    	Scanner sc= new Scanner(System.in);
	      System.out.println("Enter product name");
	      String itemName =sc.nextLine();
	        if(cart.containsKey(itemName)){
	            int quantity = cart.get(itemName);
	            Product p = new Product();
	            p = item.get(itemName);
	            p.quantity = p.quantity+quantity;
	            cart.remove(itemName);
	            item.replace(itemName,p);
	        }else{
	            System.out.println("The given item is not present in the cart");
	        }
	    }
	    public static void updateItemInCart(){
	    	Scanner sc= new Scanner(System.in);
	      System.out.println("Enter product name");
	      String itemName =sc.nextLine();
	      System.out.println("Enter product quantity");
	      int quantity=sc.nextInt();
	        if(cart.containsKey(itemName)){
	            int quan = cart.get(itemName);
	            Product p = new Product();
	            p = item.get(itemName);
	            p.quantity=p.quantity+quan;
	            if(p.quantity>=quantity){
	            	cart.replace(itemName, quantity);
	            	p.quantity=p.quantity-quantity;
	            	item.replace(itemName,p);
	            }
	              else{
	                  System.out.println("The given item is not present in that much quantity");
	              }
	            }
	            
	         else{
	            System.out.println("The given item is not present in the cart");
	        }
	    
	    }
	    public static void viewBill(){
	      Iterator<Map.Entry<String, Integer>> itr = cart.entrySet().iterator();
	      float sum=0.0f;
	      System.out.println("Product Name    Quantity  Price");
	      while(itr.hasNext()){
	          Map.Entry<String, Integer> entry = itr.next();
	          Product p = new Product();
	          p = item.get(entry.getKey());
	          sum=sum+p.price*entry.getValue();
	          System.out.println(entry.getKey()+"    "+entry.getValue()+"    "+p.price*entry.getValue());
	      }
	          System.out.println("Total"+" " +sum);
	    }
	   public static void main(String[] args) {
		   Scanner sc= new Scanner(System.in);
	     Product p1=new Product(10,20);
	     item.put("Biscuit" , p1);
	     item.put("Chocolates" , new Product(15,150));
	     item.put("Chips", new Product(20,50));
	     item.put("Coke",new Product(12,80));
	     item.put("Ice-cream",new Product(5,30));
	     System.out.println("Welcome to Shopping Cart!!. The following is the list of available items in the store");
	     viewItems();
	     int a=1;
	     while(a!=0){
	         System.out.println("Press \n 1 To Add Item In Cart\n 2 To Remove Item From Cart \n 3 To Update Cart \n 4 To View Cart Items  \n 5 To Generate Bill \n 6 To View Store Items \n 7 To Exit");
	         int ans;
	         System.out.println("Enter your choice");
	         ans=sc.nextInt();
	         switch(ans){
	             case 1 : addItemInCart();
	                      break;
	             case 2 : removeItemFromCart();
	                      break;
	             case 3 : updateItemInCart();
	                      break;
	             case 4 : viewItemsInCart();
	                      break;
	             case 5 : viewBill();
	                      break;
	             case 6 : viewItems();
	                      break;
	             case 7 : System.out.println("Thanks for shopping!!");
	                      a=0;
	                      break;
	             default : System.out.println("You entered wrong choice.Please choose again");
	         }

	     }


	}
	}


