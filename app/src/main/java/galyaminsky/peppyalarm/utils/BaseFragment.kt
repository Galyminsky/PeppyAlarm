package galyaminsky.peppyalarm.utils

import androidx.fragment.app.Fragment
import galyaminsky.peppyalarm.ui.MainActivity

abstract class BaseFragment(private val isVisible: Boolean) : Fragment() {
    override fun onStart() {
        super.onStart()
        (requireActivity() as MainActivity).isBottomAppBarVisible(isVisible)
    }

}