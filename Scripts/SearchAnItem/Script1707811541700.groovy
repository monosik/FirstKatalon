import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement as Keys
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://magento.softwaretestingboard.com/')

WebUI.waitForElementPresent(findTestObject('Page_Home Page/Search_Textbox'), 1)

WebUI.sendKeys(findTestObject('Page_Home Page/Search_Textbox'), 'Jacket')

WebUI.click(findTestObject('Object Repository/Page_Home Page/Search_Button'))

String elements = WebUI.getText(findTestObject('Object Repository/Page_Search results for Jacket/Product_Text'))
println("Jacket item: " + elements)

String fullText = elements
String[] parts = fullText.split(" ")
String actual_result = parts[parts.length - 1]
println("Extracted text: " + actual_result)
String expected_result = "Jacket"

WebUI.verifyMatch(actual_result, expected_result, false)
