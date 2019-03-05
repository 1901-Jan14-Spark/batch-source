package bankApplication;

public class Cipher {
	public static String encode(String string) {
		String output = "";
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			//change letters to lower case
			char letter = string.toLowerCase().charAt(i);
			//ignore white space
			if (letter != ' ') {
				int charVal = (int)letter;//get ascii value
				if (charVal > 96 && charVal < 123) {
					//subtract the largest ascii val from the difference between the letter's ascii val and the lowest 
					//possible ascii val
					int shift = 122 - (charVal - 97);
					//append to output
					output += (char)shift;
					count++;//increment count
					//when the fifth letter has been appended to output append a space
					if(count==5) {
						output += " ";
						count = 0;
					}
				}
				//ignore any other character besides numbers
				else if(charVal > 47 && charVal < 58) {
					output += letter;
					count++;
					if(count==5) {
						output += " ";
						count = 0;
					}
				}
			}
		}
		return output.trim();
	}

	public static String decode(String string) {
		String output = "";
		for (int i = 0; i < string.length(); i++) {
			//change letters to lower case
			char letter = string.toLowerCase().charAt(i);
			//ignore white space
			if (letter != ' ') {
				int charVal = (int)letter;//get ascii value
				if (charVal > 96 && charVal < 123) {
					//subtract the largest ascii val from the difference between the letter's ascii val and the lowest 
					//possible ascii val
					int shift = 122 - (charVal - 97);
					//append to output
					output += (char)shift;
				}
				else if(charVal > 47 && charVal < 58) 
					output += letter;

			}
		}
		return output;
	}
}
