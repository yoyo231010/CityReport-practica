package com.example.cityreport

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cityreport.databinding.ItemIncidenciaBinding

// El adaptador recibe la lista de incidencias que queremos mostrar
class IncidenciaAdapter(private val listaIncidencias: List<Incidencia>) :
    RecyclerView.Adapter<IncidenciaAdapter.IncidenciaViewHolder>() {

    // El ViewHolder es el encargado de enlazar los datos con la vista usando View Binding
    inner class IncidenciaViewHolder(private val binding: ItemIncidenciaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(incidencia: Incidencia) {
            // Aquí asignamos los valores de la data class a los TextViews del layout
            binding.tvTitulo.text = incidencia.titulo
            binding.tvDescripcion.text = incidencia.descripcion
            binding.tvFecha.text = incidencia.fecha
            binding.tvEstado.text = incidencia.estado
        }
    }

    // Este método "infla" (construye) el layout item_incidencia para cada fila
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncidenciaViewHolder {
        val binding = ItemIncidenciaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return IncidenciaViewHolder(binding)
    }

    // Este método le dice al RecyclerView cuántos elementos hay en total
    override fun getItemCount(): Int {
        return listaIncidencias.size
    }

    // Este método se llama para cada fila y le pasa los datos correspondientes a la posición
    override fun onBindViewHolder(holder: IncidenciaViewHolder, position: Int) {
        val incidencia = listaIncidencias[position]
        holder.bind(incidencia)
    }
}