package com.gogochang.artbridge.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.gogochang.artbridge.R

val NotoSerifKr = FontFamily(
    Font(R.font.notoserifkr_regular, FontWeight.Normal),
    Font(R.font.notoserifkr_bold, FontWeight.Bold),
    Font(R.font.notoserifkr_medium, FontWeight.Medium)
    // 필요에 따라 더 추가
)

val SuitFontFamily = FontFamily(
    Font(R.font.suit_thin, weight = FontWeight.Thin),
    Font(R.font.suit_extralight, weight = FontWeight.ExtraLight),
    Font(R.font.suit_light, weight = FontWeight.Light),
    Font(R.font.suit_regular, weight = FontWeight.Normal),
    Font(R.font.suit_medium, weight = FontWeight.Medium),
    Font(R.font.suit_semibold, weight = FontWeight.SemiBold),
    Font(R.font.suit_bold, weight = FontWeight.Bold),
    Font(R.font.suit_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.suit_heavy, weight = FontWeight.Black)
)
