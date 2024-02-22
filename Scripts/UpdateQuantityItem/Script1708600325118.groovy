import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys
import com.google.common.collect.FilteredEntryMultimap.Keys
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('AddAnItemKeyword'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.clearText(findTestObject('Object Repository/Bucket_List_Popup/Quantity_Textbox'))
//WebUI.sendKeys(findTestObject('Object Repository/Bucket_List_Popup/Quantity_Textbox'), Keys.chord(Keys.BACK_SPACE))
//WebUI.sendKeys(findTestObject('Object Repository/Bucket_List_Popup/Quantity_Textbox'), '2')

String CountItem = WebUI.getText(findTestObject('Object Repository/Bucket_List_Popup/Quantity_Textbox'))

println (CountItem)