package conversorDeMonedas;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConversorDeMonedas extends JFrame{
	private String eleccion1, eleccion2;
	private Double cantidad, resultado1; 
	
	public ConversorDeMonedas() {
		getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Conversor de Monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
        setResizable(false);
        setSize(500, 400);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        
		iniciar();
	}
	
	public void iniciar() {
		seleccionar();
	}
	
	
	public void seleccionar() {
		 eleccion1 = null;
		 
		while (eleccion1 == null) {
 
			try {
				eleccion1 = JOptionPane.showInputDialog(null, "Seleccione una opción de conversión", "Menú",JOptionPane.INFORMATION_MESSAGE
					    , null,new Object[] {"Conversor de Moneda", "Conversor de Temperatura"}, 
					    "Conversor de Moneda").toString();
				
					if(eleccion1.equals("Conversor de Moneda")) {
						ingresarCantidad();
						seleccionarMoneda(); 
						resultado();
						preguntar();
					}else if(eleccion1.equals("Conversor de Temperatura")) {
						ingresarCantidad();
						seleccionarUnidad();
						resultado2();
						preguntar();
					}
			}
			catch (Exception ex) {
				seleccionar();
			}
		}
		
		
	}
	 
	public void ingresarCantidad() {
			cantidad = null;
			 
			while (cantidad == null) {
	 
				try {
					cantidad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad a convertir", 
							"Ingresar Cantidad", JOptionPane.QUESTION_MESSAGE));
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null,"ERROR. Introduzca valores numéricos", "Error", JOptionPane.ERROR_MESSAGE);
					seleccionar();
				}
			}
		}
	
	public void seleccionarMoneda() {
		eleccion2 = JOptionPane.showInputDialog(null, "Seleccione la moneda a la que desea convertir", "Moneda", 
				           JOptionPane.QUESTION_MESSAGE, null, new Object[] {"De Pesos a Dólar", "De Pesos a Euro", 
				           "De Pesos a Libra", "De Pesos a Yen", "De Pesos a Won Coreano", "De Dólar a Pesos", 
				           "De Euro a Pesos", "De Libra a Pesos", "De Yen a Pesos", "De Won Coreano a Pesos"}, 
				           "De Pesos a Dólar").toString();
	}
	
	public void resultado() {
		switch (eleccion2) {
		case "De Pesos a Dólar":
			calcularPesoAMoneda(cantidad, 18.11);
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Dólares", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Pesos a Euro":
			calcularPesoAMoneda(cantidad, 19.11); 
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Euros", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Pesos a Libra":
			calcularPesoAMoneda(cantidad, 21.43); 
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Libras", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Pesos a Yen":
			calcularPesoAMoneda(cantidad, 0.13); 
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Yenes", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Pesos a Won Coreano":
			calcularPesoAMoneda(cantidad, 0.014); 
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Wones", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Dólar a Pesos":
			calcularMonedaAPeso(cantidad, 18.11);
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Pesos", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Euro a Pesos":
			calcularMonedaAPeso(cantidad, 19.11); 
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Pesos", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Libra a Pesos":
			calcularMonedaAPeso(cantidad, 21.43); 
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Pesos", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Yen a Pesos":
			calcularMonedaAPeso(cantidad, 0.13); 
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Pesos", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Won Coreano a Pesos":
			calcularMonedaAPeso(cantidad, 0.014); 
			JOptionPane.showMessageDialog(null, "Tienes: " + resultado1 + " Pesos", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break; 
 
		default:
			JOptionPane.showMessageDialog(null, "Opción Inválida");
			break;
		}
	}
	
	public void calcularPesoAMoneda(Double cantidad, Double precio) {
		resultado1 = cantidad / precio; 
		resultado1 = (double) Math.round(resultado1 * 100d)/100;
	}
	
	public void calcularMonedaAPeso(Double cantidad, Double precio) {
		resultado1 = cantidad * precio;
		resultado1 = (double) Math.round(resultado1 * 100d)/100;
	}
	
	public void calcularCelciusAFarenheit(Double cantidad) {
		resultado1 = (cantidad * 9 / 5) + 32;
		resultado1 = (double) Math.round(resultado1 * 100d)/100; 
	} 
	
	public void calcularFarenheitACelcius(Double cantidad) { 
		resultado1 = (cantidad - 32) * 5/9; 
		resultado1 = (double) Math.round(resultado1 * 100d)/100; 
	} 
	
	public void preguntar() {
		int codigo = JOptionPane.showConfirmDialog(null, "¿Desea continuar?", "¿?", JOptionPane.INFORMATION_MESSAGE);
		if(codigo == JOptionPane.YES_OPTION) {
			iniciar();
		}else if(codigo == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Programa Terminado", "Salir",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}else if(codigo == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Programa Terminado", "Salir",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
	
	public void seleccionarUnidad() {
		eleccion2 = JOptionPane.showInputDialog(null, "Seleccione la unidad a la que desea convertir", "Temperatura", 
		           JOptionPane.QUESTION_MESSAGE, null, new Object[] {"De Celsius a Fahrenheit", "De Fahrenheit a Celsius"}, 
		           "De Celsius a Fahrenheit").toString();
	}
	
	public void resultado2() {
		switch (eleccion2) {
		case "De Celsius a Fahrenheit":
			calcularCelciusAFarenheit(cantidad); 
			JOptionPane.showMessageDialog(null, resultado1 + " grados Fahrenheit", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
			
		case "De Fahrenheit a Celsius":
			calcularFarenheitACelcius(cantidad); 
			JOptionPane.showMessageDialog(null, resultado1 + " grados Celsius", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opción Inválida", "Resultado", 
			JOptionPane.WARNING_MESSAGE);
			break;
		}
	}
}
