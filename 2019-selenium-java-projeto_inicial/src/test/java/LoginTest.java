import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;

public class LoginTest {
    private LoginPage paginaDeLogin;

    @BeforeEach
    public void beforeEach(){
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        paginaDeLogin.fecharNavegador();
    }

    @Test
    public void deveriaEfetuarLogincComDadosValidos(){
        paginaDeLogin.preencherLogin("fulano", "pass");
        paginaDeLogin.clicarBotaoLogar();

        Assert.assertFalse(paginaDeLogin.ePaginaDeLogin());
        Assert.assertEquals("falano", paginaDeLogin.nomeUsuarioLogado());
    }

    @Test
    public void deveAparecerUmaMensagemDeErroAoInserirUmUsuarioInvalido(){
        paginaDeLogin.preencherLogin("fulano", "passs");
        paginaDeLogin.clicarBotaoLogar();

        Assert.assertTrue(paginaDeLogin.ePaginaDeLogin());
        Assert.assertEquals("Usuário e senha inválidos.", paginaDeLogin.mensagemDeErroUsuarioInvalido());
    }
}
