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

int randomNumberInt = Math.floor(Math.random() * ((99 - 1) + 1)) + 1

String randomNumber = randomNumberInt.toString()

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

f_wait()

bottomDetailsTabs()

WebUI.clearText(findTestObject('Tickets/Repair Order Ticket/Details/innerRemarks'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.setText(findTestObject('Tickets/Repair Order Ticket/Details/innerRemarks'), randomNumber)

WebUI.delay(1)

WebUI.click(findTestObject('Tickets/Repair Order Ticket/detailsSave'))

WebUI.delay(1)

f_wait()

bottomDetailsTabs()

WebUI.click(findTestObject('Tickets/Repair Order Ticket/Nav Bar/itemsDetailsHref'))

f_wait()

WebUI.waitForElementPresent(findTestObject('Tickets/Repair Order Ticket/Item Details/itemDetailsTable'), 5)

WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Item Details/itemDetailsTable'), 5)

WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Item Details/itemDetailsTable'), 5)

bottomItemDetailsTabs()

WebUI.click(findTestObject('Tickets/Repair Order Ticket/Nav Bar/detailsHref'), FailureHandling.STOP_ON_FAILURE)

f_wait()

WebUI.delay(1)

WebUI.clearText(findTestObject('Tickets/Repair Order Ticket/Details/innerRemarks'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

int randomNumberInt2 = Math.floor(Math.random() * ((99 - 1) + 1)) + 1

String randomNumber2 = randomNumberInt2.toString()

WebUI.setText(findTestObject('Tickets/Repair Order Ticket/Details/innerRemarks'), randomNumber2)

WebUI.delay(1)

WebUI.click(findTestObject('Tickets/Repair Order Ticket/Nav Bar/itemsDetailsHref'), FailureHandling.STOP_ON_FAILURE)

f_wait()

WebUI.click(findTestObject('Tickets/Repair Order Ticket/detailsItemsSave'))

WebUI.delay(1)

f_wait()

bottomItemDetailsTabs()

WebUI.click(findTestObject('Tickets/Repair Order Ticket/Nav Bar/detailsHref'))

wait()

bottomDetailsTabs()

WebUI.click(findTestObject('Tickets/Repair Order Ticket/detailsClose'))

def f_wait() {
    WebUI.waitForElementNotPresent(findTestObject('General/loadingBar'), 5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.waitForElementNotPresent(findTestObject('General/dropdownListSpinner'), 5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementNotPresent(findTestObject('General/dropdownListSpinner'), 1)
}

def bottomDetailsTabs() {
    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/carDetailsFirstField'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/carDetailsFirstField'), 
        5)

    WebUI.click(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/maintenanceAgreementsHref'))

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/maintenanceAgreementsTable'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/maintenanceAgreementsTable'), 
        5)

    WebUI.click(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/driverDetailsHref'))

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/driverDetailsFirstField'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/driverDetailsFirstField'), 
        5)

    WebUI.click(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/providerDetailsHref'))

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/providerDetailsFirstField'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/providerDetailsFirstField'), 
        5)

    WebUI.click(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/carDetailsHref'))

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/carDetailsFirstField'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Details/carDetailsFirstField'), 
        5)
}

def bottomItemDetailsTabs() {
    WebUI.delay(1)

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/carDetailsFirstField'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/carDetailsFirstField'), 
        5)

    WebUI.click(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/maintenanceAgreementsHref'))

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/maintenanceAgreementsTable'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/maintenanceAgreementsTable'), 
        5)

    WebUI.click(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/driverDetailsHref'))

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/driverDetailsFirstField'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/driverDetailsFirstField'), 
        5)

    WebUI.click(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/providerDetailsHref'))

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/providerDetailsFirstField'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/providerDetailsFirstField'), 
        5)

    WebUI.click(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/carDetailsHref'))

    WebUI.waitForElementVisible(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/carDetailsFirstField'), 
        5, FailureHandling.CONTINUE_ON_FAILURE)

    WebUI.verifyElementVisibleInViewport(findTestObject('Tickets/Repair Order Ticket/Bottom Tabs/Item Details/carDetailsFirstField'), 
        5)
}

