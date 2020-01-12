package br.com.curso.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.curso.appium.core.AbasPage;
import br.com.curso.appium.core.BasePage;
import br.com.curso.appium.page.MenuPage;

public class AbasTeste extends BasePage {
	private MenuPage menu = new MenuPage();
	private AbasPage page = new AbasPage();

	@Test
	public void deveInteragirComAbas() {
		// acessar menu abas
		menu.acessarAbas();

		// verificar que esta na aba1
		Assert.assertTrue(page.isAba1());

		// acessar aba 2
		page.selecionarAbar2();

		// verificar que esta no aba2
		Assert.assertTrue(page.isAba2());
	}

}
