package pe.edu.idat.ec02_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.ec02_moviles.databinding.ActivityRegistroBinding
import pe.edu.idat.ec02_moviles.util.AppMensaje
import pe.edu.idat.ec02_moviles.util.TipoMensaje

class RegistroActivity : AppCompatActivity(),View.OnClickListener{

    lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistroAcceder.setOnClickListener(this)
    }
    fun validarDatosPersonales():Boolean{
        var respuesta=true

        if(binding.tvNombre.text.toString().trim().isEmpty()||
            binding.tvApellido.text.toString().trim().isEmpty()||
            binding.tvDni.text.toString().trim().isEmpty()||
            binding.tvCelular.text.toString().trim().isEmpty()||
            binding.tvEmail.text.toString().trim().isEmpty()
            )
            respuesta=false

        return respuesta
    }

    fun validarEstadoCivil():Boolean{
        var respuesta=true

        if (binding.rgEstadoCivil.checkedRadioButtonId==-1)
            respuesta=false

        return respuesta
    }

    fun validarCualidades():Boolean{
        var respuesta=false

        if(binding.cbOtro.isChecked || binding.cbPuntual.isChecked || binding.cbRespetuoso.isChecked || binding.cbResponsable.isChecked)
            respuesta=true

        return respuesta
    }

    fun validarFormulario():Boolean{
        var respuesta=false
        var mensaje=""

        if(!validarDatosPersonales()) mensaje="Verificar que se haya ingresado el nombre, apellido, dni, celular o email"
        else if(!validarCualidades()) mensaje="Verificar que se haya ingresado las cualidades"
        else if(!validarEstadoCivil()) mensaje="Verificar que se haya ingresado el estado civil"
        else respuesta=true

        if(!respuesta) AppMensaje.enviarMensaje(binding.root,mensaje,TipoMensaje.ERROR)

        return respuesta
    }
    override fun onClick(v: View?) {

    }

}