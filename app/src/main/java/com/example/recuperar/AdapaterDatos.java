package com.example.recuperar;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapaterDatos extends RecyclerView.Adapter <AdapaterDatos.ViewHolderDatos>{

    ArrayList<DatosVO> listDatos;

    public AdapaterDatos(ArrayList<DatosVO> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_row_item,null,false);

        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        //holder.asignarDatos(listDatos.get(position));
        holder.EtiID.setText(listDatos.get(position).getID());
        holder.EtiTitulo.setText(listDatos.get(position).getTitle());
        holder.EtiInci.setText(listDatos.get(position).getIncidencia());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public static class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView EtiID,EtiTitulo,EtiInci;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            EtiID = (TextView) itemView.findViewById(R.id.id);
            EtiTitulo = (TextView) itemView.findViewById(R.id.titulo);
            EtiInci = (TextView) itemView.findViewById(R.id.inci);
        }
    }
}
