package Árboles_binarios;

import java.util.ArrayList;

public class ÁrbolBinario {
	private NodoÁrbol raíz;
	private int altura;
	private ArrayList<Integer> RecorrerInOrder = new ArrayList<Integer>();
	private ArrayList<Integer> RecorrerPreOrder = new ArrayList<Integer>();
	private ArrayList<Integer> RecorrerPostOrder = new ArrayList<Integer>();
	/* Ahora se usarán vectores dinámicos para almacenar los recorridos que posteriormente servirán para 
	 * calcular la matriz de adyacencia del árbol que desee y así poder graficarlo.
	 */
	
	//Constructor
	public ÁrbolBinario(){
		setRaíz(null);
		altura = 0;
	}
	
	//Métodos
	
	//Agregar nodo
	public void AgregarNodo(int dato) {
		NodoÁrbol nuevo = new NodoÁrbol(dato); 
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
	
	//Recorrido PostOrder
		/*
		 * El recorrido PreOrder se hace de la siguiente manera:
		 * Hijo izquierdo -> Hijo Derecho -> Raíz  
		 * Hay que realizar las siguientes operaciones de forma pseudo recursiva
		 * 1) Recorrer el subárbol izquierdo PostOrder
		 * 2) Recorrer el subárbol derecho PostOrder
		 * 3) Examinar la raíz
		 * Finalmente, este método nos devolverá un vector dinámico que contiene todos los nodos ya ordenados.
		 */
		
	public ArrayList<Integer> PostOrder(NodoÁrbol raíz) {
		if(raíz != null) {
			PostOrder(raíz.getHijoIzquierdo());
			PostOrder(raíz.getHijoDerecho());
			RecorrerPostOrder.add(raíz.getDato());
			/*
			 * Se va agregando cada uno de los datos al vector dinámico
			*/
		}
		return getRecorrerPostOrder();
		}
	
	//Método para buscar un nodo
	/*
	 * Para poder buscar un nodo debemos recorrer el árbol, primero solicitaremos el dato que se quiere buscar
	 * y luego veremos si el nodo se encuentra o no el árbol, de encontrarse lo devolvermos, y si no es el caso
	 * retornaremos null
	 */
	public NodoÁrbol buscador(int dato) {
		NodoÁrbol auxiliar = raíz;
		while(dato != auxiliar.getDato()) {
			if(dato < auxiliar.getDato()) {
				auxiliar = auxiliar.getHijoIzquierdo();
			}else {
				auxiliar = auxiliar.getHijoDerecho();
			}
			if(auxiliar == null) {
				return null;
			}
		}
		return auxiliar;
	}
	
	//Método para obtener el tamaño de un árbol
	/*
	 * Utilizaremos un método recursivo para calcular la altura del árbol, este método funciona de la siguiente 
	 * manera: pediremos la raíz de nuestro árbol y la guardaremos en la variable "noc", en caso nuestro árbol 
	 * esté vacío nuestro tamaño tendrá un valor de -1, lo cual indicará que está vacío. En caso contrario
	 * retornaremos el valor de 1 + la longitud máxima que posean o bien el hijo izquierdo o bien el hijo derecho,
	 * así el proceso será una suma de "1s" cada vez que se encuentren hijos derechos o izquierdos. Así es como 
	 * obtendremos la altura del árbol.
	 */
	public int tamaño(NodoÁrbol noc) {
		if(noc == null) {
			return -1;
		}else {
			return 1 + Math.max(tamaño(noc.getHijoIzquierdo()), tamaño(noc.getHijoDerecho()));
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
	public ArrayList<Integer> getRecorrerPreOrder() {
		return RecorrerPreOrder;
	}
	public ArrayList<Integer> getRecorrerInOrder() {
		return RecorrerInOrder;
	}
	public ArrayList<Integer> getRecorrerPostOrder() {
		return RecorrerPostOrder;
	}
	public int getAltura() {
		return altura;
	}
	/*
	 * Esta función SET es especial, porque la altura la obtendremos a partir del método tamaño, y nos servirá a 
	 * su vez para hacer la llamada desde la clase principal.
	 */
	public void setAltura() {
		altura = tamaño(raíz);
	}
}
