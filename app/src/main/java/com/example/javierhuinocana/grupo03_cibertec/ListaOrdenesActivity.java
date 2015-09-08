package com.example.javierhuinocana.grupo03_cibertec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;

import com.example.javierhuinocana.grupo03_cibertec.adap_spiner.SpinerAdapter;

import java.util.ArrayList;

/**
 * Created by Javier Huiñocana on 07/09/2015.
 */
public class ListaOrdenesActivity extends AppCompatActivity {

    Spinner cboFiltrar;
    Button btnLiquidar, btnRechazar, btnMapa;
    private SpinerAdapter SpinerAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ordenes);

        cboFiltrar = (Spinner) findViewById(R.id.cboFiltrar);
        btnLiquidar = (Button) findViewById(R.id.btnLiquidar);
        btnRechazar = (Button) findViewById(R.id.btnRechazar);
        btnMapa = (Button) findViewById(R.id.btnMapa);

        ArrayList<String> ArrayFiltro = new ArrayList<>();
        ArrayFiltro.add("Pendientes");
        ArrayFiltro.add("Liquidadas");
        ArrayFiltro.add("Rechazadas");

        SpinerAdaptador= new SpinerAdapter(ListaOrdenesActivity.this,ArrayFiltro);
        cboFiltrar.setAdapter(SpinerAdaptador);

        //ArrayList<String> Adaptador =

    }
}
