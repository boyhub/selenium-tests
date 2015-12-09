package com.wikia.webdriver.testcases.widgettests;

import com.wikia.webdriver.common.contentpatterns.MercuryMessages;
import com.wikia.webdriver.common.core.Assertion;
import com.wikia.webdriver.common.core.annotations.Execute;
import com.wikia.webdriver.common.templates.NewTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.pageobject.widget.SoundCloudWidgetPageObject;

import org.testng.annotations.Test;

@Test(groups = {"SoundCloudWidgetTests", "WidgetTests"})
public class SoundCloudTests extends NewTestTemplate {

  private static String SOUND_CLOUD_ONE_WIDGET_ARTICLE_NAME = "SoundCloudOasis/OneWidget";
  private static String SOUND_CLOUD_MULTIPLE_WIDGETS_ARTICLE_NAME = "SoundCloudOasis/MultipleWidgets";

  @Test(groups = "SoundCloudWidgetTest_001")
  @Execute(onWikia = "mercuryautomationtesting")
  public void SoundCloudWidgetTest_001_isLoaded() {
    SoundCloudWidgetPageObject widget = new SoundCloudWidgetPageObject(driver);

    widget
      .create(SOUND_CLOUD_ONE_WIDGET_ARTICLE_NAME)
      .openArticleOnWikiByNameWithCbAndNoAds(wikiURL, SOUND_CLOUD_ONE_WIDGET_ARTICLE_NAME);
    Assertion.assertTrue(widget.isLoaded(), MercuryMessages.INVISIBLE_MSG);
  }

  @Test(groups = "SoundCloudWidgetTest_002")
  @Execute(onWikia = "mercuryautomationtesting")
  public void SoundCloudWidgetTest_002_areLoaded() {
    SoundCloudWidgetPageObject widget = new SoundCloudWidgetPageObject(driver);

    widget
      .createMultiple(SOUND_CLOUD_MULTIPLE_WIDGETS_ARTICLE_NAME)
      .openArticleOnWikiByNameWithCbAndNoAds(wikiURL, SOUND_CLOUD_MULTIPLE_WIDGETS_ARTICLE_NAME);

    Assertion.assertTrue(widget.areLoaded(), MercuryMessages.INVISIBLE_MSG);
  }
}
