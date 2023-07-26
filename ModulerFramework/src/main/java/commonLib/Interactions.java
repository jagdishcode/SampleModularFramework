package commonLib;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Interactions {

	public String getText(WebElement element) {

		return element.getText();

	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public String getAttribute(WebElement element, String attribute) {

		return element.getAttribute(attribute);

	}

	public String getCssValue(WebElement element, String cssPropertyName) {

		return element.getCssValue(cssPropertyName);

	}

	public boolean isElemenetEnabled(WebElement element) {
		return element.isEnabled();
	}

	public boolean isElemenetSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isElemenetVisible(WebElement element) {
		return element.isDisplayed();
	}

	public void setText(WebElement element, String valueOfText) {
		element.sendKeys(valueOfText);
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public void changeCheckBoxStatus(WebElement element, boolean expectedStatus) {
		boolean currentStatus = element.isSelected();
		if (currentStatus != expectedStatus) {
			element.click();
		}
	}

	private Select getSelect(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	public void setVisibleText(WebElement element, String textToBeSelected) {
		Select selEle = getSelect(element);
		selEle.selectByVisibleText(textToBeSelected);

	}

	public void selectViaValue(WebElement element, String value) {
		getSelect(element).selectByValue(value);
	}
	
	public void selectViaIndex(WebElement element, int indexNum) {
		getSelect(element).selectByIndex(indexNum);
	}
	
	public List<WebElement> getAllOptions(WebElement element){
		return getSelect(element).getOptions();
	}
	
	public List<WebElement> getSelectedOption(WebElement element){
		return getSelect(element).getAllSelectedOptions();
	}
	

	public WebElement getFirstSelectedOption(WebElement element){
		return getSelect(element).getFirstSelectedOption();
	}
}
