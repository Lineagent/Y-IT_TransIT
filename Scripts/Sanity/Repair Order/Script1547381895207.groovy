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

CustomKeywords.'login.c_login.logIn'(site, userName, userPass)

WebUI.waitForElementPresent(findTestObject('Nav Bar/safetyOfficer'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Nav Bar/safetyOfficer'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('General/loadingBar'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Nav Bar/safetyOfficer'))

WebUI.delay(1)

try {
    WebUI.click(findTestObject('Nav Bar/Nav Bar Safety Officer/repairOrders'))
}
catch (Exception e) {
    WebUI.delay(1)

    WebUI.click(findTestObject('Nav Bar/safetyOfficer'))

    WebUI.delay(1)

    WebUI.click(findTestObject('Nav Bar/Nav Bar Safety Officer/repairOrders'))
} 

WebUI.waitForElementPresent(findTestObject('Indexes/repairOrdersIndex'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Indexes/Repair Orders Index/repairOrdersTable'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Indexes/Repair Orders Index/firstRowInTable'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.doubleClick(findTestObject('Indexes/Repair Orders Index/firstRowInTable'))

WebUI.waitForElementPresent(findTestObject('Tickets/Repair Order Ticket/repairOrderContainer'), 15, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('General/loadingBar'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('General/dropdownListSpinner'), 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('General/dropdownListSpinner'), 1)

