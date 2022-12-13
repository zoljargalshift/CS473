package com.miu.curriculumvitae.common

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.View.MeasureSpec.*
import android.view.ViewGroup
import androidx.core.content.withStyledAttributes
import androidx.core.view.children
import com.miu.curriculumvitae.R


class FlowLayout(context: Context, attributeSet: AttributeSet) : ViewGroup(context, attributeSet) {

    private var ht: Int = 0
    private var horizontalSpacing = 0F
    private var verticalSpacing = 0F
    init {
        context.withStyledAttributes(attributeSet, R.styleable.FlowLayout) {
            horizontalSpacing = getDimension(R.styleable.FlowLayout_horizontalSpacing, 0F)
            verticalSpacing = getDimension(R.styleable.FlowLayout_verticalSpacing, 0F)
        }
    }

    override fun generateDefaultLayoutParams(): ViewGroup.LayoutParams =
        LayoutParamsWithSpacing(1, 1)

    override fun generateLayoutParams(layoutParams: LayoutParams) =
        LayoutParamsWithSpacing(horizontalSpacing.toInt(), verticalSpacing.toInt())

    override fun checkLayoutParams(layoutParams: LayoutParams) =
        layoutParams is LayoutParamsWithSpacing

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        val width = right - left
        var xPosition = paddingLeft
        var yPosition = paddingTop

        children.forEach { child ->
            if (child.visibility != View.GONE) {
                val layoutParams = child.layoutParams as LayoutParamsWithSpacing
                val childWidth = child.measuredWidth
                if (xPosition + childWidth > width) {
                    xPosition = paddingLeft
                    yPosition += ht
                }
                child.layout(
                    xPosition, yPosition, xPosition + childWidth,
                    yPosition + child.measuredHeight
                )
                xPosition += layoutParams.horizontalSpacing
                xPosition += childWidth
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        val width = getSize(widthMeasureSpec) - paddingLeft - paddingRight
        var height = getSize(heightMeasureSpec) - paddingTop - paddingBottom
        var posX = paddingLeft
        var posY = paddingTop

        val childHeightMeasureSpec = makeMeasureSpec(
            height, if (getMode(heightMeasureSpec) == AT_MOST) AT_MOST else UNSPECIFIED
        )

        children.forEach { child ->
            if (child.visibility != GONE) {
                val layoutParams = child.layoutParams as LayoutParamsWithSpacing
                child.measure(makeMeasureSpec(width, AT_MOST), childHeightMeasureSpec)
                val childWidth = child.measuredWidth
                ht =
                    Math.max(ht, child.measuredHeight + layoutParams.verticalSpacing)

                if (posX + childWidth > width) {
                    posX = paddingLeft
                    posY += ht
                }

                posX += childWidth + layoutParams.horizontalSpacing
            }
        }

        if (getMode(heightMeasureSpec) == UNSPECIFIED ||
            getMode(heightMeasureSpec) == AT_MOST && posY + ht < height
        ) {
            height = posY + ht
        }

        setMeasuredDimension(width, height)
    }

    class LayoutParamsWithSpacing(val horizontalSpacing: Int, val verticalSpacing: Int) :
        ViewGroup.LayoutParams(0, 0)
}