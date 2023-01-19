package steps;

import cucumber.api.java.pt.Dado;
import pages.LoginPage;
import runner.RunBase;
import runner.RunCucumberTest;

public class LoginSteps extends RunCucumberTest {

    LoginPage login = new LoginPage();

    @Dado("^que estou na tela de login$")
    public void que_estou_na_tela_de_loginOld(Browser tipo) throws InterruptedException {

        getDriver(Browser.CHROME);
        login.acessarTelaLogin();
    }

    @Dado("que estou na tela de login {string}")
    public void que_estou_na_tela_de_login(String tipo) {
        if (tipo.equalsIgnoreCase("FIREFOX")) {
            getDriver(Browser.FIREFOX);
        } else if (tipo.equalsIgnoreCase("EDGE")){
            getDriver(Browser.EDGE);
        } else {
            getDriver(Browser.CHROME);
        }
        login.acessarTelaLogin();
    }


    @Dado("^acesso o cadastro de usuario$")
    public void acesso_o_cadastro_de_usuario() throws InterruptedException {
        login.preencherCriarEmail();
        login.clicarBotaoSignup();
    }
}
