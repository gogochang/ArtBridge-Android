package com.gogochang.artbridge.presentation.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogochang.artbridge.R

@Composable
fun CommunityScreen() {
    val categories = listOf("모두보기", "바이올린", "첼로", "피아노", "플루트", "클라리넷")
    var selectedSort by remember { mutableStateOf("최신순") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // 카테고리 (가로 스크롤)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { category ->
                CategoryChip(name = category)
            }
        }

        // 정렬 버튼
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SortButton("최신순", selectedSort == "최신순") { selectedSort = "최신순" }
            SortButton("인기순", selectedSort == "인기순") { selectedSort = "인기순" }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 게시글 리스트 (세로)
        repeat(10) { index ->
            PostItem(
                category = "바이올린",
                title = "게시글 제목 $index",
                contentPreview = "이곳은 게시글 내용 미리보기입니다 이곳은 게시글 내용 미리보기입니다 이곳은 게시글 내용 미리보기입니다 이곳은 게시글 내용 미리보기입니다...",
                likes = index * 3,
                comments = index * 2,
                author = "작성자$index"
            )
        }
    }
}

@Composable
fun CategoryChip(name: String) {
    Box(
        modifier = Modifier
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = name, fontSize = 14.sp)
    }
}

@Composable
fun SortButton(text: String, selected: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) MaterialTheme.colorScheme.primary else Color.LightGray,
            contentColor = if (selected) Color.White else Color.Black
        ),
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = text, fontSize = 14.sp)
    }
}

@Composable
fun PostItem(category: String, title: String, contentPreview: String, likes: Int, comments: Int, author: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
//            .padding(16.dp)
//            .background(Color.LightGray.copy(alpha = 0.4f), shape = RoundedCornerShape(8.dp))
            .padding(4.dp)
    ) {
        Text(text = category, fontWeight = FontWeight.Medium, fontSize = 12.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = contentPreview, fontSize = 14.sp, color = Color.Gray, maxLines = 1, overflow = TextOverflow.Ellipsis)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("1시간전 ❤️ $likes   💬 $comments", fontSize = 12.sp, color = Color.Gray)
            Text(text = author, fontSize = 12.sp, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
    }
}
