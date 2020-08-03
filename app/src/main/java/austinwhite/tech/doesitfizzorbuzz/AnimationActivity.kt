package austinwhite.tech.doesitfizzorbuzz

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.view.View
import android.widget.Button
import android.widget.TextView

class AnimationActivity : AppCompatActivity() {

    fun scaler(result: TextView) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 4f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 4f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(result, scaleX, scaleY)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    fun buttonScaler(generatedNumber: TextView, fizzButton: Button, buzzButton: Button, fizzbuzzButton: Button) {
        val scaleX = PropertyValuesHolder.ofFloat(View.SCALE_X, 2f)
        val scaleY = PropertyValuesHolder.ofFloat(View.SCALE_Y, 2f)
        val animator = ObjectAnimator.ofPropertyValuesHolder(generatedNumber, scaleX, scaleY)
        animator.disableViewDuringAnimation(fizzButton)
        animator.disableViewDuringAnimation(buzzButton)
        animator.disableViewDuringAnimation(fizzbuzzButton)
        animator.repeatCount = 1
        animator.repeatMode = ObjectAnimator.REVERSE
        animator.start()
    }

    private fun ObjectAnimator.disableViewDuringAnimation(view: View) {

        // This extension method listens for start/end events on an animation and disables
        // the given view for the entirety of that animation.

        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                view.isEnabled = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                view.isEnabled = true
            }
        })
    }

}