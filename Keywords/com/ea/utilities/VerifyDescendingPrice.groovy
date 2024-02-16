package com.ea.utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import internal.GlobalVariable
import java.util.ArrayList
import java.util.Collections

public class VerifyDescendingPrice {
	@Keyword
	def verifyDescendingPrice() {
		TestObject Price = findTestObject('Object Repository/Search_Results_Page/Price_Text')

		List<WebElement> PriceElements = WebUI.findWebElements(Price, 10)
		println PriceElements

		List<String> PriceTextValues = []
		for (WebElement priceElement in PriceElements) {
			String priceText = priceElement.getText()
			priceText = priceText.replace('$', '').trim()
			def price = Double.parseDouble(priceText)
			PriceTextValues.add(price)
		}
		println PriceTextValues

		for (int i = 0; i < PriceTextValues.size() - 1; i++) {
			def currentPrice = PriceTextValues[i]
			def nextPrice = PriceTextValues[i + 1]
			if (currentPrice > nextPrice) {
				println ("Prices are not in ascending order: ${currentPrice} > ${nextPrice}")
			}
		}
	}
}
