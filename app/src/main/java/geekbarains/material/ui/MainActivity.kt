package geekbarains.material.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import geekbarains.material.R
import geekbarains.material.ui.earth.EarthFragment
import geekbarains.material.ui.picture.PictureOfTheDayFragment
import geekbarains.material.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {
    private lateinit var settings: SharedPreferences
    private var currentTheme = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settings = getSharedPreferences("DESIGN_PREFERENCES", Context.MODE_PRIVATE)
        currentTheme = settings.getInt("SAVED_THEME", 1)
        when (currentTheme) {
            2 -> setTheme(R.style.AppThemeAlt)
        }
        setContentView(R.layout.main_activity)
        bottom_navigation_view.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_view_pod -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_view_earth -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, EarthFragment())
                        .commitAllowingStateLoss()
                    true
                }
                R.id.bottom_view_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment())
                        .commitAllowingStateLoss()
                    true
                }
                else -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                        .commitAllowingStateLoss()
                    true
                }
            }
        }

        when (currentBottomNavigationSelectedItem) {
            1 -> bottom_navigation_view.selectedItemId = R.id.bottom_view_pod
            2 -> bottom_navigation_view.selectedItemId = R.id.bottom_view_earth
            3 -> bottom_navigation_view.selectedItemId = R.id.bottom_view_settings
        }
    }

    fun changeTheme(theme: Int) {
        settings.edit().putInt("SAVED_THEME", theme).apply()
        this.recreate()
    }

    fun setBottomNavigationSelectedItem(item: Int) {
        currentBottomNavigationSelectedItem = item
    }

    companion object {
        private var currentBottomNavigationSelectedItem = 1
    }
}
