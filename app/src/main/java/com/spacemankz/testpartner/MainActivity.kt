package com.spacemankz.testpartner
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL ="http://demo7877231.mockable.io/api/v1/post"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMyData()

    }

    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<FirstData>?> {
            override fun onResponse(
                call: Call<List<FirstData>?>,
                response: Response<List<FirstData>?>
            ) {
                val responseType = response.body()!!

                val myStringBuilder = StringBuilder()
                for (myData in responseType) {
                    myStringBuilder.append(myData.type)
                    myStringBuilder.append("\n")
                }

            localtext.text = myStringBuilder

            }
            override fun onFailure(call: Call<List<FirstData>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: ")
            }
        })
    }

}