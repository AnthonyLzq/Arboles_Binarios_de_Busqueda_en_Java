package Árboles_binarios;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		int opción = 0, elemento;
		String nombre, RIO = "", RPO = "";
		/*
		 * Creo dos vectores
		 *  RIO: Recorrido In-Order, que me servirá para almacenar los nodos del árbol según el recorrido "In Order"
		 *  RPO: Recorrido Pre-Order, que me servirá para almacenar los nodos del árbol según el recorrido "Pre Order"
		 */
		ÁrbolBinario arbolito = new ÁrbolBinario();
		ArrayList<Integer> RecorridoIO;
		ArrayList<Integer> RecorridoPO;
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
						+ "4. Salir\n"
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
						arbolito.AgregarNodo(elemento, null);
						break;
					case 2:
						if(!arbolito.Empty()) {
							RecorridoIO = new ArrayList<Integer>(arbolito.InOrder(arbolito.getRaíz()));
							/*
							 * Aquí se realiza la copia de vectores dinámicos, primero se copia el Recorrido
							 * In Order, utilizando el método "InOrder" de la clase ÁrbolBinario
							 */	
							System.out.println(RecorridoIO.size());
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
							
						}
						else {
							JOptionPane.showMessageDialog(null, "El árbol está vacío",
									"Error", JOptionPane.CANCEL_OPTION);
						}
						break;
					case 3:
						if(!arbolito.Empty()) {
							RecorridoPO = new ArrayList<Integer>(arbolito.PreOrder(arbolito.getRaíz()));
							/*
							 * Aquí se realiza la copia de vectores dinámicos, primero se copia el Recorrido
							 * Pre Order, utilizando el método "PreOrder" de la clase ÁrbolBinario
							 */
							System.out.println(RecorridoPO.size());
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
							 * 8, 3, 10, 8, 3, 10 y así sucesivamente. Igualmente hay que limpiar la cadena para
							 * que no imprima dos veces.
							 */
						}
						else {
							JOptionPane.showMessageDialog(null, "El árbol está vacío",
									"Error", JOptionPane.CANCEL_OPTION);
						}
						break;
					case 4:
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
		}while(opción != 4);
	}

}
