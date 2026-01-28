package Ejercicio;

public class Ruleta {

		 int saldo;
		 int bolita;
		 
		 String [] colores= {"verde", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro", "negro", "rojo",
		            "negro", "rojo", "negro", "rojo", "negro", "rojo", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro",
		            "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo"
		            };
		
		  int Lanzarbolita () {
			 int resultado= (int) (Math.random() * 37);
			 return resultado;
		 }
		 
		  Ruleta (int dineroinicial) {
			 saldo= dineroinicial;
		 }
		  
		  

				
				
				
	}


