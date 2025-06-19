package PractiseDarwinBox;

import java.util.ArrayList;

public class printDenomination {

	public static void main(String[] args) {
		ArrayList< Integer> list=new ArrayList<Integer>();
		list.add(2000);
		list.add(500);
		list.add(200);
		list.add(50);
		list.add(20);
		list.add(10);
		list.add(5);
		list.add(2);
		list.add(1);
		int data=4567;
		 
		for(int i:list) {
			 if(data>i && data!=0) {
				 int count=data/i;
				 data=data%i;
			 
			 System.out.println(count+"===="+i);
			 
			
		}

	}

}}
