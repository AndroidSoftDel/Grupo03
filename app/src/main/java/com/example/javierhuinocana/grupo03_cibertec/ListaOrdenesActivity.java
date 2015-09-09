package com.example.javierhuinocana.grupo03_cibertec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.javierhuinocana.grupo03_cibertec.adap_spiner.SpinerAdapter;
import com.example.javierhuinocana.grupo03_cibertec.entities.ListaOrdenes;

import java.util.ArrayList;

/**
 * Created by Javier Huiñocana on 07/09/2015.
 */
public class ListaOrdenesActivity extends AppCompatActivity {

    Spinner cboFiltrar;
    Button btnLiquidar, btnRechazar, btnMapa;
    private SpinerAdapter SpinerAdaptador;

    /*CODIGO QUE SE BORRARA*/
    Button btnVerDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ordenes);

        cboFiltrar = (Spinner) findViewById(R.id.cboFiltrar);
        btnLiquidar = (Button) findViewById(R.id.btnLiquidar);
        btnRechazar = (Button) findViewById(R.id.btnRechazar);


        btnVerDetalle=(Button)findViewById(R.id.btnVerDetalle);


        btnMapa = (Button) findViewById(R.id.btnMapa);

        ArrayList<String> ArrayFiltro = new ArrayList<>();
        ArrayFiltro.add("Pendientes");
        ArrayFiltro.add("Liquidadas");
        ArrayFiltro.add("Rechazadas");

        SpinerAdaptador = new SpinerAdapter(ListaOrdenesActivity.this, ArrayFiltro);
        cboFiltrar.setAdapter(SpinerAdaptador);

        btnLiquidar.setOnClickListener(btnLiquidarOnClickListener);
        btnRechazar.setOnClickListener(btnRechazarOnClickListener);
        btnMapa.setOnClickListener(btnMapaOnClickListener);

        /*CODIGO QUE SE BORRARA*/
        btnVerDetalle.setOnClickListener(btnVerDetalleOnClickListener);
    }

    View.OnClickListener btnLiquidarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ListaOrdenesActivity.this, "Se liquidara", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener btnRechazarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ListaOrdenesActivity.this, "Se rechazara", Toast.LENGTH_SHORT).show();
        }
    };
    View.OnClickListener btnMapaOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(ListaOrdenesActivity.this, "Se vera mapa", Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener btnVerDetalleOnClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ListaOrdenesActivity.this,DetalleOrdenesActivity.class);
            startActivity(intent);
        }
    };
}
