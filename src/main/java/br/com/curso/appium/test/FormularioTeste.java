package br.com.curso.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.curso.appium.core.BaseTest;
import br.com.curso.appium.core.DriverFactory;
import br.com.curso.appium.page.FormularioPage;
import br.com.curso.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.functions.ExpectedCondition;

public class FormularioTeste extends BaseTest {

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
		// dsl.clicarPorTexto("Formulário");
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		page.escreverNome("Eduardo");
//      dsl.escrever(MobileBy.AccessibilityId("nome"), "Eduardo");
//		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
//		campoNome.sendKeys("Eduardo");

		assertEquals("Eduardo", page.obterNome());
//		assertEquals("Eduardo", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
//		String valida = campoNome.getText();
//		Assert.assertEquals("Eduardo", valida);
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		// CLICAR NO COMBO

		page.selecionarCombo("Nintendo Switch");
//		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
		// driver.findElement(MobileBy.AccessibilityId("console")).click();

		// SELECIONAR A OPCAO SELECIONADA
		// driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo
		// Switch']")).click();

		// VERIFICAR OPCAO SELECIONADA

		// String text =
		// dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
		// Assert.assertEquals("Nintendo Switch", text);
	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		// VALIDAÇÃO
		Assert.assertFalse(page.isCheckMarcado());
		// Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));

		Assert.assertTrue(page.isSwitchMarcado());
//		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		page.clicarCheck();
//		dsl.clicar(By.className("android.widget.CheckBox"));
		page.clicarSwitch();
//		dsl.clicar(MobileBy.AccessibilityId("switch"));
		// VERIFICAR STATUS DOS ELEMENTEOS
//		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
//		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));

		// CLICLAR NOS ELEMENTOS
//		check.click();
//		switc.click();

		// VERIFICAR ESTADOS ALTERADOS
		Assert.assertTrue(page.isCheckMarcado());
//		Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(page.isSwitchMarcado());
//		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Eduardo");
//		dsl.escrever(By.className("android.widget.EditText"), "Eduardo");
		page.clicarCheck();
//		dsl.clicar(By.className("android.widget.CheckBox"));
		page.clicarSwitch();
//		dsl.clicar(By.className("android.widget.Switch"));
		page.selecionarCombo("Nintendo Switch");
//        dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");

		// SALVAR
		page.salvar();
//		dsl.clicarPorTexto("SALVAR");
//		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();

		// VERIFIÇOES
		Assert.assertEquals("Nome: Eduardo", page.obterNomeCadastrado());
		// Assert.assertEquals("Nome:
		// Eduardo",dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome:
		// Eduardo']")));

		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		// Assert.assertEquals("Console: switch",
		// dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,
		// 'Console:')]")));

		Assert.assertTrue(page.obterCheckCadastro().endsWith("Off"));
		// Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,
		// 'Switch:')]")).endsWith("Off"));

		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));
		// Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,
		// 'Checkbox:')]")).endsWith("Marcado"));

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

	@Test
	public void deveRealizarCadastroDemorado() throws MalformedURLException {
		page.escreverNome("Eduardo");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		page.salvarDemorado();
//		esperar(3000);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Eduardo']")));
		Assert.assertEquals("Nome: Eduardo", page.obterNomeCadastrado());
	}

	@Test
	public void deveAlterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
	}

	@Test
	public void deveAlterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("10:40"));
	}

	@Test
	public void deveInteragirComSeekvar() {
		page.ClickSeekBar(0.65);
		page.salvar();

	}

}
