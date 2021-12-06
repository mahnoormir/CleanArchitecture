package com.example.cleanarchitecturedemo.presentation.meal_search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.cleanarchitecturedemo.R
import com.example.cleanarchitecturedemo.databinding.FragmentMealSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MealSearchFragment : Fragment() {

    private var _binding: FragmentMealSearchBinding?= null
            val binding : FragmentMealSearchBinding
            get() = _binding!!

    private val mealSearchViewModel:MealSearchViewModel by viewModels()
    private val mealSearchAdapter = MealSearchAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMealSearchBinding.inflate(inflater,container,false)
        return _binding?.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_meal_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.searchMeal.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               //text submitted
                query?. let {
                    mealSearchViewModel.searchMealList(it)
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
               return false
            }

        })

        binding.searchRecycler.apply {
                adapter = mealSearchAdapter
        }

        lifecycle.coroutineScope.launchWhenCreated {
            mealSearchViewModel.mealSearchList.collect {

                if(it.isLoading){
                    binding.mealNotFound.visibility= View.GONE
                    binding.progressMealSearch.visibility = View.VISIBLE
                }
                if(it.error.isNotBlank()){
                    binding.mealNotFound.visibility= View.GONE
                    binding.progressMealSearch.visibility = View.GONE
                }
                it.data?. let {

                    if (it.isEmpty()){
                        binding.mealNotFound.visibility= View.VISIBLE
                    }

                    binding.progressMealSearch.visibility = View.GONE
                    mealSearchAdapter.setContentList(it.toMutableList())
                }

            }
        }
        mealSearchAdapter.itemClickListener {
            findNavController().navigate(MealSearchFragmentDirections.actionMealSearchFragmentToMealDetailsFragment(
                mealId = it.mealId))
        }

    }

}