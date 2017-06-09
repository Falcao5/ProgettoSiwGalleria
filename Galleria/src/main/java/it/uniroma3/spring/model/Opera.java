/**
 * Entities Superclass
 * @author falcao5
 * @version 1.0
 * @category Persistence entities
 * 
 */

package it.uniroma3.spring.model;

public abstract class Opera {
	
	private Autore autoreDellOpera;
	
	/**
	 * 
	 * @param autore
	 */
	public Opera(Autore autore){
		this.setAutoreDellOpera(autore);
	}

	/**
	 * @return the autoreDellOpera
	 */
	public Autore getAutoreDellOpera() {
		return autoreDellOpera;
	}

	/**
	 * @param autoreDellOpera the autoreDellOpera to set
	 */
	public void setAutoreDellOpera(Autore autoreDellOpera) {
		this.autoreDellOpera = autoreDellOpera;
	}
	
	
}
