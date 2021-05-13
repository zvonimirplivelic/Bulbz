package com.zvonimirplivelic.bulbz.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.zvonimirplivelic.bulbz.R
import kotlinx.android.synthetic.main.fragment_flashlight.view.*

class FlashlightFragment : Fragment() {
    private var lightOn = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_flashlight, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ivFlashlight: ImageView = view.findViewById(R.id.iv_flashlight)
        val clFlashlight: ConstraintLayout = view.findViewById(R.id.cl_flashlight_layout)

        ivFlashlight.setOnClickListener {
            lightOn = if (lightOn) {
                clFlashlight.setBackgroundColor(Color.BLACK)
                false
            } else {
                clFlashlight.setBackgroundColor(Color.WHITE)
                true
            }
        }
    }
}