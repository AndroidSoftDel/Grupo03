package com.example.javierhuinocana.grupo03_cibertec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.javierhuinocana.grupo03_cibertec.entities.ListaOrdenes;

/**
 * Created by Javier Huiñocana on 08/09/2015.
 */
public class DetalleOrdenesActivity extends AppCompatActivity {

    EditText txtZonal,txtFecha_Registro,txtNegocio,txtActividad,txtOrden,txtTelefono,txtCliente,txtDireccion;
    Button btnVerMapa,btnLiquidar,btnRechazar;
    ListaOrdenes listaOrdenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_orden);

        txtZonal=(EditText)findViewById(R.id.txtZonal_Detalle);
        txtFecha_Registro=(EditText)findViewById(R.id.txtFecha_Registro_Detalle);
        txtNegocio=(EditText)findViewById(R.id.txtNegocio_Detalle);
        txtActividad=(EditText)findViewById(R.id.txtActividad_Detalle);
        txtOrden=(EditText)findViewById(R.id.txtOrden_Detalle);
        txtTelefono=(EditText)findViewById(R.id.txtTelefono_Detalle);
        txtCliente=(EditText)findViewById(R.id.txtCliente_Detalle);
        txtDireccion=(EditText)findViewById(R.id.txtDireccion_Detalle);
        btnVerMapa=(Button)findViewById(R.id.btnVerMapa_Detalle);
        btnLiquidar=(Button)findViewById(R.id.btnLiquidar_Detalle);
        btnRechazar=(Button)findViewById(R.id.btnRechazar_Detalle);

        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(ListaOrdenesActivity.ARG_ORDEN)) {
            listaOrdenes = getIntent().getParcelableExtra(ListaOrdenesActivity.ARG_ORDEN);
            txtZonal.setText(listaOrdenes.getZonal());
            txtNegocio.setText(listaOrdenes.getNegocio());
            txtActividad.setText(listaOrdenes.getActividad());
            txtOrden.setText(listaOrdenes.getOrden());
            txtTelefono.setText(listaOrdenes.getTelefono());
            txtCliente.setText(listaOrdenes.getCliente());
            txtDireccion.setText(listaOrdenes.getDireccion());
            txtFecha_Registro.setText(listaOrdenes.getFecha_Registro());
        }


        btnVerMapa.setOnClickListener(btnVerMapaOnClickListener);
        btnLiquidar.setOnClickListener(btnLiquidarOnClickListener);
        btnRechazar.setOnClickListener(btnRechazarOnClickListener);

        /*IMPEDIMOS QUE SE MODIFIQUEN LOS VALORES*/
        txtFecha_Registro.setKeyListener(null);
        txtNegocio.setKeyListener(null);
        txtActividad.setKeyListener(null);
        txtOrden.setKeyListener(null);
        txtTelefono.setKeyListener(null);
        txtCliente.setKeyListener(null);
        txtDireccion.setKeyListener(null);
    }

    View.OnClickListener btnVerMapaOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    View.OnClickListener btnLiquidarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(DetalleOrdenesActivity.this,LiquidarOrdenActivity.class);
            intent.putExtra(ListaOrdenesActivity.ARG_ORDEN,listaOrdenes);
            startActivity(intent);
        }
    };
    View.OnClickListener btnRechazarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(DetalleOrdenesActivity.this,RechazarOrdenActivity.class);
            startActivity(intent);
        }
    };
}
