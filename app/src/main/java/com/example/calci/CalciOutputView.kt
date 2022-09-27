package com.example.calci

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.LinearLayout

class CalciOutputView(context: Context, attributeSet: AttributeSet?) : LinearLayout(context, attributeSet) {
    init {
        // Set Orientation
        orientation = VERTICAL

        // Set Gravity
        gravity = Gravity.CENTER_VERTICAL

        // Layout Inflator
        LayoutInflater.from(context).inflate(R.layout.view_calci_output, this, true)
    }
}