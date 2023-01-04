package com.example.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.myapplication.Boucher
import com.example.myapplication.Paypal
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_boucher.*
import kotlinx.android.synthetic.main.fragment_paypal.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var boton1: MaterialButton
    lateinit var boton2: MaterialButton
    lateinit var Numero_Tarjeta: Integer
    lateinit var CVV: Integer
    lateinit var Mes_Caducidad: Integer
    lateinit var Anio_Caducidad: Integer
    lateinit var Cargar_Imagen: Integer
    lateinit var Fecha_Pago: Integer
    lateinit var Numero_Voucher:Integer
    lateinit var pagos: Jsonpagos
    val retrofit = Retrofit.Builder()
        .baseUrl("http://20.75.165.157/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(Jsonpagos::class.java)
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_paypal)

        boton1 = findViewById(R.id.btnPagando)

        boton1.setOnClickListener {
            sendMessage()
            Log.d("MainActivity", "Button Clicked");
        }



            val stripePaga : stripe = stripe(4242424242424242, 123,12, 2023)
            getPagar(stripePaga)
/* getPagar().enqueue(object : Callback<Boolean> {
    override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
        if (response.isSuccessful) {
            showDialogAlertSimple("pago exitoso")

        } else {
            showDialogAlertSimple("pago no exitoso")
        }
    }

    override fun onFailure(call: Call<Boolean>, t: Throwable) {
        showDialogAlertSimple(t.toString())
    }
}) */

binding = ActivityMainBinding.inflate(layoutInflater)

setContentView(binding.root)
replaceFragment(Paypal())

binding.bottomNavigationView.setOnItemSelectedListener {

    when(it.itemId){
        R.id.paypal -> replaceFragment(Paypal())
        R.id.boucher -> replaceFragment(Boucher())


        else ->{



        }

    }

    true

}

}


private fun replaceFragment(fragment : Fragment){

val fragmentManager = supportFragmentManager
val fragmentTransaction = fragmentManager.beginTransaction()
fragmentTransaction.replace(R.id.frame_layout,fragment)
fragmentTransaction.commit()
}

    fun sendMessage() {
        Numero_Tarjeta = Integer(numero_tarjeta.text.toString())
        CVV = Integer(cvv.text.toString())
        Mes_Caducidad = Integer(txtCaducidad.text.toString())
        Anio_Caducidad = Integer(anioCaducidad.text.toString())
        /*val stripePaga : stripe = stripe(Numero_Tarjeta, Mes_Caducidad, Anio_Caducidad, CVV)*/
        val stripePaga : stripe = stripe(4242424242424242, 123, 12, 2023)
        //getPagar(stripePaga)
        txtCaducidad.setText("confirmacion")
    }

fun showDialogAlertSimple(mensaje : String) {
AlertDialog.Builder(this)
    .setTitle("Titulo del diálogo")
    .setMessage(mensaje)
    .setPositiveButton(android.R.string.ok,
        DialogInterface.OnClickListener { dialog, which ->
            //botón OK pulsado
        })
    .setNegativeButton(android.R.string.cancel,
        DialogInterface.OnClickListener { dialog, which ->
            //botón cancel pulsado
        })
    .show()
}
fun getPagar(objeto: stripe) {
val api = retrofit.create(Jsonpagos::class.java)
val call = api.getPagar(objeto)

call.enqueue(object : Callback<stripe> {
    override fun onResponse(call: Call<stripe>, response: Response<stripe>) {


    }

    override fun onFailure(call: Call<stripe>, t: Throwable) {
        txtFecha.setText(t.message)
    }
})



}


/*
override fun onCreate(savedInstanceState: Bundle?) {
 super.onCreate(savedInstanceState)
 setContentView(R.layout.activity_registrar_matricula)
}*/
}


