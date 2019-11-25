package br.com.curso.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.curso.appium.core.AlertPage;
import br.com.curso.appium.core.BaseTest;
import br.com.curso.appium.page.MenuPage;

public class AlertTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AlertPage page = new AlertPage();
	
	
	@Test
	public void deveConfirmaAlerta() {
		//acessar menu alerta
		menu.acessarAlertas();	
		
		//clicar em alerta confirm
		page.clicarAlertaConfirm();
		
		//verifcar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlert());
		
		//confirma alerta
        page.confirmar();		
		
		//verificar nova mensagem
		Assert.assertEquals("Confirmado", page.obterMensagemAlert());
		
		//sair
		page.sair();
		
	}
	
	
}
