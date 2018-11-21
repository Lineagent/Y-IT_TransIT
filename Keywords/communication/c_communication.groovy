package communication

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class c_communication {
	
	private String email = "y-it@y-it.co.il"
	private String mobilePhone = "057-7894567"
	private String homePhone = "07-7894567"
	private String officePhone = "04-7894566"
	private String phoneExten = "555"
	private String faxNum = "02-7894562"
	
	@Keyword
	public String getEmail() {
		return email;
	}
	
	@Keyword
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	@Keyword
	public String getHomePhone() {
		return homePhone;
	}
	
	@Keyword
	public String getOfficePhone() {
		return officePhone;
	}
	
	@Keyword
	public String getPhoneExten() {
		return phoneExten;
	}
	
	@Keyword
	public String getFaxNum() {
		return faxNum;
	}
}
