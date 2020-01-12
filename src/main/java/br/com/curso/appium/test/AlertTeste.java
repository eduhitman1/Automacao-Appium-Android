package br.com.curso.appium.test;

import static org.junit.Assume.assumeNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.curso.appium.core.AlertPage;
import br.com.curso.appium.core.BaseTest;
import br.com.curso.appium.page.MenuPage;

public class AlertTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private AlertPage page = new AlertPage();

	@Before
	public void setup() {
		menu.acessarAlertas();
	}

	@Test
	public void deveConfirmaAlerta() {
		// acessar menu alerta
		menu.acessarAlertas();

		// clicar em alerta confirm
		page.clicarAlertaConfirm();

		// verifcar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlert());

		// confirma alerta
		page.confirmar();

		// verificar nova mensagem
		Assert.assertEquals("Confirmado", page.obterMensagemAlert());

		// sair
		page.sair();

	}

	@Test	
	public void deveClicarForaAlerta() {
		// clicar alerta simples
		page.clicarAlertaSimples();

		// clicar fora da caixa
		esperar(1000);
		page.clicarForaCaixa();

		// verificar que a mensagem não está presente
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair")); 

	}
	
	
	@Test
	public void deveClicarForaAlert() {
        // clicar alerta simles
		page.clicarAlertaSimples();
        
		
		esperar(1000);
		page.clicarForaCaixa();
		
        Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}

}
