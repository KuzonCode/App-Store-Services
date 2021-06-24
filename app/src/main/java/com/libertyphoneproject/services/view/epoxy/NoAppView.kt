package com.libertyphoneproject.services.view.epoxy

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.libertyphoneproject.services.R
import com.libertyphoneproject.services.databinding.ViewNoAppBinding

@ModelView(
    autoLayout = ModelView.Size.MATCH_WIDTH_MATCH_HEIGHT,
    baseModelClass = BaseView::class
)
class NoAppView : RelativeLayout {

    private lateinit var B: ViewNoAppBinding

    constructor(context: Context?) : super(context) {
        init(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        val view = inflate(context, R.layout.view_no_app, this)
        B = ViewNoAppBinding.bind(view)
    }

    @ModelProp
    fun message(message: String) {
        B.txt.text = message
    }
}