package herencia;

import java.util.Scanner;

public class Jefe extends Empleado {
	Scanner scanner = new Scanner(System.in);
	
	//Atributo
	private float plus, sueJefe;
	private String depa;

	
	
	
	
	public float getPlus() {
		return plus;
	}

	public void setPlus(float plus) {
		this.plus = plus;
	}

	public float getSueJefe() {
		return sueJefe;
	}

	public void setSueJefe(float sueJefe) {
		this.sueJefe = sueJefe;
	}

	public String getDepa() {
		return depa;
	}

	public void setDepa(String depa) {
		this.depa = depa;
	}
	
	
	

	public Jefe() {
		
	}

	public Jefe(float plus) {
		super();
		this.plus = 250;
	}

	//metodo
	public float sueldoJefe () {
		plus=250;
		sueJefe=super.incremento()+plus;
		return sueJefe;
		
	}
	public float sueldoFinal () {
		return super.incremento()+plus;
	}
	
	// toString 
	@Override
	public String toString() {
		return "Jefe [DNI=" + getDniEmpleado() + ", Nombre=" + getNombreEmpleado() + ", Mes Entrado="
				+ getMesEntrado() + ", Año Entrada=" + getAnioEntrado() + ", Porcentaje=" + getPorcentaje() + ", sueldoBase="
				+ incremento() + ", anituguedad=" + (getFechaActual()-getAnioEntrado()) +", Departamento=" + depa + "]";
	}

	//setDatos
	public void setDatos (String dni) {
		super.setDatos(dni);
		System.out.println("Intoduce el nombre del departamento: ");
		depa=scanner.next();
	}

}
