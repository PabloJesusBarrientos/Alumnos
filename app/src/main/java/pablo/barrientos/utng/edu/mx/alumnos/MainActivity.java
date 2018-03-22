package pablo.barrientos.utng.edu.mx.alumnos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pablo.barrientos.utng.edu.mx.alumnos.dao.Conexion;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnInicializar;
    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicializar = (Button)findViewById(R.id.btn_inicializar_bd);
        btnRegistrar = (Button)findViewById(R.id.btn_registrar);

        btnRegistrar.setOnClickListener(this);
        btnInicializar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_inicializar_bd:
                try {
                    //Se crea un objeto conexion
                    Conexion con = new Conexion(getApplication());
                    //Se invoca el metodo para inicializar la BD
                    con.inicializaBD();
                    Toast.makeText(getApplicationContext(), "BD inicializada con éxito", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    //En caso de error se muestra el mensaje en un dialogo
                    Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_registrar:
                Intent intPro = new Intent(
                        getApplicationContext(),ListaAlumnosActivity.class);
                //Se arranca la actividad
                startActivity(intPro);
                break;
        }

    }
}
