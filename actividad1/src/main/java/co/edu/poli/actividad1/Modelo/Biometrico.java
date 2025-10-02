package co.edu.poli.actividad1.Modelo;

public class Biometrico extends ElementoSeguridad{

	private String tipoBiometria;
	
	public Biometrico(String idL, String tipo, String fdescripcion, String tipoBiometria) {
		super(idL, tipo, fdescripcion);
		this.tipoBiometria = tipoBiometria;
		// TODO Auto-generated constructor stub
	}

	public String getTipoBiometria() {
		return tipoBiometria;
	}

	public void setTipoBiometria(String tipoBiometria) {
		this.tipoBiometria = tipoBiometria;
	}

	@Override
	public String toString() {
		return "tipo de seguridad"+this.getTipo()+"\n" +"descripcion"+this.getFdescripcion()+ "\n"+"Biometrico"+"\n"+ "[tipoBiometria=" + tipoBiometria + "]";
	}
	
	
	

}
