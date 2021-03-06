package Árboles_binarios;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		int opción = 0, elemento;
		/*
		 * La opción me servirá como variable del menú
		 * El elemento me servirá como variable que reciba los valores que deben contener los datos
		 */
		String RIO = "", RPO = "", RPtO = "";
		/*
		 * String nombre;
		 * Nombre aún no se usará, quizás pasará a eliminarse.
		 * Creo tres cadenasString nombre
		 *  RIO: Recorrido In-Order, que me servirá para almacenar los nodos del árbol según el recorrido "In Order"
		 *  RPO: Recorrido Pre-Order, que me servirá para almacenar los nodos del árbol según el recorrido "Pre Order"
		 *  RPtO: Recorrido Post-Order, que me servirá para almacenar los nodos del árbol según el recorrido "Post Order"
		 */
		ÁrbolBinario arbolito = new ÁrbolBinario();
		ArrayList<Integer> RecorridoIO;
		ArrayList<Integer> RecorridoPO;
		ArrayList<Integer> RecorridoPtO;
		/*
		 * Creo dos vectores dinámicos de tal forma que sean una copia de los anteriores creados en la clase
		 * ÁrbolBinario, de esta forma si hago alguna modificación en la función principal no pierdo los datos 
		 * originales.
		 */
		do {
			try {
				opción = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Agregar un Nodo\n"
						+ "2. Recorrer el árbol InOrder\n"
						+ "3. Recorrer el árbol PreOrder\n"
						+ "4. Recorrer el árbol PostOrder\n"
						+ "5. Buscar un nodo en el árbol\n"
						+ "6. Calcular el tamaño del árbol\n"
						+ "7. Eliminar un nodo del árbol\n"
						+ "8. Salir\n"
						+ "Elige una opción:", "Menú", JOptionPane.QUESTION_MESSAGE));
				switch(opción) {
					case 1:
						elemento = Integer.parseInt(JOptionPane.showInputDialog(null, 
								"Ingrese un valor para el nodo:", "Agregando elementos", 
								JOptionPane.QUESTION_MESSAGE));
						/*
						 * nombre = JOptionPane.showInputDialog(null,
						 * "Ingrese un nombre al nodo", "Agregando elementos",
						 * JOptionPane.QUESTION_MESSAGE);
						 * 
						 * Por el momento no se utilizará el nombre de los nodos.
						 */
						arbolito.AgregarNodo(elemento);
						break;
					case 2:
						if(!arbolito.Empty()) {
							RecorridoIO = new ArrayList<Integer>(arbolito.InOrder(arbolito.getRaíz()));
							/*
							 * Aquí se realiza la copia de vectores dinámicos, primero se copia el Recorrido
							 * In Order, utilizando el método "InOrder" de la clase ÁrbolBinario
							 */	
							for(int i = 0; i < RecorridoIO.size(); i++) {
								if(i < RecorridoIO.size() - 1) {
									RIO = RIO + RecorridoIO.get(i) +", ";
								}
								else {
									RIO = RIO +  RecorridoIO.get(i) + "\n";
								}
							}
							JOptionPane.showMessageDialog(null, "El recorrido In Order es:\n" + RIO,
								"Recorrido InOrder", JOptionPane.INFORMATION_MESSAGE);
							arbolito.InOrder(arbolito.getRaíz()).clear();
							RIO = "";
							/*
							 * Limpiamos el ArrayList "InOrder" para que no acumule repetidamente los valores que
							 * ya tenía previamente, es decir, si no se limpia el ArrayList se irá acumulando lo 
							 * que anteriormente lo que tenía, por ejemplo: si antes el ArrayList tenía los sigui-
							 * entes elementos: 3, 8, 10; al volver a seleccionar la opción 2 imprimirá:
							 * 3, 8, 10, 3, 8, 10 y así sucesivamente. Igualmente hay que limpiar la cadena para
							 * que no imprima dos veces.
							 */
						}
						else {
							JOptionPane.showMessageDialog(null, "El árbol está vacío",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 3:
						if(!arbolito.Empty()) {
							RecorridoPO = new ArrayList<Integer>(arbolito.PreOrder(arbolito.getRaíz()));
							/*
							 * Aquí se realiza la copia de vectores dinámicos, primero se copia el Recorrido
							 * Pre Order, utilizando el método "PreOrder" de la clase ÁrbolBinario
							 */
							for(int i = 0; i < RecorridoPO.size(); i++) {
								if(i < RecorridoPO.size() - 1) {
									RPO = RPO + RecorridoPO.get(i) +", ";
								}
								else {
									RPO = RPO +  RecorridoPO.get(i) + "\n";
								}
							}
							JOptionPane.showMessageDialog(null, "El recorrido Pre Order es:\n" + RPO,
								"Recorrido PreOrder", JOptionPane.INFORMATION_MESSAGE);			
							arbolito.PreOrder(arbolito.getRaíz()).clear();
							RPO = "";
							/*
							 * Limpiamos el ArrayList "PreOrder" para que no acumule repetidamente los valores que
							 * ya tenía previamente, es decir, si no se limpia el ArrayList se irá acumulando lo 
							 * que anteriormente lo que tenía, por ejemplo: si antes el ArrayList tenía los sigui-
							 * entes elementos: 8, 3, 10; al volver a seleccionar la opción 2 imprimirá:
							￼ * 8, 3, 10, 8, 3, 10 y así sucesivamente. Igualmente hay que limpiar la cadena para
							 * que no imprima dos veces.
							 */
						}
						else {
							JOptionPane.showMessageDialog(null, "El árbol está vacío",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 4:
						if(!arbolito.Empty()) {
							RecorridoPtO = new ArrayList<Integer>(arbolito.PostOrder(arbolito.getRaíz()));
							/*
							 * Aquí se realiza la copia de vectores dinámicos, primero se copia el Recorrido
							 * Pre Order, utilizando el método "PreOrder" de la clase ÁrbolBinario
							 */
							for(int i = 0; i < RecorridoPtO.size(); i++) {
								if(i < RecorridoPtO.size() - 1) {
									RPtO = RPtO + RecorridoPtO.get(i) +", ";
								}
								else {
									RPtO = RPtO +  RecorridoPtO.get(i) + "\n";
								}
							}
							JOptionPane.showMessageDialog(null, "El recorrido Post Order es:\n" + RPtO,
								"Recorrido PreOrder", JOptionPane.INFORMATION_MESSAGE);			
							arbolito.PostOrder(arbolito.getRaíz()).clear();
							RPtO = "";
							/*
							 * Limpiamos el ArrayList "PreOrder" para que no acumule repetidamente los valores que
							 * ya tenía previamente, es decir, si no se limpia el ArrayList se irá acumulando lo 
							 * que anteriormente lo que tenía, por ejemplo: si antes el ArrayList tenía los sigui-
							 * entes elementos: 3, 10, 8; al volver a seleccionar la opción 2 imprimirá:
							 * 3, 10, 8, 3, 10, 8 y así sucesivamente. Igualmente hay que limpiar la cadena para
							 * que no imprima dos veces.
							 */
						}
						else {
							JOptionPane.showMessageDialog(null, "El árbol está vacío",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 5:
						if(!arbolito.Empty()) {
							elemento = Integer.parseInt(JOptionPane.showInputDialog(null, 
									"Ingrese un número a buscar en el árbol:", "Buscando nodos",
									JOptionPane.INFORMATION_MESSAGE));
							if(arbolito.buscador(elemento) != null) {
								JOptionPane.showMessageDialog(null, "El nodo se encuentra en el árbol",
										"Nodo encontrado", JOptionPane.INFORMATION_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "El nodo no se encuentra en el árbol",
										"Error", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "El árbol está vacío",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 6:
						/*
						 * Para determinar el tamaño del árbol primero verificaremos que este no se encuentre 
						 * vacío, luego tendremos que establecer la altura del árbol llamando al método
						 * "setAltura", el cual a su vez llamará al método "tamaño", el cual nos devolverá
						 * el tamaño del árbol.
						 */
						if(!arbolito.Empty()) {
							arbolito.setAltura();
							int tam = arbolito.getAltura();
							JOptionPane.showMessageDialog(null, "La altura del árbol es: "+tam,
									"Altura del árbol", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null, "Él árbol está vacío",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 7:
						if(!arbolito.Empty()) {
							elemento = Integer.parseInt(JOptionPane.showInputDialog(null, 
									"Ingrese un número a eliminar en el árbol:", "Eliminando nodos",
									JOptionPane.INFORMATION_MESSAGE));
							if(!arbolito.eliminar(elemento)) {
								JOptionPane.showMessageDialog(null, "El nodo no se encuentra en el árbol",
										"Error", JOptionPane.ERROR_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, "El nodo fue eliminado con éxito",
										"Nodo Eliminado", JOptionPane.INFORMATION_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "El árbol está vacío",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
						break;
					case 8:
						JOptionPane.showMessageDialog(null,
								"Aplicación finalizada", "Fin",
								JOptionPane.INFORMATION_MESSAGE);
						break;
					default:
						JOptionPane.showMessageDialog(null,
								"Opción no válida", "Error",
								JOptionPane.ERROR_MESSAGE);
				}
			}catch(NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Error " +n.getMessage());
			}
		}while(opción != 8);
	}

}