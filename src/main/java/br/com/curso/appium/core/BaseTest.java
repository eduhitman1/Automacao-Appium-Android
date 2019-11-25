package br.com.curso.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {

	@AfterClass
	public static void finalizarClasse() {
		DriverFactory.killDriver();
	}

	@After
	public void tearDown() {
		gerarScreenShot();
//		DriverFactory.getDriver().resetApp();
	}

	// PRINT DE TELA AO FINAL DE TEST
	public void gerarScreenShot() {
		try {
			File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem, new File("target/screenshots/imagem.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
