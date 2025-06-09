package com.gogochang.artbridge.presentation.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogochang.artbridge.ui.theme.NotoSerifKr
import com.gogochang.artbridge.ui.theme.SuitFontFamily
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.gogochang.artbridge.R
import com.gogochang.artbridge.presentation.community.CommunityScreen
import com.gogochang.artbridge.presentation.home.HomeScreen

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf("홈") }
    val context = LocalContext.current  // context 가져오기

    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(selected = selectedTab, onTabSelected = {selectedTab = it})
        },
        floatingActionButton = {
            if (selectedTab == "커뮤니티") {
                FloatingActionButton(
                    onClick = { /* 글쓰기 이동 */ },
                    containerColor = MaterialTheme.colorScheme.primary
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "글쓰기",
                        tint = Color.White
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                "홈" -> HomeScreen()
                "커뮤니티" -> CommunityScreen()
                "브릿지" -> HomeScreen()
                "소식" -> HomeScreen()
                "프로필" -> HomeScreen()
            }
        }

    }
}
@Composable
fun TopBar() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp), // 상하 패딩 줄임
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_basic),
                contentDescription = "Logo",
                modifier = Modifier.size(56.dp) // 기존보다 작게 조정 (예: 72 → 56)
            )
            TextButton(onClick = { /* 로그인 로직 */ }) {
                Text("로그인", color = MaterialTheme.colorScheme.primary)
            }
        }
        HorizontalDivider(thickness = 1.dp) // 하단 구분선
    }
}
@Composable
fun BottomBar(selected: String, onTabSelected: (String) -> Unit) {
    val tabs = listOf("홈", "커뮤니티", "브릿지", "소식", "프로필")

    NavigationBar {
        tabs.forEach { tab ->
            NavigationBarItem(
                selected = selected == tab,
                onClick = { onTabSelected(tab) },
                icon = {
                    Icon(
                        imageVector = when (tab) {
                            "홈" -> Icons.Default.Home
                            "커뮤니티" -> Icons.Default.Star
                            "브릿지" -> Icons.Default.Send
                            "소식" -> Icons.Default.MailOutline
                            "프로필" -> Icons.Default.Person
                            else -> Icons.Default.Home
                        },
                        contentDescription = tab
                    )
                },
                label = { Text(tab) }
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CategoryChipPreview() {
    MainScreen()
}