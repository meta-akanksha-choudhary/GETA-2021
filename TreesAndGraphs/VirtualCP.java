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
	public static TreeNode root=new TreeNode("A:'\'",null);
	public static TreeNode curDir=root;
	
	public static TreeNode find(TreeNode node,String file){
		if(node==null)
			return null;
		int total=node.children.size();
		for(int i=0;i<total-1;i++)
			find(node.children.get(i),file);
		if(node.val==file)
			return node;
		find(node.children.get(total-1),file);
		return null;
	}
	public static TreeNode print(TreeNode node){
		if(node==null)
			return null;
		int total=node.children.size();
		for(int i=0;i<total-1;i++)
			print(node.children.get(i));
		System.out.println(node.val);
		print(node.children.get(total-1));
		return null;
	}
	
	public static void mkdir(String file){
		String data="";
		data=curDir.val+"/"+file;
		TreeNode temp=find(curDir,data);
		if(temp!=null){
			curDir.children.add(new TreeNode(data,curDir));
			
		}
		System.out.println("Directory already exists");
	}
	public static void cd(String file){
		String data="";
		data=curDir.val+"/"+file;
		TreeNode temp=find(curDir,data);
		curDir=temp;
		System.out.println(curDir.val);
	}
	public static void bk(){
		TreeNode p=curDir.parent;
		System.out.println(curDir.val);
		
	}
	public static void main(String args[]){
		int a=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to VCP");
		while(a!=0){
			String ans="";
			System.out.print(root.val);
			ans=sc.nextLine();
			String token[]=ans.split(" ");
			switch(token[0]){
			case "mkdir": mkdir(token[1]);
			              break;
			case "cd" :  cd(token[1]);
			              break;
			case "bk" :   bk();
			              break;
			case "ls" : break;
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
