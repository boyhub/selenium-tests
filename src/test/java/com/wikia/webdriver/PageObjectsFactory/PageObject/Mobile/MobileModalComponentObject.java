package com.wikia.webdriver.PageObjectsFactory.PageObject.Mobile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.wikia.webdriver.Common.Logging.PageObjectLogging;

public class MobileModalComponentObject extends MobileBasePageObject {

	public MobileModalComponentObject(WebDriver driver) {
		super(driver);
	}

	@FindBy(css=".zoomer.open.imgMdl")
	private WebElement openedModal;
	@FindBy(css="#wkMdlClo")
	private WebElement closeModalButton;
	@FindBy(css="#prvImg")
	private WebElement previousImageButton;
	@FindBy(css="#nxtImg")
	private WebElement nextImageButton;
	@FindBy(css="section.current>img")
	private WebElement currentImage;
	@FindBy(css=".imgMdl.zoomer:not(.hdn)")
	private WebElement topBarVisible;
	@FindBy(css=".imgMdl.zoomer.hdn")
	private WebElement topBarHidden;
	@FindBy(css=".swiperPage.current")
	private WebElement currentImageModal;
	@FindBys(@FindBy(css=".collSec"))
	private List<WebElement> listOfMediaElements;

	String modalTransition = "section[style*='transition']";

	public void closeModal() {
		waitForElementByElement(openedModal);
		waitForElementClickableByElement(closeModalButton);
		closeModalButton.click();
	}

	public void closeModalWithBackButton() {
		driver.navigate().back();
	}

	public void goToPreviousImage() {
		waitForElementByElement(previousImageButton);
		previousImageButton.click();
		waitForElementNotPresent(modalTransition);
	}

	public void goToNextImage() {
		waitForElementByElement(nextImageButton);
		nextImageButton.click();
		waitForElementNotPresent(modalTransition);
	}

	public String getCurrentImageUrl() {
		return currentImage.getAttribute("src");
	}

	public void verifyTopBarVisible() {
		waitForElementByElement(topBarVisible);
	}

	public void verifyTopBarHidden() {
		waitForElementByElement(topBarHidden);
	}

	public void verifyModalClosed() {
		waitForElementNotVisibleByElement(currentImageModal);
		waitForElementByElement(listOfMediaElements.get(0));
		PageObjectLogging.log("verifyModalClosed", "modal was closed", true);
	}

	public void hideTopBar() {
		waitForElementByElement(topBarVisible);
		topBarVisible.click();
	}

	public void showTopBar() {
		waitForElementByElement(topBarHidden);
		topBarHidden.click();
	}

}
