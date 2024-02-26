package pe.edu.idat.ec02_moviles

import android.app.ListActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import pe.edu.idat.ec02_moviles.databinding.ActivityFormularioBinding
import pe.edu.idat.ec02_moviles.util.AppMensaje
import pe.edu.idat.ec02_moviles.util.TipoMensaje

class FormularioActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityFormularioBinding

    private val listaPreferencias = ArrayList<String>()
    private val listarCuestionario = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun validarPregunta1():Boolean{
        var respuesta = false
        if(binding.cbautoconocimiento.isChecked || binding.cbempatia.isChecked || binding.cbcomunicacion.isChecked || binding.cbtoma.isChecked || binding.cbpensamiento.isChecked || binding.cbninguno.isChecked)
            respuesta = true
        return respuesta
    }

    fun validarPregunta2():Boolean{
        var respuesta = true
        if(binding.rgpregunta2.checkedRadioButtonId == -1)
            respuesta = false
        return respuesta
    }

    fun validarPregunta3():Boolean{
        var respuesta = true
        if(binding.rgpregunta3.checkedRadioButtonId == -1)
            respuesta = false
        return respuesta
    }

    fun validarPregunta4():Boolean{
        var respuesta = true
        if(binding.rgpregunta4.checkedRadioButtonId == -1)
            respuesta = false
        return respuesta
    }
    fun validarPregunta5():Boolean{
        var respuesta = true
        if(binding.rgpregunta5.checkedRadioButtonId == -1)
            respuesta = false
        return respuesta
    }

    fun validarFormulario():Boolean{
        var respuesta = true
        var mensaje = ""
        if(!validarPregunta1()){
           mensaje= getString(R.string.errorpregunta1)
        }else if (!validarPregunta2()){
            mensaje= getString(R.string.errorpregunta1)
        }else if (!validarPregunta3()) {
            mensaje = getString(R.string.errorpregunta1)
        }else if (!validarPregunta4()) {
            mensaje = getString(R.string.errorpregunta1)
        }else if (!validarPregunta5()) {
            mensaje = getString(R.string.errorpregunta1)
        }else {
            respuesta = true
        }

        if(!respuesta) AppMensaje.enviarMensaje(binding.root,mensaje,TipoMensaje.ERROR)
        return respuesta
    }

    override fun onClick(v: View?) {
        if(v!! is CheckBox){
            agregarQuitarPreferencia(v!!)

        }else{
        when (v!!.id) {
            R.id.btnresolver -> registrarCuestionario()
        }
        }
    }

    private fun agregarQuitarPreferencia(v: View) {
        val checkBox = v as CheckBox
        if (checkBox.isChecked){
            listaPreferencias.add(checkBox.text.toString())
        }else
            listaPreferencias.remove(checkBox.text.toString())
    }

    private fun registrarCuestionario() {
        if (validarFormulario()) {
            val infoCuestionario = "${listaPreferencias.toArray()} " +
                    "${obtenerPregunta2()} " +
                    "${obtenerPregunta3()} " +
                    "${obtenerPregunta4()} " +
                    "${obtenerPregunta5()}"

            listarCuestionario.add(infoCuestionario)
            AppMensaje.enviarMensaje(binding.root, "Cuestionario registrado correctamente", TipoMensaje.CORRECTO)
        }
    }


    fun obtenerPregunta2():String{
        return if(binding.rgpregunta2.checkedRadioButtonId.equals(R.id.rbmucho))
            binding.rbmucho.text.toString()
        else if(binding.rgpregunta2.checkedRadioButtonId.equals(R.id.rbmasomenos))
            binding.rbmasomenos.text.toString()
        else binding.rbpoco.text.toString()

    }

    fun obtenerPregunta3():String{
        return if(binding.rgpregunta3.checkedRadioButtonId.equals(R.id.rbbien))
            binding.rbbien.text.toString()
        else if(binding.rgpregunta3.checkedRadioButtonId.equals(R.id.rbregular))
            binding.rbregular.text.toString()
        else binding.rbmal.text.toString()
    }

    fun obtenerPregunta4():String{
        return if(binding.rgpregunta4.checkedRadioButtonId.equals(R.id.rbsi1))
            binding.rbsi1.text.toString()
        else binding.rbno1.text.toString()
    }

    fun obtenerPregunta5():String{
        return if(binding.rgpregunta5.checkedRadioButtonId.equals(R.id.rbsi2))
            binding.rbsi2.text.toString()
        else binding.rbno2.text.toString()
    }

    private fun irListadoPersonas() {
        var intentListado =Intent(applicationContext,
            ListActivity::class.java).apply {
                putExtra("listaCuestionarios",listarCuestionario)
        }
        startActivity(intentListado)
    }
}