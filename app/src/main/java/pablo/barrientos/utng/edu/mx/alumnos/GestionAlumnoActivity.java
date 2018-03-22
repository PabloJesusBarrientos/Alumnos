package pablo.barrientos.utng.edu.mx.alumnos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pablo.barrientos.utng.edu.mx.alumnos.dao.AlumnoDAO;
import pablo.barrientos.utng.edu.mx.alumnos.model.Alumno;

/**
 * Created by Pablo Barrientos on 12/03/2018.
 */

public class GestionAlumnoActivity extends AppCompatActivity {
    private EditText edtId;
    private EditText edtNombre;
    private EditText edtCarrera;
    private EditText edtGrupo;
    private EditText edtPromedio;
    private EditText edtBeca;
    private EditText edtGeneracion;
    private Button btnActualizar;
    private Button btnCancelar;
    private Button btnEliminar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gestion_alumno);

        edtId = (EditText)findViewById(R.id.edt_id_alumno);
        edtNombre = (EditText)findViewById(R.id.edt_nombre);
        edtCarrera = (EditText)findViewById(R.id.edt_carrera);
        edtGrupo = (EditText)findViewById(R.id.edt_grupo);
        edtPromedio = (EditText)findViewById(R.id.edt_promedio);
        edtBeca = (EditText)findViewById(R.id.edt_beca);
        edtGeneracion = (EditText)findViewById(R.id.edt_generacion);
        btnActualizar = (Button)findViewById(R.id.btn_actualizar);
        btnCancelar = (Button)findViewById(R.id.btn_cancelar);
        btnEliminar = (Button)findViewById(R.id.btn_eliminar);

        String idAlumno = getIntent().getExtras().getString("idAlumno");
        Toast.makeText(getApplicationContext(), "idAlumno: " + idAlumno, Toast.LENGTH_SHORT).show();

        Alumno a = new Alumno();
        a.setId(idAlumno);

        AlumnoDAO dao = new AlumnoDAO(getApplicationContext());
        try {
            a = dao.getById(a);
            edtId.setText(a.getId());
            edtNombre.setText(a.getNombre());
            edtCarrera.setText(a.getCarrera());
            edtGrupo.setText(a.getGrupo());
            edtPromedio.setText(String.valueOf(a.getPromedio()));
            edtBeca.setText(a.getBeca());
            edtGeneracion.setText(a.getGeneracion());
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error getById: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alumno a = new Alumno();
                a.setId(edtId.getText().toString());
                a.setNombre(edtNombre.getText().toString());
                a.setCarrera(edtCarrera.getText().toString());
                a.setGrupo(edtGrupo.getText().toString());
                a.setPromedio(Double.valueOf(edtPromedio.getText().toString()));
                a.setBeca(edtBeca.getText().toString());
                a.setGeneracion(edtGeneracion.getText().toString());

                AlumnoDAO dao = new AlumnoDAO(getApplicationContext());

                try {
                    dao.update(a);

                    Toast.makeText(getApplicationContext(),"Alumno actualizado exitosamente", Toast.LENGTH_SHORT).show();
                    System.exit(0);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error update: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alumno a = new Alumno();
                a.setId(edtId.getText().toString());
                AlumnoDAO dao = new AlumnoDAO(getApplicationContext());

                try {
                    dao.delete(a);
                    Toast.makeText(getApplicationContext(), "Alumno eliminado exitosamente", Toast.LENGTH_SHORT).show();
                    System.exit(0);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error delete: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        //8. Se asigna escuchador de clics al btnCancelar
        btnCancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Se cierra la vista
                System.exit(0);
            }
        });
    }
}
