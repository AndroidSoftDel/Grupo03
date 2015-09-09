package com.example.javierhuinocana.grupo03_cibertec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Javier Huiñocana on 08/09/2015.
 */
public class DetalleOrdenesActivity extends AppCompatActivity {

    EditText txtZonal,txtNegocio,txtActividad,txtOrden,txtTelefono,txtCliente,txtDireccion;
    Button btnVerMapa,btnLiquidar,btnRechazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_orden);

        txtZonal=(EditText)findViewById(R.id.txtZonal);
        txtNegocio=(EditText)findViewById(R.id.txtNegocio);
        txtActividad=(EditText)findViewById(R.id.txtActividad);
        txtOrden=(EditText)findViewById(R.id.txtOrden);
        txtTelefono=(EditText)findViewById(R.id.txtTelefono);
        txtCliente=(EditText)findViewById(R.id.txtCliente);
        txtDireccion=(EditText)findViewById(R.id.txtDireccion);
        btnVerMapa=(Button)findViewById(R.id.btnVerMapa_Detalle);
        btnLiquidar=(Button)findViewById(R.id.btnLiquidar_Detalle);
        btnRechazar=(Button)findViewById(R.id.btnRechazar_Detalle);


        /*CAMPOS QUE TIENEN QUE SER LLENADOS DE LA BASE DE DATOS*/
        txtZonal.setText("LIM");
        txtNegocio.setText("STB");
        txtActividad.setText("Actividad");
        txtOrden.setText("BAR0512515");
        txtTelefono.setText("5215248");
        txtCliente.setText("Luis Fajardo Lopez");
        txtDireccion.setText("Carmen de la Legua");


        btnVerMapa.setOnClickListener(btnVerMapaOnClickListener);
        btnLiquidar.setOnClickListener(btnLiquidarOnClickListener);
        btnRechazar.setOnClickListener(btnRechazarOnClickListener);

        /*IMPEDIMOS QUE SE MODIFIQUEN LOS VALORES*/
        txtZonal.setKeyListener(null);
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

        }
    };
    View.OnClickListener btnRechazarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
