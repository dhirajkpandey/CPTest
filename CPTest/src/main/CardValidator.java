package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidator {
	
	private static final String MASTERCARD = "^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$";
    private static final String VISA = "^4[0-9]{15}$";
    private static int visaNumber, masterNumber = 0;
    
    private static boolean resultSet = false;
   
	
	public static String sixteenDigitNumberGenerator()
    {
		Random randomObj = new Random();
	    int counter=0;
	    StringBuffer stringBufferObj = new StringBuffer();
	    while(counter<16){
	        int generate = randomObj.nextInt(9); 
	        stringBufferObj.append(generate);
	        counter++;
	    }
	    return stringBufferObj.toString();
	}
	
	public static void checkValidCardNumberAndType(){
		
		do{
			String ccNumber = CardValidator.sixteenDigitNumberGenerator();
			//First Validation that card number is valid
			int sum = 0;
	        boolean oddNumber = false;
	        for (int i = ccNumber.length() - 1; i >= 0; i--)
	        {
                int n = Integer.parseInt(ccNumber.substring(i, i + 1));
                if (oddNumber)
                {
                        n *= 2;
                        if (n > 9)
                        {
                                n = (n % 10) + 1;
                        }
                }
                sum += n;
                oddNumber = !oddNumber;
	        }
        	if(sum % 10 == 0){
        		//System.out.println("A valid credit card number");
        		//System.out.println(ccNumber);
        		
        		//Second validation that card is either visa or master
        		String cardTypeValue = CardValidator.getCardType(ccNumber);
        		if(cardTypeValue=="Visa"){
        			visaNumber++;
        			fileWriter("Card type is Visa " +" "+ ccNumber);
        			//System.out.println("Card is visa type");
        			//System.out.println(visaNumber);

        		}
        		else if(cardTypeValue=="Mastercard"){
        			masterNumber++;
        			fileWriter("Card type is Master" +" "+ ccNumber);
        			//System.out.println("Card is master type");
        			//System.out.println(masterNumber);

        		}
        		
        	}
        	
        	resultSet = visaNumber >=2 && masterNumber>=2;
        	
   	}while(resultSet == false);
   		
}

	
	public static String getCardType(String cardNumber) {
        if (isVisa(cardNumber)) { return "Visa"; }
        else if (isMasterCard(cardNumber)) { return "Mastercard"; }
        else return "";
	}
    private static boolean isVisa(String number) {
        Pattern pObj = Pattern.compile(VISA);
        Matcher mObj = pObj.matcher(number);
        return mObj.matches();

    }
    private static boolean isMasterCard(String number) {
        Pattern pObj = Pattern.compile(MASTERCARD);
        Matcher mObj = pObj.matcher(number);
        return mObj.matches();
    }

	public static void  fileWriter(String cardData){
		
		final String FILENAME = ".\\OutPutFile.txt";
		BufferedWriter bwObj = null;
		FileWriter fwObj = null;

		try {
			
			File file = new File(FILENAME);
			if (!file.exists()) {
				file.createNewFile();
			}

			fwObj = new FileWriter(file.getAbsoluteFile(), true);
			bwObj = new BufferedWriter(fwObj);

			bwObj.write(cardData +" "+ System.lineSeparator());

		
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bwObj != null)
					bwObj.close();

				if (fwObj != null)
					fwObj.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		}
	
	public static void main(String[] args) {
		
		/**
		 * If TestNG library is not installed, this project can be run by just removing comment from 
		 *  below method "checkValidCardNumberAndType()"
		 * 
		 * @author Dhiraj.Pandey 
		 */
		
		//checkValidCardNumberAndType();
	}
}