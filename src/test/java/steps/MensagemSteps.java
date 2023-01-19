package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.MensagemPage;
import runner.RunCucumberTest;

public class MensagemSteps extends RunCucumberTest {

    MensagemPage msgPage =  new MensagemPage();

    @Dado("que estou na tela de mensagens {string}")
    public void que_estou_na_tela_de_mensagens(String tipo) {
        if (tipo.equalsIgnoreCase("FIREFOX")) {
            getDriver(Browser.FIREFOX);
        } else if (tipo.equalsIgnoreCase("EDGE")){
            getDriver(Browser.EDGE);
        } else {
            getDriver(Browser.CHROME);
        }
        msgPage.acessarTelaLogin();
    }

    @Dado("^preencho todos os campos obrigatorios$")
    public void preencho_todos_os_campos_obrigatorios() throws Exception {
        msgPage.preencherNome();
        msgPage.preencherCriarEmail();
        msgPage.preencherCampoSubject();
        msgPage.preencherCaminhoFile("C:\\Users\\fabade\\Documents\\qazando_seleniumCadastroUsuarioRestruturado\\src\\test\\resources\\imagens\\erro firefox1.png");
        msgPage.preencherDescricaoMSG();
    }

    @Quando("^clico em enviar mensagem$")
    public void clico_em_enviar_mensagem() throws Exception{
        msgPage.clicarBtnSubimit();

    }

    @Entao("^vejo feedback de mensagem enviada com sucesso$")
    public void vejo_feedback_de_mensagem_enviada_com_sucesso() throws Exception {
        msgPage.validarMensagem();
    }
}
