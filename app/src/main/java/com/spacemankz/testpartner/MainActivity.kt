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

const val BASE_URL ="http://example.com/"

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

        retrofitData.enqueue(object : Callback<List<Payload>?> {
            override fun onResponse(
                call: Call<List<Payload>?>,
                response: Response<List<Payload>?>
            ) {
                val responseType = response.body()!!

                val myStringBuilder = StringBuilder()
                for (myData in responseType) {
                    myStringBuilder.append(myData.text)

                }

            localtext.text = myStringBuilder

            }
            override fun onFailure(call: Call<List<Payload>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: ")
            }
        })
    }

}