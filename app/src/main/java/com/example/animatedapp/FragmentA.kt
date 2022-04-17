package com.example.animatedapp

import android.os.Bundle
import android.transition.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_a_scene_1, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonShowAnimation = view.findViewById<Button>(R.id.button_start_animation)

        buttonShowAnimation.setOnClickListener { expand() }
    }

    private fun expand() {
        val secondScene = Scene.getSceneForLayout(
            requireView() as ViewGroup,
            R.layout.fragment_a_scene_2,
            requireContext()
        )
        TransitionManager.go(secondScene, TransitionSet().apply {
            addTransition(ChangeBounds())
            duration = 400
        })
    }
}