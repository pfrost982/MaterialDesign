package geekbarains.material.ui.earth

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import coil.api.load
import geekbarains.material.BuildConfig
import geekbarains.material.R
import kotlinx.android.synthetic.main.fragment_earth.*

class EarthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_earth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image_view.load("https://api.nasa.gov/EPIC/archive/natural/2021/11/03/png/epic_1b_20211103001751.png?api_key=${BuildConfig.NASA_API_KEY}") {
            lifecycle(this@EarthFragment)
            error(R.drawable.ic_load_error_vector)
            placeholder(R.drawable.ic_no_photo_vector)
        }

    }

}
