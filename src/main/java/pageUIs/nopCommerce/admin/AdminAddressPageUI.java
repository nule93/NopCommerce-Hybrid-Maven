package pageUIs.nopCommerce.admin;

public class AdminAddressPageUI {
	public static final String DYNAMIC_TEXTBOX_BY_LABEL_NAME = "xpath=//label[text()='%s']/ancestor::div[@class='form-group row']//input";
	public static final String DYNAMIC_DROPDOWN_LIST_BY_LABEL_NAME = "xpath=//label[text()='%s']/ancestor::div[@class='form-group row']/div//select";
	public static final String BACK_TO_CUSTOMER_DETAILS_BUTTON = "xpath=//a[text()='back to customer details']";
	public static final String SAVE_BUTTON = "xpath=//button[@type='submit' and @name='save']|//button[@type='submit' and contains(text(),'Save')]";
	public static final String DYNAMIC_CONTENT_MESSAGE = "XPATH=//div[contains(@class,'alert-success')]";

}
