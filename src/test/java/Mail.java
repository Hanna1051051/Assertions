import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

public class Mail extends SettingsMail {
    @Test
    public void emptyMailBox() {
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Ввести пароль')]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Введите имя ящика')]")).isDisplayed());
    }

    @Test
    public void emptyPassword() {
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("login")).sendKeys("11111@MAIL.RU");
        driver.findElement(By.xpath("//button[contains(text(),'Ввести пароль')]")).click();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Запомнить')]")).click();
        driver.findElement(By.cssSelector("[class=\"second-button svelte-1tib0qz\"]")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Введите пароль')]")).isDisplayed());
    }

    @Test
    public void emailAuthoriz() {
        driver.getCurrentUrl().contains("mail");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.name("login")).sendKeys("pupkina_antoninka@mail.ru");
        driver.findElement(By.xpath("//button[contains(text(),'Ввести пароль')]")).click()/**/;
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("mer1051051mer");
        driver.findElement(By.xpath("//label[contains(text(),'Запомнить')]")).click();
        driver.findElement(By.cssSelector("[class=\"second-button svelte-1tib0qz\"]")).click();
        Assertions.assertTrue(driver.findElement(By.id("sideBarContent")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"/inbox/\"]")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"/inbox/\"]")).isEnabled());
    }

    @Test
    public void emailContains() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("mail"));
        Assertions.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Mail.ru')]")).isEnabled());
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"//news.mail.ru/\"]")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.linkText("Новости")).getText(), "Новости");
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"http://news.mail.ru/inworld/\"]")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.linkText("В мире")).getText(), "В мире");
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"//sportmail.ru/\"]")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.linkText("Спорт")).getText(), "Спорт");
        Assertions.assertTrue(driver.findElement(By.cssSelector("[href=\"//lady.mail.ru/\"]")).isDisplayed());
        Assertions.assertEquals(driver.findElement(By.linkText("Леди")).getText(), "Леди");
    }

}
