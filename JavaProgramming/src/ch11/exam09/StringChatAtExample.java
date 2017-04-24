package ch11.exam09;
//package ch11.exam09;

public class StringChatAtExample {
	public static void main(String[] args) {
		String ssn ="010624-1230123";
		char sex = ssn.charAt(7);
		
		switch(sex){
			case '1' :
			case '3' :
				System.out.println("³²ÀÚ"); break;
				
			case '2' :
			case '4' :
				System.out.println("duwk"); break;
				
		}
	}
	
}
