package pablo.barrientos.utng.edu.mx.alumnos;

import android.os.Bundle;
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

public class NuevoAlumnoActivity extends AppCompatActivity{
    private EditText edtMatricula;
    private EditText edtNombre;
    private EditText edtCarrera;
    private EditText edtGrupo;
    private EditText edtPromedio;
    private EditText edtBeca;
    private EditText edtGeneracion;
    private Button btnGuardar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity__nuevo_alumno);

        edtMatricula = (EditText)findViewById(R.id.edt_matricula);
        edtNombre = (EditText)findViewById(R.id.edt_nombre);
        edtCarrera = (EditText)findViewById(R.id.edt_carrera);
        edtGrupo = (EditText)findViewById(R.id.edt_grupo);
        edtPromedio = (EditText)findViewById(R.id.edt_promedio);
        edtBeca = (EditText)findViewById(R.id.edt_beca);
        edtGeneracion = (EditText)findViewById(R.id.edt_generacion);
        btnGuardar = (Button)findViewById(R.id.btn_guardar);
        btnCancelar = (Button)findViewById(R.id.btn_cancelar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alumno a = new Alumno();
                a.setId(edtMatricula.getText().toString());
                a.setNombre(edtNombre.getText().toString());
                a.setCarrera(edtCarrera.getText().toString());
                a.setGrupo(edtGrupo.getText().toString());
                a.setPromedio(Double.valueOf(edtPromedio.getText().toString()));
                a.setBeca(edtBeca.getText().toString());
                a.setGeneracion(edtGeneracion.getText().toString());

                AlumnoDAO dao = new AlumnoDAO(getApplicationContext());

                try {
                    dao.insert(a);

                    Toast.makeText(getApplicationContext(),"Alumno registrado exitosamente", Toast.LENGTH_SHORT).show();
                    System.exit(0);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error insert: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        //3. Se asigna escuchador de clics al btnCancelar
        btnCancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Se cierra la vista
                System.exit(0);
            }
        });
    }
}
