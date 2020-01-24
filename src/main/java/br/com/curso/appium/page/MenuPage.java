package br.com.curso.appium.page;

import br.com.curso.appium.core.BasePage;

public class MenuPage extends BasePage {

	public void acessarFormulario() {
		clicarPorTexto("Formul�rio");
	}

	public void acessarSplash() {
		clicarPorTexto("Splash");
	}

	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}

	public void acessarAbas() {
		clicarPorTexto("Abas");
	}

	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}

	public void cliquesLongos() {
		clicarPorTexto("Cliques");
	}
	
	public void acessarSwipe() {
		clicarPorTexto("Swipe");
	}
	
	public void acessarSwipeList() {
		clicarPorTexto("Swipe List");
	}
	
	
	public void acessarDragNDrop() {
         clicarPorTexto("Drag and drop");
	}
	
	public void acessarAppHibrido() {
        clicarPorTexto("SeuBarriga H�brido");
	}
}
