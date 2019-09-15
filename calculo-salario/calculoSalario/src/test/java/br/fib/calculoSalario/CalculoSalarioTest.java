package br.fib.calculoSalario;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculoSalarioTest {
	private WebDriver driver;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "/var/www/chromedriver/chromedriver");
		this.driver = new ChromeDriver();
		driver.get("http://192.168.5.115:9098");
	}

	@Test
	public void deveAdicionarUmCalculo() {
		driver.findElement(By.linkText("Novo Calculo")).click();
		WebElement nome = driver.findElement(By.name("name"));
		WebElement dependents = driver.findElement(By.name("dependents"));
		WebElement timeToWork = driver.findElement(By.name("timeToWork"));
		WebElement salaryHour = driver.findElement(By.name("salaryHour"));

		nome.sendKeys("Augusto dos Santos");
		dependents.sendKeys(String.valueOf(0));
		timeToWork.sendKeys(String.valueOf(15));
		salaryHour.clear();
		salaryHour.sendKeys(String.valueOf(34.0));
		nome.submit();

		boolean achouNome = driver.getPageSource().contains("Augusto dos Santos");
		assertTrue(achouNome);

	}

	@Test
	public void deveEditarUmFuncionario() {

		List<WebElement> rows = driver.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if (cells.size() > 0 && cells.get(0).getText().equals("Augusto dos Santos")) {
				row.findElement(By.cssSelector("td:nth-child(6) a")).click();
				break;
			}
		}
		WebElement nome = driver.findElement(By.name("name"));
		nome.clear();
		nome.sendKeys("Augusto dos Santos Editar");
		nome.submit();

		boolean achouNome = driver.getPageSource().contains("Augusto dos Santos Editar");
		assertTrue(achouNome);
	}

	@Test
	public void deveDeletarUmFuncionario() {

		List<WebElement> rows = driver.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			if (cells.size() > 0 && cells.get(0).getText().equals("Augusto dos Santos")) {
				row.findElement(By.cssSelector("td:nth-child(7) a")).click();
				break;
			}
		}

		boolean achouNome = driver.getPageSource().contains("Augusto dos Santos");
		assertTrue(achouNome);
	}

	// @After
	// public void encerra() {
	// driver.close();
	// }
}
