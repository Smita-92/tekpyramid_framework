package PractiseDarwinBox;

public class reverseEachword {

	public static void main(String[] args) {
		String f="My name is xyz";
		String[] g=f.split(" ");
		String rev="";
		for(int i=0;i<g.length;i++) {
			String result=g[i];
			for(int j=result.length()-1;j>=0;j--) {
				char ch = result.charAt(j);
				System.out.print(ch);
			}
			System.out.print(" ");
		}	
	}

}
