package Árboles_binarios;

import java.util.ArrayList;

public class ÁrbolBinario {
	private NodoÁrbol raíz;
	private ArrayList<Integer> RecorrerInOrder = new ArrayList<Integer>();
	private ArrayList<Integer> RecorrerPreOrder = new ArrayList<Integer>();
	/* Ahora se usarán vectores dinámicos para almacenar los recorridos que posteriormente servirán para 
	 * calcular la matriz de adyacencia del árbol que desee y así poder graficarlo.
	 */
	
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
	//Recorrido InOrder
	/*
	 * El recorrido InOrder se hace de la siguiente manera: 
	 *  Hijo Izquierdo -> Raíz -> Hijo Derecho
	 *  Hay que realizar las siguientes operaciones de forma pseudo recursiva
	 *  1) Recorrer el subárbol izquierdo InOrder
	 *  2) Examinar la raíz
	 *  3) Recorrer el subárbol derecho InOrder
	 *  Finalmente, este método nos devolverá un vector dinámico que contiene todos los nodos ya ordenados.
	 */
	
	public ArrayList<Integer> InOrder(NodoÁrbol raíz) {
		if(raíz != null) {
			InOrder(raíz.getHijoIzquierdo());
			RecorrerInOrder.add(raíz.getDato());
			/*
			 * Se va agregando cada uno de los datos al vector dinámico
			 */
			InOrder(raíz.getHijoDerecho());
		}
		return getRecorrerInOrder();
	}
	//Recorrido PreOrder
	/*
	 * El recorrido PreOrder se hace de la siguiente manera:
	 * Raíz -> Hijo izquierdo -> Hijo Derecho
	 * Hay que realizar las siguientes operaciones de forma pseudo recursiva
	 * 1) Examinar la raíz
	 * 2) Recorrer el subárbol izquierdo PreOrder
	 * 3) Recorrer el subárbol derecho PreOrder
	 * Finalmente, este método nos devolverá un vector dinámico que contiene todos los nodos ya ordenados.
	 */
	
	public ArrayList<Integer> PreOrder(NodoÁrbol raíz) {
		if(raíz != null) {
			RecorrerPreOrder.add(raíz.getDato());
			/*
			 * Se va agregando cada uno de los datos al vector dinámico
			 */
			PreOrder(raíz.getHijoIzquierdo());
			PreOrder(raíz.getHijoDerecho());
		}
		return getRecorrerPreOrder();
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
	public ArrayList<Integer> getRecorrerPreOrder() {
		return RecorrerPreOrder;
	}
	public ArrayList<Integer> getRecorrerInOrder() {
		return RecorrerInOrder;
	}
}
