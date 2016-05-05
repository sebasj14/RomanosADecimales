package convertidor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Clase de pruebas unitarias para el convertidor de números romanos a
 * decimales.
 * 
 * @author Sebastián Jiménez
 */
public class RomanosADecimalesTest {

	@Test
	public void testConvertir1() {
		int decimalActual = RomanosADecimales.convertirADecimal("I");
		int decimalEsperado = 1;
		assertEquals(decimalEsperado, decimalActual);
	}

	@Test
	public void testConvertir2() {
		int decimalActual = RomanosADecimales.convertirADecimal("II");
		int decimalEsperado = 2;
		assertEquals(decimalEsperado, decimalActual);
	}

	@Test
	public void testConvertir4() {
		int decimalActual = RomanosADecimales.convertirADecimal("IV");
		int decimalEsperado = 4;
		assertEquals(decimalEsperado, decimalActual);
	}

	@Test
	public void testConvertir6() {
		int decimalActual = RomanosADecimales.convertirADecimal("VI");
		int decimalEsperado = 6;
		assertEquals(decimalEsperado, decimalActual);
	}

	@Test
	public void testConvertir9() {
		int decimalActual = RomanosADecimales.convertirADecimal("IX");
		int decimalEsperado = 9;
		assertEquals(decimalEsperado, decimalActual);
	}

	@Test
	public void testConvertir19() {
		int decimalActual = RomanosADecimales.convertirADecimal("XIX");
		int decimalEsperado = 19;
		assertEquals(decimalEsperado, decimalActual);
	}

	@Test
	public void testConvertir391() {
		int decimalActual = RomanosADecimales.convertirADecimal("CCCXCI");
		int decimalEsperado = 391;
		assertEquals(decimalEsperado, decimalActual);
	}

	@Test
	public void testConvertir428() {
		int decimalActual = RomanosADecimales.convertirADecimal("CDXXVIII");
		int decimalEsperado = 428;
		assertEquals(decimalEsperado, decimalActual);
	}

	@Test
	public void testConvertir888() {
		int decimalActual = RomanosADecimales.convertirADecimal("DCCCLXXXVIII");
		int decimalEsperado = 888;
		assertEquals(decimalEsperado, decimalActual);
	}

	@Test
	public void testConvertirNoValido() {
		int decimalActual = RomanosADecimales.convertirADecimal("");
		int decimalEsperado = 0;
		assertEquals(decimalEsperado, decimalActual);

		decimalActual = RomanosADecimales.convertirADecimal("IIII");
		assertEquals(decimalEsperado, decimalActual);

		decimalActual = RomanosADecimales.convertirADecimal("DD");
		assertEquals(decimalEsperado, decimalActual);

		decimalActual = RomanosADecimales.convertirADecimal("VVDX");
		assertEquals(decimalEsperado, decimalActual);

		decimalActual = RomanosADecimales.convertirADecimal("LL");
		assertEquals(decimalEsperado, decimalActual);
	}
}
