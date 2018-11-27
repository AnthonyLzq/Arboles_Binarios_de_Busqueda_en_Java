package Árboles_binarios;

public class ÁrbolBinario {
	private NodoÁrbol raíz;
	private String recorridoInOrder = "";
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
	/*v
	 * El recorrido InOrder se hace de la siguiente manera: 
	 *  Hijo Izquierdo -> Raíz -> Hijo Derecho
	 *  Hay que realizar las siguientes operaciones de forma pseudo recursiva
	 *  1) Recorrer el subárbol izquierdo InOrder
	 *  2) Examinar la raíz
	 *  3) Recorrer el subárbol derecho InOrder
	 */
	
	public String InOrder(NodoÁrbol raíz) {
		if(raíz != null) {
			InOrder(raíz.getHijoIzquierdo());
			setRecorridoInOrder(Integer.toString(raíz.getDato()));
			InOrder(raíz.getHijoDerecho());
		}
		return getRecorridoInOrder();
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
	public void setRecorridoInOrder(String recorridoInOrder) {
		this.recorridoInOrder = this.recorridoInOrder + " " + recorridoInOrder;
	}
	public String getRecorridoInOrder() {
		return recorridoInOrder;
	}
}
