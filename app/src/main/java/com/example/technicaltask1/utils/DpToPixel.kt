package com.example.technicaltask1.utils

import android.content.Context
import android.util.TypedValue
import android.view.View

 fun Context.dpToPx(dp: Float): Int {
    val displayMetrics = this.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
        .toInt()
}