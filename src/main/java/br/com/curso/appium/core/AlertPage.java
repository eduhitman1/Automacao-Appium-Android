package br.com.curso.appium.core;

import org.openqa.selenium.By;

public class AlertPage extends BasePage {

	public void clicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}

	public String obterMensagemAlert() {
		return obterTexto(By.id("android:id/message"));
	}
	
	
	public void  confirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	
	public void sair() {
		clicar(By.id("android:id/button1"));
	}
	
	
	
	
}
