package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import runner.RunCucumberTest;
import suporte.UltilsFR;

import java.security.SecureRandom;

public class CadastroPage extends RunCucumberTest {

    private By radioMr = By.id("id_gender1");
    private By radioMrs = By.id("id_gender2");
    private By nome = By.id("name");
    private By email = By.id("email");
    private By campoPassword = By.id("password");
    private By selecionarDia = By.id("days");
    private By selecionarMes = By.id("months");
    private By selecionarAno = By.id("years");
    private By checkSignNewsletter = By.id("newsletter");
    private By campoPrimeiroNome = By.id("first_name");
    private By campoUltimoNome = By.id("last_name");
    private By campoCompany = By.id("company");
    private By enderecoCompany = By.id("address1");
    private By checkCountry = By.id("country");
    private By campoState = By.id("state");
    private By campoCity = By.id("city");
    private By campoCEP = By.id("zipcode");
    private By campoMobileNumber = By.id("mobile_number");
    private By botaoCriarConta = By.xpath("//button[contains(text(),'Create Account')]");


    /**
     * metodo para selecionar radio button MR masculino ou MRS feminino
     * @param vSexo
     */
    public void selecionarTituloMRouMRS(String vSexo){
        switch (vSexo){
            case "masculino":
                UltilsFR.clicar(radioMr);
                break;
            case "feminino":
                UltilsFR.clicar(radioMrs);
                break;
        }
    }

    public void preencherPassword(){
        System.out.println(UltilsFR.gerarSenha().toString());
        UltilsFR.escreverTexto(campoPassword, UltilsFR.gerarSenha());
    }

    public void selecionarDiaCombo(int dia){
        Select selectDia = new Select(getDriver().findElement(selecionarDia));
        selectDia.selectByIndex(dia);
    }

    public void selecionarMesCombo(int mes){
        Select selectMes = new Select(getDriver().findElement(selecionarMes));
        selectMes.selectByIndex(mes);
    }

    public void selecionarAnoCombo(String ano){
        Select selectAno = new Select(getDriver().findElement(selecionarAno));
        selectAno.selectByValue(ano);
    }

    /**
     * metodo para clicar no checkBox newsletter
     */
    public void selecionarCheckNewsLetter(){
        UltilsFR.clicar(checkSignNewsletter);
    }

    /**
     * metodo para preencher telefone mobile
     */
    public void preencerCampoMobileNumber(String fone){
        UltilsFR.escreverTexto(campoMobileNumber,fone);
    }

    /**
     * metodo para preencher telefone mobile
     */
    public void preencerCampoPrimeiroNome(String primeiroNome){
        UltilsFR.escreverTexto(campoPrimeiroNome,primeiroNome);
    }

    /**
     * metodo para preencher telefone mobile
     */
    public void preencerCampoUltimoNome(String ultimoNome){
        UltilsFR.escreverTexto(campoUltimoNome,ultimoNome);
    }

    public void preencerCampoCompany(String company){

        UltilsFR.escreverTexto(campoCompany,company);
    }

    public void preencerCampoEndereco(String endereco){

        UltilsFR.escreverTexto(enderecoCompany,endereco);
    }

    public void selecionarPais(String pais){
        Select selPais = new Select(getDriver().findElement(checkCountry));
        selPais.selectByValue(pais);
    }

    public void preencerCampoEstado(String estado){
        UltilsFR.escreverTexto(campoState,estado);
    }
    public void preencerCampoCidade(String cidade){
        UltilsFR.escreverTexto(campoCity,cidade);
    }
    public void preencerCampoCEP(String cep){
        UltilsFR.escreverTexto(campoCEP,cep);
    }
    public void clicarBotaoCriarConta(){
        UltilsFR.clicar(botaoCriarConta);
    }

    public void validarMensagemContaCriadaSucesso(){
        WebElement msgSucesso = getDriver().findElement(By.cssSelector("#form > div > div > div > h2 > b"));
        System.out.println(msgSucesso.getText());

        String msgNovaContaCriada = getDriver().findElement(By.cssSelector("#form > div > div > div > p:nth-child(2)")).getText();
        System.out.println(msgNovaContaCriada);

        Assert.assertEquals("ACCOUNT CREATED!",msgSucesso.getText());
        Assert.assertEquals("Congratulations! Your new account has been successfully created!",msgNovaContaCriada);
    }
}
