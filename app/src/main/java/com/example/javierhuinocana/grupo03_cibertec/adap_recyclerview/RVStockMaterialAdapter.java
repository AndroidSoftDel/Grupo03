package com.example.javierhuinocana.grupo03_cibertec.adap_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.javierhuinocana.grupo03_cibertec.R;
import com.example.javierhuinocana.grupo03_cibertec.dao.StockDAO;
import com.example.javierhuinocana.grupo03_cibertec.entities.StockMaterial;

import java.util.ArrayList;

/**
 * Created by JMartinez on 12/09/2015.
 */
public class RVStockMaterialAdapter extends RecyclerView.Adapter<RVStockMaterialAdapter.RVStockMaterialAdapterViewHolder> {
    private ArrayList<StockMaterial> mLstStockMaterial,mLstStockMaterialFilter;
    private RVStockMaterialAdapterCallBack mRVStockMaterialAdapterCallBack;
    private String Cantidad = "";

    public interface RVStockMaterialAdapterCallBack {
        void onStockClick(StockMaterial stockMaterial, int position);
    }

    public RVStockMaterialAdapter(RVStockMaterialAdapterCallBack mRVStockMaterialAdapterCallBack) {
        this.mRVStockMaterialAdapterCallBack = mRVStockMaterialAdapterCallBack;
        mLstStockMaterialFilter = new ArrayList<>();
        mLstStockMaterial = new ArrayList<>();
        mLstStockMaterial.addAll(new StockDAO().lstStockMaterial());
        mLstStockMaterialFilter.addAll(mLstStockMaterial);
    }

    @Override
    public RVStockMaterialAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new RVStockMaterialAdapterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_material_add, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RVStockMaterialAdapterViewHolder rvStockMaterialAdapterViewHolder, int i) {
        StockMaterial stockMaterial = mLstStockMaterialFilter.get(i);
        rvStockMaterialAdapterViewHolder.itemView.setTag(i);
        rvStockMaterialAdapterViewHolder.itemView.setOnClickListener(itemViewOnClickListener);
        rvStockMaterialAdapterViewHolder.tvDescripcion.setText(stockMaterial.getDescripcion());
        rvStockMaterialAdapterViewHolder.tvStock.setText(String.valueOf(stockMaterial.getCantidad()));
        rvStockMaterialAdapterViewHolder.tvCantidadAdd.setText(String.valueOf(Cantidad));
    }

    View.OnClickListener itemViewOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mRVStockMaterialAdapterCallBack != null){
                mRVStockMaterialAdapterCallBack.onStockClick(mLstStockMaterialFilter.get((int) view.getTag()),(int) view.getTag());
            }
        }
    };

    @Override
    public int getItemCount() {
        return mLstStockMaterialFilter.size();
    }

    static class RVStockMaterialAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView  tvDescripcion, tvStock, tvCantidadAdd;

        public RVStockMaterialAdapterViewHolder(View itemView) {
            super(itemView);

            tvDescripcion = (TextView) itemView.findViewById(R.id.txtDescripcion_AddMat);
            tvStock = (TextView) itemView.findViewById(R.id.txtStock_AddMat);
            tvCantidadAdd = (TextView) itemView.findViewById(R.id.txtCantidad_AddMat);
        }
    }
}
