package suporte;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumberTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

//import static org.codehaus.plexus.util.xml.PrettyPrintXMLWriter.amp;

public class UltilsFR extends RunCucumberTest {

    public static void esperarElementoEstarPresente(By elemento, int tempo){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public static void clicar(By propriedade) {
        getDriver().findElement(propriedade).click();
    }

    public static void escreverTexto(By propriedade, String texto) {
        WebElement vTexto = getDriver().findElement(propriedade);
        vTexto.clear();
        vTexto.sendKeys(texto);
    }
    public WebElement find(By selector) {
//        WebElement test = driver.findElement(selector);
//        test.sendKeys();
        return getDriver().findElement(selector);
    }

    /**
     * Metodo para gerar email de forma a não repetir o mesmo.
     * @return
     */
    public static String  getRandomEmail(){
        String email_init = "qazando_";
        String email_final = "@qazando.com.br";

        Random random = new Random();
        int minimo =1;
        int maximo = 99999999;
        int resultado = random.nextInt(maximo-minimo)+ minimo;

        return email_init + resultado + email_final;
    }

    /**
     * Metodo para gerar senha aleatoria
     * @return
     */
    public static String gerarSenha(){
        int qtdeMaximaCaracteres = 8;
        String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8",
                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
                "x", "y", "z"};

        StringBuilder senha = new StringBuilder();

        for (int i = 0; i < qtdeMaximaCaracteres; i++) {
            int posicao = (int) (Math.random() * caracteres.length);
            senha.append(caracteres[posicao]);
        }
        return senha.toString();
    }

    public static void tirarEvidencia(String fname) throws Exception {
        File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        String imageFileDir = System.getProperty("selenium.screenshot.dir");
        if (imageFileDir == null)
            imageFileDir = System.getProperty("java.io.tmpdir");
        FileUtils.copyFile(scrFile, new File(imageFileDir, fname));
    }

    /**
     * Método para capturar screenshot
     * @param fileName - Nome do arquivo
     */
    public static void takeScreenshot(String fileName) {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        Date data = new Date();
        try {
            FileUtils.copyFile(scrFile, new File(new File("src/test/resources/evidencias/prints") + fileName.toString() + data.getTime() + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
