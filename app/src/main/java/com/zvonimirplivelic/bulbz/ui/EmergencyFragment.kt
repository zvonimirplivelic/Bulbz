package com.zvonimirplivelic.bulbz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.zvonimirplivelic.bulbz.R
import kotlinx.coroutines.*

class EmergencyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_emergency, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topHalf = view.findViewById<ImageView>(R.id.iv_top)
        val bottomHalf = view.findViewById<ImageView>(R.id.iv_bottom)
        val switchEmergency = view.findViewById<SwitchCompat>(R.id.switch_emergency)

        switchEmergency?.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                topHalf.visibility = View.GONE
                bottomHalf.visibility = View.GONE
            } else {
                GlobalScope.launch(Dispatchers.Main) {
                    topHalf.visibility = View.VISIBLE
                    bottomHalf.visibility = View.VISIBLE
                    while (isChecked) {
                        for (i in 1..4) {
                            delay(150L)
                            topHalf.setBackgroundColor(resources.getColor(R.color.red))
                            bottomHalf.setBackgroundColor(resources.getColor(R.color.blue))
                            delay(150L)
                            topHalf.setBackgroundColor(resources.getColor(R.color.blue))
                            bottomHalf.setBackgroundColor(resources.getColor(R.color.red))
                        }
                        for (i in 1..7) {
                            delay(75L)
                            topHalf.setBackgroundColor(resources.getColor(R.color.red))
                            bottomHalf.setBackgroundColor(resources.getColor(R.color.blue))
                            delay(75L)
                            topHalf.setBackgroundColor(resources.getColor(R.color.blue))
                            bottomHalf.setBackgroundColor(resources.getColor(R.color.red))
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}