package uz.otamurod.mvc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.otamurod.mvc.databinding.ActivityMainBinding
import uz.otamurod.mvc.model.Model
import java.util.*

/** Controller: Activity and Fragment */
class MainActivity : AppCompatActivity(), Observer {
    private lateinit var binding: ActivityMainBinding
    private var model: Model? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = Model()
        model?.addObserver(this)

        // View
        binding.apply {
            // View will set data
            /** Model will get data */
            button1.setOnClickListener {
                model?.setValueAtIndex(0)
            }
            button2.setOnClickListener {
                model?.setValueAtIndex(1)
            }
            button3.setOnClickListener {
                model?.setValueAtIndex(2)
            }
        }
    }

    /** Update presentation */
    override fun update(p0: Observable?, p1: Any?) {
        binding.apply {
            button1.text = model?.getValueAtIndex(0).toString()
            button2.text = model?.getValueAtIndex(1).toString()
            button3.text = model?.getValueAtIndex(2).toString()
        }
    }
}