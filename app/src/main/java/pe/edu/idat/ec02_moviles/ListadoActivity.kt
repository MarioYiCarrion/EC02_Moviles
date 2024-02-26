package pe.edu.idat.ec02_moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import pe.edu.idat.ec02_moviles.databinding.ActivityListadoBinding

class ListadoActivity : AppCompatActivity() {

    lateinit var binding: ActivityListadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.getSerializableExtra("listaPersonas")
        as ArrayList<String>
        val adapter = ArrayAdapter(applicationContext,
            android.R.layout.simple_list_item_1,
            listaPersonas)
        binding.lvlistado.adapter = adapter
    }
}