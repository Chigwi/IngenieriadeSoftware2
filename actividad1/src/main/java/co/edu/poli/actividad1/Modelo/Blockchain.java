package co.edu.poli.actividad1.Modelo;

public class Blockchain extends ElementoSeguridad{
		
		private String hash;

		public Blockchain(String idL, String tipo, String fdescripcion, String hash) {
			super(idL, tipo, fdescripcion);
			this.hash = hash;
		}

		public String getHash() {
			return hash;
		}

		public void setHash(String hash) {
			this.hash = hash;
		}

		@Override
		public String toString() {
			return "Blockchain: " + hash ;
		}
		
		

}
