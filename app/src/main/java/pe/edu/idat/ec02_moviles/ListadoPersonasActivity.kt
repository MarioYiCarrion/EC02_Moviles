package pe.edu.idat.ec02_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.ec02_moviles.databinding.ActivityListadoPersonasBinding
//nueva version
class ListadoPersonasActivity : AppCompatActivity() {

    lateinit var binding:ActivityListadoPersonasBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        val intent = intent

        super.onCreate(savedInstanceState)
        binding =ActivityListadoPersonasBinding.inflate(layoutInflater)
        setContentView(binding.root)

<<<<<<< HEAD
=======
        binding.rvElementos.layoutManager=LinearLayoutManager(applicationContext)
        binding.rvElementos.adapter=AdapterItem(intent.getSerializableExtra("listadoPersonas") as ArrayList<String>)
>>>>>>> 588dad46d42b438b44fb1efd7676785b64228831

    }

}