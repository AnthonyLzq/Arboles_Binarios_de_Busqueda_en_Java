package Árboles_binarios;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		int opción = 0, elemento;
		String nombre;
		ÁrbolBinario arbolito = new ÁrbolBinario();
		do {
			try {
				opción = Integer.parseInt(JOptionPane.showInputDialog(null,
						"1. Agregar un Nodo\n"
						+ "2. Recorrer el árbol InOrden\n"
						+ "3. Salir\n"
						+ "Elige una opción:", "Menú", JOptionPane.QUESTION_MESSAGE));
				switch(opción) {
					case 1:
						elemento = Integer.parseInt(JOptionPane.showInputDialog(null, 
								"Ingrese un valor para el nodo:", "Agregando elementos", 
								JOptionPane.QUESTION_MESSAGE));
						nombre = JOptionPane.showInputDialog(null,
								"Ingrese un nombre al nodo", "Agregando elementos",
								JOptionPane.QUESTION_MESSAGE);
						arbolito.AgregarNodo(elemento, nombre);
						break;
					case 2:
						arbolito.InOrden(arbolito.getRaíz());
						break;
					case 3:
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
		}while(opción != 3);
	}

}
