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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

CustomKeywords.'login.c_login.logIn'(site, userName, userPass)

'login'
WebUI.delay(1)

'enter drivers ticket confiramtion view'
WebUI.waitForElementPresent(findTestObject('General/mainEmptyBackground'), 15)

boolean isWorkingTicketOpen = WebUI.waitForElementPresent(findTestObject('Nav Bar/Nav Bar Funds/workingTicketConfirmation'), 
    5)

if (!(isWorkingTicketOpen)) {
    WebUI.waitForElementPresent(findTestObject('Nav Bar/funds'), 15)

    WebUI.click(findTestObject('Nav Bar/funds'))

    WebUI.delay(1)

    try {
        WebUI.waitForElementPresent(findTestObject('Nav Bar/Nav Bar Funds/workingTicketConfirmation'), 2)

        WebUI.click(findTestObject('Nav Bar/Nav Bar Funds/workingTicketConfirmation'))
    }
    catch (Exception e) {
        WebUI.click(findTestObject('Nav Bar/funds'))

        WebUI.delay(1)

        WebUI.waitForElementPresent(findTestObject('Nav Bar/Nav Bar Funds/workingTicketConfirmation'), 2)

        WebUI.click(findTestObject('Nav Bar/Nav Bar Funds/workingTicketConfirmation'))
    } 
}

WebUI.delay(1)

'wait for loading'
WebUI.waitForElementVisible(findTestObject('Driver Ticket Confirmation/driverTciketView'), 15)

WebUI.waitForElementNotPresent(findTestObject('General/loadingBar'), 15)

WebUI.verifyElementVisibleInViewport(findTestObject('Driver Ticket Confirmation/driverTciketView'), 5)

WebUI.waitForElementNotPresent(findTestObject('General/dropdownListSpinner'), 15)

WebUI.verifyElementNotPresent(findTestObject('General/dropdownListSpinner'), 5)

WebUI.waitForElementNotPresent(findTestObject('General/gridLoadingBar'), 15)

WebUI.verifyElementNotPresent(findTestObject('General/gridLoadingBar'), 5)

'check if tables exist'
WebUI.waitForElementPresent(findTestObject('Driver Ticket Confirmation/driversTable'), 15)

WebUI.verifyElementPresent(findTestObject('Driver Ticket Confirmation/driversTable'), 5)

WebUI.waitForElementPresent(findTestObject('Driver Ticket Confirmation/datesTable'), 15)

WebUI.verifyElementPresent(findTestObject('Driver Ticket Confirmation/datesTable'), 5)

WebUI.waitForElementPresent(findTestObject('Driver Ticket Confirmation/specificDateTable'), 15)

WebUI.verifyElementPresent(findTestObject('Driver Ticket Confirmation/specificDateTable'), 5)

int i = 0

int j = 0

int ij = 0

int validCount = 0

int validCountMax = 3

TestObject driversTableRow = new TestObject('Empty')

TestObject datesTableRow = new TestObject('Empty')

TestObject specificDateTableRow = new TestObject('Empty')

while ((validCount < validCountMax) && (i < 20)) {
    j = 0

    driversTableRow = new TestObject('driversTableRow' + i)

    driversTableRow.addProperty('xpath', ConditionType.EQUALS, f_driver(i))

    WebUI.delay(1)

    WebUI.scrollToElement(driversTableRow, 1)

    WebUI.click(driversTableRow)

    while ((validCount < validCountMax) && (j < 20)) {
        ij = 0

        datesTableRow = new TestObject('datesTableRow' + j)

        datesTableRow.addProperty('xpath', ConditionType.EQUALS, f_dates(j))

        WebUI.delay(1)

        try {
            WebUI.scrollToElement(datesTableRow, 1)

            WebUI.click(datesTableRow)

            while ((validCount < validCountMax) && (ij < 3)) {
                specificDateTableRow = new TestObject('specificDateRow' + ij)

                specificDateTableRow.addProperty('xpath', ConditionType.EQUALS, f_specidicDate(ij))

                try {
                    boolean elemPresent = WebUI.waitForElementVisible(specificDateTableRow, 1)

                    if (elemPresent) {
                        WebUI.verifyElementVisibleInViewport(specificDateTableRow, 1)

                        ij++

                        if (ij == 3) {
                            validCount++

                            break
                        }
                    } else {
                        break
                    }
                }
                catch (def e) {
                    break
                } 
            }
        }
        catch (def e) {
            break
        } 
        finally { 
            if (ij == 3) {
                break
            }
            
            j++
        }
    }
    
    i++
}

if (validCount < 3) {
    throw new com.kms.katalon.core.exception.StepFailedException('Data in one of the tables might be misssing.')
}

WebUI.click(findTestObject('Driver Ticket Confirmation/driversTcicketConfirmation_Close'))

WebUI.closeBrowser()

String f_driver(int rowNum) {
    return ('.//*[@id=\'managementKioskview\']//div[2]//div[1]//div[2]//div[1]//div[2]//div[1]//table//tr[' + (rowNum + 
    1)) + ']'
}

String f_dates(int rowNum) {
    return ('.//*[@id=\'managementKioskview\']//div[2]//div[1]//div[4]//div[1]//div[2]//table//tr[' + (rowNum + 1)) + ']'
}

String f_specidicDate(int rowNum) {
    return ('.//*[@id=\'managementKioskview\']/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]//table//tr[' + (rowNum + 
    1)) + ']'
}

