
public class Sparse {

    private final int mat[][];
    private final int row,col;
    private final int len;
    public Sparse(int rno , int cno , int[] r,int[] c,int[] val){
    	len=r.length;
    	row=rno;
    	col=cno;
    	mat=new int[len][3];
    	for(int i=0;i<len;i++){
    		mat[i][0]=r[i];
    		mat[i][1]=c[i];
    		mat[i][2]=val[i];
    	}
    }
    
    public Sparse add(Sparse s2){
    	
    	if(this.row!=s2.row || this.col!=s2.col){
    		System.out.println("Matrices can't be added");
    		return null;
    	}
    	else{
    		int row[]=new int[this.len+s2.len];
        	int col[]=new int[this.len+s2.len];
        	int val[]=new int[this.len+s2.len];
        	int j=0;
    		int s1pos=0,s2pos=0;
    		while(s1pos<this.len && s2pos<s2.len){
    			if(this.mat[s1pos][0]>s2.mat[s2pos][0]||
    			   (this.mat[s1pos][0]==s2.mat[s2pos][0] &&
    					   this.mat[s1pos][1]>s2.mat[s2pos][1])){
    				row[j]=s2.mat[s2pos][0];
    				col[j]=s2.mat[s2pos][1];
    				val[j]=s2.mat[s2pos][2];
    				s2pos++;
    				j++;
    			}
    			else if(this.mat[s1pos][0]<s2.mat[s2pos][0]||
    	    			   (this.mat[s1pos][0]==s2.mat[s2pos][0] &&
    	    			   this.mat[s1pos][1]<s2.mat[s2pos][1])){
    				row[j]=this.mat[s1pos][0];
    				col[j]=this.mat[s1pos][1];
    				val[j]=this.mat[s1pos][2];
    	    				s1pos++;
    	    				j++;
    	    			}
    			else{
    				int addval=this.mat[s1pos][2]+s2.mat[s2pos][2];
    				if(addval!=0){
    					row[j]=this.mat[s1pos][0];
        				col[j]=this.mat[s1pos][1];
        				val[j]=addval;
    					
    				}
    				s1pos++;
					s2pos++;
					j++;
    			}
    		}
    		while(s1pos<this.len){
    			row[j]=this.mat[s1pos][0];
				col[j]=this.mat[s1pos][1];
				val[j]=this.mat[s1pos][2];
				j++;
				s1pos++;
    		}
    			
    		while(s2pos<s2.len)
    		{
    			row[j]=s2.mat[s2pos][0];
				col[j]=s2.mat[s2pos][1];
				val[j]=s2.mat[s2pos][2];
				s2pos++;
				j++;
    		}
    		Sparse res=new Sparse(this.row,this.col,row,col,val);
    		return res;
    	}
    	
    }
    public Sparse transpose(){
    	int row[]=new int[this.len];
    	int col[]=new int[this.len];
    	int val[]=new int[this.len];
    	int count[]=new int[this.col+1];
    	for(int i=1;i<=this.col;i++)
    		count[i]=0;
    	for(int i=0;i<len;i++)
    		count[mat[i][1]]++;
    	int[] index=new int[this.col+1];
    	index[1]=0;
    	for(int i=2;i<=this.col;i++)
    		index[i]=index[i-1]+count[i-1];
    	for(int i=0;i<len;i++){
    		int rpos=index[mat[i][1]]++;
    		row[rpos]=mat[i][1];
    		col[rpos]=mat[i][0];
    		val[rpos]=mat[i][2];
    	}
    	Sparse trans=new Sparse(this.col,this.row,row,col,val);
    	
    	return trans;
    	
    }
    public Sparse multiply(Sparse s2){
    	if(this.col!=s2.row){
    		System.out.println("Multiplication not possible");
    		return null;
    	}
    	int row[]=new int[this.len*s2.len];
    	int col[]=new int[this.len*s2.len];
    	int val[]=new int[this.len*s2.len];
    	int j=0;
    	s2=s2.transpose();
    	int s1pos,s2pos;
    	for(s1pos=0;s1pos<this.len;){
    		int r=mat[s1pos][0];
    		for(s2pos=0;s2pos<s2.len;){
    			int c=s2.mat[s2pos][0];
    			int tempa=s1pos;
    			int tempb=s2pos;
    			int sum=0;
    			while(tempa<this.len&&mat[tempa][0]==r&&tempb<s2.len&&s2.mat[tempb][0]==c){
    				if(this.mat[tempa][1]<s2.mat[tempb][1])
    					tempa++;
    				else if(this.mat[tempa][1]>s2.mat[tempb][1])
    					tempb++;
    				else
    					sum+=this.mat[tempa++][2]*s2.mat[tempb++][2];
    			}
    			if(sum!=0){
    				row[j]=r;
    				col[j]=c;
    				val[j]=sum;
    				j++;
    			}
    			while(s2pos<s2.len && s2.mat[s2pos][0]==c)
    				s2pos++;
    		}
    		while(s1pos<this.len && this.mat[s1pos][0]==r)
				s1pos++;
    		
    	}
    	Sparse res=new Sparse(this.row,s2.col,row,col,val);
    	return res;
    	
    }
    public boolean symmetric(Sparse s){
    	Sparse sy=s.transpose();
    	sy=s.transpose();
    	if(s==sy)
    		return true;
    	else
    		return false;
    }
    public void print(){
    	System.out.println("Dimension: "+row+"x"+col);
    	System.out.println("Sparse Matrix: \nRow Column Value");
    	for(int i=0;i<len&&mat[i][2]!=0;i++){
    		System.out.println(mat[i][0]+" "+mat[i][1]+" "+mat[i][2]);
    	}
    }
    public static void main(String args[]){
    	int r1[]={1,1,3,4,4};
    	int c1[]={2,4,3,1,2};
    	int val1[]={10,12,5,15,12};
    	int r2[]={1,2,3,4,4};
    	int c2[]={3,4,3,1,2};
    	int val2[]={8,23,9,20,25};
    	Sparse s1=new Sparse(4,4,r1,c1,val1);
    	Sparse s2=new Sparse(4,4,r2,c2,val2);
    	Sparse s3=s1.add(s2);
    	Sparse s4=s1.multiply(s2);
    	Sparse s5=s1.transpose();
    	s1.print();
    	s2.print();
    	System.out.println("Addition");
        s3.print();
    	System.out.println("Multiplication");
    	s4.print();
    	System.out.println("Transpose");
    	s5.print();
    	System.out.println("Symmetric"+" "+s1.symmetric(s1));
    	
    }
}
