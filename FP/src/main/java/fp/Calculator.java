package fp;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.*;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		return x.getClass();
	}


	/*
     * devuelve una lista con los n numeros de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		List<Integer> Lista = new ArrayList<Integer>();
		Integer primero=1;
		Integer segundo=1;
		switch(n){
			case 1: Lista.add(primero);
			case 2: Lista.add(primero); Lista.add(segundo);
			default:
				Lista.add(primero); Lista.add(segundo);
				for(int i=2; i<n;i++){
					Lista.add(Lista.get(i-2)+Lista.get(i-1));
				}
		}
		return Lista;
	}

	/*
	 * Escribir todos los numeros del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		/* uso de ArrayList en vez de array por no saber de antemano el tama�o del mismo*/
		List<Integer> lista= new ArrayList();
		int dato=number-step;
		while(dato>0){
			lista.add(dato);
			dato=dato-step;
		}
		/* una vez ArrayList lleno ya se crea el array de enteros */
		int vector[]=new int[lista.size()];
		for (int i=0;i<lista.size();i++)
			vector[i]=lista.get(i);

		return vector;
	}

	/*
	 * Modulo al que se le pasa un numero entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		List<Integer> lista= new ArrayList();
		int divisor=n;

		if(n>0){
			while(divisor>0){
				if(n%divisor==0){
					lista.add(divisor);
					divisor--;
				}
				else
					divisor--;
			}
		}
		else if(n<=0)
				return null;

		int divisores[]=new int[lista.size()];
		for (int i=0;i<lista.size();i++)
			divisores[i]=lista.get(i);

		return divisores;

	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String cadena) {
		/*String vuelta="";
		for (int i=cadena.length()-1;i>=0;i--)
			vuelta=vuelta + cadena.charAt(i);
		return cadena.equals(vuelta);*/
		String reverse = "";
		for (int j = cadena.length() - 1; j >= 0; j--) {
				reverse += cadena.charAt(j);
		}
		return cadena.equals(reverse);
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		throw  new NotImplementedException();
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		throw  new NotImplementedException();
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		throw  new NotImplementedException();
	}
}
