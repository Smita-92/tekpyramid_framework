package PractiseDarwinBox;

public class reverseatheastring {

	public static void main(String[] args) {
		String g="My name is xyz";
		
		String h[]=g.split(" ");
		//String temp="";
		for(int i=h.length-1;i>=0;i--) {
			String result=h[i];
			//temp=temp+result+" ";
			System.out.print(result+" ");
		}
		

	}

}
