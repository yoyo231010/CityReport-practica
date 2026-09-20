package com.example.cityreport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityreport.databinding.FragmentListaIncidenciasBinding

class ListaIncidenciasFragment : Fragment() {

    // Configuración de View Binding recomendada para Fragments
    private var _binding: FragmentListaIncidenciasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaIncidenciasBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Aquí es donde configuramos nuestro RecyclerView una vez que la pantalla ya cargó
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Crear una lista simulada para probar que funcione
        val listaDePrueba = listOf(
            Incidencia("1", "Semáforo descompuesto", "Falla en semáforo cerca de Metrobús Línea 2", "20/09/2026", "Pendiente"),
            Incidencia("2", "Bache profundo", "Bache en el carril derecho de Av. Té", "19/09/2026", "En proceso"),
            Incidencia("3", "Luminaria fundida", "Poste sin luz en la esquina", "18/09/2026", "Resuelto")
        )

        // 2. Enviar los datos al Adaptador
        val adaptador = IncidenciaAdapter(listaDePrueba)

        // 3. Configurar cómo se acomodará la lista (uno debajo del otro) y asignarle el adaptador
        binding.rvIncidencias.layoutManager = LinearLayoutManager(requireContext())
        binding.rvIncidencias.adapter = adaptador
    }

    // Es importante limpiar el binding cuando el fragmento se destruye
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}