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

import internal.GlobalVariable

public class SelectSortBy {
	@Keyword
	def selectSortBy(String value) {

		WebUI.waitForElementPresent(findTestObject('Object Repository/label_Sort By'), 5)

		WebUI.click(findTestObject('Object Repository/Search_Results_Page/Sort_Select'))
		if (value == 'Price') {
			WebUI.click(findTestObject('Object Repository/Search_Results_Page/Price_Option'))
		} else if (value == 'Name') {
			WebUI.click(findTestObject('Object Repository/Search_Results_Page/Name_Option'))
		} else if (value == 'Relevance') {
			WebUI.click(findTestObject('Object Repository/Search_Results_Page/Relevance_Option'))
		}
	}
}
