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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://magento.softwaretestingboard.com/')

CustomKeywords.'com.ea.utilities.SearchItem.searchItem'('Jacket')

WebUI.click(findTestObject('Object Repository/Search_Results_Page/Adrienne_Trek_Jacket_Item'))

String actualItemResult = WebUI.getText(findTestObject('Object Repository/Detail_Item_Page/Product_Title_Text'))
String expectedItemResult = "Adrienne Trek Jacket"
WebUI.verifyMatch(actualItemResult, expectedItemResult, false)

String actualStatusResult = WebUI.getText(findTestObject('Object Repository/Detail_Item_Page/Stock_Status_Text'))
List expectedStatusResult = ["IN STOCK", "OUT OF STOCK"]
if (WebUI.verifyMatch(actualStatusResult, expectedStatusResult[0], false)) {
    // Status is "IN STOCK"
    WebUI.verifyElementClickable(findTestObject('Object Repository/Detail_Item_Page/Add_To_Cart_Button'))
} else {
    // Status is "OUT OF STOCK"
    WebUI.verifyElementNotClickable(findTestObject('Object Repository/Detail_Item_Page/Add_To_Cart_Button'))
}

WebUI.closeBrowser()