package address

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

public class c_address {
	
	private String city = "רחובות"
	private String street = "יעקב הלל"
	private String houseNum = "6"
	private String apartmentNum = "5"
	private String entrance = "1"
	private String mailbox = "66776"
	private String zipCode = "123"
	
	@Keyword
	public String getCity() {
		return city;
	}
	
	@Keyword
	public String getStreet() {
		return street;
	}
	
	@Keyword
	public String getHouseNum() {
		return houseNum;
	}
	
	@Keyword
	public String getApartmentNum() {
		return apartmentNum;
	}
	
	@Keyword
	public String getEntrance() {
		return entrance;
	}
	
	@Keyword
	public String getMailbox() {
		return mailbox;
	}
	
	@Keyword
	public String getZipCode() {
		return zipCode;
	}
}
