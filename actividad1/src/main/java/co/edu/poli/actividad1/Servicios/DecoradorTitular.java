package co.edu.poli.actividad1.Servicios;

public abstract class DecoradorTitular implements IntTitular{

	private IntTitular wrapee;

	public DecoradorTitular(IntTitular wrapee) {
		super();
		this.wrapee = wrapee;
	}

	public IntTitular getWrapee() {
		return wrapee;
	}

	public void setWrapee(IntTitular wrapee) {
		this.wrapee = wrapee;
	}

	@Override
	public String toString() {
		return "DecoradorTitular [wrapee=" + wrapee + "]";
	}
	
	
}
