package pablo.barrientos.utng.edu.mx.alumnos.dao;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pablo.barrientos.utng.edu.mx.alumnos.model.Alumno;

/**
 * Created by Pablo Barrientos on 12/03/2018.
 */

public class AlumnoDAO {
    private Context contexto;

    /**
     * Método constructor que inicializa la variable contexto
     * @param contexto
     */
    public AlumnoDAO(Context contexto) {
        this.contexto = contexto;
    }

    /**
     * Método para insertar un objeto Alumno en la BD
     * @param obj
     */
    public void insert(Alumno obj) throws Exception{
        //Se crea la sentencia a ejecutar en la base de datos
        String comando = "INSERT INTO ALUMNOS(id, nombre, carrera, grupo, promedio, beca, generacion) " +
                "VALUES('" + obj.getId() + "','" + obj.getNombre() + "', '" + obj.getCarrera() + "', '" + obj.getGrupo() +
                "', " + obj.getPromedio() + ", '" + obj.getBeca() + "', '" + obj.getGeneracion() + "' )";
        //Se crea un objeto Conexion
        Conexion con = new Conexion(contexto);
        try {
            //Se ejecuta la sentencia
            con.ejecutarSentencia(comando);
        } catch (Exception e) {
            //Lanzamos la excepciÃ³n aquien invoca el Método para que Ã©l lo maneje
            throw new Exception("Error al insertar: " + e.getMessage());
        }
    }

    /**
     * Método para actualizar un objeto Alumno en la BD
     * @param obj
     */
    public void update(Alumno obj) throws Exception{
        //Se crea la sentencia a ejecutar en la base de datos
        String comando = "UPDATE ALUMNOS SET " +
                "nombre='" + obj.getNombre() + "'," +
                "carrera='" + obj.getCarrera() + "'," +
                "grupo='" + obj.getGrupo() + "'," +
                "promedio=" + obj.getPromedio() + ", " +
                "beca='" + obj.getBeca() + "', " +
                "generacion='" + obj.getGeneracion() + "' " +
                "WHERE id='" + obj.getId() + "'";
        //Se crea un objeto Conexion
        Conexion con = new Conexion(contexto);
        try {
            //Se ejecuta la sentencia
            con.ejecutarSentencia(comando);
        } catch (Exception e) {
            //Lanzamos la excepciÃ³n aquien invoca el Método para que Ã©l lo maneje
            throw new Exception("Error al actualizar: " + e.getMessage());
        }
    }

    /**
     * Método para eliminar un objeto Producto en la BD
     * @param obj
     */
    public void delete(Alumno obj) throws Exception{
        //Se crea la sentencia a ejecutar en la base de datos
        String comando = "DELETE FROM ALUMNOS WHERE id='" + obj.getId() + "'";
        //Se crea un objeto Conexion
        Conexion con = new Conexion(contexto);
        try {
            //Se ejecuta la sentencia
            con.ejecutarSentencia(comando);
        } catch (Exception e) {
            //Lanzamos la excepciÃ³n aquien invoca el Método para que Ã©l lo maneje
            throw new Exception("Error al eliminar: " + e.getMessage());
        }
    }

    /**
     * Método para listar todos los objetos Alumno de la BD
     * @return
     */
    public List<Alumno> getAll() throws Exception{
        //Se especifica el nombre de la tabla a consultar
        String tabla = "ALUMNOS";
        //Se indica los campos a consultar de la tabla
        String campos[] = new String[]{"id", "nombre", "carrera", "grupo", "promedio", "beca", "generacion"};
        //Se crea una lista para almacenar los objetos producto almacenados en la tabla
        List<Alumno> listaAlumnos = new ArrayList<>();
        //Se abre la conexiÃ³n a la BD
        Conexion con = new Conexion(contexto);
        //Se consulta mediante la conexiÃ³n todos los registros y campos de la tabla
        List<HashMap<String, String>> resultado = con.ejecutarConsulta(tabla, campos, null);

        //Se crea una referencia a un objeto Producto
        Alumno alu;
        //se recorre cada uno de los registros regresados de la consulta.
        for (HashMap<String, String> reg : resultado) {
            //Por cada registro se crea un objeto Producto
            alu = new Alumno();
            //Se asigna cada uno de los atributos del objeto producto.
            alu.setId(reg.get("id"));
            alu.setNombre(reg.get("nombre"));
            alu.setCarrera(reg.get("carrera"));
            alu.setGrupo(reg.get("grupo"));
            alu.setPromedio(Double.valueOf(reg.get("promedio")));
            alu.setBeca(reg.get("beca"));
            alu.setGeneracion(reg.get("generacion"));
            //Se inserta el objeto al producto en la lista
            listaAlumnos.add(alu);
        }
        return listaAlumnos;
    }

    /**
     * Método para buscar un objeto Alumno por su ID en la BD
     * @param obj
     * @return
     */
    public Alumno getById(Alumno obj) throws Exception{
        //Se especifica el nombre de la tabla a consultar
        String tabla = "ALUMNOS";
        //Se indica los campos a consultar de la tabla
        String campos[] = new String[]{"id", "nombre", "carrera", "grupo", "promedio", "beca", "generacion"};
        //Se especifica la condiciÃ³n para realizar la consulta.
        String condicion = "id = '" + obj.getId() + "'";
        //Se abre la conexiÃ³n a la BD
        Conexion con = new Conexion(contexto);
        //Se consulta mediante la conexiÃ³n todos los registros y campos de la tabla
        List<HashMap<String, String>> resultado = con.ejecutarConsulta(tabla, campos, condicion);
        //Se crea una referencia a un objeto Producto
        Alumno alu = null;
        //se recorre cada uno de los registros regresados de la consulta.
        for (HashMap<String, String> reg : resultado) {
            //Por cada registro se crea un objeto Alumno
            alu = new Alumno();
            //Se asigna cada uno de los atributos del objeto producto.
            alu.setId(reg.get("id"));
            alu.setNombre(reg.get("nombre"));
            alu.setCarrera(reg.get("carrera"));
            alu.setGrupo(reg.get("grupo"));
            alu.setPromedio(Double.valueOf(reg.get("promedio")));
            alu.setBeca(reg.get("beca"));
            alu.setGeneracion(reg.get("generacion"));

        }
        //Se retorna el objeto alumno
        return alu;
    }

}
