package com.autos.ui.auto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.autos.R
import com.autos.databinding.FragmentAddAutoBinding
import com.autos.model.Auto
import com.autos.viewmodel.AutoViewModel

class AddAutoFragment : Fragment() {

    private lateinit var autoViewModel : AutoViewModel

    private var _binding: FragmentAddAutoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        autoViewModel = ViewModelProvider(this)[AutoViewModel::class.java]
        _binding = FragmentAddAutoBinding.inflate(inflater, container, false)

        binding.btAgregar.setOnClickListener { addAuto() }
        return binding.root
    }

    private fun addAuto() {
        val marca = binding.etMarca.text.toString()
        val modelo = binding.etModelo.text.toString()
        val color = binding.etColor.text.toString()
        val anualidad = binding.etAnualidad.text.toString()
        val placa = binding.etPlaca.text.toString()
        val pais = binding.etPais.text.toString()
        val plazas = binding.etPlazas.text.toString()
        val cilindraje = binding.etCilindraje.text.toString()

        if(marca.isNotEmpty()){
            val auto = Auto(0,marca,modelo,color,anualidad,placa,pais,plazas,cilindraje)
            autoViewModel.addAuto(auto)
            Toast.makeText(requireContext(),getString(R.string.autoAdded),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addAutoFragment_to_nav_auto)
        }else{
            Toast.makeText(requireContext(),getString(R.string.noData),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
