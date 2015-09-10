package com.example.javierhuinocana.grupo03_cibertec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Javier Huiñocana on 08/09/2015.
 */
public class RechazarOrdenActivity extends AppCompatActivity {

    EditText txtOrden, txtTelefono, txtAtendio, txtDni;
    Button btnRechazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rechazar_orden);

        txtOrden = (EditText) findViewById(R.id.txtOrden_Rechazar);
        txtTelefono = (EditText) findViewById(R.id.txtTelefono_Rechazar);
        txtAtendio = (EditText) findViewById(R.id.txtAtendio_Rechazar);
        txtDni = (EditText) findViewById(R.id.txtDNI_Rechazar);
        txtOrden = (EditText) findViewById(R.id.txtObservaciones_Rechazar);

        btnRechazar = (Button) findViewById(R.id.btnRechazar_Rechazar);

        /*PARA CANCELAR LA EDICION EN LOS CONTROLES*/
        txtOrden.setKeyListener(null);
        txtTelefono.setKeyListener(null);

        /*ENVIAMOS FOCO*/
        txtAtendio.requestFocus();

        /*ASOCIAMOS EVENTO CLICK AL BOTON*/
        btnRechazar.setOnClickListener(btnRechazarOnClickListener);
    }

    View.OnClickListener btnRechazarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
