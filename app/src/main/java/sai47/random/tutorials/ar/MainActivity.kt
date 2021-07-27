package sai47.random.tutorials.ar

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior

private const val BOTTOM_SHEET_PEEK_HEIGHT = 50f

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomSheet()
    }

    private fun setupBottomSheet() {
        val bottomSheetView = findViewById<View>(R.id.bottom_sheet)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView)
        bottomSheetBehavior.peekHeight = getPeekHeightForDevice()
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                bottomSheet.bringToFront()
            }

        })
    }

    /**
     * Returns the peek height of the device running the app in pixels
     */
    private fun getPeekHeightForDevice(): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, BOTTOM_SHEET_PEEK_HEIGHT, resources.displayMetrics).toInt()
    }
}
