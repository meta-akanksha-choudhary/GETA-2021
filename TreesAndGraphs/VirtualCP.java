import java.util.*;
public class VirtualCP {
	public static int n=5;
	public static class TreeNode{
		public String val;
		public List<TreeNode> children=new LinkedList<>();
		public TreeNode parent;
		public TreeNode(String data,TreeNode parent){
			val=data;
			this.parent=parent;
		}
		public TreeNode(String data,List<TreeNode> child,TreeNode parent){
			val=data;
			children=child;
			this.parent=parent;
		}
	}
	public static TreeNode root=new TreeNode("A:\\>",null);
	public static TreeNode curDir=root;
	
	/*public static TreeNode find(TreeNode node,String file){
		if(node==null)
			return null;
		if(node.val==file)
			return node;
		int total=node.children.size();
		for(int i=0;i<total;i++)
			return(find(node.children.get(i),file));
		//if(node.val==file)
			//return node;
		//find(node.children.get(total-1),file);
		return node;
	}*/
	public static TreeNode find(TreeNode node,String file){
		if(node==null){
			return null;
		}
		TreeNode res=null;
		List<TreeNode> q=new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()){
			int n=q.size();
			while(n>0){
				int index=0;
				TreeNode p=q.remove(index);
				if(p.val==file)
				{
					res=p;
					break;
				}
				for(int i=0;i<p.children.size();i++)
					q.add(p.children.get(i));
				n--;
			}
			
		}
		return res;
	}
	
	public static void print(TreeNode node){
		if(node==null){
		}
		List<TreeNode> q=new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()){
			int n=q.size();
			while(n>0){
				int index=0;
				TreeNode p=q.remove(index);
				System.out.print(p.val+" ");
				for(int i=0;i<p.children.size();i++)
					q.add(p.children.get(i));
				n--;
			}
			System.out.println();
		}
		
	}
	
	public static void mkdir(String file){
		TreeNode temp=find(root,file);
		if(temp==null){
			curDir.children.add(new TreeNode(file,curDir));
			System.out.println("Directory created successfully");
		}
		else{
		System.out.println("Directory already exists");
		}
	}
	public static void cd(String file){
		TreeNode temp=find(root,file);
		curDir=temp;
		if(temp!=null)
		  System.out.println(curDir.val);
		else
			System.out.println("No such directory");
	}
	public static void bk(){
		if(curDir==root){
			System.out.println(curDir.val);
		}
		else{
			curDir=curDir.parent;
		    System.out.println(curDir.val);
		}
		
	}
	public static void main(String args[]){
		int a=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to VCP");
		while(a!=0){
			String ans="";
			System.out.print(root.val+">");
			ans=sc.nextLine();
			String token[]=ans.split(" ");
			switch(token[0]){
			case "mkdir": mkdir(token[1]);
			              break;
			case "cd" :  cd(token[1]);
			              break;
			case "bk" :   bk();
			              break;
			case "ls" :   break;
			case "find" : find(curDir,token[1]);
				          break;
			case "tree" : print(root);
			              break;
			case "exit" : System.out.println("Thanks for using!!");
                          a=0;
				          break;
			default : System.out.println("You entered wrong commnad.");
			}
		}
	}

}
