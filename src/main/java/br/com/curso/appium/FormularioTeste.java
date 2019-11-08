package br.com.curso.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		// desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		// desiredCapabilities.setCapability("appActivity",
		// "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
		"/Users/eduardo.matias/Documents/eclipce-workspace/Automacao-Appium-Android/src/main/resources/CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		
		// SELECIONAR FORMULARIO
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		elementosEncontrados.get(1).click();
//		for (MobileElement elemento : elementosEncontrados) {
//			System.out.println(elemento.getText());
//		}
		
        // ESCREVER NOME  EDITTEXT
		MobileElement campoNome =  driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Eduardo Henrique");
        // CHECAR A ESCRITA
		String valida = campoNome.getText();
		Assert.assertEquals("Eduardo Henrique", valida);
		

		driver.quit();
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
		"/Users/eduardo.matias/Documents/eclipce-workspace/Automacao-Appium-Android/src/main/resources/CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// SELECIONAR FORMULARIO XPATH
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		// CLICAR NO COMBO
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		// SELECIONAR A OPCAO SELECIONADA
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
	    
	    // VERIFICAR OPCAO SELECIONADA
	    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Nintendo Switch", text);

	    driver.quit();
	}
	
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/eduardo.matias/Documents/eclipce-workspace/Automacao-Appium-Android/src/main/resources/CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// SELECIONAR FORMULARIO XPATH
		
		
		// VERIFICAR STATUS DOS ELEMENTEOS 
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		// VALIDAÇÃO
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		
		// CLICLAR NOS ELEMENTOS
		check.click();
		switc.click();
		
		// VERIFICAR ESTADOS ALTERADOS
		Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertFalse(switc.getAttribute("checked").equals("true"));
		

	    driver.quit();
	}
	
	@Test
	public void deveResolverDesafio() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/eduardo.matias/Documents/eclipce-workspace/Automacao-Appium-Android/src/main/resources/CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
		
		driver.findElement(By.className("android.widget.EditText")).sendKeys("Eduardo");
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//SALVAR
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
		
		//VERIFIÇOES
		MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Eduardo']"));
		Assert.assertEquals("Nome: Eduardo", nome.getText());
		
		
		MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
		Assert.assertTrue(swit.getText().endsWith("Off"));
		
		
		MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
		Assert.assertEquals("Console: switch", combo.getText());
		
		
		
		MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		Assert.assertTrue(check.getText().endsWith("Marcado"));
		
		
		driver.quit();
		
		
		
	}
	
	
	
	
}
