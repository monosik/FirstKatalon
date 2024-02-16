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

public class VerifyItemSearch {
	@Keyword
	def verifyItemSearch(String expectedResult){

		TestObject Item = findTestObject('Object Repository/Search_Results_Page/Product_Text')

		List<WebElement> ItemElements = WebUI.findWebElements(Item, 10)
		println ItemElements

		List<String> ItemTextValues = []
		for (WebElement itemElement in ItemElements) {
			String itemText = itemElement.getText().trim()
			String[] itemWords = itemText.split(" ") // Split by comma
			String actualText = itemWords[itemWords.size() - 1].trim() // Trim any extra spaces
			ItemTextValues.add(actualText)
		}
		println ItemTextValues

		for (String actualResult in ItemTextValues) {
			WebUI.verifyMatch(actualResult, expectedResult, false)
		}
	}
}
