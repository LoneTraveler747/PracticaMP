package com.example.perfectweather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.perfectweather.Model.ModelWeather
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottom_navigation,navController)
//        var call: retrofit2.Call<ModelWeather> =
//            APIWeatherService.invoke().getCurrentWeather("Москва")
//
//        call.enqueue(object : retrofit2.Callback<ModelWeather> {
//            override fun onFailure(call: Call<ModelWeather>, t: Throwable) {
//                Log.e("error", t.message.toString())
//            }
//
//            override fun onResponse(call: Call<ModelWeather>, response: Response<ModelWeather>) {
//                    Log.i("test", response.body()!!.dt.toString())
//            }
//        })
    }
}
