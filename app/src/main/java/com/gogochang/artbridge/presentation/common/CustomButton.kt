package com.gogochang.artbridge.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.gogochang.artbridge.ui.theme.SuitFontFamily

//@Composable
//fun CustomButton(
//    text: String,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    // 클릭 상태를 관리
//    var pressed by remember { mutableStateOf(false) }
//
//    // 배경색 지정
//    val backgroundColor = if (pressed) Color(0xFF6D4C41) else Color.White.copy(alpha = 0.08f)
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = modifier
//            .height(64.dp)
//            .clip(RoundedCornerShape(64.dp))       // 둥근 모서리 8dp
//            .clickable(
//                interactionSource = remember { MutableInteractionSource() },
//                indication = null,                  // 클릭 효과 제거
//                onClick = onClick
//            )
//            .background(backgroundColor)
//            .border(BorderStroke(1.dp, Color.LightGray.copy(alpha = 0.4f)), RoundedCornerShape(64.dp))
//            .padding(horizontal = 16.dp, vertical = 8.dp)
//            .pointerInput(Unit) {
//                // 터치 상태 감지
//                detectTapGestures(
//                    onPress = {
//                        pressed = true
//                        tryAwaitRelease()
//                        pressed = false
//                    }
//                )
//            }
//    ) {
//        Text(
//            text = text,
//            color = Color.White,
//            fontSize = 16.sp,
//            fontFamily = SuitFontFamily,
//            fontWeight = FontWeight.Normal
//        )
//    }
//}

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pressed by interactionSource.collectIsPressedAsState()

    val backgroundColor = if (pressed) Color(0xFF6D4C41) else Color.White.copy(alpha = 0.08f)

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .height(64.dp)
            .clip(RoundedCornerShape(64.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            )
            .background(backgroundColor)
            .border(BorderStroke(1.dp, Color.White.copy(alpha = 0.4f)), RoundedCornerShape(64.dp))
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            fontFamily = SuitFontFamily,
            fontWeight = FontWeight.Normal
        )
    }
}
