package pe.edu.idat.ec02_moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.idat.ec02_moviles.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}