import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.Iterator;

public class CollegeManagement implements Queue1{
	
	private String arr[];
	private int rear;
	private int front;
	private final int size=100;
	private static HashMap<String,Double> programs = new HashMap<>();
	public static HashMap<String,List<IPrograms>> students=new HashMap<>();
	private static HashMap<String,String> studentAndPrograms = new HashMap<>();

	public CollegeManagement(){
		arr=new String[size];
		rear=-1;
		front=-1;
	}
	public static CollegeManagement q=new CollegeManagement();
	public void insert(String x){
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		if(front==-1){
			front=0;
			rear=0;
		}
		else if(rear==size-1 && front!=0){
			rear=0;
		}
		else{
			rear=rear+1;
		}
		arr[rear]=x;
	}
	public String delete(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return "#";
		}
		String temp=arr[front];
		if(front==rear){
			front=-1;
			rear=-1;
		}
		else if(front==size-1)
			front=0;
		else 
			front=front +1;
		return temp;
	}
	public boolean isFull(){
		if((front==0 && rear==size-1 )|| (rear==(front-1)%(size-1)))
			return true;
		else
			return false;
	}
	public boolean isEmpty(){
		if(front==-1)
			return true;
		return false;
		
	}
	
	
	public static void getInputStudent(String pathOfFile){
		try{
	
	FileInputStream fs = new FileInputStream(new File(pathOfFile));
	HSSFWorkbook wb=new HSSFWorkbook(fs);
	HSSFSheet sheet = wb.getSheetAt(1);
	int rowEnd=Math.max(0,sheet.getLastRowNum());
	for(int i=1;i<=rowEnd;i=i+5){
		int j=1,k;
		Row row=sheet.getRow(i);
		String name=row.getCell(0).getStringCellValue();
		q.insert(name);
		List<IPrograms> a=new ArrayList<IPrograms>();
		k=i;
		for(int l=k;l<=k+5;l++){
		Row row1=sheet.getRow(l);
		IPrograms ip=new IPrograms();
		ip.name=row1.getCell(1).getStringCellValue();
		ip.rank=j;
		j++;
		a.add(ip);
		}
		students.put(name, a);
	  }
	}catch(Exception e){
		System.out.println(e.getMessage());
	  }
	}
		
		public static void getInputProgram(String pathOfExcelFile){
			try{
		FileInputStream fs = new FileInputStream(new File(pathOfExcelFile));
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(1);
		int rowEnd=Math.max(0,sheet.getLastRowNum());
		for(int i=1;i<=rowEnd;i++){
			Row row=sheet.getRow(i);
			String name=row.getCell(0).getStringCellValue();
			double cap=row.getCell(1).getNumericCellValue();
			programs.put(name, cap);
		 }
		}
			catch(Exception e){
			System.out.println(e.getMessage());
		   }
		}
	public static void setStudent(){
		try{
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("Student Program");
		HSSFRow row;
		
		while(!q.isEmpty()){
			String name=q.delete();
	        List<IPrograms> ip=students.get(name);
	        for(int i=0;i<ip.size();i++){
	        	IPrograms j=ip.get(i);
	        	String pname=j.name;
	        	Double cap=programs.get(pname);
	        	if(cap>0){
	        		cap--;
	        		programs.put(pname, cap);
	        		studentAndPrograms.put(name, pname);
	        		break;
	        	}
	        }
	        if(!studentAndPrograms.containsKey(name))
	        	studentAndPrograms.put(name, null);
		}
		Iterator<Map.Entry<String, String>> itr = studentAndPrograms.entrySet().iterator();
		int rowid=0;
		Map.Entry<String, String>it=itr.next();
		while(itr.hasNext()){
			row=sheet.createRow(rowid++);
			int cellid=0;
			Cell cell1=row.createCell(cellid++);
			cell1.setCellValue(it.getKey());
			Cell cell2=row.createCell(cellid++);
			cell2.setCellValue(it.getValue());
		}
		FileOutputStream out=new FileOutputStream("C:\\Users\\akanksha.choudhary_m\\Desktop\\Students&Programs.xls");
		wb.write(out);
		out.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void print(){
		for(Map.Entry<String, List<IPrograms>> i: students.entrySet())
			System.out.println(i.getKey()+" "+i.getValue());
		
	}
	public static void printProgram(){
		for(Map.Entry<String, Double> i:programs.entrySet())
			System.out.println(i.getKey()+" "+i.getValue());
		
	}
	
	public static void main(String[] args) {
		
		String file="C:\\Users\\akanksha.choudhary_m\\Desktop\\Students.xls";
		String file1="C:\\Users\\akanksha.choudhary_m\\Desktop\\Program.xls";
		getInputStudent(file);
		print();
		getInputProgram(file1);
		printProgram();
		setStudent();
	}
}
