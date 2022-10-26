package com.qualitystream.tutorial;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;



public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com/");
		
	}
	
	@Test
	public void testGooglePage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("Quality-stream Introducción a la automatización de pruebas en selenium");
		
		searchbox.submit();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		assertEquals("Quality-stream Introducción a la automatización de pruebas en selenium - Buscar con Google", driver.getTitle());
		
		WebElement resultadoDeBusqueda = driver.findElement(By.xpath("//span[@class=\"cHaqb\"][contains(text() , \"pruebas de software\")]"));
		resultadoDeBusqueda.click();
				
		WebElement videoYoutube = driver.findElement(By.xpath ("//yt-formatted-string[contains(text() , \"pruebas de software\")]"));		
		String tituloVideo = videoYoutube.getText();
		Assert.assertTrue(tituloVideo.contains("pruebas de software"));
		
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
	
	

