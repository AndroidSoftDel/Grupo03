package com.example.javierhuinocana.grupo03_cibertec;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.javierhuinocana.grupo03_cibertec.adap_recyclerview.RVListadoAdapter;
import com.example.javierhuinocana.grupo03_cibertec.adap_recyclerview.RVStockMaterialAdapter;
import com.example.javierhuinocana.grupo03_cibertec.entities.StockMaterial;

/**
 * Created by Javier Huiñocana on 11/09/2015.
 */
public class AddMaterialLiquidarActivity extends AppCompatActivity implements RVStockMaterialAdapter.RVStockMaterialAdapterCallBack{
    private RecyclerView rvMaterial;
    private RVStockMaterialAdapter rvStockMaterialAdapter;

    Button btnAgregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_material_liquidar);

        btnAgregar=(Button)findViewById(R.id.btnAgregarMaterial_AddMaterialLiquidar);

        btnAgregar.setOnClickListener(btnAgregarOnClickListener);

        rvMaterial = (RecyclerView) findViewById(R.id.rvAddMaterial);
        rvMaterial.setHasFixedSize(true);
        rvMaterial.setLayoutManager(new LinearLayoutManager(AddMaterialLiquidarActivity.this));

        rvStockMaterialAdapter = new RVStockMaterialAdapter(AddMaterialLiquidarActivity.this);
        rvMaterial.setAdapter(rvStockMaterialAdapter);
    }

    View.OnClickListener btnAgregarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    @Override
    public void onStockClick(StockMaterial stockMaterial, int position) {

    }
}
