import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.generalCaseExpression_scope as generalCaseExpression_scope
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

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Pre-Salary/driversListDropdownOpen'), 15)

WebUI.waitForElementNotPresent(findTestObject('Pre-Salary/isLoadingDropdown'), 15)

WebUI.delay(1)

WebUI.click(findTestObject('Pre-Salary/driversListDropdownOpen'))

WebUI.delay(1)

try {
    WebUI.setText(findTestObject('Pre-Salary/driversListDropdownSearchBox'), driver_Id)
}
catch (Exception err) {
    WebUI.delay(5)

    WebUI.setText(findTestObject('Pre-Salary/driversListDropdownSearchBox'), driver_Id)
} 

WebUI.delay(1)

WebUI.click(findTestObject('Pre-Salary/driversListDropdownSelectFirstDriver'))

WebUI.delay(1)

WebUI.click(findTestObject('Pre-Salary/importButton'))

WebUI.delay(1)

try {
    WebUI.waitForElementPresent(findTestObject('Pre-Salary/firstDriverInCalculationSummeryTable'), 20)

    WebUI.doubleClick(findTestObject('Pre-Salary/firstDriverInCalculationSummeryTable'))
}
catch (Exception err) {
    WebUI.waitForElementPresent(findTestObject('Pre-Salary/firstDriverInCalculationSummeryTable'), 20)

    WebUI.waitForElementPresent(findTestObject('Pre-Salary/firstDriverInCalculationSummeryTable'), 20)

    WebUI.verifyElementPresent(findTestObject('Pre-Salary/calculationSummeyTable'), 2)

    WebUI.verifyElementPresent(findTestObject('Pre-Salary/firstDriverInCalculationSummeryTable'), 2)

    WebUI.doubleClick(findTestObject('Pre-Salary/firstDriverInCalculationSummeryTable'))
} 

WebUI.waitForElementPresent(findTestObject('Pre-Salary/driversReportTable'), 20)

WebUI.waitForElementPresent(findTestObject('Pre-Salary/driversReportTable'), 20)

WebUI.verifyElementPresent(findTestObject('Pre-Salary/driversReportTable'), 2)

WebUI.verifyElementPresent(findTestObject('Pre-Salary/driversCodeId_InDriversReportTableHeader'), 2)

String driverCodeFromReport = WebUI.getText(findTestObject('Pre-Salary/driversCodeId_InDriversReportTableHeader'))

if (driverCodeFromReport != driver_Id) {
    throw new com.kms.katalon.core.exception.StepFailedException('Report driver\'s id doesn\'t match with with test\'s driver id.')
}

WebUI.closeBrowser()

