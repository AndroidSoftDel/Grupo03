package com.example.javierhuinocana.grupo03_cibertec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView;

import com.example.javierhuinocana.grupo03_cibertec.adap_recyclerview.RVListadoAdapter;
import com.example.javierhuinocana.grupo03_cibertec.adap_spiner.SpinerAdapter;
import com.example.javierhuinocana.grupo03_cibertec.dao.DataBaseHelper;
import com.example.javierhuinocana.grupo03_cibertec.dao.ListadoDAO;
import com.example.javierhuinocana.grupo03_cibertec.entities.ListaOrdenes;

import java.util.ArrayList;

/**
 * Created by Javier Huiñocana on 07/09/2015.
 */
public class ListaOrdenesActivity extends AppCompatActivity implements RVListadoAdapter.RVListadoAdapterCallBack {

    Spinner cboFiltrar;
    Button btnLiquidar, btnRechazar, btnMapa;
    private SpinerAdapter SpinerAdaptador;
    private RecyclerView rvPrincipal;
    private RVListadoAdapter rvListadoAdapter;
    private DataBaseHelper dataBaseHelper;

    public final static String ARG_ORDEN = "orden", ARG_POSITION = "position";
    private final static int REQUEST_CODE_EDITAR = 2;

    private ArrayList<ListaOrdenes> ListaArray_Pendientes, ListaArray_Liquidadas, ListaArray_Rechazadas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ordenes);

        cboFiltrar = (Spinner) findViewById(R.id.cboFiltrar);
        btnLiquidar = (Button) findViewById(R.id.btnLiquidar_ListaOrdenes);
        btnRechazar = (Button) findViewById(R.id.btnRechazar_ListaOrdenes);
        btnMapa = (Button) findViewById(R.id.btnMapa_ListaOrdenes);

        /*CREAMOS LOS ITEM PARA EL SPINER*/
        ArrayList<String> ArrayFiltro = new ArrayList<>();
        ArrayFiltro.add("Pendientes");
        ArrayFiltro.add("Liquidadas");
        ArrayFiltro.add("Rechazadas");
        /*ASOCIAMOS EL ADAPTADOR AL SPINER*/
        SpinerAdaptador = new SpinerAdapter(ListaOrdenesActivity.this, ArrayFiltro);
        cboFiltrar.setAdapter(SpinerAdaptador);

        /*ASOCIAMOS EVENTOS*/
        btnLiquidar.setOnClickListener(btnLiquidarOnClickListener);
        btnRechazar.setOnClickListener(btnRechazarOnClickListener);
        btnMapa.setOnClickListener(btnMapaOnClickListener);

        /*CREAMOS Y/O COPIAMOS BD AL CELULAR*/
        try {
            dataBaseHelper = new DataBaseHelper(ListaOrdenesActivity.this);
            dataBaseHelper.createDataBase();
            dataBaseHelper.openDataBase();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        ArrayList<ListaOrdenes> arrayListTemporal;
        arrayListTemporal = new ArrayList<>();
        arrayListTemporal.addAll(new ListadoDAO().listOrdenes());

        ListaArray_Pendientes= new ArrayList<ListaOrdenes>();
        ListaArray_Liquidadas= new ArrayList<ListaOrdenes>();
        ListaArray_Rechazadas= new ArrayList<ListaOrdenes>();

        for (int i = 0; i < arrayListTemporal.size(); i++) {
            switch (arrayListTemporal.get(i).getEstado()) {
                case 0:
                    /*PENDIENTES*/
                    ListaArray_Pendientes.add(arrayListTemporal.get(i)); //, ListaArray_Liquidadas, ListaArray_Rechazadas;
                    break;
                case 1:
                    ListaArray_Liquidadas.add(arrayListTemporal.get(i)); //, , ListaArray_Rechazadas;

                    break;
                case 10:
                    ListaArray_Rechazadas.add(arrayListTemporal.get(i));
                    break;
            }
        }

        rvPrincipal = (RecyclerView) findViewById(R.id.rvPrincipal);
        rvPrincipal.setHasFixedSize(true);
        rvPrincipal.setLayoutManager(new LinearLayoutManager(ListaOrdenesActivity.this));

        rvListadoAdapter = new RVListadoAdapter(ListaOrdenesActivity.this,ListaArray_Pendientes);
        rvPrincipal.setAdapter(rvListadoAdapter);

        cboFiltrar.setOnItemSelectedListener(cboFiltrarOnItemSelectedListener);
    }

    AdapterView.OnItemSelectedListener cboFiltrarOnItemSelectedListener = new AdapterView.OnItemSelectedListener(){

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position){
                case 0:
                    /*PENDIENTES*/
                    rvListadoAdapter = new RVListadoAdapter(ListaOrdenesActivity.this,ListaArray_Pendientes);
                    rvPrincipal.setAdapter(rvListadoAdapter);

                    /*ACTIVAMOS CONTROLES*/
                    btnLiquidar.setEnabled(true);
                    btnRechazar.setEnabled(true);
                    break;
                case 1:
                    /*LIQUIDADAS*/
                    rvListadoAdapter = new RVListadoAdapter(ListaOrdenesActivity.this,ListaArray_Liquidadas);
                    rvPrincipal.setAdapter(rvListadoAdapter);

                    /*DESACTIVAMOS CONTROLES*/
                    btnLiquidar.setEnabled(false);
                    btnRechazar.setEnabled(false);


                    break;
                case 2:
                    /*RECHAZADAS*/
                    rvListadoAdapter = new RVListadoAdapter(ListaOrdenesActivity.this,ListaArray_Rechazadas);
                    rvPrincipal.setAdapter(rvListadoAdapter);

                    /*DESACTIVAMOS CONTROLES*/
                    btnLiquidar.setEnabled(false);
                    btnRechazar.setEnabled(false);

                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

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

    @Override
    public void onListadoClick(ListaOrdenes listaOrdenes, int position) {
        Intent intent = new Intent(ListaOrdenesActivity.this, DetalleOrdenesActivity.class);
        intent.putExtra(ARG_ORDEN, listaOrdenes);
        intent.putExtra(ARG_POSITION, position);
        startActivity(intent);
        //startActivityForResult(intent, REQUEST_CODE_EDITAR);
        //Toast.makeText(ListaOrdenesActivity.this, listaOrdenes.getOrden(), Toast.LENGTH_SHORT).show();
    }
}
