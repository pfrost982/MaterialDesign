package geekbarains.material.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import geekbarains.material.R
import geekbarains.material.ui.picture.PictureOfTheDayFragment

class MainActivity : AppCompatActivity() {
    private lateinit var settings: SharedPreferences
    var currentTheme = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settings = getSharedPreferences("DESIGN_PREFERENCES", Context.MODE_PRIVATE)
        currentTheme = settings.getInt("SAVED_THEME", 1)
        when (currentTheme) {
            2 -> setTheme(R.style.AppThemeAlt)
        }
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                .commitNow()
        }
    }

    fun changeTheme(theme: Int) {
        settings.edit().putInt("SAVED_THEME", theme).apply()
        this.recreate()
    }
}
