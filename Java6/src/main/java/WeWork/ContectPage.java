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
    By searchButton= By.id("com.tencent.wework:id/ixy");
    By editText = By.xpath("//android.wiget.EditText");
    By searchResultList = By.id("com.tencent.wework:id/e4x");
    By infoButton = By.id("com.tencent.wework:id/ix5");
    By iconButton = By.id("com.tencent.wework:id/i1v");
    By nameButton = By.id(" ic4");
    By departText = By.id("bq_");

    public ContectPage(AppiumDriver driver) {
        super(driver);
    }

    public ContectPage add(String name , String phone){
        //必须及时findElement，不能缓存,或者用以前的，窗口变化后，控件就会发生变化所以就无法复用
        memu= MobileBy.id("ixb");
        //driver.findElement(memu).click();
        find(memu).click().find(addMember).click().find(menu).click();

       /* driver.findElement(addMember).click();
        driver.findElement(menu).click();*/
        find(nameInput).sendKeys(name);
        find(phoneInput).sendKeys(phone);
        find(saveButton).click();
        find(closeButton).click();
        return this;
    }
    public Member find(String keyword){
        driver.findElement(searchButton).click();
        driver.findElement(editText).sendKeys(keyword);
        driver.findElement(searchResultList).click();
    /*    driver.findElement(infoButton).click();
        driver.findElement(iconButton).click();*/
        String name = driver.findElement(nameButton).getText();
        String departName=driver.findElement(departText).getText();
        driver.navigate().back();
        driver.navigate().back();
        return new Member(name,null,departName);

    }

    public DefaultPage back() {
        return  new DefaultPage(driver);
    }
}
