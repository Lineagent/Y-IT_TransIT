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

'log in with code and id'
WebUI.openBrowser(site)

WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('Kiosk/Login/Code Plus Id/driverCodeInput'), 15)

WebUI.waitForElementVisible(findTestObject('Kiosk/Login/Code Plus Id/driverIdInput'), 15)

WebUI.waitForElementVisible(findTestObject('Kiosk/Login/Code Plus Id/enterButton'), 15)

WebUI.delay(1)

WebUI.setText(findTestObject('Kiosk/Login/Code Plus Id/driverCodeInput'), driverCode)

WebUI.setText(findTestObject('Kiosk/Login/Code Plus Id/driverIdInput'), driverId)

WebUI.delay(1)

WebUI.click(findTestObject('Kiosk/Login/Code Plus Id/enterButton'))

'check if header exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Lobby/header'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Kiosk/Lobby/header'), 5)

'check if work ticket button exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Lobby/workTicketButton'), 15)

WebUI.verifyElementClickable(findTestObject('Kiosk/Lobby/workTicketButton'), FailureHandling.STOP_ON_FAILURE)

'navigate to work ticket'
WebUI.delay(1)

WebUI.click(findTestObject('Kiosk/Lobby/workTicketButton'))

'check if status dropdown exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Work Ticket/statusDropdown'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Kiosk/Work Ticket/statusDropdown'), 5)

'check if dates table exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Work Ticket/datesTableFirstRow'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Kiosk/Work Ticket/datesTableFirstRow'), 5)

'check if main table exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Work Ticket/mainTableFirstRow'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Kiosk/Work Ticket/mainTableFirstRow'), 5)

'check if back button exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Work Ticket/back button'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Kiosk/Work Ticket/back button'), 5)

'navigate to lobby'
WebUI.delay(1)

WebUI.click(findTestObject('Kiosk/Work Ticket/back button'))

'check if header exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Lobby/header'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Kiosk/Lobby/header'), 5)

'check if work ticket button exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Lobby/workTicketButton'), 15)

WebUI.verifyElementClickable(findTestObject('Kiosk/Lobby/workTicketButton'), FailureHandling.STOP_ON_FAILURE)

'check if logout button exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Lobby/logoutButton'), 15)

WebUI.verifyElementClickable(findTestObject('Kiosk/Lobby/logoutButton'), FailureHandling.STOP_ON_FAILURE)

'logout'
WebUI.click(findTestObject('Kiosk/Lobby/logoutButton'))

WebUI.waitForElementVisible(findTestObject('Kiosk/Login/Code Plus Id/enterButton'), 15)

WebUI.closeBrowser()

