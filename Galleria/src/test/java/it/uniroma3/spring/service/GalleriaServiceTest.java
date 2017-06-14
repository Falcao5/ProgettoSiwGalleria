package it.uniroma3.spring.service;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.service.GalleriaService;
import it.uniroma3.spring.model.Amministratore;

public class GalleriaServiceTest {
	
	private GalleriaService<Amministratore> gs;
	
	@Before
	public void setUp(){
		this.gs = new GalleriaService<Amministratore>();
	}

	@Test
	public void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Method temp = null;
//		try {
//			temp = this.gs.getClass().getDeclaredMethod("queryBuilder", String.class , String.class);
//			temp.setAccessible(true);
//			this.gs = new GalleriaService<Amministratore>();
//		} catch (NoSuchMethodException e) {
//			System.out.println("Non esiste il metodo cercato");
//			e.printStackTrace();
//		} catch (SecurityException e){
//			System.out.println("Violazione accessibility");
//			e.printStackTrace();
//		}
//
//		assertEquals("Amministratore.findByNome", temp.invoke(this.gs, "nome", "amministratore"));
		
//		assertEquals("Amministratore.findByNome", this.gs.queryBuilder("nome", "amministratore"));
	}

}
