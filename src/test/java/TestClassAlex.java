import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.Random;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestClassAlex {

    WebDriver _globalDriver;
        
    

    @BeforeTest 
    public void SetupWebDriver(){
        _globalDriver = new ChromeDriver();
        _globalDriver.get("https://elenta.lt");//reikia https
        WebElement cookieButton = _globalDriver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/div[2]/div[2]/button[1]"));
        cookieButton.click();
        WebElement sutikimas = _globalDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/a[3]"));
        sutikimas.click();
        WebElement prisiregistruoti = _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[10]/td/p/a"));
        prisiregistruoti.click();


    }

    @Test
    public void openBrowser() {

        ChromeDriver _globalDriver = new ChromeDriver();
        _globalDriver.get("https://www.google.lt");


    }

    @Test // anotacija, kuri leidžia javai suprasti, kad tai yra testas ir jį reikia paleisti.
    public void test1() {//jei atidaro teisingai pakūrėme projektą
        
        _globalDriver.get("https://elenta.lt/registracija");//reikia https
    }

    @Test //leisti po viena
    public void test2() {//jei atidaro teisingai pakūrėme projektą
       


        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[1]/td[2]/input")).sendKeys(generateUsername()); // Username
        _globalDriver.findElement(By.id("Email")).sendKeys(generateRandomEmail());// Email.

        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[7]/td[2]/input")).sendKeys("Traktorius1!"); // Pwrd1
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[8]/td[2]/input")).sendKeys("Traktorius1!"); // pwrd2
        _globalDriver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        WebElement resultText= _globalDriver.findElement(By.xpath("/html/body/div[1]/div[2]/h1/b"));
        Assert.assertEquals(resultText.getText(),"Jūs sėkmingai prisiregistravote!");
        _globalDriver.close();


    }


    @Test //leisti po viena
    public void test3() {//jei atidaro teisingai pakūrėme projektą


        _globalDriver.findElement(By.id("submit-new-ad-nav-button")).click();
        _globalDriver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a")).click();
        _globalDriver.findElement(By.id("title")).sendKeys(generateUsername());// operacija nekuriant kintamojo.
        _globalDriver.findElement(By.id("text")).sendKeys(generateUsername());// operacija nekuriant kintamojo.
        // //*[@id="searchKeyword"]  paltginti dalinio xpath struktūrą su id. iš xpath matosi, kad elementas turi savo id.
        // papasakoti kad galima selectinti pagal id, unikalu, pagal klase, (jei vienas elementas ok, jei keli su ta klase paims pirmą. arba su findelements galima paimti visus su x klase, bet tai vėliau.)
        _globalDriver.findElement(By.id("price")).sendKeys("15");
        _globalDriver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        _globalDriver.findElement(By.id("phone")).sendKeys("+3706123456");
        _globalDriver.findElement(By.id("email")).sendKeys(generateRandomEmail());
        _globalDriver.findElement(By.xpath("//html/body/div[1]/ul/li[1]/a")).click();
        _globalDriver.findElement(By.xpath("//html/body/div[1]/ul/li[1]/a")).click();
//        _globalDriver.close();

    }

    public static boolean assertEquals(String actual, String expected) {
        return actual.equals(expected);
    }


    public static String generateRandomEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};

        Random random = new Random();

        StringBuilder email = new StringBuilder();

        // Generate username part
        int usernameLength = random.nextInt(10) + 5; // Random length between 5 to 14 characters
        for (int i = 0; i < usernameLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            email.append(randomChar);
        }

        // Adding '@' symbol
        email.append("@");

        // Selecting random domain
        String randomDomain = domains[random.nextInt(domains.length)];
        email.append(randomDomain);

        return email.toString();
    }
    public String generateUsername(){
        String[] characters = {"abcdefghijklmnopqrstuvwxyz", "0123456789"};

        Random random = new Random();

        StringBuilder username = new StringBuilder();

        // Generate username part
        int usernameLength = random.nextInt(10) + 5; // Random length between 5 to 14 characters
        for (int i = 0; i < usernameLength; i++) {
            String characterSet = characters[random.nextInt(2)]; // Selecting either alphabets or numbers
            char randomChar = characterSet.charAt(random.nextInt(characterSet.length()));
            username.append(randomChar);

        }
        return username.toString();
    }
}