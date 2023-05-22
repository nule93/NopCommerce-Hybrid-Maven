package pageUIs.nopCommerce.admin;

public class AdminCustomerPageUI {

	public static final String ADD_NEW_BUTTON = "xpath=//a[contains(@href,'Create')]";
	public static final String DYNAMIC_TEXTBOX_BY_LABEL_NAME = "xpath=//label[text()='%s']/ancestor::div[@class='form-group row']//input";
	public static final String ADMIN_COMMENT_TEXTAREA = "XPATH=//label[text()='Admin comment']/ancestor::div[@class='form-group row']//textarea";
	public static final String GENDER_RADIO_BUTTON = "xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String CLEAR_ALL_CUSTOMER_ROLES = "xpath=//label[text()='Customer roles']/ancestor::div[@class='form-group row']/div//span[@title='clear']";
	public static final String CUSTOMER_ROLES_CHILD_DROPDOWN = "css=#SelectedCustomerRoleIds_listbox>li";
	public static final String CUSTOMER_ROLES_PARENT_DROPDOWN = "xpath=//label[text()='Customer roles']/parent::div/parent::div/following-sibling::div";
	public static final String VALUE_SELECTED_CUSTOMER_ROLES_DROPDOWN = "xpath=//select[@id='SelectedCustomerRoleIds']/option";
	
	public static final String ACTIVE_CHECKBOX = "xpath=//label[text()='Active']/parent::div/parent::div/following-sibling::div/input";
	public static final String DYNAMIC_BUTTON_BY_ATTRIBUTE_NAME = "xpath=//button[@type='submit' and @name='%s']";

	public static final String DYNAMIC_CONTENT_MESSAGE = "XPATH=//div[contains(@class,'alert-success')]";
	public static final String BACK_TO_CUSTOMER_LIST_BUTTON = "xpath=//a[text()='back to customer list']";
	public static final String DYNAMIC_BUTTON_AT_CUSTOMER_LIST_SCREEN = "XPATH=//button[contains(string(),'%s')]";
	public static final String DYNAMIC_DATE_OF_BIRTH_BY_ID_ATTRIBUTE_TO_SEARCH = "xpath=//label[text()='Date of birth']/ancestor::div[@class='form-group row']//select[@id='%s']";
	public static final String DYNAMIC_PRECEDING_SIBLING_BY_LABEL_NAME = "XPATH=//th[text()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_VALUE_BY_TABLE_NAME_AND_INDEX_ROW_AND_INDEX_LABEL_NAME = "xpath=//*[contains(text(),'%s')]/parent::div/following-sibling::div//tr[%s]/td[%s]";
	public static final String DYNAMIC_EDIT_BY_CUSTOMER_NAME = "XPATH=//td[text()='%s']/following-sibling::td/a[contains(text(),'Edit')]";
	public static final String ADD_NEW_ADDRESS_BUTTON = "xpath=//button[@type='button' and contains(text(),'Add new address')]";
	public static final String DYNAMIC_BUTTON_AT_ADDRESS_TABLE_BY_FIRST_NAME = "xpath=//td[text()='%s']/following-sibling::td/a[contains(text(),'%s')]";
	public static final String EMPTY_TABLE_BY_DYNAMIC_BLOCK_NAME = "xpath=//div[@class='card-title' and contains(text(),'%s')]/parent::div/following-sibling::div//tbody//td";
	public static final String DATA_LIST_OF_COLUMN_BY_DYNAMIC_LABEL_NAME = "XPATH=//tr/td[%s]";
	public static final String ADDRESSES_BLOCK = "xpath=//div[@id='customer-address']//div[@class='card-title']";
}
