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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LightshowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lightshow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val clLightshow = view.findViewById<ConstraintLayout>(R.id.cl_lightshow_layout)
        val switchLightshow = view.findViewById<SwitchCompat>(R.id.switch_lightshow)

        switchLightshow.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                clLightshow.setBackgroundColor(ContextCompat.getColor(context!!, R.color.black))
            } else {
                val animatedBackground = clLightshow.background as AnimationDrawable
                animatedBackground.apply {
                    setEnterFadeDuration(1500)
                    setExitFadeDuration(3000)
                    start()
                }

            }
        }
    }
}