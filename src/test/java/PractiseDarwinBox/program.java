package PractiseDarwinBox;

import java.util.ArrayList;

public class program {

	public static void main(String[] args) 
	{
		ArrayList<Integer> list=new ArrayList();

		int k=0;

		for(int i=0;i<99;i++) {

			list.add(i+1);

		}

		System.out.println(list);

		for(int j=1; j<=100;j++) {

			try {

			//System.out.println(list.get(j));

			if(list.get(k)==j) {

				System.out.println(j);

				k++;

			}}

			catch(Exception e) {

			System.out.println("missing number"+j);

			}

		}

	}

}
