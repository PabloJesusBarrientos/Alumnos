package pablo.barrientos.utng.edu.mx.alumnos;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pablo.barrientos.utng.edu.mx.alumnos.dao.AlumnoDAO;
import pablo.barrientos.utng.edu.mx.alumnos.model.Alumno;

/**
 * Created by Pablo Barrientos on 12/03/2018.
 */

public class ListaAlumnosActivity extends AppCompatActivity {
    private Button btnAgregarAlumno;
    private ListView lvsAlumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alumnos);

        btnAgregarAlumno = (Button) findViewById(R.id.btn_agregar_alumno);
        lvsAlumnos = (ListView) findViewById(R.id.lsv_alumnos);

        btnAgregarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intNewAlu = new Intent(getApplicationContext(),
                        NuevoAlumnoActivity.class);
                startActivity(intNewAlu);
            }
        });

        AlumnoDAO dao = new AlumnoDAO(getApplicationContext());
        List<Alumno> listaAlumnos = new ArrayList<Alumno>();
        try {
            listaAlumnos = dao.getAll();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error getAll: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        List<HashMap<String, String>> filas = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> registro;

        for (Alumno alumno : listaAlumnos){
            registro = new HashMap<String, String>();
            registro.put("id", alumno.getId());
            registro.put("nombre", alumno.getNombre());
            registro.put("grupo", alumno.getGrupo());
            filas.add(registro);
        }

        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                filas,
                R.layout.activity_registro_alumno,
                new String[]{"id", "nombre", "grupo"},
                new int[]{R.id.txt_id,R.id.txt_nombre, R.id.txt_grupo});

        lvsAlumnos.setAdapter(adapter);
        lvsAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                TextView txtId = (TextView)arg1.findViewById(R.id.txt_id);

                Bundle bundle = new Bundle();
                bundle.putString("idAlumno", txtId.getText().toString());
                Intent intGesAlu = new Intent(getApplicationContext(), GestionAlumnoActivity.class);
                intGesAlu.putExtras(bundle);
                startActivity(intGesAlu);
            }
        });

    }
}
