package br.com.curso.appium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.curso.appium.core.DSL;
import br.com.curso.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTeste {

	private DSL dsl = new DSL();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		dsl.clicarPorTexto("Formulário");
	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Eduardo");
//		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
//		campoNome.sendKeys("Eduardo");

		assertEquals("Eduardo", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
//		String valida = campoNome.getText();
//		Assert.assertEquals("Eduardo", valida);
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		// CLICAR NO COMBO
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
		// driver.findElement(MobileBy.AccessibilityId("console")).click();

		// SELECIONAR A OPCAO SELECIONADA
		// driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo
		// Switch']")).click();

		// VERIFICAR OPCAO SELECIONADA
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("Nintendo Switch", text);
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		// VALIDAÇÃO
		Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));
		// VERIFICAR STATUS DOS ELEMENTEOS
//		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
//		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));

		// CLICLAR NOS ELEMENTOS
//		check.click();
//		switc.click();

		// VERIFICAR ESTADOS ALTERADOS
		Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		dsl.escrever(By.className("android.widget.EditText"), "Eduardo");
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));
		dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");

		// SALVAR
		dsl.clicarPorTexto("SALVAR");
//		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();

		// VERIFIÇOES
		Assert.assertEquals("Nome: Eduardo",dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Eduardo']")));
		
		Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));
		
		Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));
		
		Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).endsWith("Marcado"));
		
		

//		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
//
//		driver.findElement(By.className("android.widget.EditText")).sendKeys("Eduardo");
//		driver.findElement(By.className("android.widget.CheckBox")).click();
//		driver.findElement(By.className("android.widget.Switch")).click();
//		driver.findElement(By.className("android.widget.Spinner")).click();
//		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
//		// SALVAR
//		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
//		// VERIFIÇOES
//		MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Eduardo']"));
//		Assert.assertEquals("Nome: Eduardo", nome.getText());
//
//		MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
//		Assert.assertTrue(swit.getText().endsWith("Off"));
//
//		MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
//		Assert.assertEquals("Console: switch", combo.getText());
//
//		MobileElement check = driver
//				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
//		Assert.assertTrue(check.getText().endsWith("Marcado"));
	}
}
