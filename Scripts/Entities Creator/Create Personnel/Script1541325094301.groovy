import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String nowStr = CustomKeywords.'newDate.c_nowStr.getNowStr'()

String city = CustomKeywords.'address.c_address.getCity'()

String street = CustomKeywords.'address.c_address.getStreet'()

String houseNum = CustomKeywords.'address.c_address.getHouseNum'()

String apartmentNum = CustomKeywords.'address.c_address.getApartmentNum'()

String entrance = CustomKeywords.'address.c_address.getEntrance'()

String mailbox = CustomKeywords.'address.c_address.getMailbox'()

String zipCode = CustomKeywords.'address.c_address.getZipCode'()

String email = CustomKeywords.'communication.c_communication.getEmail'()

String mobilePhone = CustomKeywords.'communication.c_communication.getMobilePhone'()

String homePhone = CustomKeywords.'communication.c_communication.getHomePhone'()

String officePhone = CustomKeywords.'communication.c_communication.getOfficePhone'()

String phoneExten = CustomKeywords.'communication.c_communication.getPhoneExten'()

String faxNum = CustomKeywords.'communication.c_communication.getFaxNum'()

CustomKeywords.'login.c_login.logIn'(GlobalVariable.site, GlobalVariable.userName, GlobalVariable.userPass)

WebUI.waitForElementPresent(findTestObject('Nav Bar/catalogues'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Nav Bar/catalogues'))

WebUI.delay(1)

try {
    WebUI.click(findTestObject('Object Repository/Nav Bar Catalogues/personnel'))
}
catch (def e) {
    WebUI.click(findTestObject('Nav Bar/catalogues'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Nav Bar Catalogues/personnel'))
} 

try {
	WebUI.delay(1)
	
    WebUI.waitForElementPresent(findTestObject('Indexes/Personnel Index/add Personnel'), 5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1)

    WebUI.click(findTestObject('Indexes/Personnel Index/add Personnel'))
}
catch (def e) {
	WebUI.delay(1)
	
    WebUI.click(findTestObject('Nav Bar/catalogues'))
	
	WebUI.delay(1)

    WebUI.click(findTestObject('Object Repository/Nav Bar Catalogues/personnel'))
	
	WebUI.delay(1)

    WebUI.waitForElementPresent(findTestObject('Indexes/Personnel Index/add Personnel'), 5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.delay(1)

    WebUI.click(findTestObject('Indexes/Personnel Index/add Personnel'))
} 

WebUI.delay(1)

WebUI.setText(findTestObject('Object Repository/General/first Name'), nowStr)

WebUI.setText(findTestObject('Object Repository/General/last Name'), 'קטלון')

WebUI.setText(findTestObject('Object Repository/General/city'), city)

WebUI.setText(findTestObject('Object Repository/General/street'), street)

WebUI.setText(findTestObject('Object Repository/General/house Number'), houseNum)

WebUI.setText(findTestObject('Object Repository/General/entrance'), entrance)

WebUI.setText(findTestObject('Object Repository/General/apartment Number'), apartmentNum)

WebUI.setText(findTestObject('Object Repository/General/mailbox'), mailbox)

WebUI.setText(findTestObject('Object Repository/General/zip Code'), zipCode)

WebUI.setText(findTestObject('Object Repository/General/remarks'), 'בדיקה')

WebUI.setText(findTestObject('Object Repository/General/email'), email)

WebUI.setText(findTestObject('Object Repository/General/mobile Phone'), mobilePhone)

WebUI.click(findTestObject('Object Repository/General/interface Button'))

WebUI.setText(findTestObject('Object Repository/General/home Phone'), homePhone)

WebUI.setText(findTestObject('Object Repository/General/office Phone'), officePhone)

WebUI.setText(findTestObject('Object Repository/General/phone Extention'), phoneExten)

WebUI.setText(findTestObject('Object Repository/General/fax Number'), faxNum)

WebUI.delay(1)

WebUI.click(findTestObject('Tickets/Personnel Ticket/personnel Save'))

WebUI.delay(5)

WebUI.click(findTestObject('Tickets/Personnel Ticket/personnel Close'))

WebUI.click(findTestObject('Nav Bar/catalogues'))

try {
    WebUI.click(findTestObject('Object Repository/Nav Bar Catalogues/personnel'))
}
catch (def e) {
    WebUI.click(findTestObject('Nav Bar/catalogues'))

    WebUI.click(findTestObject('Object Repository/Nav Bar Catalogues/personnel'))
} 

WebUI.delay(1)

WebUI.click(findTestObject('Indexes/Personnel Index/refresh'))

WebUI.delay(3)

WebUI.setText(findTestObject('Indexes/Personnel Index/fast Search'), nowStr)

WebUI.delay(1)

WebUI.doubleClick(findTestObject('Indexes/Personnel Index/new Driver td'))

WebUI.delay(1)

WebUI.executeJavaScript('alert(`Personnel created with: ` + arguments[0])', [nowStr])

WebUI.delay(5)

WebUI.acceptAlert()

WebUI.closeBrowser()

