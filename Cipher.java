import java.util.*;
public class Cipher {

	public static void Decrypt() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println(" Input the ciphertext message : ");
	        String ciphertext = sc.nextLine();
	        System.out.println(" Enter the shift value : ");
	        int shift = sc.nextInt();
	        String decryptMessage = "";
	        for(int i=0; i < ciphertext.length();i++)

	        {
	            // Shift one character at a time
	            char alphabet = ciphertext.charAt(i);
	            // if alphabet lies between a and z
	            if(alphabet >= 'a' && alphabet <= 'z')
	            {
	                // shift alphabet
	                alphabet = (char) (alphabet - shift);

	                // shift alphabet lesser than 'a'
	                if(alphabet < 'a') {
	                    //reshift to starting position
	                    alphabet = (char) (alphabet-'a'+'z'+1);
	                }
	                decryptMessage = decryptMessage + alphabet;
	            }
	                // if alphabet lies between A and Z
	            else if(alphabet >= 'A' && alphabet <= 'Z')
	            {
	             // shift alphabet
	                alphabet = (char) (alphabet - shift);

	                //shift alphabet lesser than 'A'
	                if (alphabet < 'A') {
	                    // reshift to starting position
	                    alphabet = (char) (alphabet-'A'+'Z'+1);
	                }
	                decryptMessage = decryptMessage + alphabet;
	            }
	            else
	            {
	             decryptMessage = decryptMessage + alphabet;
	            }
	        }
	        System.out.println(" decrypt message : " + decryptMessage);
    }

    public static void Encrypt() {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Input the plaintext message : ");
        String plaintext = sc.nextLine();
        System.out.println(" Enter the value by which each character in the plaintext message gets shifted : ");
        int shift = sc.nextInt();
        String ciphertext = "";
        char alphabet;
        for(int i=0; i < plaintext.length();i++)
        {
             // Shift one character at a time
            alphabet = plaintext.charAt(i);

            // if alphabet lies between a and z
            if(alphabet >= 'a' && alphabet <= 'z')
            {
             // shift alphabet
             alphabet = (char) (alphabet + shift);
             // if shift alphabet greater than 'z'
             if(alphabet > 'z') {
                // reshift to starting position
                alphabet = (char) (alphabet+'a'-'z'-1);
             }
             ciphertext = ciphertext + alphabet;
            }

            // if alphabet lies between 'A'and 'Z'
            else if(alphabet >= 'A' && alphabet <= 'Z') {
             // shift alphabet
             alphabet = (char) (alphabet + shift);

             // if shift alphabet greater than 'Z'
             if(alphabet > 'Z') {
                 //reshift to starting position
                 alphabet = (char) (alphabet+'A'-'Z'-1);
             }
             ciphertext = ciphertext + alphabet;
            }
            else {
             ciphertext = ciphertext + alphabet;
            }

    }
    System.out.println(" ciphertext : " + ciphertext);
  }

  public static void BruteForce(){
  	 	        Scanner sc = new Scanner(System.in);
	 	        System.out.println(" Input the ciphertext message : ");
	 	        String ciphertext = sc.nextLine();
	 	        //System.out.println(" Enter the shift value : ");
	 	        for(int shift=0;shift<=24;shift++){
	 	        //int shift = sc.nextInt();
	 	        String decryptMessage = "";
	 	        for(int i=0; i < ciphertext.length();i++)

	 	        {
	 	            // Shift one character at a time
	 	            char alphabet = ciphertext.charAt(i);
	 	            // if alphabet lies between a and z
	 	            if(alphabet >= 'a' && alphabet <= 'z')
	 	            {
	 	                // shift alphabet
	 	                alphabet = (char) (alphabet - shift);

	 	                // shift alphabet lesser than 'a'
	 	                if(alphabet < 'a') {
	 	                    //reshift to starting position
	 	                    alphabet = (char) (alphabet-'a'+'z'+1);
	 	                }
	 	                decryptMessage = decryptMessage + alphabet;
	 	            }
	 	                // if alphabet lies between A and Z
	 	            else if(alphabet >= 'A' && alphabet <= 'Z')
	 	            {
	 	             // shift alphabet
	 	                alphabet = (char) (alphabet - shift);

	 	                //shift alphabet lesser than 'A'
	 	                if (alphabet < 'A') {
	 	                    // reshift to starting position
	 	                    alphabet = (char) (alphabet-'A'+'Z'+1);
	 	                }
	 	                decryptMessage = decryptMessage + alphabet;
	 	            }
	 	            else
	 	            {
	 	             decryptMessage = decryptMessage + alphabet;
	 	            }
	 	        }
	        System.out.println(" decrypt message by shift key "+shift+" :" + decryptMessage);
		  }
	}

  public static void main(String args[]){
	  Encrypt();
	  BruteForce();
	  Decrypt();
  }
}
