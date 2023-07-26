package com.js.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLib.Interactions;

public class AmzHomePage {

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;

	@CacheLookup
	@FindBy(id = "searchDropdownBox")
	private WebElement searchCategory;

	@CacheLookup
	@FindBy(xpath = "//input[@value='Go']")
	private WebElement searchButton;

	@CacheLookup
	@FindBy(xpath = "//span[contains(text(), 'results for')]")
	private WebElement searchResult;

	private Interactions interactions;

	public AmzHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		interactions = new Interactions();
	}
	
	public void searchProduct(String product, String category) throws Exception {
		interactions.setText(searchBox, product);
		interactions.setVisibleText(searchCategory, category);
		interactions.clickElement(searchButton);
		System.out.println(interactions.getText(searchResult));
	}

}
