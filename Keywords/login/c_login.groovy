package login

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class c_login {

	private String site = 'https://aws_test.y-it.co.il/#/login'
	private String userName = 'admin'
	private String userPass = '9wwwy+yAouiJKpUPQ8CK+g=='

	@Keyword
	def logIn(String site, String userName, String userPass) {

		if (site) {
			this.site = site
		}
		if (userName) {
			this.userName = userName
		}
		if (userPass) {
			this.userPass = userPass
		}

		WebUI.openBrowser(this.site)

		WebUI.maximizeWindow()

		WebUI.setText(findTestObject('Y-IT Log In/input_ _userName'), this.userName)
		
		try {
			WebUI.setEncryptedText(findTestObject('Y-IT Log In/input_ _password'), this.userPass)
		} catch (err) {
			WebUI.setText(findTestObject('Y-IT Log In/input_ _password'), this.userPass)
		}
		

		WebUI.click(findTestObject('Y-IT Log In/input_  _submit'))
	}
}
