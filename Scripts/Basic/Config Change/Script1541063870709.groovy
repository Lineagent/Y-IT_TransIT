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

String randomNumber = Math.round(Math.random() * 1000).toString()

CustomKeywords.'logIn.c_logIn.logIn'(GlobalVariable.site, GlobalVariable.userName, GlobalVariable.userPass)

WebUI.waitForElementPresent(findTestObject('Nav Bar/settings'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Nav Bar/settings'))

try {
    WebUI.click(findTestObject('Nav Bar/Nav Bar Settings/system Preferences'))
}
catch (def e) {
    WebUI.click(findTestObject('Nav Bar/settings'))

    WebUI.click(findTestObject('Nav Bar/Nav Bar Settings/system Preferences'))
} 

WebUI.waitForElementClickable(findTestObject('System Preferences/System/General/fax_Zip_Code'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.setText(findTestObject('System Preferences/System/General/fax_Zip_Code'), '')

String checkValue = WebUI.getText(findTestObject('System Preferences/System/General/fax_Zip_Code'))

int i = 0

while (checkValue && (i < 5)) {
    WebUI.setText(findTestObject('System Preferences/System/General/fax_Zip_Code'), '')

    checkValue = WebUI.getText(findTestObject('System Preferences/System/General/fax_Zip_Code'))

    i++
}

WebUI.setText(findTestObject('System Preferences/System/General/fax_Zip_Code'), randomNumber)

WebUI.delay(1)

WebUI.click(findTestObject('System Preferences/System/General/settings Save'))

WebUI.delay(1)

WebUI.click(findTestObject('System Preferences/System/General/settings Close'))

WebUI.delay(1)

WebUI.click(findTestObject('Nav Bar/settings'))

try {
    WebUI.click(findTestObject('Nav Bar/Nav Bar Settings/system Preferences'))
}
catch (def e) {
    WebUI.click(findTestObject('Nav Bar/settings'))

    WebUI.click(findTestObject('Nav Bar/Nav Bar Settings/system Preferences'))
} 

WebUI.waitForElementClickable(findTestObject('System Preferences/System/General/fax_Zip_Code'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('System Preferences/System/General/fax_Zip_Code'), 'value', randomNumber, 0)

WebUI.delay(1)

WebUI.executeJavaScript('alert(`Fax zip code containes: ` + arguments[0])', [randomNumber])

WebUI.delay(5)

WebUI.acceptAlert()

WebUI.closeBrowser()

