package edu.ieu.basedatosartculos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etCodigo;
    private EditText etDescripcion;
    private EditText etPrecio;

    private Button btnNuevo;
    private Button btnBorrar;
    private Button btnActualizar;

    private Button btnBuscarCodigo;
    private Button btnBuscarDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo = findViewById(R.id.etCodigo);
        etDescripcion = findViewById(R.id.etDescripcion);
        etPrecio = findViewById(R.id.etPrecio);

        btnNuevo = findViewById(R.id.btnCrear);
        btnBorrar = findViewById(R.id.btnBorrar);
        btnActualizar = findViewById(R.id.btnModificar);
        btnBuscarCodigo = findViewById(R.id.btnBuscarCodigo);
        btnBuscarDescripcion = findViewById(R.id.btnBuscarDescripcion);
    }
}