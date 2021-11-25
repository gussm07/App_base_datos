package edu.ieu.basedatosartculos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.ieu.basedatosartculos.basedatos.AdminSQLiteOpenHelper;
import static edu.ieu.basedatosartculos.basedatos.AdminSQLiteOpenHelper.BASE_DATOS;
import static edu.ieu.basedatosartculos.basedatos.AdminSQLiteOpenHelper.CODIGO;
import static edu.ieu.basedatosartculos.basedatos.AdminSQLiteOpenHelper.DESCRIPCION;
import static edu.ieu.basedatosartculos.basedatos.AdminSQLiteOpenHelper.PRECIO;
import static edu.ieu.basedatosartculos.basedatos.AdminSQLiteOpenHelper.TABLA;

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

        btnNuevo.setOnClickListener(view -> {
            alta();
        });
        btnBuscarCodigo.setOnClickListener(view -> {
            buscarCodigo();
        });
    }

    @SuppressLint("Range")
    private void buscarCodigo() {
        String strCodigo = etCodigo.getText().toString();
        try{
            Integer.parseInt(strCodigo);
            AdminSQLiteOpenHelper adminDbHelper = new AdminSQLiteOpenHelper(this, TABLA);
            SQLiteDatabase adminDb = adminDbHelper.getReadableDatabase();
            Cursor cursor = adminDb.query(TABLA,null,CODIGO + " = ?", new String[]{strCodigo}, null, null, null);
            if(cursor.moveToNext()){
                etDescripcion.setText(cursor.getString(cursor.getColumnIndex(DESCRIPCION)));
                etPrecio.setText(cursor.getString(cursor.getColumnIndex(PRECIO)));
            }else{
                Toast.makeText(this, "Codigo" +strCodigo+ "inexistente", Toast.LENGTH_SHORT).show();
            }

        }catch (NumberFormatException ex){
            Toast.makeText(this, "Ingrese un código numérico correcto", Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }

    private void alta() {
        AdminSQLiteOpenHelper adminDbHelper =
                new AdminSQLiteOpenHelper(this, BASE_DATOS);
        SQLiteDatabase adminDb = adminDbHelper.getWritableDatabase();
        String codigo = etCodigo.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        String precio = etPrecio.getText().toString();
        if(codigo.isEmpty())
        {
            Toast.makeText(this, "Codigo no puede ser vacio", Toast.LENGTH_SHORT)
                    .show();
            return;
        }
        ContentValues values = new ContentValues();
        values.put(CODIGO, codigo);
        values.put(DESCRIPCION, descripcion);
        values.put(PRECIO, precio);
        adminDb.insert(TABLA, null, values);
        adminDb.close();
        Toast.makeText(this, "Artículo con código" +codigo+"guardado en la base de datos", Toast.LENGTH_SHORT).show();
        limpiarET();



    }

    private void limpiarET(){
        etCodigo.setText("");
        etDescripcion.setText("");
        etPrecio.setText("");
    }
}