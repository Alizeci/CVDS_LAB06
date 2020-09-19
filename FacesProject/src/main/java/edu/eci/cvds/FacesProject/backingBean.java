package edu.eci.cvds.FacesProject;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "calculadoraBean")
@SessionScoped
public class backingBean {
	private ArrayList<Float> datos;
	private String datosOriginal;
	private float respuesta;
	private float promedio;
	private float desviacionEstandar;
	private float varianza;
	private float moda;
	private int palabras;
	
	/**
	 * metodo principal de la clase backingBean
	 */
	public backingBean() {
		datos= new ArrayList<Float>();
		setDatosOriginal("");
		promedio = 0;
		desviacionEstandar=0;		
		varianza=0;
		moda=0;
	}
	
	
	public void cambio(String datosOriginal ) {
		setPalabras(0);
		ArrayList<Float> datosCambio= new ArrayList<Float>();
		String[] parts = datosOriginal.split(",");
		for (String i : parts) {
			float flotante = Float.parseFloat(i);
			datosCambio.add (flotante);
			setPalabras(getPalabras() + 1);
		}
		datos=datosCambio;
	}
	
	
	/**
	 * Debe recibir como parámetro el listado de valores y retornar el promedio de los números en ella.
	 * @param datos
	 * @return respuesta
	 */
	public float calculateMean(String datosOriginal) {
		cambio(datosOriginal);
		respuesta=0;
		for (Float i : datos) respuesta += i ;respuesta = respuesta / datos.size();
		this.promedio=respuesta;
	    return respuesta;
	    }
		 
	/**
	 * Debe recibir como parámetro el listado de valores y retornar el la desviación estandar de los números en ella.
	 * @param datos
	 * @return respuesta
	 */
	public Float calculateStandardDeviation(String datosOriginal) {
		cambio(datosOriginal);
		respuesta = 0;
		respuesta =(float) Math.pow(calculateVariance(datosOriginal), 0.5);
		this.desviacionEstandar=respuesta;
		return respuesta;
		}
		 
	/**
	 * Debe recibir como parámetro el listado de valores y retornar la varianza de los números en ella.
	 * @param datos
	 * @return respuesta
	 */
	public Float calculateVariance(String datosOriginal) {
		cambio(datosOriginal);
		respuesta = 0; promedio = 0; varianza = 0;
		for (Float i : datos) promedio += i;
		promedio = promedio / datos.size();
		for (Float i : datos) varianza+= Math.pow(i-promedio,2);
		respuesta = varianza / datos.size();
		this.varianza=respuesta;
		return respuesta;
		}
	
	 /**
	  * Debe recibir como parámetro el listado de valores y retornar la moda de los números en ella.
	  * @param datos
	  * @return 
	  */
	  public Float calculateMode(String datosOriginal) {
		  cambio(datosOriginal);
		  respuesta=0; int maxRep=0; int rep = 0;
	        for (int i=0;i<datos.size(); i++) {
	        	for (int j = 0; j < datos.size(); j++) {
	                if (datos.get(i) == datos.get(j))rep++;
	                if (rep>maxRep) { 
	                	respuesta= datos.get(i);
	                		maxRep=rep;
	                		}
	                }
	        }
	        this.moda=respuesta;
	        return moda;
	  }
	/**
	 * Debe volver a iniciar la aplicación (Borrar el campo de texto para que el usuario agregue los datos).
	 */
	  public void restart(){
		  this.promedio=0;
		  this.desviacionEstandar=0;
		  this.varianza=0;
		  this.moda=0;
		  this.respuesta=0;
		  this.datos = null;
		  
	  }
	  
	  	// metodos GET
	  	public ArrayList<Float> getDatos() {
			return datos;
		}
		public float getPromedio() {
			return promedio;
		}
		public float getDesviacionEstandar() {
			return desviacionEstandar;
		}
		public float getvarianza() {
			return varianza;
		}
		public float getmoda() {
			return moda;
		}

		public int getPalabras() {
			return palabras;
		}

		public String getDatosOriginal() {
			return datosOriginal;
		}
		// metodos SET
		public void setDatos(ArrayList <Float> datos){
			this.datos = datos;
		}
		 public void setPromedio(float promedio) {
		        this.promedio = promedio;
		}
		 public void setDesviacionEstandar(float DesviacionEstandar) {
		        this.desviacionEstandar = DesviacionEstandar;
		}
		 public void setVarianza(float varianza) {
		        this.varianza = varianza;
		}
		 public void setModa(float moda) {
		        this.moda = moda;
		}
		public void setPalabras(int palabras) {
			this.palabras = palabras;
		}
		public void setDatosOriginal(String datosOriginal) {
			this.datosOriginal = datosOriginal;
		}
}
