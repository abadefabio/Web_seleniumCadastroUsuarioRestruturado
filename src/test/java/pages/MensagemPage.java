package pages;

import com.codeborne.selenide.commands.PressEnter;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import runner.RunCucumberTest;
import suporte.UltilsFR;

public class MensagemPage extends RunCucumberTest {

    String url = "https://automationexercise.com/contact_us";

    //Mapeamanto dos elementos da tela
    private By criarNome_field = By.name("name");
    private By campoPreencherEmail = By.cssSelector("input[name=email][class=form-control]");
    private By subject_field = By.name("subject");
    private By mensagem_field = By.id("message");
    private By btn_submit = By.name("submit");
    private By file_caminho = By.cssSelector("input[name=upload_file][class=form-control]");
    private By validarMensagemSucesso = By.cssSelector("div>div.status.alert");

    public void acessarTelaLogin() {
        getDriver().get(url);
        UltilsFR.esperarElementoEstarPresente(criarNome_field,20);
        UltilsFR.takeScreenshot("Acessando browser");
    }

    public void preencherCriarEmail() throws Exception {
        UltilsFR.escreverTexto(campoPreencherEmail,UltilsFR.getRandomEmail());
        UltilsFR.tirarEvidencia("Preenchendo e-mail");
    }

    public void preencherNome() {
        UltilsFR.escreverTexto(criarNome_field,"QAzando Name");
    }

    public void preencherCampoSubject() {
        UltilsFR.escreverTexto(subject_field,"QAzando Name");
    }

    public void preencherDescricaoMSG() {
        UltilsFR.escreverTexto(mensagem_field,"QAzando Name");
    }

    public void preencherCaminhoFile(String caminhoArquivo) {

        UltilsFR.escreverTexto(file_caminho,caminhoArquivo);
    }

    public void clicarBtnSubimit() throws Exception {
        UltilsFR.takeScreenshot("clicando botão enviar");
        UltilsFR.clicar(btn_submit);
        try{
            getDriver().switchTo().alert().accept();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void validarMensagem() throws Exception {
        String msg = getDriver().findElement(validarMensagemSucesso).getText();
        Assert.assertEquals(msg,"Success! Your details have been submitted successfully.");
        UltilsFR.takeScreenshot("Validando mensagem sucesso");
    }
}
