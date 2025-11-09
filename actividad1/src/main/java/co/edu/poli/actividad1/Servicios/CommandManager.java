package co.edu.poli.actividad1.Servicios;

public class CommandManager {

	private Command comando;
	
	public CommandManager(Command comando) {
		super();
		this.comando = comando;
	}

	public void setCommand(Command comando) {
		this.comando = comando;
	}
	
	public String execute() {
		return comando.validate();
	}

	@Override
	public String toString() {
		return "CommandManager [comando=" + comando + "]";
	}
	
}
