package com.gogochang.artbridge.presentation.login


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.gogochang.artbridge.R
import com.gogochang.artbridge.presentation.common.CustomButton
import com.gogochang.artbridge.presentation.main.MainActivity
import com.gogochang.artbridge.ui.theme.NotoSerifKr
import com.gogochang.artbridge.ui.theme.SuitFontFamily

@Composable
fun LoginScreen(onClick: () -> Unit) {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // 배경이미지
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // 로고 + 텍스트를 Column으로 정렬
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(top = 130.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.simbol),
                contentDescription = "Logo",
                modifier = Modifier.size(72.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "클래식 음악을 사랑하는 사람들을 위한\n일자리 플랫폼 아트브릿지.",
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = NotoSerifKr,
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(94.dp))

            CustomButton(
                text = "Sign up Free",
                onClick = { onClick() },
                modifier = Modifier.fillMaxWidth()  // 가로 꽉 채움(부모의 fillMaxWidth, 즉 가로 - 24dp*2)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Or",
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.4f),
                textAlign = TextAlign.Center,
                fontFamily = SuitFontFamily,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            CustomButton(
                text = "Sign in with Apple",
                onClick = { /* TODO */ },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            CustomButton(
                text = "Sign in with kakao",
                onClick = { /* TODO */ },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            CustomButton(
                text = "Sign in with Naver",
                onClick = { /* TODO */ },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            val text = AnnotatedString.Builder().apply {
                withStyle(
                    style = SpanStyle(
                        color = Color.White.copy(alpha = 0.4f),
                        textDecoration = TextDecoration.Underline,
                        fontFamily = SuitFontFamily,
                        fontSize = 16.sp
                    )
                ) {
                    append("로그인 없이 둘러보기")
                }
            }.toAnnotatedString()

            ClickableText(
                text = text,
                onClick = { offset ->
                    // 클릭 동작 처리
                    println("텍스트 클릭됨")
                }
            )
        }
    }
}