package pablo.barrientos.utng.edu.mx.alumnos.model;

/**
 * Created by Pablo Barrientos on 12/03/2018.
 */

public class Alumno {
    private String id;
    private String nombre;
    private String carrera;
    private String grupo;
    private Double promedio;
    private String beca;
    private String generacion;

    public Alumno() {
    }

    public Alumno(String id, String nombre, String carrera, String grupo, Double promedio, String beca, String generacion) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
        this.grupo = grupo;
        this.promedio = promedio;
        this.beca = beca;
        this.generacion = generacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", grupo='" + grupo + '\'' +
                ", promedio=" + promedio +
                ", beca='" + beca + '\'' +
                ", generacion='" + generacion + '\'' +
                '}';
    }
}

