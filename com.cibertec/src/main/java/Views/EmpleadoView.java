package Views;

import controllers.EmpleadoController;

public class EmpleadoView {

	public static void main(String[] args) {
		
     //String empleado = new EmpleadoController().createEmpleado("Costa","Juan",12,"masculino",100);
     //String empleado = new EmpleadoController().deleteEmpleado(1);
     // String empleado = new EmpleadoController().updateEmplado(1, "Barrios");
      String empleado = new EmpleadoController().getEmpleado(1);
     System.out.println(empleado);
	}

}
