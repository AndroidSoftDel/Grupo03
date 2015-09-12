package com.example.javierhuinocana.grupo03_cibertec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javierhuinocana.grupo03_cibertec.entities.ListaOrdenes;

/**
 * Created by Javier Huiñocana on 08/09/2015.
 */
public class LiquidarOrdenActivity extends AppCompatActivity {

    EditText txtOrden, txtTelefono, txtAtendio, txtDni, txtObservaciones;
    Button btnAddMat, btnLiquidar;
    ListaOrdenes listaOrdenes;

    public final static int CODE_Resul=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liquidar_orden);

        txtOrden = (EditText) findViewById(R.id.txtOrden_Liquidar);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono_Liquidar);
        txtAtendio = (EditText) findViewById(R.id.txtAtendio_Liquidar);
        txtDni = (EditText) findViewById(R.id.txtDNI_Liquidar);
        txtObservaciones = (EditText) findViewById(R.id.txtObservaciones_Liquidar);

        btnAddMat = (Button) findViewById(R.id.btnAddMateriales_Liquidar);
        btnLiquidar = (Button) findViewById(R.id.btnLiquidarOrden_Liquidar);

        /*PARA CANCELAR LA EDICION EN LOS CONTROLES*/
        txtOrden.setKeyListener(null);
        txtTelefono.setKeyListener(null);

        /*ENVIAMOS FOCO*/
        txtAtendio.requestFocus();

        /*ASOCIAMOS EVENTOS CLICK*/
        btnAddMat.setOnClickListener(btnAddMatOnClickListener);
        btnLiquidar.setOnClickListener(btnLiquidarOnClickListener);

        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(ListaOrdenesActivity.ARG_ORDEN)) {
            listaOrdenes = getIntent().getParcelableExtra(ListaOrdenesActivity.ARG_ORDEN);
            txtOrden.setText(listaOrdenes.getOrden());
            txtTelefono.setText(listaOrdenes.getTelefono());
        }
    }

    View.OnClickListener btnAddMatOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Toast.makeText(LiquidarOrdenActivity.this, "Se llamara una nueva Actividad", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LiquidarOrdenActivity.this,AddMaterialLiquidarActivity.class);
            //startActivityForResult(intent,CODE_Resul);
            startActivity(intent);
        }
    };

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
}
