
public class LoopDetection {
	List head;
	class List{
    	int data;
    	List next;
    	List(int d){
    		data=d;
    		next=null;
    	}
    }
	public void push(int val){
    	List new_node=new List(val);
    	new_node.next=head;
    	head=new_node;
	}
	public boolean detectLoop(){
		List slow=head,fast=head;
		int flag=0;
		while(slow!=null && fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				flag=1;
				break;
			}
		}
		if(flag==1)
			return true;
		else return false;
	}
	public static void main(String args[]){
		LoopDetection l=new LoopDetection();
    	l.push(10);
    	l.push(20);
    	l.push(30);
    	l.push(40);
    	l.push(50);
    	//l.head.next.next.next=l.head;
    	
    	System.out.println("List has loop "+l.detectLoop());
    }

}
