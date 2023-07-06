package com.zvonimirplivelic.bulbz.ui

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.zvonimirplivelic.bulbz.R
import kotlinx.coroutines.*

class LightshowFragment : Fragment() {

    private var lightShowJob: Job?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lightshow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val clLightShow = view.findViewById<ConstraintLayout>(R.id.cl_light_show_layout)
        val switchLightShow = view.findViewById<SwitchCompat>(R.id.switch_light_show)

        switchLightShow.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                clLightShow.setBackgroundColor(ContextCompat.getColor(context!!, R.color.black))
            } else {
                val animatedBackground = clLightShow.background as AnimationDrawable
                animatedBackground.apply {
                    setEnterFadeDuration(1500)
                    setExitFadeDuration(3000)
                    start()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (lightShowJob?.isActive == true) {
            lightShowJob!!.cancel()
        }
    }
}