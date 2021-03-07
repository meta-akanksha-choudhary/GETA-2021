
public class MaxHeap {
	private int[] heap;
	private int size;
	private int maxsize;
	public MaxHeap(int maxsize){
		this.maxsize=maxsize;
		this.size=0;
		heap=new int[this.maxsize+1];
		heap[0]=Integer.MAX_VALUE;
	}
	private int parent(int pos){
		return pos/2;
	}
	private int leftChild(int pos){
		return (2*pos);
	}
	private int rightChild(int pos){
		return (2*pos)+1;
	}
	private boolean isLeaf(int pos){
		if(pos>(size/2) && pos<=size)
			return true;
		return false;
	}
	private void swap(int fpos,int spos){
		int temp=heap[fpos];
		heap[fpos]=heap[spos];
		heap[spos]=temp;
	}
	private void maxHeapify(int pos){
		if(isLeaf(pos))
			return;
		if(heap[pos]<heap[leftChild(pos)] || heap[pos]<heap[rightChild(pos)]){
			if(heap[leftChild(pos)]>heap[rightChild(pos)]){
				swap(pos,leftChild(pos));
				maxHeapify(leftChild(pos));
			}
			else{
				swap(pos,rightChild(pos));
				maxHeapify(rightChild(pos));
			}
		}
	}
	public void insert(int x){
		heap[++size]=x;
		int current=size;
		while(heap[current]>heap[parent(current)]){
			swap(current,parent(current));
			current=parent(current);
		}
	}
	public void print(){
		for(int i=1;i<=size/2;i++){
			System.out.print("P "+heap[i]+" "+"L "+heap[2*i]+" "+"R "+heap[2*i+1]+" ");
			System.out.println();
		}
		System.out.println();
	}
	public int extractMax(){
		int pop=heap[1];
		heap[1]=heap[size--];
		maxHeapify(1);
		return pop;
	}
	public static void main(String[] arg){
	  int balls=5;
	  int n=7;
	  int quota[]={16,18,4,8,5,7,9};
	  MaxHeap m=new MaxHeap(n);
	  for(int i=0;i<n;i++)
		  m.insert(quota[i]);
	  
	  while(balls!=0){
		  m.print();
		  int a=m.extractMax();
		  a--;
		  m.insert(a);
		  balls--;
	  }
		
	}

}
