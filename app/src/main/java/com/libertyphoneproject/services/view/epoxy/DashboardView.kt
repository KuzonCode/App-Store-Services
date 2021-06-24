package com.libertyphoneproject.services.view.epoxy

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.OnViewRecycled
import com.libertyphoneproject.services.R
import com.libertyphoneproject.services.data.model.DashboardItem
import com.libertyphoneproject.services.databinding.ViewDashboardBinding

@ModelView(
    autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT,
    baseModelClass = BaseView::class
)

class DashboardView : RelativeLayout {

    private lateinit var B: ViewDashboardBinding

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
        val view = inflate(context, R.layout.view_dashboard, this)
        B = ViewDashboardBinding.bind(view)
    }

    @ModelProp
    fun dash(dashboardItem: DashboardItem) {
        B.img.setImageDrawable(ContextCompat.getDrawable(context, dashboardItem.icon))
        B.txtLine1.text = dashboardItem.title
        B.txtLine2.text = dashboardItem.subtitle
    }

    @CallbackProp
    fun click(onClickListener: OnClickListener?) {
        B.root.setOnClickListener(onClickListener)
    }

    @OnViewRecycled
    fun clear() {

    }
}