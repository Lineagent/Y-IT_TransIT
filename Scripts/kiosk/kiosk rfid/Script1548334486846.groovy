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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent

WebUI.delay(10)

'log in with rfid'
WebUI.openBrowser(rfidSite)



'check if rfid landingpage is ready'
WebUI.waitForElementVisible(findTestObject('Kiosk/Login/Rfid/cardImage'), 30)

WebUI.focus(findTestObject('Kiosk/Login/Rfid/cardImage'))

f_logInwithRfid()

try {
    'check if header exist'
    WebUI.waitForElementVisible(findTestObject('Kiosk/Lobby/header'), 15)

    WebUI.verifyElementVisibleInViewport(findTestObject('Kiosk/Lobby/header'), 5)
}
catch (def e) {
    WebUI.refresh()

    'check if rfid landingpage is ready'
    WebUI.waitForElementVisible(findTestObject('Kiosk/Login/Rfid/cardImage'), 30)

    f_logInwithRfid()
} 

WebUI.maximizeWindow()

'check if work ticket button exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Lobby/workTicketButton'), 15)

WebUI.verifyElementClickable(findTestObject('Kiosk/Lobby/workTicketButton'), FailureHandling.STOP_ON_FAILURE)

'check if logout button exist'
WebUI.waitForElementVisible(findTestObject('Kiosk/Lobby/logoutButton'), 15)

WebUI.verifyElementClickable(findTestObject('Kiosk/Lobby/logoutButton'), FailureHandling.STOP_ON_FAILURE)

'logout'
WebUI.click(findTestObject('Kiosk/Lobby/logoutButton'))

'check if rfid landingpage is ready'
WebUI.waitForElementVisible(findTestObject('Kiosk/Login/Rfid/cardImage'), 30)

WebUI.closeBrowser()

def f_logInwithRfid() {
    Robot robot = new Robot()

    char[] rfidCodeArray = rfidCode.toString().toCharArray()

    WebUI.delay(5)

    for (int i = 0; i < rfidCodeArray.length; i++) {
        WebUI.delay(1)

        int n = Integer.parseInt(rfidCodeArray[i].toString())

        switch (n) {
            case 1:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_1)

                break
            case 2:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_2)

                break
            case 3:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_3)

                break
            case 4:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_4)

                break
            case 5:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_5)

                break
            case 6:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_6)

                break
            case 7:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_7)

                break
            case 8:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_8)

                break
            case 9:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_9)

                break
            case 0:
				WebUI.delay(1)
                robot.keyPress(KeyEvent.VK_0)

                break
        }
    }
    
    WebUI.delay(1)

    robot.keyPress(KeyEvent.VK_ENTER)
	
	WebUI.delay(1)
	
	robot.keyPress(KeyEvent.VK_ENTER)
	
	WebUI.delay(1)
	
	robot.keyPress(KeyEvent.VK_ENTER)
	
	WebUI.delay(1)
	
	robot.keyPress(KeyEvent.VK_ENTER)
	
	WebUI.delay(1)
	
	robot.keyPress(KeyEvent.VK_ENTER)
	
	WebUI.delay(1)
}

