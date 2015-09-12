package com.example.javierhuinocana.grupo03_cibertec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Javier Huiñocana on 11/09/2015.
 */
public class AddMaterialLiquidarActivity extends AppCompatActivity {

    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_material_liquidar);

        btnAgregar=(Button)findViewById(R.id.btnAgregarMaterial_AddMaterialLiquidar);

        btnAgregar.setOnClickListener(btnAgregarOnClickListener);
    }

    View.OnClickListener btnAgregarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };
}
