
public class Rotation {
    static class List{
    	int data;
    	List next;
    }
    public static void rotate(List A,int m,int n,int k){
    	int size=n-m+1;
    	if(k>size){
    		k=k%size;
    	}
    	if(k==0 || k==size){
    		print(A);
    		return;
    	}
    	List link=null;
    	if(m==1)
    		link=A;
    	List c=A;
    	int count=0;
    	List end=null;
    	List pre=null;
    	while(c!=null){
    		count++;
    		if(count==m-1){
    			pre=c;
    			link=c.next;
    		}
    		if(count==n-k){
    			if(m==1){
    				end=c;
    				A=c.next;
    			}
    			else{
    				end=c;
    				pre.next=c.next;
    			}
    		}
    		if(count==n){
    			List d=c.next;
    			c.next=link;
    			end.next=d;
    			List head=A;
    			print(head);
    			return;
    		}
    		c=c.next;
    	}
    	
    }
    public static List push(List head,int val){
    	List new_node=new List();
    	new_node.data=val;
    	new_node.next=head;
    	head=new_node;
    	return head;
    }
    public static void print(List head){
    	List temp=head;
    	System.out.println("The list is :");
    	while(temp!=null){
    		System.out.print(temp.data+" ->");
    		temp=temp.next;
    	}
    	System.out.println();
    }
    public static void main(String args[]){
    	List head=null;
    	head=push(head,70);
    	head=push(head,60);
    	head=push(head,50);
    	head=push(head,40);
    	head=push(head,10);
    	print(head);
    	System.out.println("The list after rotation is");
    	rotate(head,2,4,2);
    }
}
