package com.example.covidtracking2.Usuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covidtracking2.R;

import java.util.List;

public class AdapterSuge extends RecyclerView.Adapter<AdapterSuge.PersonViewHolder>
{
    List<Suge> sugeList;
    public  AdapterSuge(List<Suge> sugeList)
    {
        this.sugeList=sugeList;
    }
    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_vista_sugerencia,parent,false);
        PersonViewHolder holder=new PersonViewHolder(v);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Suge suges=sugeList.get(position);
        holder.textNombre.setText(suges.getNombre());
        holder.textDescripcion.setText(suges.getDescripcion());
        //  holder.texCodigo.setText(usuarios.getStrinCodigo());
    }

    @Override
    public int getItemCount() {
        return sugeList.size();
    }

    public static  class  PersonViewHolder extends RecyclerView.ViewHolder{
        TextView textNombre,textDescripcion,texCodigo;

        public PersonViewHolder(View itemView)
        {
            super(itemView);
            textNombre=(TextView) itemView.findViewById(R.id.txtUsuario);
            textDescripcion=(TextView) itemView.findViewById(R.id.txtDescipcion);
            //texCodigo=(TextView) itemView.findViewById(R.id.txtcodigo);
        }
    }
}
