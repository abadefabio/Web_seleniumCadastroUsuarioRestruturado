package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CadastroPage;
import runner.RunCucumberTest;


public class CadastroSteps extends RunCucumberTest {

    CadastroPage cadPage = new CadastroPage();

   @Quando("^eu preencho o formulario de cadastro$")
    public void eu_preencho_o_formulario_de_cadastro() {
       cadPage.selecionarTituloMRouMRS("masculino");
       cadPage.preencherPassword();
       cadPage.selecionarDiaCombo(4);
       cadPage.selecionarMesCombo(2);
       cadPage.selecionarAnoCombo("2009");
       cadPage.selecionarCheckNewsLetter();
       cadPage.preencerCampoPrimeiroNome("FR Silva");
       cadPage.preencerCampoUltimoNome(" Company LDTA");
       cadPage.preencerCampoCompany("FRsystem");
       cadPage.preencerCampoEndereco("Ivete vargas, 9999");
       cadPage.selecionarPais("Canada");
       cadPage.preencerCampoEstado("São Paulo");
       cadPage.preencerCampoCidade("Osasco");
       cadPage.preencerCampoCEP("06243210");
       cadPage.preencerCampoMobileNumber("97867678");
    }

    @Quando("^clico em registrar$")
    public void clico_em_registrar() {
        cadPage.clicarBotaoCriarConta();
    }

    @Entao("^vejo a mensagem de cadastro realizado com sucesso$")
    public void vejo_a_mensagem_de_cadastro_realizado_com_sucesso() {
        cadPage.validarMensagemContaCriadaSucesso();
    }
}
