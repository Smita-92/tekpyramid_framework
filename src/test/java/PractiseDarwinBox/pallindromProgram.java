package PractiseDarwinBox;

public class pallindromProgram {

	public static void main(String[] args) {
		String d="MOM";
		String result="";
		for(int i=d.length()-1;i>=0;i--) {
			char ch=d.charAt(i);
			result=result+ch;
		}
			if(result.equalsIgnoreCase(d)) {
				System.out.print("Pallindrom");
			}
			else
				System.out.println("not a pallindrom");
		}

	}


