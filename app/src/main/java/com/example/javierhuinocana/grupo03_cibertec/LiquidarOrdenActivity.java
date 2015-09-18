package com.example.javierhuinocana.grupo03_cibertec;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javierhuinocana.grupo03_cibertec.dao.ListadoDAO;
import com.example.javierhuinocana.grupo03_cibertec.entities.ListaOrdenes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Javier Huiñocana on 08/09/2015.
 */
public class LiquidarOrdenActivity extends AppCompatActivity {

    EditText txtOrden, txtTelefono, txtAtendio, txtDni, txtObservaciones;
    ListaOrdenes listaOrdenes;
    //agregar nueva repo
    private Button btnLiquidarOrden_Liquidar, btnCancelar_Liquidar;
    private TextInputLayout tilNombre_Liquidar, tilDni_Liquidar, tilObservaciones_Liquidar;
    TextView tvTelefono_Liquidar,tvOrden_Liquidar;
    ////


    public final static int CODE_Resul = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liquidar_orden);

        //agregar nueva repo
        btnLiquidarOrden_Liquidar = (Button)findViewById(R.id.btnLiquidarOrden_Liquidar);
        btnCancelar_Liquidar = (Button)findViewById(R.id.btnCancelar_Liquidar);
        tvOrden_Liquidar = (TextView)findViewById(R.id.tvOrden_Liquidar);
        tvTelefono_Liquidar = (TextView)findViewById(R.id.tvTelefono_Liquidar);

        btnLiquidarOrden_Liquidar.setOnClickListener(btnLiquidarOrden_LiquidarOnClickListener);
        btnCancelar_Liquidar.setOnClickListener(btnCancelar_LiquidarOnClickListener);

        tilNombre_Liquidar = (TextInputLayout)findViewById(R.id.tilNombre_Liquidar);
        tilDni_Liquidar = (TextInputLayout)findViewById(R.id.tilDni_Liquidar);
        tilObservaciones_Liquidar = (TextInputLayout)findViewById(R.id.tilObservaciones_Liquidar);

        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(ListaOrdenesActivity.ARG_ORDEN)) {
            listaOrdenes = getIntent().getParcelableExtra(ListaOrdenesActivity.ARG_ORDEN);
            tvOrden_Liquidar.setText(listaOrdenes.getOrden());
            //tvTelefono_Liquidar.setText(listaOrdenes.getTelefono());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    View.OnClickListener btnLiquidarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(LiquidarOrdenActivity.this, "Se Liquidó Orden", Toast.LENGTH_SHORT).show();
            finish();
        }
    };


    //agregar nuevo repo
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        /*OCULTAMOS EL BOTON: VER MAPA*/
        menu.getItem(1).setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_agregar_materiales:
                Toast.makeText(LiquidarOrdenActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LiquidarOrdenActivity.this, AddMaterialLiquidarActivity.class);
                //startActivityForResult(intent,CODE_Resul);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    View.OnClickListener btnLiquidarOrden_LiquidarOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            boolean isCorrect = true;
            ListaOrdenes listaOrdenes = new ListaOrdenes();

            tilNombre_Liquidar.setErrorEnabled(false);
            tilDni_Liquidar.setErrorEnabled(false);
            tilObservaciones_Liquidar.setErrorEnabled(false);

            if (tilNombre_Liquidar.getEditText().getText().toString().trim().length() <= 0) {
                tilNombre_Liquidar.setError("Ingrese un nombre de cliente");
                tilNombre_Liquidar.setErrorEnabled(true);
                isCorrect = false;
            } else
                listaOrdenes.setClienteAtendio(tilNombre_Liquidar.getEditText().getText().toString().trim());

            if (tilDni_Liquidar.getEditText().getText().toString().trim().length() != 8) {
                tilDni_Liquidar.setError("Ingrese un DNI válido");
                tilDni_Liquidar.setErrorEnabled(true);
                isCorrect = false;
            } else
                listaOrdenes.setDniCliente(tilDni_Liquidar.getEditText().getText().toString().trim());

            if (tilObservaciones_Liquidar.getEditText().getText().toString().trim().length() <= 0) {
                tilObservaciones_Liquidar.setError("Ingrese las observaciones");
                tilObservaciones_Liquidar.setErrorEnabled(true);
                isCorrect = false;
            } else
                listaOrdenes.setObservaciones(tilObservaciones_Liquidar.getEditText().getText().toString().trim());

            if (isCorrect) {

                //estado para orden rechazada = 10
                listaOrdenes.setEstado(ListaOrdenesActivity.estadoOrdenLiquidada);
                //se obtiene la fecha
                String fecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", java.util.Locale.getDefault()).format(Calendar.getInstance().getTime());
                listaOrdenes.setFecha_Liquidacion(fecha);

                listaOrdenes.setOrden(tvOrden_Liquidar.getText().toString().trim());

                ListadoDAO listadoDAO = new ListadoDAO();
                long rc = listadoDAO.updateListado(listaOrdenes);
                if(rc==1)
                    Toast.makeText(LiquidarOrdenActivity.this, "Orden liquidada satisfactoriamente", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent();
                //intent.putExtra(MainActivity.ARG_PERSONA, persona);
                //intent.putExtra(MainActivity.ARG_POSITION, position);
                //setResult(RESULT_OK, intent);
                finish();
            }
        }
    };
    View.OnClickListener btnCancelar_LiquidarOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Toast.makeText(LiquidarOrdenActivity.this, "Liquidacion cancelada", Toast.LENGTH_SHORT).show();
            finish();
        }
    };
}
