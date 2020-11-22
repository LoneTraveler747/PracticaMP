package com.example.perfectweather.Model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/*
   weather: {
     "description" - название погодных условий
    http://openweathermap.org/img/wn/+ "icon" - картинка + .png
   }
   */

/*"main": {
    "temp": -1, - текущая погода
    "feels_like": -4.53, - погода которую ощущает человек
    "temp_min": -1, - минимальная температура
    "temp_max": -1, - максимальная температура
    "humidity" - влажность %
    "pressure" - давление
}*/

/*
    "wind": {
        "speed": 2, - скорость ветра м/с
    },
*/

/*
"clouds": {
    "all" - облачность %
},
* */
// dt - время

const val URL_IMG = "http://openweathermap.org/img/wn/"

@Parcelize
class ModelWeather(
    @SerializedName("weather")
    @Expose
    var weather: ArrayList<Json_Weather>?

) : Parcelable {

    @SerializedName("main")
    @Expose
    var main: Json_Main? = null

    @SerializedName("wind")
    @Expose
    var wind: Json_Wind? = null

    @SerializedName("clouds")
    @Expose
    var clouds: Json_Clouds? = null

    @SerializedName("dt")
    @Expose
    var dt: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null
}

@Parcelize
class Json_Clouds(
    @SerializedName("all")
    @Expose
    var all: String
) : Parcelable {}

@Parcelize
class Json_Wind(
    @SerializedName("speed")
    @Expose
    var speed: String
) : Parcelable {}

@Parcelize
class Json_Weather(
    @SerializedName("description")
    @Expose
    var description: String,
    @SerializedName("icon")
    @Expose
    var icon: String
) : Parcelable {}

@Parcelize
class Json_Main(
    @SerializedName("temp")
    @Expose
    var temp: String,

    @SerializedName("feels_like")
    @Expose
    var feels_like: String,

    @SerializedName("temp_min")
    @Expose
    var temp_min: String,

    @SerializedName("temp_max")
    @Expose
    var temp_max: String,

    @SerializedName("humidity")
    @Expose
    var humidity: String,

    @SerializedName("pressure")
    @Expose
    var pressure: String

) : Parcelable {}