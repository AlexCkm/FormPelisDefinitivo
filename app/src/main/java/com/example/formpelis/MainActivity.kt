package com.example.formpelis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.formpelis.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var year = "2000"
    var tipo = "Serie"
    var cat = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getSpinner(binding.spYear)
        binding.rbSerie.setOnClickListener { tipo = "Serie" }
        binding.rbPelicula.setOnClickListener { tipo = "Película" }
        binding.btnSend.setOnClickListener { getAndSend() }
    }
    fun getAndSend(){
        val intentResult = Intent(this, ResultActivity::class.java)
        intentResult.putExtra("TITULO", binding.etTitulo.text.toString())
        intentResult.putExtra("YEAR", year)
        intentResult.putExtra("TIPO", tipo)
        intentResult.putExtra("CATEGORIA", cat.toString())
        startActivity(intentResult)
    }
    fun getSpinner(spinner: Spinner){
        var userSelect = ""
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.Year,
            android.R.layout.simple_spinner_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                userSelect = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, userSelect, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                userSelect = "No ha habido selección"
                Toast.makeText(this@MainActivity, userSelect, Toast.LENGTH_SHORT).show()
            }
        }
        //Sustituir 'year' por la variable global donde se recoge el valor
        year = userSelect
    }
    fun onCheckBoxClicked(view: View){
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.ckChild -> { if (checked) {
                    checkCategory(binding.ckChild.text.toString())
                } else {
                    unCheckCategory(binding.ckChild.text.toString())
                }
                }
                R.id.ckSciFi -> { if (checked) {
                    checkCategory(binding.ckSciFi.text.toString())
                } else {
                    unCheckCategory(binding.ckSciFi.text.toString())
                }
                }
                R.id.ckTerror -> { if (checked) {
                    checkCategory(binding.ckTerror.text.toString())
                } else {
                    unCheckCategory(binding.ckTerror.text.toString())
                }
                }
                R.id.ckThriller -> { if (checked) {
                    checkCategory(binding.ckThriller.text.toString())
                } else {
                    unCheckCategory(binding.ckThriller.text.toString())
                }
                }
                R.id.ckFantasy -> { if (checked) {
                    checkCategory(binding.ckFantasy.text.toString())
                } else {
                    unCheckCategory(binding.ckFantasy.text.toString())
                }
                }
                R.id.ckHumour -> { if (checked) {
                    checkCategory(binding.ckHumour.text.toString())
                } else {
                    unCheckCategory(binding.ckHumour.text.toString())
                }
                }
                R.id.ckAnimation -> { if (checked) {
                    checkCategory(binding.ckAnimation.text.toString())
                } else {
                    unCheckCategory(binding.ckAnimation.text.toString())
                }
                }
                R.id.ckDrama -> { if (checked) {
                    checkCategory(binding.ckDrama.text.toString())
                } else {
                    unCheckCategory(binding.ckDrama.text.toString())
                }
                }
                R.id.ckSpanish -> { if (checked) {
                    checkCategory(binding.ckSpanish.text.toString())
                } else {
                    unCheckCategory(binding.ckSpanish.text.toString())
                }
                }

            }
        }
    }
    fun checkCategory(str:String){
        if (!cat.contains(str)) { cat.add(str) }
    }
    fun unCheckCategory(str:String){
        if (cat.contains(str)) { cat.remove(str) }
    }

    fun msj(str:String){
        Toast.makeText(this@MainActivity, str, Toast.LENGTH_SHORT).show()
    }

}