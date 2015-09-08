package com.example.javierhuinocana.grupo03_cibertec.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;

import com.example.javierhuinocana.grupo03_cibertec.entities.ListaOrdenes;
/**
 * Created by luisrios on 9/5/15.
 */
public class ListadoDAO {

    public ArrayList<ListaOrdenes> listOrdenes() {
        ArrayList<ListaOrdenes> lstOrdenes = new ArrayList<>();
        Cursor cursor = null;


        try {
            cursor = DataBaseHelper.myDataBase.query("Persona", null, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    ListaOrdenes listaOrdenes = new ListaOrdenes();
                    listaOrdenes.setIdOrden(cursor.isNull(cursor.getColumnIndex("IdOrden")) ? 0 : cursor.getInt(cursor.getColumnIndex("IdOrden")));
                    listaOrdenes.setOrden(cursor.isNull(cursor.getColumnIndex("Orden")) ? "" : cursor.getString(cursor.getColumnIndex("Orden")));
                    listaOrdenes.setTelefono(cursor.isNull(cursor.getColumnIndex("Telefono")) ? "" : cursor.getString(cursor.getColumnIndex("Telefono")));
                    listaOrdenes.setCliente(cursor.isNull(cursor.getColumnIndex("Cliente")) ? "" : cursor.getString(cursor.getColumnIndex("Cliente")));
                    listaOrdenes.setDireccion(cursor.isNull(cursor.getColumnIndex("Direccion")) ? "" : cursor.getString(cursor.getColumnIndex("Direccion")));
                    lstOrdenes.add(listaOrdenes);
                } while (cursor.moveToNext());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }

        return lstOrdenes;
    }


    public long updateListado(ListaOrdenes listaOrdenes) {
        long udp = 0;
        try {
            ContentValues cv = new ContentValues();
            cv.put("DniCliente", listaOrdenes.getDniCliente());
            cv.put("Estado", listaOrdenes.getEstado());
            cv.put("Fecha_Liquidacion", listaOrdenes.getFecha_Liquidacion());

            DataBaseHelper.myDataBase.beginTransaction();
            udp = DataBaseHelper.myDataBase.update("ListadoOrdenes", cv, "IdOrden = ?", new String[]{String.valueOf(listaOrdenes.getIdOrden())});
            DataBaseHelper.myDataBase.setTransactionSuccessful();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataBaseHelper.myDataBase.endTransaction();
        }
        return  udp;
    }

}