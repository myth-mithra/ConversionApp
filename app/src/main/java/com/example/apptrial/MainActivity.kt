package com.example.apptrial

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // access the items of the list
        val units = resources.getStringArray(R.array.conversion)
        val t = resources.getStringArray(R.array.tempunits)
        val l = resources.getStringArray(R.array.lengthunits)
        val w = resources.getStringArray(R.array.weightunits)
        val s = resources.getStringArray(R.array.speedunits)

        var position1 = 0
        // access the spinner
        val spinner1 = findViewById<Spinner>(R.id.conversion)
        val spinner2 = findViewById<Spinner>(R.id.from)
        val spinner3 = findViewById<Spinner>(R.id.to)
        if (spinner1 != null) {
            if (spinner1.toString() == "Temparature") {

            }
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, units
            )
            spinner1.adapter = adapter

            spinner1.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    if (position == 0) {

                        val adapter2 = ArrayAdapter(
                            baseContext,
                            android.R.layout.simple_spinner_item, t
                        )
                        spinner2.adapter = adapter2

                        val adapter1 = ArrayAdapter(
                            baseContext,
                            android.R.layout.simple_spinner_item, t
                        )
                        spinner3.adapter = adapter1
                    } else if (position == 1) {

                        val adapter2 = ArrayAdapter(
                            baseContext,
                            android.R.layout.simple_spinner_item, l
                        )
                        spinner2.adapter = adapter2

                        val adapter1 = ArrayAdapter(
                            baseContext,
                            android.R.layout.simple_spinner_item, l
                        )
                        spinner3.adapter = adapter1
                    } else if (position == 2) {

                        val adapter2 = ArrayAdapter(
                            baseContext,
                            android.R.layout.simple_spinner_item, w
                        )
                        spinner2.adapter = adapter2

                        val adapter1 = ArrayAdapter(
                            baseContext,
                            android.R.layout.simple_spinner_item, w
                        )
                        spinner3.adapter = adapter1
                    } else if (position == 3) {

                        val adapter2 = ArrayAdapter(
                            baseContext,
                            android.R.layout.simple_spinner_item, s
                        )
                        spinner2.adapter = adapter2

                        val adapter1 = ArrayAdapter(
                            baseContext,
                            android.R.layout.simple_spinner_item, s
                        )
                        spinner3.adapter = adapter1
                    } else {
                    }
                    position1 = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        val text1 = findViewById<EditText>(R.id.editTextNumberDecimal1)
        val text2 = findViewById<EditText>(R.id.editTextNumberDecimal2)
        val btnconvert = findViewById<Button>(R.id.buttonconvert)
       // val btncheck = findViewById<Button>(R.id.buttoncheck)
        var position2 = 0
        var position3 = 0
        val finalconversion = {
            "Metre" to 1000; "Feet" to 304.8; "Yard" to 914.4; //to millimetre
            "Kilogram" to 1000;"Pound" to 453.592; "Ounce" to 28.3495; //to grams
            "Kmph" to 0.277778; "Mph" to 0.44704; "Knot" to 0.514444; //to m/s
        };
        if (spinner2 != null) {
            spinner2.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    //val a=text1.toString().toInt()
                    position2 = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        if (spinner3 != null) {
            spinner3.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    position3 = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
        var d:Float= 0.0f

        btnconvert.setOnClickListener() {
            var a = text1.text.toString().toFloat()
            var b = 0
            var d = a
            if (text1.text.toString() == "") {
                val text = "Invalid input. Please provide a valid input."
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, text, duration)
                toast.show()
            } else {

                try {


                    if (a != null) {
                        if (position1 == 0) {
                            if (position2 == 0 && position3 == 1) {
                                text2.setText(((a * 9 / 5) + 32).toString())
                                b = 1
                            } else if (position2 == 0 && position3 == 2) {
                                text2.setText((a + 273.15).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 0) {
                                text2.setText(((a - 32) * 5 / 9).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 2) {
                                text2.setText((((a - 32) * 5 / 9) + 273.15).toString())
                                b = 1
                            } else if (position2 == 2 && position3 == 0) {
                                text2.setText(((a - 273.15).toString()))
                                b = 1
                            } else if (position2 == 2 && position3 == 1) {
                                text2.setText((((a - 273.15) * 9 / 5) + 32).toString())
                                b = 1
                            } else if (position2 == 0 && position3 == 0) {
                                b = 0
                            } else if (position2 == 1 && position3 == 1) {
                                b = 0
                            } else if (position2 == 2 && position3 == 2) {
                                b = 0
                            }
                        } else if (position1 == 1) {
                            if (position2 == 0 && position3 == 1) {
                                text2.setText((a * 304.8 / 1000).toString())
                                b = 1
                            } else if (position2 == 0 && position3 == 2) {
                                text2.setText((a * 914.4 / 1000).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 0) {
                                text2.setText((a * 1000 / 304.8).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 2) {
                                text2.setText((a * 914.4 / 304.8).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 0) {
                                text2.setText((a * 1000 / 914.4).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 2) {
                                text2.setText((a * 304.8 / 914.4).toString())
                                b = 1
                            } else if (position2 == 0 && position3 == 0) {
                                b = 0
                            } else if (position2 == 1 && position3 == 1) {
                                b = 0
                            } else if (position2 == 2 && position3 == 2) {
                                b = 0
                            }
                        } else if (position1 == 2) {
                            if (position2 == 0 && position3 == 1) {
                                text2.setText((a * 453.592 / 1000).toString())
                                b = 1
                            } else if (position2 == 0 && position3 == 2) {
                                text2.setText((a * 28.3495 / 1000).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 0) {
                                text2.setText((a * 1000 / 453.592).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 2) {
                                text2.setText((a * 24.3895 / 453.592).toString())
                                b = 1
                            } else if (position2 == 2 && position3 == 0) {
                                text2.setText((a * 1000 / 24.3895).toString())
                                b = 1
                            } else if (position2 == 2 && position3 == 1) {
                                text2.setText((a * 453.592 / 24.3895).toString())
                                b = 1
                            } else if (position2 == 0 && position3 == 0) {
                                b = 0
                            } else if (position2 == 1 && position3 == 1) {
                                b = 0
                            } else if (position2 == 2 && position3 == 2) {
                                b = 0
                            }
                        } else if (position1 == 3) {
                            if (position2 == 0 && position3 == 1) {
                                text2.setText((a * 0.44704 / 0.277778).toString())
                                b = 1
                            } else if (position2 == 0 && position3 == 2) {
                                text2.setText((a * 0.514444 / 0.277778).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 0) {
                                text2.setText((a * 0.277778 / 0.44704).toString())
                                b = 1
                            } else if (position2 == 1 && position3 == 2) {
                                text2.setText((a * 0.514444 / 0.44704).toString())
                                b = 1
                            } else if (position2 == 2 && position3 == 0) {
                                text2.setText((a * 0.277778 / 0.514444).toString())
                                b = 1
                            } else if (position2 == 2 && position3 == 1) {
                                text2.setText((a * 0.44704 / 0.514444).toString())
                                b = 1
                            } else if (position2 == 0 && position3 == 0) {
                                b = 0
                            } else if (position2 == 1 && position3 == 1) {
                                b = 0
                            } else if (position2 == 2 && position3 == 2) {
                                b = 0
                            }
                        } else if (position2 == position3) {
                            b = 0
                            val text3 = "Please select different units in order to convert."
                            val duration2 = Toast.LENGTH_SHORT

                            val toast2 = Toast.makeText(applicationContext, text3, duration2)
                            toast2.show()
                        }
                        println("$(position2)")
                        println("$(position3)")
                        println("$(b)")
                        if (b == 0) {
                            val text3 = "Please select different units in order to convert."
                            val duration2 = Toast.LENGTH_SHORT

                            val toast3 = Toast.makeText(applicationContext, text3, duration2)
                            toast3.show()
                        } else if (b == 1) {
                            val text = "Conversion was successful."
                            val duration = Toast.LENGTH_SHORT

                            val toast = Toast.makeText(applicationContext, text, duration)
                            toast.show()
                        }
                        d= text2.text.toString().toFloat()
                    } else {
                        val text = "Invalid input. Please provide a valid input."
                        val duration = Toast.LENGTH_SHORT

                        val toast = Toast.makeText(applicationContext, text, duration)
                        toast.show()
                    }
                    fun ArrayAdapter(
                        onItemSelectedListener: AdapterView.OnItemSelectedListener,
                        simpleSpinnerItem: Int,
                        t: Array<String>
                    ) {

                    }
                } catch (ex: Exception) {
                    //your error handling code here
                    //here, consider adding Log.e("SmsReceiver", ex.localizedMessage)
                    //this log statement simply prints errors to your android studio terminal and will help with debugging, alternatively leave it out

                    val text = "Invalid input. Please provide a valid input."
                    val duration = Toast.LENGTH_SHORT

                    val toast = Toast.makeText(applicationContext, text, duration)
                    toast.show()

                }
            }
        }
//        btncheck.setOnClickListener()
//        {
//            var c = text2.text.toString().toFloat()
//            if (c == d) {
//                btncheck.setBackgroundColor(getResources().getColor(R.color.black))
//            }
//            else{
//                btncheck.setBackgroundColor(getResources().getColor(R.color.teal_200))
//            }
       // }
    }
}