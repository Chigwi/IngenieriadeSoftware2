package co.edu.poli.actividad1.Servicios;

import co.edu.poli.actividad1.Modelo.PDiplomatico;
import co.edu.poli.actividad1.Modelo.POrdinario;
import co.edu.poli.actividad1.Modelo.Pasaporte;

public class PasaporteOriginator implements Cloneable {
	
	private Pasaporte state;
	
	
	
	public PasaporteOriginator(Pasaporte state) {
		super();
		this.state = state;
	}

	public Pasaporte getState() {
		return state;
	}

	public void setState(Pasaporte state) {
		this.state = state;
	}

	//metodos memento
	public ConcreteMemento createMemento () {
		PasaporteOriginator p = this.clone();
		ConcreteMemento m = new ConcreteMemento (p);
		return m;
	}
	
	public PasaporteOriginator restore(ConcreteMemento m) {
	    Pasaporte restored = m.getMemento().getState();

	    Pasaporte copy;
	    if (restored instanceof POrdinario) {
	        copy = new POrdinario((POrdinario) restored);
	    } else if (restored instanceof PDiplomatico) {
	        copy = new PDiplomatico((PDiplomatico) restored);
	    } else {
	        throw new IllegalStateException("Pasaporte desconocido");
	    }

	    this.state = copy;
	    return this;
	}
	
	
	@Override
	public String toString() {
		return "PasaporteOriginator [state=" + state + "]";
	}

	@Override
	public PasaporteOriginator clone() {
	    Pasaporte copy;
	    if (state instanceof POrdinario) {
	        copy = new POrdinario((POrdinario) state); // assuming copy constructor exists
	    } else if (state instanceof PDiplomatico) {
	        copy = new PDiplomatico((PDiplomatico) state);
	    } else {
	        throw new IllegalStateException("Pasaporte Desocnocido");
	    }
	    return new PasaporteOriginator(copy);
	}
}
