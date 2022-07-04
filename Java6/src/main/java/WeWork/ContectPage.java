package WeWork;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 12-21
 **/
public class ContectPage extends BasePage{
    /*findBy注解不建议使用，比如有个控件第一次找到的时候，他的位置稍后会发生变化的。要定位这样变化位置的控件，需要多次定位，
    判断连续两次定位到的 控件位置是不再发生变化，如何解决呢那就使用自己灵活定义的find方法，而不是使用最直接的Findby注解*/
    private final By addMember = By.id("ekp");
    private final By menu = By.xpath("//*[@text='手动输入添加']");
    private final By nameInput = By.id("ber");
    private final By phoneInput = By.id("gcr");
    private final By saveButton = By.xpath("//*[@text='保存']");
    private final By closeButton = By.id("ix5");
    private By memu;

    public ContectPage(AppiumDriver driver) {
        super(driver);
    }

    public ContectPage add(String name , String phone){
        //必须及时findElement，不能缓存,或者用以前的，窗口变化后，控件就会发生变化所以就无法复用
        memu= MobileBy.id("ixb");
        driver.findElements(memu).click();

        driver.findElements(addMember).click();

        driver.findElements(menu).click();
        driver.findElements(nameInput).sendKeys(name);
        driver.findElements(phoneInput).sendKeys(phone);
        driver.findElements(saveButton).click();
        driver.findElements(closeButton).click();
        return this;
    }
    public Member find(String keyword){
        return new Member("1","1");
    }

    public DefaultPage back() {
        return  new DefaultPage(driver);
    }
}
