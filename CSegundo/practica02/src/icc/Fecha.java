	/**
 	* Programa sobre el manejo de fechas y sus operaciones.
 	* @author Cassandra Segundo
 	* @version 1a version
 	*/

	import java.util.Scanner;

	/**
 	* Clase que crea una fecha y maneja sus operaciones
 	*/

	public class Fecha{

   	//Declaración  de atributos
		private int dia;
		private int mes;
		private int year;
	


 	/** Constructor por defecto para la creación de una fecha predeterminada
  	* <p>
  	* La fecha se inicializa como 1/1/2026 al usar el método obtenerFecha().
  	*/

  	public Fecha(){
		dia = 1;
		mes = 1;
		year = 2026;
  	}

  	/** Constructor para la creación de una fecha mediante dias, meses, y año en int.
   	* @param dia El dia designado al crear la fecha
   	* @param mes El mes designado (debe ser numérico)
   	* @param year El año designado
   	* */ 

  	public Fecha(int dia, int mes, int year){
	  	this.dia = dia;
	  	this.mes = mes;
	  	this.year = year;
	
  	}
  
  	/** Constructor para la creación de una fecha mediante int y String mes
  	 * @param dia El dia designado.
  	 * @param mes El mes designado (debe ser una palabra).
  	 * @param year El año designado.
  	 * <p> 
  	 * Crea una fecha cambiando el String por int para usar el resto de métodos.
  	 */

  	public Fecha(int dia, String mes, int year){
		  this.dia = dia;
	  	this.mes = obtenerNumMes(mes);
	  	this.year = year;
 	}
  
  		/**
   		* Método setter para asignar día
   		* @param dia El int dia recibido 
   		*/

		public void asignarDia(int dia){
			this.dia = dia;
		}

		/**
		 * Método getter para obtener día
		 * @return dia
		 * <p>
		 * Para usarlo lo llamamos con un objeto fecha
		 */

		public int obtenerDia(){
			return dia;
		}
	
		/**
		 * Método setter para asignar mes.
		 * @param mes El mes recibido, sea int o String con método auxiliar
		 * <p>
		 * Para usarlo necesitamos un objeto fecha
		 * <p>
		 * Si el mes es String podemos recurrir a métodos auxiliares
		 * @see #obtenerNumMes(String mes)
		 */
	
		/**
	 	* Método setter para asignar mes
	 	* @param mes
	 	* <p>
	 	* Si mes es String podemos recurrir a obtnerNumMes(String mes)
	 	*/

		public void asignarMes(int mes){
			this.mes = mes;
		}

		/**
		 * Método getter para obtener mes
		 * @return mes 
		 */

		public int obtenerMes(){
			return mes;
		}

		/**
		 * Método setter para asignar año
		 * @param year El int del año recibido
		 */

		public void asignarYear(int year){
			this.year = year;
		}


		/**
		 * Método getter para obtener año
		 * @return year
		 */

		public int obtenerYear(){
			return year;
		}
	

		/**
		 * Método para asignar fecha desde int
		 * @param dia El dia recibido como int
		 * @param mes El mes recibido como int
		 * @param year El año recibido como int
		 */

  		public void asignarFecha(int dia, int mes, int year){
			this.dia = dia;
			this.mes = mes;
			this.year = year;
  		}


  		/**
   		* Método que devuelve formato de fecha dd/mm/aaaa 
   		* @return String Devuelve la cadena en el nuevo formato (usar con int mes)
		*/
	
  		public String obtenerFecha(){
			return dia + "/" + mes + "/" + year;
  		}

		/**
		 * Método que obtiene la diferencia de dias entre dos fechas
		 * @param nuevaFecha Objeto Fecha creado mediante constructores
		 * @return diasFecha Regresa el cálculo de dias entre fechas en valor absoluto
		 * <p>
		 * Hace uso de sumaTotal() para encontrar la diferencia positiva de dias
		 * @see #sumaTotal()
		 */

  		public int obtenerDiferencia(Fecha nuevaFecha){
			int diasFecha1 = this.sumaTotal();
			int diasFecha2 = nuevaFecha.sumaTotal();

		if(diasFecha1 - diasFecha2 > 0){
			return(diasFecha1 - diasFecha2);
		}else{
			return((diasFecha1 - diasFecha2)*(-1));
			}
   		}

   		/**
		 * Método que calcula la suma de dias en el año 
		 * @param dia El int dia de la fecha
		 * @param mes El int del mes perteneciente a la fecha
		 * <p>
		 * Considera cada limite de dias por cada mes tomando en cuenta si el año tiene 365 o 366 días para la modificación de febrero (mes 2)
		 * @return totalDias 
		 */

		public int calcularDiasMes(int dia, int mes){
			int diasMes = 0;
			int totalDias = 0;	
	
			int m = 1;
		while(m < this.mes){
	        if(m == 1){
                	diasMes = 31;
	        }else if(m == 2){

                	if(this.year % 4 == 0){
                		diasMes = 29;
                	}else{
                        	diasMes = 28;
                	}
        	}else if(m == 3){
                	diasMes = 31;
        	}else if(m == 4){
                	diasMes = 30;
        	}else if(m == 5){
                	diasMes = 31;
        	}else if(m == 6){
                	diasMes = 30;
        	}else if(m == 7){
                	diasMes = 31;
        	}else if(m == 8){
                	diasMes = 31;
        	}else if(m == 9){
                	diasMes = 30;
        	}else if(m == 10){
                	diasMes = 31;
        	}else if(m == 11){
                	diasMes = 30;
        	}else if(m == 12){
			 diasMes = 31;
        	}else{
                	diasMes = 0;
        	}
                	totalDias += diasMes;
                	m += 1;
		}
	
        	totalDias += this.dia;
			return totalDias;
		}
	
		/**
		 * Método que calcula los dias en el año
		 * @param year El int año recibido por la fecha 
		 * @return sumaYears
		 * <p>
		 * Considera las reglas para ver los años bisiestos.
		 */

		public int calcularDiasYear(int year){

		int sumaYears = 0;
        	int bisiestos = (this.year-1) / 4 - (this.year-1) / 100 + (this.year-1) / 400;
        	sumaYears = ((this.year-1) *365) + bisiestos;
			return sumaYears;
		}

		/**
	 	* Método que realiza la suma total de dias según la fecha
	 	* @return sumaTotal
	 	* @see #calcularDiasYear
	 	* @see #calcularDiasMes
	 	*/

		public int sumaTotal(){
			int sumaTotal = 0;
		sumaTotal = calcularDiasYear(this.year) + calcularDiasMes(this.dia, this.mes);
			return sumaTotal;
		}

		/**
		 * Método que obtiene el número de un mes según su String
		 * @param mes El String mes de la fecha
		 * @return this.mes (int del mes)
		 */

		public int obtenerNumMes(String mes){
	   			mes = mes.toLowerCase();
          		if(mes.equals("enero") || mes.equals("1")){
                		this.mes = 1;
          		}else if(mes.equals("febrero") || mes.equals("2")){
                		this.mes = 2;
          		}else if(mes.equals("marzo") || mes.equals("3")){
                		this.mes = 3;
          		}else if(mes.equals("abril") || mes.equals("4")){
                		this.mes = 4;
          		}else if(mes.equals("mayo") || mes.equals("5")){
                		this.mes = 5;
          		}else if(mes.equals("junio") || mes.equals("6")){
                		this.mes = 6;
          		}else if(mes.equals("julio") || mes.equals("7")){
                		this.mes = 7;
          		}else if(mes.equals("agosto") || mes.equals("8")){
                		this.mes = 8;
          		}else if(mes.equals("septiembre") || mes.equals("9")){
                		this.mes = 9;
          		}else if(mes.equals("octubre") || mes.equals("10")){
                		this.mes = 10;
          		}else if(mes.equals("noviembre") || mes.equals("11")){
                		this.mes = 11;
          		}else if(mes.equals("diciembre") || mes.equals("12")){
                		this.mes = 12;
          		}else{
                		this.mes = 0;
          		}
				return this.mes;
			}

		/**
		 * Método que obtiene el nombre del mes en base al número del mismo
		 * @param numeroMes El número de mes de la fecha (int mes)
		 * @return mes Donde mes es un String
		 * Regresa "mes inválido" si mes es distinto del rango 1 a 12
		 */

		public String obtenerNombreMes(int numeroMes){
				String mes = new String();
				int numeroM = numeroMes;
			if (numeroM == 1){
				mes = "Enero";
			}else if(numeroM == 2){
				mes = "Febrero";
			}else if(numeroM == 3){
				mes = "Marzo";
			}else if(numeroM == 4){
				mes = "Abril";
			}else if(numeroM == 5){
				mes = "Mayo";
			}else if(numeroM == 6){
				mes = "Junio";
			}else if(numeroM == 7){
				mes = "Julio";
			}else if(numeroM == 8){
				mes = "Agosto";
			}else if(numeroM == 9){
				mes = "Septiembre";
			}else if(numeroM == 10){
				mes = "Octubre";
			}else if(numeroM == 11){
				mes = "Noviembre";
			}else if(numeroM == 12){
				mes = "Diciembre";
			}else{
				mes = "Mes inválido";
			}
			return mes;
		}

		/**
		 * Método para ver la igualdad de dos fechas
		 * @param otraFecha Objeto Fecha con el que se comparará
		 * @return boolean 
		 */

		public boolean igualdad(Fecha otraFecha){
			if(this.dia == otraFecha.obtenerDia() && this.mes == otraFecha.obtenerMes() && this.year == otraFecha.obtenerYear()){
				return true;}
			else{
				return false;}

		}
	

		/**
		 * Método que devuelve fecha en formato dd/mes/aaaa
		 * @return formato (String)
		 * <p>
		 * Usar cuando queramos obtener el formato con el nombre del mes
		 * @see #obtenerNombreMes(int mes)
		 * */

		public String obtenerFechaFormato(){
		String formato = new String();
		formato = this.dia + "/" + obtenerNombreMes(this.mes) + "/" + this.year;
			return formato;
		}

		/**
		 * Método auxiliar para ver los días que debe tener un mes
		 * @param mes El int mes de la fecha
		 * @param year El int año de la fecha
		 * @return diasMes
		 * <p>
		 * Es usado para verificar si los días ingresados son válidos
		 */

		public int dias(int mes, int year){
				int diasMes = 0;
			if(mes == 1){
				diasMes = 31;
       			 }else if(mes == 2){

                		if(year % 4 == 0){
               			 diasMes = 29;
               		 }else{
                        	diasMes = 28;
                	}

        		}else if(mes == 3){
                		diasMes = 31;
        		}else if(mes == 4){
                		diasMes = 30;
        		}else if(mes == 5){
                		diasMes = 31;
        		}else if(mes == 6){
                		diasMes = 30;
        		}else if(mes == 7){
                		diasMes = 31;
        		}else if(mes == 8){
                		diasMes = 31;
        		}else if(mes == 9){
                	diasMes = 30;
        		}else if(mes == 10){
                		diasMes = 31;
        		}else if(mes == 11){
                		diasMes = 30;
        		}else if(mes == 12){
                 		diasMes = 31;
        		}else{
                		diasMes = 0;
        		}

				return diasMes;
		}

		/**
		 * Método que suma o resta dias a una fecha
		 * @param cantidadDias Los días que sumaremos o restaremos
		 * @return fechaNuevita (objeto Fecha)
		 * <p>
		 * Si se desea devolver un formato como dd/mm/aaaa usar métodos auxiliares
		 * @see #obtenerDia()
		 * @see #obtenerMes()
		 * @see #obtenerYear()
		 */

		public Fecha sumaOresta(int cantidadDias){
				int d = this.obtenerDia();
				int m = this.obtenerMes();
				int a = this.obtenerYear();

			while(cantidadDias > 0){
			d++;
				if (d > this.dias(m, a)){
				m += 1;
				d = 1;
					if(m >= 13){
					a = 1 + a;
					m = 1;
					}
				}
			cantidadDias--;
			}
			while(cantidadDias < 0){
			d--; 
				if(d == 0){
				m--;
					if(m <= 0){
					a = a - 1;
					m = 12;
					}
				d = this.dias(m, a);
				}
			
			cantidadDias++;
			}
			Fecha fechaNuevita = new Fecha(d, m, a);
			return fechaNuevita;
		}

		/**
		 * Método que evalua la validez de una fecha
		 * @param d Los dias de la fecha
		 * @param m El mes de la fecha
		 * @return boolean
		 * <p>
		 * Validez se refiere a si los dias corresponden a su rango de días válidos según el mes y si el mes pertenece a su rango [1-12].
		 */

 		public boolean validez(int d, int m){
		
			if(m > 0 && m <= 12 && d > 0 && d <= dias(m, obtenerYear())){
				return true;
			}else{
				return false;
			}
		}

  	
	}




