package com.example.calci

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class CalciInputView(context: Context, attributeSet: AttributeSet?) : RelativeLayout(context, attributeSet){

    init {
        // Inflate layout
        LayoutInflater.from(context).inflate(R.layout.view_calci_input, this, true)

        // Read Attribute Set
        attributeSet?.run {
            val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CalciInputView)

            val textResource = typedArray.getString(R.styleable.CalciInputView_item_text)
            val iconResource = typedArray.getResourceId(R.styleable.CalciInputView_item_icon, -1)
            val inputElementImage = findViewById<ImageView>(R.id.ivInput)
            val inputElementText = findViewById<TextView>(R.id.tvInput)
            if(iconResource != -1) {
                inputElementText.visibility = View.GONE
                inputElementImage.apply {
                    visibility = View.VISIBLE
                    setImageResource(iconResource)
                }
            } else if (!textResource.isNullOrEmpty()) {
                inputElementImage.visibility = View.GONE
                inputElementText.apply {
                    visibility = View.VISIBLE
                    text = textResource
                }
            } else {
                inputElementImage.visibility = View.GONE
                inputElementText.visibility = View.GONE
            }

            typedArray.recycle()

        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        val inputElementClick = findViewById<View>(R.id.vInputClick)
        inputElementClick.setOnClickListener(l)
    }
}