package br.com.curso.appium.test;

import static br.com.curso.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.curso.appium.core.BaseTest;
import br.com.curso.appium.page.DragDropPage;
import br.com.curso.appium.page.MenuPage;

public class DragNDropTeste extends BaseTest {

	private String[] estadoInicial = new String[] { "Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,","e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[] { "é uma lista", "Drag em Drop!", "Faça um clique longo,","e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[] { "Faça um clique longo,","é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

	MenuPage menu = new MenuPage();
	DragDropPage page = new DragDropPage();

	@Before
	public void setUp() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		menu.scroll(0.9, 0.1);
		menu.acessarDragNDrop();
	}

	@Test
	public void DragNDropTeste() {

		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		
		page.arrastar("Esta", "e arraste para");

		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		page.arrastar("Faça um clique longo,", "é uma lista");

		Assert.assertArrayEquals(estadoFinal, page.obterLista());
		
	}

}
