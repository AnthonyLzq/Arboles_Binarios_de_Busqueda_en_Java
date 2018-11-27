package Árboles_binarios;

public class ÁrbolBinario {
	private NodoÁrbol raíz;
	//Constructor
	public ÁrbolBinario(){
		setRaíz(null);
	}
	//Métodos
	//Agregar nodo
	public void AgregarNodo(int dato, String nombre) {
		NodoÁrbol nuevo = new NodoÁrbol(dato, nombre); 
		if(!Empty()) {
			NodoÁrbol auxiliar = raíz;
			NodoÁrbol padre;
			while(true) {
				padre = auxiliar;
				if(dato < auxiliar.getDato()) {
					auxiliar = auxiliar.getHijoIzquierdo();
					if(auxiliar == null) {
						padre.setHijoIzquierdo(nuevo);
						return;
					}
				}
				else {
					auxiliar = auxiliar.getHijoDerecho();
					if(auxiliar == null) {
						padre.setHijoDerecho(nuevo);
						return;
					}
				}
			}
		}else {
			setRaíz(nuevo);
		}
	}
	//Recorrido InOrden
	/*
	 * El recorrido InOrden se hace de la siguiente manera: 
	 *  Hijo Izquierdo -> Raíz -> Hijo Derecho
	 *  Hay que realizar las siguientes operaciones de forma pseudo recursiva
	 *  1) Recorrer el subárbol izquierdo InOrden
	 *  2) Examinar la raíz
	 *  3) Recorrer el subárbol derecho InOrden
	 */
	
	public void InOrden(NodoÁrbol raíz) {
		if(raíz != null) {
			InOrden(raíz.getHijoIzquierdo());
			System.out.println(raíz.getDato());
			InOrden(raíz.getHijoDerecho());
		}
	}
	
	//Ver si el árbol está vacío
	public boolean Empty() {
		return getRaíz() == null;
	}
	
	//Getters && Setters
	public void setRaíz(NodoÁrbol raíz) {
		this.raíz = raíz;
	}
	public NodoÁrbol getRaíz() {
		return raíz;
	}
}
