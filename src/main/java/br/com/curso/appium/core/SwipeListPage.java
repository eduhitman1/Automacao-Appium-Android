package br.com.curso.appium.core;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SwipeListPage extends BasePage {

	public void swipeElementEsquerda(String opcao) {
		swipeElementy(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
	}
	
	
	public void swipeElementDireita(String opcao) {
		swipeElementy(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.1);
	}
	
	
	public void clicarBotaoMais() {
		MobileElement botao = DriverFactory.getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		new TouchAction(DriverFactory.getDriver())
		   .tap(botao,-50, 0)
		   .perform();
	}
	
}
