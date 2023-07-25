package com.prueba.stefanini;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EvaluacionPractica {

	public static void main(String[] args) throws InterruptedException {
		// Instanciando navegador
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\marce\\OneDrive\\Documentos\\AUTOMATIZACION\\lib-chrome\\chromedriver.exe" );
		//instanciar navegador
		WebDriver driver = new ChromeDriver ();
		// Accediendo al sitio solicitado 
		driver.get("https://www.amazon.com/-/es/");
		driver.manage().window().maximize();
		//Ingresando nombre de un producto
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
		Thread.sleep(3000);
		//Haciendo clic en boton de busqueda
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);

		// Obtiene los elementos que representan los productos en la página
        List<WebElement> listaProductos = driver.findElements(By.cssSelector("h2.a-size-mini > a.a-link-normal"));

        // Obtiene la cantidad de productos en la lista
        int cantidadProductos = listaProductos.size();
        	 System.out.println("PRODUCTOS LISTAS: " + cantidadProductos);

        // Verifica si hay productos en la lista
        if (cantidadProductos >= 24) {
        	listaProductos.get(1).click(); 
        }
        
		//Agregando Producto al carrito 
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		//Click en carrito
		driver.findElement(By.id("attach-view-cart-button-form")).click();
		Thread.sleep(3000);
		//Eliminando producto del carrito 
		driver.findElement(By.cssSelector("[value='Eliminar']")).click();
		driver.close();

        
	}
}
