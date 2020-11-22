package com.example.perfectweather.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.perfectweather.APIWeatherService
import com.example.perfectweather.Model.ModelWeather
import com.example.perfectweather.Model.URL_IMG
import com.example.perfectweather.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashSet

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_home, container, false)

        var sp : SharedPreferences? = null
//        var  City = sp!!.getStringSet("City",HashSet<String>())


        val button = v.findViewById(R.id.search) as ImageButton
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.i("Ds", "dsd")

                if (EditCountry.text.toString().trim() != "") {

                    var call: retrofit2.Call<ModelWeather> =
                        APIWeatherService.invoke()
                            .getCurrentWeather(EditCountry.text.toString())
                    var savecity = HashSet<String>()

//                    if(City!!.contains(EditCountry.text.toString()))
  //                  {
  //                      savecity.add(EditCountry.text.toString())
   //                 }
                    call.enqueue(object : retrofit2.Callback<ModelWeather> {
                        override fun onFailure(call: Call<ModelWeather>, t: Throwable) {
                            Log.e("error", t.message.toString())
                        }

                        override fun onResponse(
                            call: Call<ModelWeather>,
                            response: Response<ModelWeather>
                        ) {
                            if (response.body() != null) {
                                scrol.visibility = View.VISIBLE
                                name.text = response.body()!!.name
                                var time = ("1606000364" + "000").toLong()
                                dt.text =
                                    SimpleDateFormat(/*"yyyy.MM.dd H" - по желанию*/"H:mm:ss").format(
                                        Date((response.body()!!.dt + "000").toLong())
                                    )
                                        .toString()
                                temp.text = response.body()!!.main!!.temp
                                feels_like.text =
                                    "Ощущается как: ${response.body()!!.main!!.feels_like}"
                                temp_max.text = "Min: ${response.body()!!.main!!.temp_max}"
                                temp_min.text = "Max: ${response.body()!!.main!!.temp_max}"
                                pressure.text =
                                    "Давление: ${response.body()!!.main!!.pressure} hPa"
                                humidity.text =
                                    "Влажность: ${response.body()!!.main!!.humidity}%"
                                Picasso.with(context)
                                    .load(
                                        "http://openweathermap.org/img/wn/${response.body()!!.weather?.get(
                                            0
                                        )!!.icon}.png"
                                    )
                                    .into(image, object : Callback {
                                        override fun onSuccess() {
                                            if (progressbar != null) {
                                                progressbar.visibility = View.GONE
                                            }
                                        }

                                        override fun onError() {
                                            progressbar.visibility = View.GONE
                                            image.visibility = View.GONE
                                        }
                                    })
                            } else {
                                scrol.visibility = View.GONE
                            }

                        }
                    })

                }
            }
        })

        val liner = v.findViewById<ImageButton>(R.id.description)
        var boolean = true
        liner.setOnClickListener({
            if (boolean) {
                linear_description.visibility = View.VISIBLE
                boolean = false
            } else {
                linear_description.visibility = View.INVISIBLE
                boolean = true
            }
        })


        return v
    }
}