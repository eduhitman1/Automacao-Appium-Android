package br.com.curso.appium.test;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;

import br.com.curso.appium.core.BaseTest;
import br.com.curso.appium.page.CliquesPage;
import br.com.curso.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.cliquesLongos();
	}

	@Test
    public void cliqueLongo() {
    	page.cliqueLongo();
    	assertEquals("Clique Longo", page.obterTextoCampo());
    }
}
