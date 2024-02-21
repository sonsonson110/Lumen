package com.example.lumen.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumen.R
import com.example.lumen.ui.components.LumenDivider
import com.example.lumen.ui.theme.Dandelion
import com.example.lumen.ui.theme.EerieBlack
import com.example.lumen.ui.theme.MediumAquamarine
import java.time.LocalTime

internal val titleTextSize: TextUnit = 18.sp
internal val subTitleTextSize: TextUnit = 12.sp

internal val bigEmojiSize: TextUnit = 70.sp
internal val mediumSummaryEmojiSize: TextUnit = 50.sp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToMoodCheckScreen: () -> Unit
) {
    Scaffold(modifier = modifier, topBar = { HomeTopBar(navigateToMoodCheckScreen = navigateToMoodCheckScreen) }) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            HomeContent(
                Modifier
                    .fillMaxSize()
                    .background(color = EerieBlack)
            )
        }
    }
}

@Composable
fun HomeContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .padding(top = 8.dp)
        .padding(horizontal = 16.dp)
        .verticalScroll(rememberScrollState())) {
        QuoteSection(
            modifier = Modifier.height(180.dp)
        )

        LumenDivider(modifier = Modifier.padding(vertical = 16.dp))

        UserStatistic()

        Spacer(modifier = Modifier.size(8.dp))
    }
}

@Composable
fun UserStatistic(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Mind Score",
            color = MediumAquamarine,
            fontSize = titleTextSize,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontWeight = FontWeight.Bold)
        )

        UserSummaryStatistic(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )

        UserMeditationStatic(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            UserSubStatistic(
                moodStatus = "Not good",
                title = "Mood",
                suggest = "lorem ipsum dolor sit amet",
                modifier = Modifier.weight(0.5f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            UserSubStatistic(
                moodStatus = "Bad",
                title = "Mood",
                suggest = "lorem ipsum dolor sit amet",
                modifier = Modifier.weight(0.5f)
            )
        }
    }
}

@Composable
fun UserMeditationStatic(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .border(
                2.dp,
                shape = RoundedCornerShape(8.dp),
                color = MediumAquamarine
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(0.7f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Meditation Streak",
                color = MediumAquamarine,
                fontSize = titleTextSize,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "You are doing great",
                color = MediumAquamarine,
                fontSize = subTitleTextSize
            )
        }

        Column(
            modifier = Modifier.weight(0.3f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "\uD83D\uDD25", fontSize = mediumSummaryEmojiSize)
            Text(text = "16", color = Color.White, fontSize = 24.sp)
        }
    }
}


@Composable
fun UserSubStatistic(
    title: String,
    moodStatus: String,
    suggest: String,
    modifier: Modifier = Modifier
) {
    val moodEmoji = when (moodStatus) {
        "Not good" -> "☹\uFE0F"
        "Bad" -> "\uD83D\uDE25"
        else -> ""
    }
    val borderColor: Color = when (moodStatus) {
        "Not good" -> Color.Yellow
        "Bad" -> Color.Red
        else -> Color.Transparent
    }

    Column(
        modifier = modifier
            .border(
                2.dp,
                shape = RoundedCornerShape(8.dp),
                color = borderColor
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = moodEmoji, fontSize = mediumSummaryEmojiSize)

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = title,
                    fontSize = titleTextSize,
                    color = MediumAquamarine,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = moodStatus,
                    color = MediumAquamarine,
                    fontSize = subTitleTextSize,
                )

            }
        }

        Text(
            text = suggest,
            color = MediumAquamarine,
            textAlign = TextAlign.Center,
            fontSize = subTitleTextSize,
            lineHeight = subTitleTextSize
        )
    }
}

@Composable
fun UserSummaryStatistic(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "\uD83D\uDE31",
            fontSize = bigEmojiSize,
            modifier = Modifier
                .padding(end = 16.dp)
                .weight(0.3f)
        )
        Column(
            modifier = Modifier.weight(0.7f, fill = true),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "50",
                fontSize = 50.sp,
                style = TextStyle(fontWeight = FontWeight.Bold),
                color = Dandelion,
            )
            Text(
                text = "Not cool, something is happening",
                fontSize = subTitleTextSize,
                color = Dandelion,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun QuoteSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.CenterStart) {
        Image(
            painter = painterResource(id = R.drawable.peaceful_background_1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0F to Color.Transparent,
                        .5F to Color.Black.copy(alpha = 0.3F),
                    )
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "A fit body, a calm mind, a house full of love. These things cannot be bought – they must be earned.",
                color = Color.White,
                fontSize = titleTextSize,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(modifier: Modifier = Modifier, navigateToMoodCheckScreen: () -> Unit) {
    val time by remember { mutableStateOf(LocalTime.now()) }
    val greeting = when (time.hour) {
        in 0 until 12 -> "Good morning"
        in 12 until 18 -> "Good afternoon"
        else -> "Good evening"
    }
    TopAppBar(
        colors = topAppBarColors(containerColor = EerieBlack),
        modifier = modifier
            .height(80.dp)
            .shadow(elevation = 8.dp, spotColor = Color.Gray),
        title = {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Face,
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp),
                    tint = Color.Gray
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1.0f)
                ) {
                    Text(text = greeting, color = MediumAquamarine, fontSize = titleTextSize)
                    Text(
                        text = "User A",
                        fontSize = titleTextSize,
                        color = MediumAquamarine,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(horizontal = 8.dp)
                        .clickable { navigateToMoodCheckScreen() }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_featured_seasonal_and_gifts_24),
                        contentDescription = null,
                        tint = MediumAquamarine
                    )
                    Text(
                        text = "Mood check",
                        color = MediumAquamarine,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 12.sp
                    )
                }
            }
        },
    )
}
