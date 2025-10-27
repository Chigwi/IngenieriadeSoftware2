package co.edu.poli.actividad1.Servicios;

public class Proxy implements InterfazProxy{
	
	private AdaptadorPasaporte servicio;
	
	
	
	public Proxy(AdaptadorPasaporte servicio) {
		super();
		this.servicio = servicio;
	}

	private String confirmarAcceso(String rol) {
		if(rol.equals("superusuario")) {
			return "Acceso total";
		}else if(rol.equals("basicusuario")){
			return "Acceso basico";
		}else {
			return "Acceso denegado";
		}
	}

	@Override
	public String verDetalles(String rol) {
		if(confirmarAcceso(rol).equals("Acceso total")){
			return servicio.toString();
		}else if(confirmarAcceso(rol).equals("Acceso basico")){
			StringBuilder r = new StringBuilder();
			r.append("Pasaporte: id = " + servicio.getAdaptada().getNumeroId() + "\n" );
			r.append("Pais Emisor = " + servicio.getAdaptada().getPaisEmisor().getNombre() + "\n");
			r.append("Titular = " + servicio.getAdaptada().getTitular().getNombre() + "\n");
			r.append("Fecha Expiracion = " + servicio.getAdaptada().getFechaExpiracion() + "\n");
			return r.toString();
		}else {
			return "Usuario no tiene acceso a los detalles de este pasaporte";
		}
	}

}
