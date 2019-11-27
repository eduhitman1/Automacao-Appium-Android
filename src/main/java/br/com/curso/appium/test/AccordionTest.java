package br.com.curso.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.curso.appium.core.BaseTest;
import br.com.curso.appium.page.AccordionPage;
import br.com.curso.appium.page.MenuPage;


public class AccordionTest extends BaseTest{

	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		//acessar menu
		menu.acessarAccordion();
		
		// click ao 1
		page.selecionarOp1();
		
		 
       	//verificar texto op 1
		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
		
		
		
	}
	
	
}
