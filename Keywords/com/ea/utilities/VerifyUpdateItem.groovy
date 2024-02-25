package com.ea.utilities

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys


public class VerifyUpdateItem {
	@Keyword
	def verifyUpdateQuantityItem(String ItemQuantity) {
		WebUI.sendKeys(findTestObject('Object Repository/Bucket_List_Popup/Quantity_Textbox'),Keys.chord(Keys.CONTROL, '1'));
		WebUI.sendKeys(findTestObject('Object Repository/Bucket_List_Popup/Quantity_Textbox'), Keys.chord(Keys.BACK_SPACE))

		WebUI.sendKeys(findTestObject('Object Repository/Bucket_List_Popup/Quantity_Textbox'), ItemQuantity)

		WebUI.click(findTestObject('Object Repository/Bucket_List_Popup/Update_Button'))

		String ActualQuantity = WebUI.getText(findTestObject('Object Repository/Bucket_List_Popup/Quantity_Number_Text'))

		println (ActualQuantity)

		WebUI.verifyEqual(ActualQuantity, ItemQuantity)

		String StringTotalPrice = WebUI.getText(findTestObject('Object Repository/Bucket_List_Popup/Subtotal_Price_Text'))
		StringTotalPrice = StringTotalPrice.replace('$', '').trim()
		double ActualTotalPrice = Double.parseDouble(StringTotalPrice)

		String StringItemlPrice = WebUI.getText(findTestObject('Object Repository/Search_Results_Page/Price_Text'))

		StringItemlPrice = StringItemlPrice.replace('$', '').trim()

		double ActualItemPrice = Double.parseDouble(StringItemlPrice)

		println (ActualItemPrice + " " + ActualTotalPrice )

		double ExpectedTotalPrice = ActualItemPrice * Double.parseDouble(ItemQuantity)

		WebUI.verifyEqual(ActualTotalPrice, ExpectedTotalPrice)
	}
}
