package com.nutriwise.universe.ui.onBoarding.feature.onboarding.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.nutriwise.universe.R

enum class OnBoardingPage(
    @StringRes val descriptionResource: Int,
    @DrawableRes val logoResource: Int
) {
    ONE(R.string.onboarding_slide1_desc, R.drawable.onboarding_slide1),
    TWO(R.string.onboarding_slide2_desc, R.drawable.onboarding_slide2),
    THREE(R.string.onboarding_slide3_desc, R.drawable.onboarding_slide3),
}
