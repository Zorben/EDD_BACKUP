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
		if (cadena==null)
			return false;
		else{
			String original = cadena.replaceAll("[^\\p{L}\\p{Nd}]+", ""); // borra todo aquel caracter que no es a-z
			original.toLowerCase(); // minusculas
			original=original.trim(); // sin espacios
			String reverse = "";
			for (int j = original.length() - 1; j >= 0; j--) {
					reverse += cadena.charAt(j);
			}
			return original.equals(reverse);
		}
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		String[] decenas = {"","Diez","Veinte","Treinta","Cuarenta","Cincuenta",
				  "Sesenta","Setenta","Ochenta","Noventa"};

		  String[] unidades = {"Cero","uno","dos","tres","cuatro","cinco","seis","siete",
				  "ocho","nueve","Diez","Once","Doce","Trece","Catorce","Quince","Dieciseis",
				  "Diecisiete","Dieciocho","Diecinueve"};
	  
		  String numero="";
		  
		  if(n==0){
			  numero=unidades[0];
			  return numero;
		  }
		  else if(n>0 && n<20){
			  numero=unidades[n];
			  if (n>0 && n<10) // primera letra mayuscula si n es 1-9
				  numero=numero.substring(0, 1).toUpperCase() + numero.substring(1);
			  return numero;
		  }
		  else if((n%10)==0){
			  numero=decenas[n/10];
			  return numero;
		  }
		  else{
			  numero=decenas[n/10]+ " y " +unidades[n%10];
			  return numero;
		  }
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (!isValidDate(fecha))
			return false;
		/* la fecha es valida */
		else{
			int anyo=Integer.parseInt(fecha.substring(6));
			GregorianCalendar f = new GregorianCalendar();
			return f.isLeapYear(anyo);
		}
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		int day, month, year;	
		
		try{
			day=Integer.parseInt(date.substring(0, 2));
			month=Integer.parseInt(date.substring(3,5));
			year=Integer.parseInt(date.substring(6));
			
		}catch(IndexOutOfBoundsException i){
			return false;
		}catch (NumberFormatException e) {
			return false;
		}
		if (date==null) 
			return false;
		
		/* si se ha extraido dia, mes y anio con exito */
		
		else if(year>0){
			switch(month){
				/* meses de 31 */
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:				
					if(day>0 && day<=31)
						return true;
						break;
				/* meses de 30 */
				case 4:
				case 6:
				case 9:
				case 11:
					if(day>0 && day<=30)
						return true;
						break;
				/* febrero */
				case 2:
					if(day<=28 && day>0)
						return true;
						break;
			}
		}
		return false;
	}
}
