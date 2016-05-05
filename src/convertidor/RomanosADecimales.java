package convertidor;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase de utilidad para convertir números romanos a decimales.
 * 
 * @author Sebastián Jiménez
 */
public class RomanosADecimales {
	/** Expresiones regulares para validar la sintaxis de los números romanos. */
	private static final String REGEX_INVALIDA = "(\\w*?I{4,}\\w*?)|(\\w*?V{2,}\\w*?)|(\\w*?X{4,}\\w*?)|(\\w*?L{2,}\\w*?)|"
			+ "(\\w*?C{4,}\\w*?)|(\\w*?D{2,}\\w*?)|(\\w*?M{4,}\\w*?)";
	private static final String REGEX_VALIDA = "[I*?V*?X*?L*?C*?D*?M*?]*";

	/** Mapa de números romanos con su equivalente en decimal. */
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

	/**
	 * Convierte un número romano entre 1 y 1000 a su equivalente en decimal.
	 * 
	 * @param numeroRomano
	 *          Número escrito en romano.
	 * @return - Equivalente en decimal. <br>
	 *         <t> - 0 si el número romano ingresado no es válido.
	 */
	public static int convertirADecimal(String numeroRomano) {
		numeroRomano = numeroRomano.toUpperCase();

		if (!numeroRomanoEsValido(numeroRomano)) {
			return 0;
		}

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

	/**
	 * Valida si el número romano está bien escrito.
	 * 
	 * @param numeroRomano
	 *          Número romano a verificar.
	 * @return true si la sintaxis del número romano es válida, false de lo
	 *         contrario.
	 */
	private static boolean numeroRomanoEsValido(String numeroRomano) {
		return !numeroRomano.matches(REGEX_INVALIDA) && numeroRomano.matches(REGEX_VALIDA);
	}
}
