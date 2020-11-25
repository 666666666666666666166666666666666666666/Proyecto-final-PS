package com.example.covidtracking2.Usuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracking2.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PersonViewHolder>
{
    List<Usuarios> usuariosList;
    public  Adapter(List<Usuarios> usuariosList)
    {
        this.usuariosList=usuariosList;
    }
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler,parent,false);
        PersonViewHolder holder=new PersonViewHolder(v);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Usuarios usuarios=usuariosList.get(position);
        holder.textNombre.setText(usuarios.getNombre());
        holder.texCorreo.setText(usuarios.getEmail());
      //  holder.texCodigo.setText(usuarios.getStrinCodigo());
    }

    @Override
    public int getItemCount() {
        return usuariosList.size();
    }

    public static  class  PersonViewHolder extends RecyclerView.ViewHolder{
        TextView textNombre,texCorreo,texCodigo;

        public PersonViewHolder(View itemView)
        {
            super(itemView);
            textNombre=(TextView) itemView.findViewById(R.id.txtNombreSalida);
            texCorreo=(TextView) itemView.findViewById(R.id.textView63);
            //texCodigo=(TextView) itemView.findViewById(R.id.txtcodigo);
        }
    }
}
