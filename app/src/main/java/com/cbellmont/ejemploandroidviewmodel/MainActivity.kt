package com.cbellmont.ejemploandroidviewmodel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cbellmont.ejemploandroidviewmodel.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*//Si en lugar de una lista de 3 elementos fuese una llamada a una base de datos llevaria mucho tiempo y bloquearia el movil durante un tiempo
        val list = getFilm()

        list.forEach{
            tvFilms.append("${it.name}\n")
        }*/

        //Por eso es mejor usar el ViewModel -> Se crea una clase
        //Log.d(MainActivity::class.java.simpleName, "Iniciando ViewModel")
        val model = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        //Log.d(MainActivity::class.java.simpleName, "Iniciando iniciado")

        model.downloadFilms()
        model.films.forEach {
            binding.tvFilms.append("${it.name}\n")
        }

        binding.boton1.setOnClickListener {
            binding.tvFilms.text=""
            model.dowload1to3().forEach {
                binding.tvFilms.append("${it.name}\n")
            }
        }

        boton2.setOnClickListener {
            binding.tvFilms.text=""
            model.download4to6().forEach {
                tvFilms.append("${it.name}\n")
            }
        }

        boton3.setOnClickListener {
            binding.tvFilms.text=""
            model.dowloand7to9().forEach {
                tvFilms.append("${it.name}\n")
            }
        }



    }

    /*fun getFilm() : List<Film>{
        return  listOf(Film(1,"Peli 1", "S1"), Film(2, "Peli 2","S2"), Film(3, "Peli 3", "S3"))
    }*/
}