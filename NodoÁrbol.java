package Árboles_binarios;

public class NodoÁrbol {
	private int dato;
	//private String nombre;
	private NodoÁrbol HijoIzquierdo;
	private NodoÁrbol HijoDerecho;
	/*
	 * 
	 */
	//Constructor
	public NodoÁrbol (int dato) {
		setDato(dato);
		//setNombre(nombre);
		setHijoIzquierdo(null);
		setHijoDerecho(null);
	}
	
	//Getters&Setters
	public int getDato() {
		return dato;
	}
	/*
	 * public String getNombre() {
	 * 	return nombre;
	 * }
	 */
		
	public NodoÁrbol getHijoIzquierdo() {
		return HijoIzquierdo;
	}
	public NodoÁrbol getHijoDerecho() {
		return HijoDerecho;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	/*
	 * public void setNombre(String nombre) {
	 * 	this.nombre = nombre;
	 * 	}
	 */
		
	public void setHijoIzquierdo(NodoÁrbol HijoIzquierdo) {
		this.HijoIzquierdo = HijoIzquierdo;
	}
	public void setHijoDerecho(NodoÁrbol HijoDerecho) {
		this.HijoDerecho = HijoDerecho;
	}
}
