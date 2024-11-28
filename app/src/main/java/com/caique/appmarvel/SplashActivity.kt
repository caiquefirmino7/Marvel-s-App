package daniel.lop.io.marvelappstarter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.caique.appmarvel.R
import com.caique.appmarvel.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}