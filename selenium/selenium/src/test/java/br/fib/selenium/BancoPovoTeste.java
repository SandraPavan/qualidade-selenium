package br.fib.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BancoPovoTeste {
	@Test
	public void deveAdicionarUmCorrentista() {
		System.setProperty("webdriver.chrome.driver", "/var/www/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.5.115:8080/correntista/novo");
		WebElement nome = driver.findElement(By.name("nome"));
		WebElement email = driver.findElement(By.name("email"));

		nome.sendKeys("Augusto dos Santos");
		email.sendKeys("augusto.dsantos@gmail.com");

		WebElement botaoSalvar = driver.findElement(By.id("button1"));
		botaoSalvar.click();

		boolean achouNome = driver.getPageSource().contains("Augusto dos Santos");
		boolean achouEmail = driver.getPageSource().contains("augusto.dsantos@gmail.com");

		assertTrue(achouNome);
		assertTrue(achouEmail);

		driver.close();
	}
}
