package it.uniroma3.spring.facade;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.spring.model.Amministratore;


public class AmministratoreFacadeTest {
	
	private AbstractFacade<Amministratore> ammfac;
	
	@Before
	public void setUp(){
		this.ammfac = new AmministratoreFacade();
	}
	
	/* Utilizza la riflessione per invocare il metodo della classe. In questo modo possiamo lasciare privato il metodo. */
	@Test
	public void trovaNomeDiQuestaClasseTest() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method temp = null;
		try {
			temp = this.ammfac.getClass().getSuperclass().getDeclaredMethod("trovaNomeDiQuestaClasse");
			temp.setAccessible(true);
			this.ammfac = new AmministratoreFacade();
		} catch (NoSuchMethodException e) {
			System.out.println("Non esiste il metodo cercato");
			e.printStackTrace();
		} catch (SecurityException e){
			System.out.println("Violazione accessibility");
			e.printStackTrace();
		}

		assertEquals("Amministratore", temp.invoke(this.ammfac));
	}
	
	
	
}
