package geekbarains.material.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import geekbarains.material.R
import geekbarains.material.ui.MainActivity
import kotlinx.android.synthetic.main.fragment_settings.*

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chipGroup.setOnCheckedChangeListener { chipGroup, position ->
            chipGroup.findViewById<Chip>(position)?.let {
                val context = activity as MainActivity
                when (it.text) {
                    "Original" -> {
                        context.changeTheme(1)
                        context.setBottomNavigationSelectedItem(3)
                    }
                    "Alternative" -> {
                        context.changeTheme(2)
                        context.setBottomNavigationSelectedItem(3)
                    }
                }
            }
        }
    }
}
