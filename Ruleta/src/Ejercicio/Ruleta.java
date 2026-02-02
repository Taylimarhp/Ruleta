package Ejercicio;

public class Ruleta {

		private int saldo;
		private int bolita;
		 
		 
		 
	    final String [] colores= {"verde", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro", "negro", "rojo",
		            "negro", "rojo", "negro", "rojo", "negro", "rojo", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro",
		            "negro", "rojo", "negro", "rojo", "negro", "rojo", "negro", "rojo"
		            };
		final int[] primera_Docena= { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		final int[] segunda_Docena= {13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
		final int[] tercera_Docena= {25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};
		
		final int multiplicador_Numero= 36;
		final int MULTIPLICADOR_COLOR = 2;
	    final int MULTIPLICADOR_PAR_IMPAR = 2;
	    final int MULTIPLICADOR_DOCENA = 3;
		final int MULTIPLICADOR_FILA = 3;
		
		public  Ruleta (int saldoInicial) {
			this.saldo= saldoInicial;
		}
		
		public int getSaldo() {
			return this.saldo;
		}
		
		public int getbolita() {
			return this.bolita;
		}
		
		
		public void Lanzarbolita () {
			 this.bolita= (int) (Math.random() * colores.length);
			
		 }
		 
		  
		  boolean apostarFila (int apuesta, int filaApostada) {
				
				this.saldo -= apuesta;
				
				switch(filaApostada) {
					case 1 -> {
						if (this.bolita != 0 && this.bolita % 3 == 1) {
							 this.saldo += (apuesta * MULTIPLICADOR_FILA);
							return true;
						}
					}
					case 2 -> {
						if (this.bolita != 0 && this.bolita % 3 == 2) {
							 this.saldo += (apuesta * MULTIPLICADOR_FILA);
							return true;
						}
					}
					case 3 -> {
						if (this.bolita != 0 && this.bolita % 3 == 0) {
							 this.saldo += (apuesta * MULTIPLICADOR_FILA);
							return true;
						}
					}
				}
				
				return false;
			}
		  
		  boolean apuestaPar (int bolita, int apuesta) {
			  this.saldo -= apuesta;
			  
			  if (bolita % 2 == 0) {
				  saldo = saldo + (apuesta * MULTIPLICADOR_PAR_IMPAR);
				  return true;
			  }
			  return false;
		  } 
		  
		  boolean apuestaImpar (int bolita, int apuesta) {
			  this.saldo -= apuesta;
			  
			  if (bolita % 2 != 0) {
				  saldo = saldo + (apuesta * MULTIPLICADOR_PAR_IMPAR);
				  return true;
			  }
			  return false;
		  }
		  
		  boolean apuestaPorNumero (int apuesta, int numeroApostado) {
			  this.saldo -= apuesta;
			  if(bolita==numeroApostado) {
				  this.saldo += (apuesta * multiplicador_Numero);
				  return true;
				  }
			  return false;
		  }
		  
		  boolean apuestaPorDocena (int apuesta, int docenaElegida) {
			  this.saldo -= apuesta;
			  
			  if(this.bolita==0) return false;
			  
			  boolean gana=
			  
			  switch (docenaElegida) {
		        case 1 -> gana = (this.bolita >= 1 && this.bolita <= 12);
		        case 2 -> gana = (this.bolita >= 13 && this.bolita <= 24);
		        case 3 -> gana = (this.bolita >= 25 && this.bolita <= 36);
		        default -> false;
		    };
				if(gana) {
					this.saldo += (apuesta * MULTIPLICADOR_DOCENA);
					return true;
				}
				  
				return false;
				  
		  }
				
	
}

