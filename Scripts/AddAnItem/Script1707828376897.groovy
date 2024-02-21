import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://magento.softwaretestingboard.com/')

WebUI.maximizeWindow()

CustomKeywords.'com.ea.utilities.SearchItem.searchItem'('Jacket')

WebUI.click(findTestObject('Object Repository/Search_Results_Page/Adrienne_Trek_Jacket_Item'))

String actualItemResult = WebUI.getText(findTestObject('Object Repository/Detail_Item_Page/Product_Title_Text'))
String actualPriceResult = WebUI.getText(findTestObject('Object Repository/Detail_Item_Page/Price_Text'))
String expectedItemResult = "Adrienne Trek Jacket"
WebUI.verifyMatch(actualItemResult, expectedItemResult, false)

String actualStatusResult = WebUI.getText(findTestObject('Object Repository/Detail_Item_Page/Stock_Status_Text'))
List expectedStatusResult = ["IN STOCK", "OUT OF STOCK"]
if (WebUI.verifyMatch(actualStatusResult, expectedStatusResult[0], false)) {
    
    WebUI.verifyElementClickable(findTestObject('Object Repository/Detail_Item_Page/Add_To_Cart_Button'))
} else {
    
    WebUI.verifyElementNotClickable(findTestObject('Object Repository/Detail_Item_Page/Add_To_Cart_Button'))
}

WebUI.click(findTestObject('Object Repository/Detail_Item_Page/XS_Size_Option'))
String ExpectedChoiceSize = WebUI.getText(findTestObject('Object Repository/Detail_Item_Page/XS_Size_Option'))
String ActualChoiceSize = WebUI.getText(findTestObject('Object Repository/Detail_Item_Page/Size_Result_Text'))
WebUI.verifyEqual(ActualChoiceSize, ExpectedChoiceSize)

println (ExpectedChoiceSize + " " + ActualChoiceSize)

//WebUI.scrollToElement(findTestObject('Object Repository/Detail_Item_Page/Color_Result_Text'), 3)
WebUI.click(findTestObject('Object Repository/Detail_Item_Page/Orange_Color_Option'))
String ExpectedChoiceColor = WebUI.getText(findTestObject('Object Repository/Detail_Item_Page/Orange_Color_Option'))
String ActualChoiceColor = WebUI.getText(findTestObject('Object Repository/Detail_Item_Page/Color_Result_Text'))
//WebUI.verifyEqual(ActualColor, ExpectedColor)

println (ExpectedChoiceColor + " " + ActualChoiceColor)

WebUI.click(findTestObject('Object Repository/Detail_Item_Page/Add_To_Cart_Button'))

WebUI.scrollToElement(findTestObject('Object Repository/Home_Page/Cart_Icon'), 3)

WebUI.waitForElementPresent(findTestObject('Object Repository/Detail_Item_Page/Add_Success_Text'), 5)

WebUI.click(findTestObject('Object Repository/Home_Page/Cart_Icon'))\

WebUI.click(findTestObject('Object Repository/Bucket_List_Popup/See_Detail_Text'))

String actualItem = WebUI.getText(findTestObject('Object Repository/Bucket_List_Popup/Item_Text'))
String actualPrice = WebUI.getText(findTestObject('Object Repository/Bucket_List_Popup/Price_Text'))
String actualSize = WebUI.getText(findTestObject('Object Repository/Bucket_List_Popup/Size_Text'))
String actualColor = WebUI.getText(findTestObject('Object Repository/Bucket_List_Popup/Color_Text'))

println (actualColor + " " + actualItem + " " + actualPrice + " " + actualSize)

WebUI.verifyEqual(actualItem, actualItemResult)
WebUI.verifyEqual(actualPrice, actualPriceResult)
WebUI.verifyEqual(actualSize, ActualChoiceSize)
WebUI.verifyEqual(actualColor, ActualChoiceColor)

WebUI.closeBrowser()