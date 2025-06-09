package com.gogochang.artbridge.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gogochang.artbridge.R
import com.gogochang.artbridge.ui.theme.SuitFontFamily

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // 스크롤
    ) {
        // 검색 바 | 검색부분   검색아이콘|
        SearchBar()

        Spacer(modifier = Modifier.height(16.dp))

        // 카테고리 2줄 가로 스크롤
        CategorySection()

        Spacer(modifier = Modifier.height(16.dp))

        // 광고 배너 (초기에는 공지사항만)
        BannerSection()

        // 커뮤니티 인기글
        var selectedCategory by remember { mutableStateOf("일간") }

        val dummyPosts = listOf(
            "이 곡 어떤가요?",
            "첫 공연 후기입니다",
            "믹싱 팁 공유해요",
            "좋은 마이크 추천?",
            "오늘 연습한 결과 공유!"
        )

        CommunityPostSection(
            posts = dummyPosts,
            selectedCategory = selectedCategory,
            onCategorySelected = { selectedCategory = it },
            onMoreClick = { /* navigate to detail list */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 인기 강사
        SectionTitle("인기 강사")
        ContentCardList(listOf("강사 A", "강사 B", "강사 C"))

        Spacer(modifier = Modifier.height(16.dp))

        // 뉴스~
        SectionTitle("뉴스")
        ContentCardList(listOf("뉴스 1", "뉴스 2", "뉴스 3"))

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),  // 여기 추가
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo_basic),
            contentDescription = "Logo",
            modifier = Modifier.size(72.dp)
        )
        TextButton(onClick = { }) {
            Text("로그인", color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("검색어를 입력하세요.")},
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}

@Composable
fun CategorySection() {
    val categories = listOf("보컬", "기타", "피아노", "작곡", "믹싱", "랩", "댄스", "K-POP", "JAZZ", "클래식","보컬", "기타", "피아노", "작곡", "믹싱", "랩", "댄스", "K-POP", "JAZZ", "클래식")

    // 두 줄로 나누기 (홀수/짝수 인덱스)
    val firstRowItems = categories.filterIndexed { index, _ -> index % 2 == 0 }
    val secondRowItems = categories.filterIndexed { index, _ -> index % 2 == 1 }

    LazyRow(modifier = Modifier.fillMaxWidth()) {
        item {
            Column {
                Row {
                    firstRowItems.forEach { item ->
                        CategoryChip(name = item)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row {
                    secondRowItems.forEach { item ->
                        CategoryChip(name = item)
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryChip(name: String) {
    Column(
        modifier = Modifier
            .padding(end = 20.dp)
            .width(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color.LightGray.copy(alpha = 0.35f), RoundedCornerShape(16.dp))
        ) {

            Image(
                painter = painterResource(id = R.drawable.icon_violin),
                contentDescription = null,
                modifier = Modifier.size(72.dp),  // Box보다 크게 설정
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = SuitFontFamily,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(horizontal = 4.dp, vertical = 2.dp)
        )
    }
}

@Composable
fun BannerSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text("공지사항 배너 영역", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = SuitFontFamily,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun ContentCardList(items: List<String>) {
    LazyRow {
        items(items) { item ->
            ContentCard(item)
        }
    }
}

@Composable
fun ContentCard(title: String) {
    Card(
        modifier = Modifier
            .size(width = 160.dp, height = 100.dp)
            .padding(end = 8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
        )
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(title)
        }
    }
}

@Composable
fun CommunityPostSection(
    posts: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    onMoreClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // 섹션 타이틀 + 더 보기 버튼
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "커뮤니티 인기글",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SuitFontFamily,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            TextButton(onClick = onMoreClick) {
                Text("더 보기", color = MaterialTheme.colorScheme.primary)
            }
        }

        // 카테고리 필터 버튼 (일간 / 주간 / 월간)
        val categories = listOf("일간", "주간", "월간")
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            categories.forEach { category ->
                OutlinedButton(
                    onClick = { onCategorySelected(category) },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = if (category == selectedCategory)
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                        else
                            Color.Transparent
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        category,
                        color = if (category == selectedCategory)
                            MaterialTheme.colorScheme.primary
                        else
                            Color.Gray
                    )
                }
            }
        }

        // 게시글 리스트 (최대 5개)
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            posts.take(5).forEach { title ->
                Text(
                    text = "• $title",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 4.dp)
                )
            }
        }
    }
}