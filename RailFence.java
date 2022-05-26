import java.util.*;

public class RailFence{
	public static void Encrypt(){

		Scanner sc = new Scanner(System.in);



		//Password: Input/Uppercase/Space removal/Splitting to array of char
		System.out.print("Enter Password: ");
		String tempPass=sc.nextLine().toUpperCase();
		char[] pass = tempPass.replaceAll(" ", "").toCharArray();



		//Plain Text: Input/Lowercase/Space removal/Adding X
    	System.out.print("\nEnter Plain Text: ");
    	String plaintext=sc.nextLine().toLowerCase();
    	char[] text = plaintext.replaceAll(" ", "").toCharArray();
    	if(text.length%pass.length!=0){
			int tempLength=text.length%pass.length;
			for(int x=tempLength;x<pass.length;x++){
				  text = Arrays.copyOf(text, text.length + 1);
				  text[text.length-1] = 'x';
			}
		}



		//Output Table
    	for ( int x=0; x<pass.length; x++) {
			System.out.print(pass[x] + "	");
		}
     	System.out.println();
     	for ( int x=0; x<text.length; x++) {
			if(x%pass.length==0){
				System.out.println();
			}
			System.out.print(text[x] + "	");
    	}

		String encrypt="";
		for(int x=0;x<pass.length;x++){
			encrypt=encrypt+pass[x];
			int y;
			y=x;
			while(y<text.length){
				encrypt=encrypt+text[y];
				y=y+pass.length;
			}
		}



		//Split the Encryption into an array that contains equal number of char in each String
		String splitted[]=(encrypt.length()/pass.length<1 || encrypt==null) ? null : encrypt.split("(?<=\\G.{"+encrypt.length()/pass.length+"})");
		//Sort the Array in alphabetical order
	  	Arrays.sort(splitted);
	  	//Remove first letter in each String in the array, this letter belongs to the password
		for (int i = 0; i < splitted.length; i++) {
 	    	splitted[i] = splitted[i].substring(1);
  		}
		//Merge the Strings in the array into one String
  		encrypt="";
  		for(int i=0;i<splitted.length;i++){
			encrypt=encrypt+splitted[i];
		}

		System.out.println("\n\nEncrypt: "+encrypt);
	}

	public static void Decrypt(){

		Scanner sc=new Scanner(System.in);

		//Input encypted text/lowercase/remove spaces
		System.out.print("Enter Encrypted Text: ");
		String encrypt=sc.nextLine().toLowerCase().replaceAll(" ","");



		//Input password/uppercase/remove spaces/put in an array/sort array alphabetically
		System.out.print("Enter Password: ");
		String tempPass=sc.nextLine().toUpperCase().replaceAll(" ","");
		char pass[]=tempPass.toCharArray();
		Arrays.sort(pass);



		//Split the encypted text into equal parts/add letter of the sorted pass into each string in the splitted array
		String splitted[]=(encrypt.length()/pass.length<1 || encrypt==null) ? null : encrypt.split("(?<=\\G.{"+encrypt.length()/pass.length+"})");
		for(int x=0;x<pass.length;x++){
			splitted[x]=pass[x]+splitted[x];
		}



		//Form decrypted message
		String decrypt;
		encrypt="";
		String tempEncrypt="";
		for(int x=0;x<splitted.length;x++){
			encrypt=encrypt+splitted[x];
		}
		for(int y=0;y<tempPass.length();y++){
			for(int x=0;x<encrypt.length();x++){
				if(tempPass.charAt(y)==encrypt.charAt(x)){
					tempEncrypt=tempEncrypt+encrypt.substring(x,x+(encrypt.length()/pass.length));
				}
			}
		}
		String splittedEncrypt[]=(tempEncrypt.length()/pass.length<1 || tempEncrypt==null) ? null : tempEncrypt.split("(?<=\\G.{"+tempEncrypt.length()/pass.length+"})");
		encrypt="";
		for(int y=1;y<(tempEncrypt.length()/pass.length);y++){
			for(int x=0;x<pass.length;x++){
				encrypt=encrypt+splittedEncrypt[x].charAt(y);
			}
		}
		decrypt=encrypt;



		//Output table and final decrypt
		for ( int x=0; x<tempPass.length(); x++) {
			System.out.print(tempPass.charAt(x)+"	");
		}
		System.out.println();

		for(int x=0;x<decrypt.length();x++){
			if(x%pass.length==0){
				System.out.println();
			}
			System.out.print(decrypt.charAt(x)+"	");
		}

		System.out.println("\n\nDecrypted message: "+decrypt);
	}


	public static void main(String args[]){
		Encrypt();
		Decrypt();
	}
}
