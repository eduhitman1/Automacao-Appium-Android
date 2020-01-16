package br.com.curso.appium.test;

import static br.com.curso.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.curso.appium.core.BasePage;
import br.com.curso.appium.core.SwipeListPage;
import br.com.curso.appium.page.MenuPage;

public class SwipeListTest  extends BasePage {

    MenuPage menu = new MenuPage();
    SwipeListPage page = new SwipeListPage();
	
	@Before
	public void setUp() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		menu.scroll(0.9, 0.1);
		menu.acessarSwipeList();
	}
	
	@Test
	public void deveSelecionaUmItem() {
		page.swipeElementDireita("Op��o 1");
		page.clicarBotaoMais();
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 1 (+)"));
		
		page.swipeElementDireita("Op��o 4");
		page.clicarPorTexto("(-)");
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 4 (-)"));
		
		page.swipeElementEsquerda("Op��o 5 (-)");
		Assert.assertTrue(page.existeElementoPorTexto("Op��o 5"));
	}
	
	
	
}
