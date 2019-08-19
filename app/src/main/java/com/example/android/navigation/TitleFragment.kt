package com.example.android.navigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    lateinit var binding:FragmentTitleBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //initiate binding var and inflate it with the frament_titile layout.
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_title, container, false
        )

        onTapPlayButton()

        //return root of binding
        return binding.root

    }

    fun onTapPlayButton(){
        binding.playButton.setOnClickListener {view: View -> //view as in button's parentView
            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
            //navigation can also create onClickListeners for us as well
            //simpler way ->
            //Navigation.createNavigationOnClickListener(R.id.action_titleFragment_to_gameFragment)
        }
    }



}
