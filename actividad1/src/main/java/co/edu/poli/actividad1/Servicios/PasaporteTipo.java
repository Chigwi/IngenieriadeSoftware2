package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.Pasaporte;

public class PasaporteTipo {

	private String colorCubierta;
	
	private String idioma;
	
	private String paisEmisor;

	public PasaporteTipo(String colorCubierta, String idioma, String paisEmisor) {
		super();
		
		this.colorCubierta = colorCubierta;
		this.idioma = idioma;
		this.paisEmisor = paisEmisor;
		
		FactoriaFlyweight.getMapaTipos().put(paisEmisor, this);
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
	
	
}
