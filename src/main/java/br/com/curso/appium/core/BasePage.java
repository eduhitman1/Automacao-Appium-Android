package br.com.curso.appium.core;

import static br.com.curso.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasePage {

//	private MobileElement findElement;

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}

	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
//		getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).click();
	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
//		getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='"+valor+"']")).click();
	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	// VERIFICAR NOVAMENTEO
//	List<MobileElement> elementos = getDriver().findElement(By.xpath("//*[@text='"+texto+"']"));
	public boolean existeElementoPorTexto(String texto) {
     List<MobileElement> elementos = (List<MobileElement>) getDriver()
				.findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}
	
	
	public void tap(int x, int y) {
		 new TouchAction(getDriver()).tap(x,y).perform();
	}
	

	public void scroll(double inicio, double fim ) {
		Dimension size = getDriver().manage().window().getSize();
		int x = size.width /2;
		int start_y = (int)(size.height* inicio);
		int end_y = (int)(size.height *fim);
		
		new TouchAction(getDriver())
		.press(x,start_y)
		.waitAction(Duration.ofMillis(500))
		.moveTo(x, end_y)
		.release()
		.perform();
	}
	
	public String obterMensagemAlert() {
		return obterTexto(By.id("android:id/message"));
	}
	
	
	
	
	
}
