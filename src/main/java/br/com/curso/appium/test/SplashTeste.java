package br.com.curso.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.curso.appium.core.BaseTest;
import br.com.curso.appium.page.MenuPage;
import br.com.curso.appium.page.SplashPage;

public class SplashTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
	    //acessar menu splash
		menu.acessarSplash();
		
		//verificar que o splash esta sendo exibido
		page.isTelaSplashVisivel();
		
		// aguarda saida do splash
		page.aguardarSplashSumir();
		
		//verificar que o formulario esta aparecendo
		Assert.assertTrue(page.existeElementoPorTexto("Formulário"));
	}
}
