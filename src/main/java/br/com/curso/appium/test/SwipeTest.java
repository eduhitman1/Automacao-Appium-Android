package br.com.curso.appium.test;

import static br.com.curso.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.curso.appium.core.BaseTest;
import br.com.curso.appium.page.MenuPage;

public class SwipeTest extends BaseTest {

	MenuPage menu = new MenuPage();

	@Before
	public void setUp() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		menu.scroll(0.9, 0.1);
		menu.acessarSwipe();
	}

	@Test
	public void deveRealizarSwipe() {

		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

		menu.swipeDireita();

		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

		menu.clicarPorTexto("›");

		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

		menu.swipeEsquerda();

		menu.clicarPorTexto("‹");

		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

	}

}
