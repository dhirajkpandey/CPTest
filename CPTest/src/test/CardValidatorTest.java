package test;
import org.testng.Reporter;
import org.testng.annotations.Test;
import main.CardValidator;

public class CardValidatorTest {
	
	@Test
	public void verifyCardIsValidAndIsOfVisaOrMasterType() {
		CardValidator.checkValidCardNumberAndType();
		Reporter.log("Card validation test passed successfully", true);
		
	}
}
