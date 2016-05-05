package convertidor;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase de utilidad para convertir números romanos a decimales.
 * 
 * @author Sebastián Jiménez
 */
public class RomanosADecimales {

	private static final Map<Character, Integer> NUMEROS_ROMANOS = new HashMap<>();

	static {
		NUMEROS_ROMANOS.put('I', 1);
		NUMEROS_ROMANOS.put('V', 5);
		NUMEROS_ROMANOS.put('X', 10);
		NUMEROS_ROMANOS.put('L', 50);
		NUMEROS_ROMANOS.put('C', 100);
		NUMEROS_ROMANOS.put('D', 500);
		NUMEROS_ROMANOS.put('M', 1000);
	}

	// FIXME: Verificar números no válidos. Los de 1 no repiten más de 3, los de
	// 5 no repiten.
	public static int convertirADecimal(String numeroRomano) {
		numeroRomano = numeroRomano.toUpperCase();

		char romanoActual;
		int romanoEnDecimal = 0;

		int decimalPrevio = 0;
		int decimalActual = 0;

		for (int i = numeroRomano.length() - 1; i >= 0; i--) {
			romanoActual = numeroRomano.charAt(i);
			decimalActual = NUMEROS_ROMANOS.get(romanoActual);

			if (decimalPrevio <= decimalActual) {
				romanoEnDecimal += decimalActual;
			} else {
				romanoEnDecimal -= decimalActual;
			}
			decimalPrevio = decimalActual;
		}

		return romanoEnDecimal;
	}
}
