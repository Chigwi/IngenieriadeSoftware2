package co.edu.poli.actividad1.Servicios;

public class ConcreteMediador implements Mediador{
	private Cancilleria componenteA;
	private Policia componenteB;
	private Migracion componenteC;
	private ComponenteP componenteD;
	@Override
	public String notificar(Componente sender) {
		if (sender instanceof Cancilleria) {
			return reactA();
		}else if (sender instanceof Policia) {
			return reactB();
		}else if (sender instanceof Migracion) {
			return reactC();
		}else if(sender instanceof ComponenteP) {
			return reactD();
		}else {
			return "Componente no permitido";
		}
	}
	
	public String reactA () {
		
		return "la Policia ha sido notificada";
	}
	
	public String reactB () {
		return "Migracion ha sido notificada \n Cancilleria ha sido notificada";
	
	}
	public String reactC () {
		return "Cancilleria ha sido notificada";
	}
	
	public String reactD () {
		return "la Policia ha sido notificada \n Migracion ha sido notificada";
	}

}
