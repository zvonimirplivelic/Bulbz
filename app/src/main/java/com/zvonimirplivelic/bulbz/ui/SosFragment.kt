package com.zvonimirplivelic.bulbz.ui

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.zvonimirplivelic.bulbz.R
import com.zvonimirplivelic.bulbz.util.Constants.MORSE_TIME_UNIT
import kotlinx.android.synthetic.main.fragment_sos.*
import kotlinx.coroutines.*


class SosFragment : Fragment() {
    private var sosJob: Job? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val clSosLayout = view.findViewById<ConstraintLayout>(R.id.cl_sos_layout)
        val switchSos = view.findViewById<SwitchCompat>(R.id.switch_sos)

        switchSos?.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                sosJob?.cancel()
                clSosLayout.setBackgroundColor(
                    ContextCompat.getColor(
                        context!!,
                        R.color.black
                    )
                )
            } else {
                sosJob = GlobalScope.launch(Dispatchers.Main) {
                    while (isChecked) {
                        for (s in 0..2) {
                            clSosLayout.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.white
                                )
                            )
                            delay(MORSE_TIME_UNIT)
                            clSosLayout.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.black
                                )
                            )
                            delay(MORSE_TIME_UNIT)
                        }
                        delay(MORSE_TIME_UNIT * 2)
                        for (o in 0..2) {
                            clSosLayout.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.white
                                )
                            )
                            delay(MORSE_TIME_UNIT * 3)
                            clSosLayout.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.black
                                )
                            )
                            delay(MORSE_TIME_UNIT)
                        }
                        delay(MORSE_TIME_UNIT * 2)
                        for (s in 0..2) {
                            clSosLayout.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.white
                                )
                            )
                            delay(MORSE_TIME_UNIT)
                            clSosLayout.setBackgroundColor(
                                ContextCompat.getColor(
                                    context!!,
                                    R.color.black
                                )
                            )
                            delay(MORSE_TIME_UNIT)
                        }
                        delay(MORSE_TIME_UNIT*5)
                    }

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (sosJob?.isActive == true) {
            sosJob!!.cancel()
        }
    }
}