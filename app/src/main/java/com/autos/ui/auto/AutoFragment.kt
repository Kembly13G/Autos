package com.autos.ui.auto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.autos.R
import com.autos.databinding.FragmentAutoBinding
import com.autos.viewmodel.AutoViewModel

class AutoFragment : Fragment() {

    private lateinit var autoViewModel : AutoViewModel

    private var _binding: FragmentAutoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        autoViewModel = ViewModelProvider(this)[AutoViewModel::class.java]
        _binding = FragmentAutoBinding.inflate(inflater, container, false)

        binding.addAutoButton.setOnClickListener{
            findNavController().navigate(R.id.action_nav_auto_to_addAutoFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}