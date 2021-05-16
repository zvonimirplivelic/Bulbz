package com.zvonimirplivelic.bulbz.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.zvonimirplivelic.bulbz.R
import kotlinx.coroutines.*

class EmergencyFragment : Fragment() {

    private var emergencyJob: Job?= null
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
                emergencyJob = GlobalScope.launch(Dispatchers.Main) {
                    topHalf.visibility = View.VISIBLE
                    bottomHalf.visibility = View.VISIBLE
                    while (isChecked) {
                        for (i in 0..2) {
                            delay(125L)
                            topHalf.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.red
                                )
                            )
                            bottomHalf.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.blue
                                )
                            )
                            delay(125L)
                            topHalf.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.blue
                                )
                            )
                            bottomHalf.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.red
                                )
                            )
                        }
                        for (i in 0..6) {
                            delay(70L)
                            topHalf.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.red
                                )
                            )
                            bottomHalf.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.blue
                                )
                            )
                            delay(70L)
                            topHalf.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.blue
                                )
                            )
                            bottomHalf.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.red
                                )
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (emergencyJob?.isActive == true) {
            emergencyJob!!.cancel()
        }
    }
}