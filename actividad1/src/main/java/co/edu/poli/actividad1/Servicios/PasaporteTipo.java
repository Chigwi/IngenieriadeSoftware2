package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pasaporte;

public class PasaporteTipo {

	private String colorCubierta;
	
	private String idioma;
	
	private String paisEmisor;
	
	

	private PasaporteTipo() {
		super();
	}

	public PasaporteTipo(String colorCubierta, String idioma, String paisEmisor) {
		super();
		PasaporteTipo r = new PasaporteTipo();
		r.setColorCubierta(colorCubierta);
		r.setIdioma(idioma);
		r.setPaisEmisor(paisEmisor);
		addToMap(paisEmisor, r);
	
		
	}

	public String getColorCubierta() {
		return colorCubierta;
	}

	public void setColorCubierta(String colorCubierta) {
		this.colorCubierta = colorCubierta;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPaisEmisor() {
		return paisEmisor;
	}

	public void setPaisEmisor(String paisEmisor) {
		this.paisEmisor = paisEmisor;
	}

	@Override
	public String toString() {
		return "PasaporteTipo [colorCubierta=" + colorCubierta + ", idioma=" + idioma + ", paisEmisor=" + paisEmisor
				+ "]";
	}
	
	private void addToMap(String key, PasaporteTipo p) {
		FactoriaFlyweight.getMapaTipos().put(key,p );
	}
	
	
}
