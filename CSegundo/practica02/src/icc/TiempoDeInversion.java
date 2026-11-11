	/**
 	* Programa main que ejecuta operaciones con fechas
 	* @author Cassandra Segundo
 	* @version 1a version
 	* */

	import java.util.Scanner;

	/**
 	* Clase que contiene las operaciones con fechas
 	* <p>
 	* Parámetros variables según los métodos a usar.
 	* @see Fecha
 	* */

		public class TiempoDeInversion{

        	public static void main(String [] args){
		// Declaración de los elementos a usar (Scanner y String)

        	Scanner in = new Scanner(System.in);
                	String nombreUsuario = new String();
                	String mesUsuario = new String();
                	String mesFin = new String();
                	String respuesta = new String();

		//Impresión del mensaje de bienvenida

          	System.out.println("Bienvenido a BanCoppel, ¿cuál es su nombre?");
	  	//Captura del nombre del Usuario
          	nombreUsuario = in.nextLine();
          	System.out.println("Saludos, "+ nombreUsuario + ".");

	 	//Bloque de código donde preguntaremos sobre fechas y haremos las operaciones
         	do{
			 //Captura de información
          	System.out.println("¿Cuánto deseas invertir?");  
          	int monto = in.nextInt();
          	System.out.println("¿Desde que fecha inicia su inversión?");
          	System.out.println("Introduzca el dia");
          	int diaUsuario = in.nextInt();
          	System.out.println("Introduzca el mes");
          	mesUsuario = in.next();
          	System.out.println("Introduzca el año");
          	int yearUsuario = in.nextInt();

	  	//Creación de la fecha1
          	Fecha fecha1 = new Fecha(diaUsuario, mesUsuario, yearUsuario);
		
	  	//Captura de información de fecha final de inversión.
          	System.out.println("¿Cuándo desea terminar esta inversión?");
	  	System.out.println("Introduzca el dia");
          	int diaFin = in.nextInt();
          	System.out.println("Introduzca el mes");
          	mesFin = in.next();
          	System.out.println("Introduzca el año");
          	int yearFin = in.nextInt();
	
	  	//Creación de fecha final
          	Fecha fecha2 = new Fecha(diaFin, mesFin, yearFin);

	
	  	//Prueba sobre el constructor por defecto
	  	//Fecha fecha3 = new Fecha();

	  	//Pruebas sobre los formatos aceptados y el funcionamiento de calcularDiasMes() y sumaOresta()
	  	//System.out.println(fecha1.obtenerFecha());
	  	//System.out.println(fecha2.obtenerFechaFormato());
	  	//System.out.println(fecha3.obtenerFecha());
	  	//System.out.println(fecha1.calcularDiasMes(diaUsuario, fecha1.obtenerNumMes(mesUsuario)));
	  	//System.out.println((fecha2.sumaOresta((-9))).obtenerFecha());
		
	  	//Verificación de la validez de fechas tal que los datos entren en su respectivo rango
	  	if(fecha1.validez(diaUsuario, fecha1.obtenerNumMes(mesUsuario)) != true || fecha2.validez(diaFin, fecha2.obtenerNumMes(mesFin)) != true){
		  
			System.out.println("Sus datos de entrada son incorrectos en mes o día, recuerde que el cálculo puede ser erróneo.");
	  	}
		
	  	//Verificación de fechas tal que la fecha de inicio sea anterior a la fecha final de inversión
	  	int fechaSuma = 0;
	  	if(fecha1.sumaTotal() < fecha2.sumaTotal()){
          	fechaSuma = fecha1.obtenerDiferencia(fecha2);
	  	}else{
			System.out.println("Favor de introducir fechas válidas, el año inicial debe ser anterior al final.");
	  	}
	
	  	//Cálculo del rendimiento diario esperado multiplicado por el número de dias
          	System.out.println("Su inversión duraría: " +fechaSuma+ " días.");
          	double rendimiento = (fechaSuma * (0.12/365) * monto);
		
	  	//Impresión del rendimiento y captura de respuesta para repetir el ciclo
          	System.out.println("Su rendimiento a un 12% sería de: " + rendimiento);
          	System.out.println("Desea hacer otra simulación?");
          	respuesta = in.next();
          	respuesta = respuesta.trim().toLowerCase();
	  
	  	}
	  
          	while(respuesta.equals("si") || respuesta.equals("sí"));

		}

  	}


