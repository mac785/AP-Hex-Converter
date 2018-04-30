import java.util.Scanner;

public class HexConverter {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String args[]){
		System.out.println("Hello, enter a number");
		String numString = input.nextLine();
		boolean isNum = false;
		while(!isNum){
			isNum = checkIsNum(numString);
			if(!isNum){
				System.out.println("Not a number, please try again");
				numString = input.nextLine();
			}
		}
		int num = Integer.parseInt(numString);
		System.out.println("Your Number is: "+num);
		String hex = hexConverter(num);
		System.out.println("Your Number in Hex is: "+hex);
	}
	
//	Checks if the input is a decimal number
	public static boolean checkIsNum(String num){		
		try{
			Integer.parseInt(num);
		}
		catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	public static String hexConverter(int decNum){
		int converterBase = 16;
		String numbers[] = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String hexNum = "";
		
		if (decNum == 0){
			return "";
		}
		else{
			int lowestDig = decNum%converterBase;
			decNum-=lowestDig;
			decNum/=converterBase;
			String lowestDigHex = numbers[lowestDig];
			hexNum += hexConverter(decNum)+lowestDigHex;
			return hexNum;
		}
	}

}
