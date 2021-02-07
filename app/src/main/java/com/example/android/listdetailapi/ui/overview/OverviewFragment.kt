package com.example.android.listdetailapi.ui.overview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android.listdetailapi.databinding.FragmentOverviewBinding
import com.example.android.listdetailapi.data.Result


class OverviewFragment : Fragment(),GroupAdapter.OnItemClick {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GroupViewModel by viewModels()
    private lateinit var groupAdapter: GroupAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        val view = binding.root
        val groupObserver = Observer<Result>{
            binding.progressBar.visibility = View.GONE
            when (it){
                is Result.Success->{
                    groupAdapter.groupList= it.list
                    Log.i("groups", it.list.toString())
                    groupAdapter.notifyDataSetChanged()
                }
                is Result.Failure->
                    Toast.makeText(requireContext(), "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.getGroupListLiveData().observe(viewLifecycleOwner, groupObserver)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerView
        groupAdapter= GroupAdapter(requireContext(), this)
        recyclerView.adapter = groupAdapter
        recyclerView.setHasFixedSize(true)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClickListener(position: Int) {
        val group= groupAdapter.groupList[position]
        val action = OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(group)
        findNavController().navigate(action)
    }


}