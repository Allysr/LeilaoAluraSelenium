import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    public static final String LOGIN = "http://localhost:8080/login";
    private WebDriver browser;

    public LoginPage(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(LOGIN);
    }

    public void fecharNavegador(){
        this.browser.quit();
    }

    public void preencherLogin(String nome, String senha){
        browser.findElement(By.id("username")).sendKeys(nome);
        browser.findElement(By.id("password")).sendKeys(senha);
    }

    public void clicarBotaoLogar(){
        browser.findElement(By.id("login-form")).click();
    }

    public boolean ePaginaDeLogin(){
        return browser.getCurrentUrl().equals(LOGIN);
    }

    public String nomeUsuarioLogado(){
        return browser.findElement(By.id("user")).getText();
    }

    public String mensagemDeErroUsuarioInvalido() {
        return browser.findElement(By.id("invalid-user")).getText();
    }

}
