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

'login\r\n'
WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('General/mainEmptyBackground'), 15)

WebUI.waitForElementPresent(findTestObject('Nav Bar/commandAndControl'), 15)

WebUI.waitForElementNotPresent(findTestObject('General/loadingBar'), 15)

'check if task control view is already open'
boolean isControldTasksOpen = WebUI.waitForElementPresent(findTestObject('Command and Control/Tasks Control/taskControlView'), 
    15)

'if task control view is not open then open it'
if (!(isControldTasksOpen)) {
    WebUI.click(findTestObject('Nav Bar/commandAndControl'))

    WebUI.delay(1)

    try {
        WebUI.click(findTestObject('Nav Bar/Nav Bar CnC/controlTasks'))
    }
    catch (Exception e) {
        WebUI.delay(1)

        WebUI.click(findTestObject('Nav Bar/commandAndControl'))

        WebUI.delay(1)

        WebUI.click(findTestObject('Nav Bar/Nav Bar CnC/controlTasks'))
    } 
}

WebUI.waitForElementPresent(findTestObject('Command and Control/Tasks Control/taskControlView'), 15)

WebUI.waitForElementNotPresent(findTestObject('General/loadingBar'), 15)

WebUI.delay(1)

'check if date field exist'
WebUI.waitForElementVisible(findTestObject('Command and Control/Tasks Control/dateField'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Command and Control/Tasks Control/dateField'), 5)

'check if footer exist'
WebUI.waitForElementVisible(findTestObject('Command and Control/Tasks Control/footer'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Command and Control/Tasks Control/footer'), 5)

'check if main table exist'
WebUI.waitForElementVisible(findTestObject('Command and Control/Tasks Control/mainTable'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Command and Control/Tasks Control/mainTable'), 5)

'check if first line exist in table'
WebUI.waitForElementVisible(findTestObject('Command and Control/Tasks Control/tableFirstLine'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Command and Control/Tasks Control/tableFirstLine'), 5)

'check if upper left elemnt has content'
WebUI.waitForElementVisible(findTestObject('Command and Control/Tasks Control/upperLeftFirstLine'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Command and Control/Tasks Control/upperLeftFirstLine'), 5)

'enter a task'
WebUI.doubleClick(findTestObject('Command and Control/Tasks Control/tableFirstLine'))

WebUI.delay(1)

WebUI.waitForElementNotPresent(findTestObject('General/loadingBar'), 15)

'check task tracking view exist'
WebUI.waitForElementVisible(findTestObject('Command and Control/Task Tracking/taskTrackingView'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Command and Control/Task Tracking/taskTrackingView'), 5)

WebUI.waitForElementNotPresent(findTestObject('General/loadingBar'), 15)

