package com.example.javierhuinocana.grupo03_cibertec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView;

import com.example.javierhuinocana.grupo03_cibertec.adap_recyclerview.RVListadoAdapter;
import com.example.javierhuinocana.grupo03_cibertec.adap_spiner.SpinerAdapter;
import com.example.javierhuinocana.grupo03_cibertec.dao.DataBaseHelper;
import com.example.javierhuinocana.grupo03_cibertec.entities.ListaOrdenes;

import java.util.ArrayList;

/**
 * Created by Javier Huiñocana on 07/09/2015.
 */
public class ListaOrdenesActivity extends AppCompatActivity implements RVListadoAdapter.RVListadoAdapterCallBack{

    Spinner cboFiltrar;
    Button btnLiquidar, btnRechazar, btnMapa;
    private SpinerAdapter SpinerAdaptador;
    private RecyclerView rvPrincipal;
    private RVListadoAdapter rvListadoAdapter;
    private DataBaseHelper dataBaseHelper;
    private int Estado;
    public final static String ARG_ORDEN = "orden", ARG_POSITION = "position";
    private final static int REQUEST_CODE_EDITAR = 2;
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
        Estado = 0;

        SpinerAdaptador = new SpinerAdapter(ListaOrdenesActivity.this, ArrayFiltro);
        cboFiltrar.setAdapter(SpinerAdaptador);

        btnLiquidar.setOnClickListener(btnLiquidarOnClickListener);
        btnRechazar.setOnClickListener(btnRechazarOnClickListener);
        btnMapa.setOnClickListener(btnMapaOnClickListener);

        try {
            dataBaseHelper = new DataBaseHelper(ListaOrdenesActivity.this);
            dataBaseHelper.createDataBase();
            dataBaseHelper.openDataBase();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        /*CODIGO QUE SE BORRARA*/
        btnVerDetalle.setOnClickListener(btnVerDetalleOnClickListener);

        rvPrincipal = (RecyclerView) findViewById(R.id.rvPrincipal);
        rvPrincipal.setHasFixedSize(true);
        rvPrincipal.setLayoutManager(new LinearLayoutManager(ListaOrdenesActivity.this));

        rvListadoAdapter = new RVListadoAdapter(ListaOrdenesActivity.this);
        rvPrincipal.setAdapter(rvListadoAdapter);
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

    @Override
    public void onListadoClick(ListaOrdenes listaOrdenes, int position) {
        Intent intent = new Intent(ListaOrdenesActivity.this,DetalleOrdenesActivity.class);
        intent.putExtra(ARG_ORDEN, listaOrdenes);
        intent.putExtra(ARG_POSITION, position);
        startActivity(intent);
        //startActivityForResult(intent, REQUEST_CODE_EDITAR);
        Toast.makeText(ListaOrdenesActivity.this, listaOrdenes.getOrden(), Toast.LENGTH_SHORT).show();
    }
}
