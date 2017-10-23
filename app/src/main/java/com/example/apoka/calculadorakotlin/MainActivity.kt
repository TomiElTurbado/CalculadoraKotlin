package com.example.apoka.calculadorakotlin

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.lang.Long.toBinaryString
import java.lang.Long.toHexString
import java.lang.Math.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var total: EditText
    lateinit var actual: EditText
    var memory: Double = 0.0
    var lMemory: Long = 0
    var lastSymbol: Int = 0
    var mode: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        total = findViewById(R.id.editText)
        actual = findViewById(R.id.editText2)
        total.setText("0")
        actual.setText("")
        memory = 0.0
        lMemory = 0
        lastSymbol = 0
        mode = 0

        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            /*findViewById<Button>(R.id.button7).isEnabled = false
            findViewById<Button>(R.id.button21).isEnabled = true
            findViewById<Button>(R.id.button22).isEnabled = true

            findViewById<Button>(R.id.button).isEnabled = false
            findViewById<Button>(R.id.button2).isEnabled = false
            findViewById<Button>(R.id.button4).isEnabled = false
            findViewById<Button>(R.id.button3).isEnabled = false
            findViewById<Button>(R.id.button33).isEnabled = false
            findViewById<Button>(R.id.button34).isEnabled = false

            findViewById<Button>(R.id.button23).isEnabled = false
            findViewById<Button>(R.id.button35).isEnabled = false
            findViewById<Button>(R.id.button36).isEnabled = false

            findViewById<Button>(R.id.button10).isEnabled = true
            findViewById<Button>(R.id.button11).isEnabled = true
            findViewById<Button>(R.id.button13).isEnabled = true
            findViewById<Button>(R.id.button14).isEnabled = true
            findViewById<Button>(R.id.button15).isEnabled = true
            findViewById<Button>(R.id.button17).isEnabled = true
            findViewById<Button>(R.id.button18).isEnabled = true
            findViewById<Button>(R.id.button19).isEnabled = true*/
            adjustButtonsAtStart()

            total.setText("0")
            actual.setText("")
        }
        else
        {
            findViewById<Button>(R.id.button7).isEnabled = true
            findViewById<Button>(R.id.button21).isEnabled = true
            findViewById<Button>(R.id.button22).isEnabled = true
            findViewById<Button>(R.id.button23).isEnabled = true
            findViewById<Button>(R.id.button10).isEnabled = true
            findViewById<Button>(R.id.button11).isEnabled = true
            findViewById<Button>(R.id.button13).isEnabled = true
            findViewById<Button>(R.id.button14).isEnabled = true
            findViewById<Button>(R.id.button15).isEnabled = true
            findViewById<Button>(R.id.button17).isEnabled = true
            findViewById<Button>(R.id.button18).isEnabled = true
            findViewById<Button>(R.id.button19).isEnabled = true

            total.setText("0")
            actual.setText("")
        }
    }

    override fun onResume()
    {
        super.onResume()
        total.setText("0")
        actual.setText("")
    }

    fun adjustButtonsAtStart()
    {
        findViewById<Button>(R.id.button7).isEnabled = false
        findViewById<Button>(R.id.button21).isEnabled = true
        findViewById<Button>(R.id.button22).isEnabled = true

        findViewById<Button>(R.id.button).isEnabled = false
        findViewById<Button>(R.id.button2).isEnabled = false
        findViewById<Button>(R.id.button4).isEnabled = false
        findViewById<Button>(R.id.button3).isEnabled = false
        findViewById<Button>(R.id.button33).isEnabled = false
        findViewById<Button>(R.id.button34).isEnabled = false

        findViewById<Button>(R.id.button10).isEnabled = true
        findViewById<Button>(R.id.button11).isEnabled = true
        findViewById<Button>(R.id.button13).isEnabled = true
        findViewById<Button>(R.id.button14).isEnabled = true
        findViewById<Button>(R.id.button15).isEnabled = true
        findViewById<Button>(R.id.button17).isEnabled = true
        findViewById<Button>(R.id.button18).isEnabled = true
        findViewById<Button>(R.id.button19).isEnabled = true
    }

    fun buttonCero(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "0")
    }

    fun buttonUno(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "1")
    }

    fun buttonDos(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "2")
    }

    fun buttonTres(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "3")
    }

    fun buttonCuatro(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "4")
    }

    fun buttonCinco(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "5")
    }

    fun buttonSeis(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "6")
    }

    fun buttonSiete(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "7")
    }

    fun buttonOcho(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "8")
    }

    fun buttonNueve(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "9")
    }

    fun buttonOff(view: View)
    {
        exitProcess(0)
    }

    fun buttonDel(view: View)
    {
        if(actual.text.length > 0)
        {
            actual.setText(actual.text.subSequence(0, actual.text.length - 1))
            if(actual.text.toString().equals("-"))
                actual.setText("")
        }
    }

    fun buttonCE(view: View)
    {
        actual.setText("")
    }

    fun buttonC(view: View)
    {
        actual.setText("")
        total.setText("0")
        lastSymbol = 0
    }

    fun buttonMC(view: View)
    {
        memory = 0.0
        lMemory = 0
    }

    fun buttonMR(view: View)
    {
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            actual.setText("" + memory)
        else
        {
            when(mode)
            {
                0 -> actual.setText("" + lMemory)
                1 -> actual.setText(toHexString(lMemory).toUpperCase())
                2 -> actual.setText(toBinaryString(lMemory))
            }
        }
    }

    fun buttonMP(view: View)
    {
        if(actual.text.isNotEmpty())
        {
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                memory += actual.text.toString().toDouble()
            else
            {
                when(mode)
                {
                    0 -> lMemory += actual.text.toString().toLong()
                    1 -> lMemory += actual.text.toString().toLong(radix = 16)
                    2 -> lMemory += actual.text.toString().toLong(radix = 2)
                }
            }
        }
    }

    fun buttonMM(view: View)
    {
        if(actual.text.isNotEmpty())
        {
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
                memory -= actual.text.toString().toDouble()
            else
            {
                when(mode)
                {
                    0 -> lMemory -= actual.text.toString().toLong()
                    1 -> lMemory -= actual.text.toString().toLong(radix = 16)
                    2 -> lMemory -= actual.text.toString().toLong(radix = 2)
                }
            }
        }
    }

    fun buttonPM(view: View)
    {
        if(actual.text.toString().indexOf('.', 0, false) == -1)
        {
            if (actual.text.length > 0)
            {
                actual.setText("" + (actual.text.toString().toDouble() * -1))
                actual.setText(actual.text.subSequence(0, actual.text.length - 2))
            }
        }
        else
        {
            if (actual.text.length > 0)
                actual.setText("" + (actual.text.toString().toDouble() * -1))
        }
    }

    fun buttonComma(view: View)
    {
        if(actual.text.toString().indexOf('.', 0, false) == -1)
        {
            if (actual.text.toString().equals(""))
                actual.setText("0.")
            else
                actual.setText("" + actual.text + ".")
        }
    }

    fun buttonPlus(view: View)
    {
        if(actual.text.isNotEmpty())
        {
            if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            {
                when (lastSymbol)
                {
                    0 -> {
                        total.setText("" + (total.text.toString().toDouble() + actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    1 -> {
                        total.setText("" + (total.text.toString().toDouble() - actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    2 -> {
                        total.setText("" + (total.text.toString().toDouble() * actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    3 -> {
                        total.setText("" + (total.text.toString().toDouble() / actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                }
            }
            else
            {
                when(mode) {
                    0 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText("" + (total.text.toString().toLong() + actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            1 -> {
                                total.setText("" + (total.text.toString().toLong() - actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            2 -> {
                                total.setText("" + (total.text.toString().toLong() * actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            3 -> {
                                total.setText("" + (total.text.toString().toLong() / actual.text.toString().toLong()))
                                actual.setText("")
                            }
                        }
                    }
                    1 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) + actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            1 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) - actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            2 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) * actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            3 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) / actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                        }
                    }
                    2 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) + actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                            1 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) - actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            2 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) * actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                            3 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) / actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                        }
                    }
                }
            }
            lastSymbol = 0
        }
    }

    fun buttonMinus(view: View)
    {
        if(actual.text.isNotEmpty())
        {
            if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            {
                when (lastSymbol)
                {
                    0 -> {
                        total.setText("" + (total.text.toString().toDouble() + actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    1 -> {
                        total.setText("" + (total.text.toString().toDouble() - actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    2 -> {
                        total.setText("" + (total.text.toString().toDouble() * actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    3 -> {
                        total.setText("" + (total.text.toString().toDouble() / actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                }
            }
            else
            {
                when(mode) {
                    0 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText("" + (total.text.toString().toLong() + actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            1 -> {
                                total.setText("" + (total.text.toString().toLong() - actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            2 -> {
                                total.setText("" + (total.text.toString().toLong() * actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            3 -> {
                                total.setText("" + (total.text.toString().toLong() / actual.text.toString().toLong()))
                                actual.setText("")
                            }
                        }
                    }
                    1 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) + actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            1 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) - actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            2 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) * actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            3 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) / actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                        }
                    }
                    2 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) + actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                            1 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) - actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            2 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) * actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                            3 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) / actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                        }
                    }
                }
            }
            lastSymbol = 1
        }
    }

    fun buttonMulti(view: View)
    {
        if(actual.text.isNotEmpty())
        {
            if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            {
                when (lastSymbol)
                {
                    0 -> {
                        total.setText("" + (total.text.toString().toDouble() + actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    1 -> {
                        total.setText("" + (total.text.toString().toDouble() - actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    2 -> {
                        total.setText("" + (total.text.toString().toDouble() * actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    3 -> {
                        total.setText("" + (total.text.toString().toDouble() / actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                }
            }
            else
            {
                when(mode) {
                    0 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText("" + (total.text.toString().toLong() + actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            1 -> {
                                total.setText("" + (total.text.toString().toLong() - actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            2 -> {
                                total.setText("" + (total.text.toString().toLong() * actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            3 -> {
                                total.setText("" + (total.text.toString().toLong() / actual.text.toString().toLong()))
                                actual.setText("")
                            }
                        }
                    }
                    1 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) + actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            1 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) - actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            2 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) * actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            3 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) / actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                        }
                    }
                    2 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) + actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                            1 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) - actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            2 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) * actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                            3 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) / actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                        }
                    }
                }
            }
            lastSymbol = 2
        }
    }

    fun buttonDivi(view: View)
    {
        if(actual.text.isNotEmpty())
        {
            if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            {
                when (lastSymbol)
                {
                    0 -> {
                        total.setText("" + (total.text.toString().toDouble() + actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    1 -> {
                        total.setText("" + (total.text.toString().toDouble() - actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    2 -> {
                        total.setText("" + (total.text.toString().toDouble() * actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                    3 -> {
                        total.setText("" + (total.text.toString().toDouble() / actual.text.toString().toDouble()))
                        actual.setText("")
                    }
                }
            }
            else
            {
                when(mode) {
                    0 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText("" + (total.text.toString().toLong() + actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            1 -> {
                                total.setText("" + (total.text.toString().toLong() - actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            2 -> {
                                total.setText("" + (total.text.toString().toLong() * actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            3 -> {
                                total.setText("" + (total.text.toString().toLong() / actual.text.toString().toLong()))
                                actual.setText("")
                            }
                        }
                    }
                    1 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) + actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            1 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) - actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            2 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) * actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                            3 -> {
                                total.setText(toHexString(total.text.toString().toLong(radix = 16) / actual.text.toString().toLong(radix = 16)).toUpperCase())
                                actual.setText("")
                            }
                        }
                    }
                    2 -> {
                        when (lastSymbol) {
                            0 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) + actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                            1 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) - actual.text.toString().toLong()))
                                actual.setText("")
                            }
                            2 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) * actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                            3 -> {
                                total.setText(toBinaryString(total.text.toString().toLong(radix = 2) / actual.text.toString().toLong(radix = 2)))
                                actual.setText("")
                            }
                        }
                    }
                }
            }
            lastSymbol = 3
        }
    }

    fun buttonEqual(view: View)
    {
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (actual.text.isNotEmpty())
            {
                when (lastSymbol) {
                    0 -> {
                        actual.setText("" + (total.text.toString().toDouble() + actual.text.toString().toDouble()))
                        total.setText("0")
                    }
                    1 -> {
                        actual.setText("" + (total.text.toString().toDouble() - actual.text.toString().toDouble()))
                        total.setText("0")
                    }
                    2 -> {
                        actual.setText("" + (total.text.toString().toDouble() * actual.text.toString().toDouble()))
                        total.setText("0")
                    }
                    3 -> {
                        actual.setText("" + (total.text.toString().toDouble() / actual.text.toString().toDouble()))
                        total.setText("0")
                    }
                }
                lastSymbol = 0
            }
            else
            {
                when (lastSymbol) {
                    0 -> {
                        actual.setText("" + (total.text.toString().toDouble()))
                        total.setText("0")
                    }
                    1 -> {
                        actual.setText("" + (total.text.toString().toDouble()))
                        total.setText("0")
                    }
                    2 -> {
                        actual.setText("" + (total.text.toString().toDouble()))
                        total.setText("0")
                    }
                    3 -> {
                        actual.setText("" + (total.text.toString().toDouble()))
                        total.setText("0")
                    }
                }
                lastSymbol = 0
            }
        }
        else
        {
            if(actual.text.isNotEmpty())
            {
                when(mode) {
                    0 -> {
                        when (lastSymbol) {
                            0 -> {
                                actual.setText("" + (total.text.toString().toLong() + actual.text.toString().toLong()))
                                total.setText("0")
                            }
                            1 -> {
                                actual.setText("" + (total.text.toString().toLong() - actual.text.toString().toLong()))
                                total.setText("0")
                            }
                            2 -> {
                                actual.setText("" + (total.text.toString().toLong() * actual.text.toString().toLong()))
                                total.setText("0")
                            }
                            3 -> {
                                actual.setText("" + (total.text.toString().toLong() / actual.text.toString().toLong()))
                                total.setText("0")
                            }
                        }
                    }
                    1 -> {
                        when (lastSymbol) {
                            0 -> {
                                actual.setText(toHexString(total.text.toString().toLong(radix = 16) + actual.text.toString().toLong(radix = 16)).toUpperCase())
                                total.setText("0")
                            }
                            1 -> {
                                actual.setText(toHexString(total.text.toString().toLong(radix = 16) - actual.text.toString().toLong(radix = 16)).toUpperCase())
                                total.setText("0")
                            }
                            2 -> {
                                actual.setText(toHexString(total.text.toString().toLong(radix = 16) * actual.text.toString().toLong(radix = 16)).toUpperCase())
                                total.setText("0")
                            }
                            3 -> {
                                actual.setText(toHexString(total.text.toString().toLong(radix = 16) / actual.text.toString().toLong(radix = 16)).toUpperCase())
                                total.setText("0")
                            }
                        }
                    }
                    2 -> {
                        when (lastSymbol) {
                            0 -> {
                                actual.setText(toBinaryString(total.text.toString().toLong(radix = 2) + actual.text.toString().toLong(radix = 2)))
                                total.setText("0")
                            }
                            1 -> {
                                actual.setText(toBinaryString(total.text.toString().toLong(radix = 2) - actual.text.toString().toLong()))
                                total.setText("0")
                            }
                            2 -> {
                                actual.setText(toBinaryString(total.text.toString().toLong(radix = 2) * actual.text.toString().toLong(radix = 2)))
                                total.setText("0")
                            }
                            3 -> {
                                actual.setText(toBinaryString(total.text.toString().toLong(radix = 2) / actual.text.toString().toLong(radix = 2)))
                                total.setText("0")
                            }
                        }
                    }
                }
                lastSymbol = 0
            }
            else
            {
                when(mode) {
                    0 -> {
                        when (lastSymbol) {
                            0 -> {
                                actual.setText("" + (total.text.toString().toLong()))
                                total.setText("0")
                            }
                            1 -> {
                                actual.setText("" + (total.text.toString().toLong()))
                                total.setText("0")
                            }
                            2 -> {
                                actual.setText("" + (total.text.toString().toLong()))
                                total.setText("0")
                            }
                            3 -> {
                                actual.setText("" + (total.text.toString().toLong()))
                                total.setText("0")
                            }
                        }
                    }
                    1 -> {
                        when (lastSymbol) {
                            0 -> {
                                actual.setText(toHexString(total.text.toString().toLong(radix = 16)).toUpperCase())
                                total.setText("0")
                            }
                            1 -> {
                                actual.setText(toHexString(total.text.toString().toLong(radix = 16)).toUpperCase())
                                total.setText("0")
                            }
                            2 -> {
                                actual.setText(toHexString(total.text.toString().toLong(radix = 16)).toUpperCase())
                                total.setText("0")
                            }
                            3 -> {
                                actual.setText(toHexString(total.text.toString().toLong(radix = 16)).toUpperCase())
                                total.setText("0")
                            }
                        }
                    }
                    2 -> {
                        when (lastSymbol) {
                            0 -> {
                                actual.setText(toBinaryString(total.text.toString().toLong(radix = 2)))
                                total.setText("0")
                            }
                            1 -> {
                                actual.setText(toBinaryString(total.text.toString().toLong(radix = 2)))
                                total.setText("0")
                            }
                            2 -> {
                                actual.setText(toBinaryString(total.text.toString().toLong(radix = 2)))
                                total.setText("0")
                            }
                            3 -> {
                                actual.setText(toBinaryString(total.text.toString().toLong(radix = 2)))
                                total.setText("0")
                            }
                        }
                    }
                }
                lastSymbol = 0
            }
        }
    }

    fun buttonSine(view: View)
    {
        if(actual.text.isNotEmpty())
            actual.setText("" + sin(actual.text.toString().toDouble()))
    }

    fun buttonCosine(view: View)
    {
        if(actual.text.isNotEmpty())
            actual.setText("" + cos(actual.text.toString().toDouble()))
    }

    fun buttonTangent(view: View)
    {
        if(actual.text.isNotEmpty())
            actual.setText("" + tan(actual.text.toString().toDouble()))
    }

    fun buttonDec(view: View)
    {
        if(mode == 1)
        {
            if (actual.text.isNotEmpty())
                actual.setText("" + (actual.text.toString().toLong(radix = 16)))
            total.setText("" + (total.text.toString().toLong(radix = 16)))
            //lastSymbol = 0
        }
        else
        {
            if (actual.text.isNotEmpty())
                actual.setText("" + (actual.text.toString().toLong(radix = 2)))
            total.setText("" + (total.text.toString().toLong(radix = 2)))
            //lastSymbol = 0
        }

        mode = 0

        findViewById<Button>(R.id.button7).isEnabled = false
        findViewById<Button>(R.id.button21).isEnabled = true
        findViewById<Button>(R.id.button22).isEnabled = true

        findViewById<Button>(R.id.button).isEnabled = false
        findViewById<Button>(R.id.button2).isEnabled = false
        findViewById<Button>(R.id.button4).isEnabled = false
        findViewById<Button>(R.id.button3).isEnabled = false
        findViewById<Button>(R.id.button33).isEnabled = false
        findViewById<Button>(R.id.button34).isEnabled = false

        findViewById<Button>(R.id.button10).isEnabled = true
        findViewById<Button>(R.id.button11).isEnabled = true
        findViewById<Button>(R.id.button13).isEnabled = true
        findViewById<Button>(R.id.button14).isEnabled = true
        findViewById<Button>(R.id.button15).isEnabled = true
        findViewById<Button>(R.id.button17).isEnabled = true
        findViewById<Button>(R.id.button18).isEnabled = true
        findViewById<Button>(R.id.button19).isEnabled = true
    }

    fun buttonHex(view: View)
    {
        if(mode == 0)
        {
            if (actual.text.isNotEmpty())
                actual.setText(toHexString(actual.text.toString().toLong(radix = 10)).toUpperCase())
            total.setText(toHexString(total.text.toString().toLong(radix = 10)).toUpperCase())
            //lastSymbol = 0
        }
        else
        {
            if (actual.text.isNotEmpty())
                actual.setText(toHexString(actual.text.toString().toLong(radix = 2)).toUpperCase())
            total.setText(toHexString(total.text.toString().toLong(radix = 2)).toUpperCase())
            //lastSymbol = 0
        }

        mode = 1

        findViewById<Button>(R.id.button7).isEnabled = true
        findViewById<Button>(R.id.button21).isEnabled = false
        findViewById<Button>(R.id.button22).isEnabled = true

        findViewById<Button>(R.id.button).isEnabled = true
        findViewById<Button>(R.id.button2).isEnabled = true
        findViewById<Button>(R.id.button4).isEnabled = true
        findViewById<Button>(R.id.button3).isEnabled = true
        findViewById<Button>(R.id.button33).isEnabled = true
        findViewById<Button>(R.id.button34).isEnabled = true

        findViewById<Button>(R.id.button10).isEnabled = true
        findViewById<Button>(R.id.button11).isEnabled = true
        findViewById<Button>(R.id.button13).isEnabled = true
        findViewById<Button>(R.id.button14).isEnabled = true
        findViewById<Button>(R.id.button15).isEnabled = true
        findViewById<Button>(R.id.button17).isEnabled = true
        findViewById<Button>(R.id.button18).isEnabled = true
        findViewById<Button>(R.id.button19).isEnabled = true
    }

    fun buttonBin(view: View)
    {
        if(mode == 0)
        {
            if (actual.text.isNotEmpty())
                actual.setText(toBinaryString(actual.text.toString().toLong(radix = 10)))
            total.setText(toBinaryString(total.text.toString().toLong(radix = 10)))
            //lastSymbol = 0
        }
        else
        {
            if (actual.text.isNotEmpty())
                actual.setText(toBinaryString(actual.text.toString().toLong(radix = 16)))
            total.setText(toBinaryString(total.text.toString().toLong(radix = 16)))
            //lastSymbol = 0
        }

        mode = 2

        findViewById<Button>(R.id.button7).isEnabled = true
        findViewById<Button>(R.id.button21).isEnabled = true
        findViewById<Button>(R.id.button22).isEnabled = false

        findViewById<Button>(R.id.button).isEnabled = false
        findViewById<Button>(R.id.button2).isEnabled = false
        findViewById<Button>(R.id.button4).isEnabled = false
        findViewById<Button>(R.id.button3).isEnabled = false
        findViewById<Button>(R.id.button33).isEnabled = false
        findViewById<Button>(R.id.button34).isEnabled = false

        findViewById<Button>(R.id.button10).isEnabled = false
        findViewById<Button>(R.id.button11).isEnabled = false
        findViewById<Button>(R.id.button13).isEnabled = false
        findViewById<Button>(R.id.button14).isEnabled = false
        findViewById<Button>(R.id.button15).isEnabled = false
        findViewById<Button>(R.id.button17).isEnabled = false
        findViewById<Button>(R.id.button18).isEnabled = false
        findViewById<Button>(R.id.button19).isEnabled = false
    }

    fun buttonHexA(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "A")
    }

    fun buttonHexB(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "B")
    }

    fun buttonHexC(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "C")
    }

    fun buttonHexD(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "D")
    }

    fun buttonHexE(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "E")
    }

    fun buttonHexF(view: View)
    {
        if(actual.text.length > 30)
            return
        if(!actual.text.toString().equals("0"))
            actual.setText("" + actual.text + "F")
    }
}
