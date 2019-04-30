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
import java.util.Date as Date
import java.util.Locale as Locale
import java.util.Calendar as Calendar
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter

CustomKeywords.'login.c_login.logIn'(site, userName, userPass)

Date date = new Date()

Calendar cal = Calendar.getInstance()

cal.setTime(date)

int month = cal.get(Calendar.MONTH) + 1

int year = cal.get(Calendar.YEAR)

String dayStr = '01'

String monthStr = ''

String yearStr = year.toString()

if (month < 10) {
    monthStr = ('0' + month.toString())
} else {
    monthStr = month.toString()
}

String fullDate = (dayStr + monthStr) + yearStr

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('General/mainEmptyBackground'), 15)

boolean isPreSalaryTabOpen = WebUI.waitForElementPresent(findTestObject('Pre-Salary/preSalaryTab'), 5)

if (!(isPreSalaryTabOpen)) {
    WebUI.waitForElementPresent(findTestObject('Nav Bar/funds'), 15)

    WebUI.click(findTestObject('Nav Bar/funds'))

    WebUI.delay(1)

    try {
        WebUI.waitForElementPresent(findTestObject('Nav Bar/Nav Bar Funds/preSalary'), 2)

        WebUI.click(findTestObject('Nav Bar/Nav Bar Funds/preSalary'))
    }
    catch (Exception e) {
        WebUI.click(findTestObject('Nav Bar/funds'))

        WebUI.delay(1)

        WebUI.waitForElementPresent(findTestObject('Nav Bar/Nav Bar Funds/preSalary'), 2)

        WebUI.click(findTestObject('Nav Bar/Nav Bar Funds/preSalary'))
    } 
}

WebUI.waitForElementNotPresent(findTestObject('General/loadingBar'), 30)

WebUI.waitForElementNotPresent(findTestObject('Pre-Salary/Filters/Drivers Dropdown/isLoadingDropdown'), 15)

WebUI.waitForElementPresent(findTestObject('Pre-Salary/Filters/Date Picker Start/datePickerInputField'), 15)

WebUI.delay(5)

WebUI.click(findTestObject('Pre-Salary/Filters/Date Picker Start/datePickerInputField'))

WebUI.delay(1)

WebUI.setText(findTestObject('Pre-Salary/Filters/Date Picker Start/datePickerInputField'), '')

WebUI.delay(1)

WebUI.setText(findTestObject('Pre-Salary/Filters/Date Picker Start/datePickerInputField'), fullDate)

WebUI.waitForElementPresent(findTestObject('Pre-Salary/Filters/Date Picker Start/datePickerInputField'), 15)

WebUI.waitForElementNotPresent(findTestObject('Pre-Salary/Filters/Drivers Dropdown/isLoadingDropdown'), 15)

WebUI.delay(1)

try {
    WebUI.click(findTestObject('Pre-Salary/Filters/Drivers Dropdown/driversListDropdownOpen'))
}
catch (Exception err) {
    WebUI.delay(5)

    WebUI.waitForElementPresent(findTestObject('Pre-Salary/Filters/Drivers Dropdown/driversListDropdownOpen'), 10)

    WebUI.click(findTestObject('Pre-Salary/Filters/Drivers Dropdown/driversListDropdownOpen'))
} 

WebUI.delay(1)

try {
    WebUI.setText(findTestObject('Pre-Salary/Filters/Drivers Dropdown/driversListDropdownSearchBox'), driver_Id)
}
catch (Exception err) {
    WebUI.delay(5)

    WebUI.setText(findTestObject('Pre-Salary/Filters/Drivers Dropdown/driversListDropdownSearchBox'), driver_Id)
} 

WebUI.delay(1)

WebUI.click(findTestObject('Pre-Salary/Filters/Drivers Dropdown/driversListDropdownSelectFirstDriver'))

WebUI.delay(1)

WebUI.click(findTestObject('Pre-Salary/Data Status/importButton'))

WebUI.delay(1)

try {
    WebUI.waitForElementPresent(findTestObject('Pre-Salary/Calculation Summary/firstDriverInCalculationSummeryTable'), 20)

    WebUI.doubleClick(findTestObject('Pre-Salary/Calculation Summary/firstDriverInCalculationSummeryTable'))
}
catch (Exception err) {
    WebUI.waitForElementPresent(findTestObject('Pre-Salary/Calculation Summary/firstDriverInCalculationSummeryTable'), 20)

    WebUI.waitForElementPresent(findTestObject('Pre-Salary/Calculation Summary/firstDriverInCalculationSummeryTable'), 20)

    WebUI.verifyElementPresent(findTestObject('Pre-Salary/Calculation Summary/calculationSummeyTable'), 2)

    WebUI.verifyElementPresent(findTestObject('Pre-Salary/Calculation Summary/firstDriverInCalculationSummeryTable'), 2)

    WebUI.doubleClick(findTestObject('Pre-Salary/Calculation Summary/firstDriverInCalculationSummeryTable'))
} 

WebUI.waitForElementPresent(findTestObject('Pre-Salary/Employee Details/driversReportTable'), 20)

WebUI.waitForElementPresent(findTestObject('Pre-Salary/Employee Details/driversReportTable'), 20)

WebUI.verifyElementPresent(findTestObject('Pre-Salary/Employee Details/driversReportTable'), 2)

WebUI.verifyElementPresent(findTestObject('Pre-Salary/Employee Details/driversCodeId_InDriversReportTableHeader'), 2)

String driverCodeFromReport = WebUI.getText(findTestObject('Pre-Salary/Employee Details/driversCodeId_InDriversReportTableHeader'))

if ((driverCodeFromReport != driver_Id) && !(driverCodeFromReport.contains(driver_Id))) {
    throw new com.kms.katalon.core.exception.StepFailedException('Report driver\'s id doesn\'t match with with test\'s driver id.')
}

WebUI.waitForElementPresent(findTestObject('Pre-Salary/Employee Details/rightSideTable'), 10)

WebUI.verifyElementPresent(findTestObject('Pre-Salary/Employee Details/rightSideTable'), 2)

WebUI.waitForElementPresent(findTestObject('Pre-Salary/Employee Details/rightSideTableDriversId'), 10)

WebUI.verifyElementPresent(findTestObject('Pre-Salary/Employee Details/rightSideTableDriversId'), 2)

String driversCodeFromRightSideTable = WebUI.getText(findTestObject('Pre-Salary/Employee Details/rightSideTableDriversId'))

if (!(driversCodeFromRightSideTable.contains(driver_Id))) {
    throw new com.kms.katalon.core.exception.StepFailedException('Right side table driver\'s id doesn\'t match with with test\'s driver id.')
}

WebUI.closeBrowser()

