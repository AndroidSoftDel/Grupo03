package com.example.javierhuinocana.grupo03_cibertec;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Javier Huiñocana on 08/09/2015.
 */
public class RechazarOrdenActivity extends AppCompatActivity {

    private Button btnRechazarOrden_Rechazar, btnCancelar_Rechazar;
    private TextInputLayout tilNombre_Rechazar, tilDni_Rechazar, tilObservaciones_Rechazar;
    TextView tvOrden_Rechazar, tvTelefono_Rechazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rechazar_orden);

        tilNombre_Rechazar = (TextInputLayout) findViewById(R.id.tilNombre_Rechazar);
        tilDni_Rechazar = (TextInputLayout) findViewById(R.id.tilDni_Rechazar);
        tilObservaciones_Rechazar = (TextInputLayout) findViewById(R.id.tilObservaciones_Rechazar);

        btnRechazarOrden_Rechazar = (Button) findViewById(R.id.btnRechazarOrden_Rechazar);
        btnCancelar_Rechazar = (Button) findViewById(R.id.btnCancelar_Rechazar);

        tvOrden_Rechazar = (TextView)findViewById(R.id.tvOrden_Rechazar);
        tvTelefono_Rechazar = (TextView)findViewById(R.id.tvTelefono_Rechazar);


        /*ASOCIAMOS EVENTO CLICK AL BOTON*/
        btnRechazarOrden_Rechazar.setOnClickListener(btnRechazarOrden_RechazarOnClickListener);
        btnCancelar_Rechazar.setOnClickListener(btnCancelar_RechazarOnClickListener);
    }

    View.OnClickListener btnRechazarOrden_RechazarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isCorrect = true;
            // Persona persona = new Persona();

            tilObservaciones_Rechazar.setErrorEnabled(false);
            //falta actualizar la BD
            //no se hacen validaciones de nombre, DNI. si debe existie una observacion.
            if (tilObservaciones_Rechazar.getEditText().getText().toString().trim().length() <= 0) {
                tilObservaciones_Rechazar.setError("Ingrese las observaciones");
                tilObservaciones_Rechazar.setErrorEnabled(true);
                isCorrect = false;
            } //else
            // persona.setDni(tilSecondDNI.getEditText().getText().toString().trim());
            Toast.makeText(RechazarOrdenActivity.this, "Rechazado correctamente", Toast.LENGTH_SHORT).show();
            /*if (isCorrect) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.ARG_PERSONA, persona);
                intent.putExtra(MainActivity.ARG_POSITION, position);
                setResult(RESULT_OK, intent);
                finish();
            }*/
            finish();

        }
    };
        View.OnClickListener btnCancelar_RechazarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

}
