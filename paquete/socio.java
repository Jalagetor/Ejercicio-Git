public class socio implements Serializable
{
//Atrivutos
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected String dni;
	protected String nacimiento;

	// Constructor
	public socio(String nombre, String apellido1, String apellido2, String dni, String naciomiento)
	{
		this.nombre=nombre;
		this.apellido1=apellido1;
		this.apellido2=apellido2;
		this.dni=dni;
		this.nacimiento=nacimiento;
	}
	
	//Métodos
	public String toString()
	{
		return "Nombre: " + nombre + " " + apellido1 + " " + apellido2 + "\tDNI: " + dni + "\tFecha nacimiento: " + nacimiento;	
	}
}