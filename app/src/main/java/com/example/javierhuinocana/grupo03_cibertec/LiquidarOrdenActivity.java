package com.example.javierhuinocana.grupo03_cibertec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Javier Huiñocana on 08/09/2015.
 */
public class LiquidarOrdenActivity extends AppCompatActivity {

    EditText txtOrden, txtTelefono, txtAtendio, txtDni, txtObservaciones;
    Button btnAddMat, btnLiquidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liquidar_orden);

        txtOrden = (EditText) findViewById(R.id.txtOrden);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono);
        txtAtendio = (EditText) findViewById(R.id.txtAtendio);
        txtDni = (EditText) findViewById(R.id.txtDNI);
        txtObservaciones = (EditText) findViewById(R.id.txtObservaciones);

        btnAddMat = (Button) findViewById(R.id.btnAddMateriales);
        btnLiquidar = (Button) findViewById(R.id.btnLiquidarOrden_Liquidar);

        btnAddMat.setOnClickListener(btnAddMatOnClickListener);
        btnLiquidar.setOnClickListener(btnLiquidarOnClickListener);
    }

    View.OnClickListener btnAddMatOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(LiquidarOrdenActivity.this, "Se llamara una nueva Actividad", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener btnLiquidarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(LiquidarOrdenActivity.this, "Se Liquidó Orden", Toast.LENGTH_SHORT).show();
            finish();
        }
    };
}
