package PractiseDarwinBox;

public class reverseWithoutSpace {

	public static void main(String[] args) {
		String f="My name is xyz";
		String withoutspace=f.replace(" ", "");
		int index=withoutspace.length()-1;
		for(int i=0;i<f.length()-1;i++) {
			char ch=f.charAt(i);
			if(ch==' ') {
				System.out.print(ch);
			}else
				System.out.print(withoutspace.charAt(index--));
		}

	}

}
