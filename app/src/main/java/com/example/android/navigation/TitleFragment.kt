package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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
        addOverflowMenu()

        //return root of binding
        return binding.root

    }

    //set onClick listener for the playButton
    fun onTapPlayButton(){
        binding.playButton.setOnClickListener {view: View -> //view as in button's parentView
            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
            //navigation can also create onClickListeners for us as well
            //simpler way ->
            //Navigation.createNavigationOnClickListener(R.id.action_titleFragment_to_gameFragment)
        }
    }

    //adds the 3 dotted overflowMenu bar to the appBar
    fun addOverflowMenu(){
        setHasOptionsMenu(true)
    }

    //required func for creating an option menu
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater ?.inflate(R.menu.overflow_menu, menu)
    }

    //since we only have one page to navigate to on the overflow menu, we directly navigate to their kotlin file
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }
}
