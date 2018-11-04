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

String nowStr = CustomKeywords.'newDate.c_nowStr.getNowStr'()

CustomKeywords.'logIn.LogIn.logIn'(GlobalVariable.site, GlobalVariable.userName, GlobalVariable.userPass)

WebUI.waitForElementPresent(findTestObject('Nav Bar/catalogues'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Nav Bar/catalogues'))

try {
    WebUI.click(findTestObject('Nav Bar/Nav Bar Catalogues/personnel'))
}
catch (def e) {
    WebUI.click(findTestObject('Nav Bar/catalogues'))

    WebUI.click(findTestObject('Nav Bar/Nav Bar Catalogues/personnel'))
} 

WebUI.waitForElementPresent(findTestObject('Indexes/Personnel Index/add Personnel'), 5)

WebUI.delay(1)

WebUI.click(findTestObject('Indexes/Personnel Index/add Personnel'))

WebUI.setText(findTestObject('Tickets/Personnel Ticket/Details/General/first Name'), nowStr)

WebUI.setText(findTestObject('Tickets/Personnel Ticket/Details/General/last Name'), 'קטלון')

