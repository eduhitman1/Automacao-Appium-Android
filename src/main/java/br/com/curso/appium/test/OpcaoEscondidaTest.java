package br.com.curso.appium.test;

import static br.com.curso.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.curso.appium.core.BaseTest;
import br.com.curso.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {


	private MenuPage menu =  new MenuPage();
	
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		WebDriverWait wait = new WebDriverWait(getDriver(),10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("Começando..");
		
		menu.scroll(0.9, 0.1);
		
		menu.clicarPorTexto("Opção bem escondida");
		
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlert());
		
		menu.clicarPorTexto("OK");
	}
	
	
}
