package com.example.lumen.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumen.R
import com.example.lumen.ui.theme.EerieBlack
import com.example.lumen.ui.theme.MediumAquamarine
import com.example.lumen.ui.theme.Typography

@Composable
fun MoodCheckScreen(modifier: Modifier = Modifier, onNavigateUp: () -> Unit) {
    Scaffold(
        modifier = modifier,
        topBar = { MoodCheckTopBar(onNavigateUp = onNavigateUp) }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            MoodCheckContent(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = EerieBlack)
            )
        }
    }
}

@Composable
fun MoodCheckContent(modifier: Modifier) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "How do you feel today?",
                style = Typography.titleLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.size(16.dp))

            Row() {
                Text(
                    text = "\uD83D\uDE22",
                    modifier = Modifier.weight(0.2f),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp
                )
                Text(
                    text = "\uD83D\uDE41",
                    modifier = Modifier.weight(0.2f),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp
                )
                Text(
                    text = "\uD83D\uDE10",
                    modifier = Modifier.weight(0.2f),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp
                )
                Text(
                    text = "\uD83D\uDE42",
                    modifier = Modifier.weight(0.2f),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp
                )
                Text(
                    text = "\uD83D\uDE03",
                    modifier = Modifier.weight(0.2f),
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp
                )
            }

            Spacer(modifier = Modifier.size(16.dp))

            var text by remember { mutableStateOf("") }
            OutlinedTextField(
                label = { Text("Enter your thoughts today (max 100 characters)", style = Typography.titleSmall, color = MediumAquamarine)},
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = MediumAquamarine,
                    focusedBorderColor = MediumAquamarine,
                    unfocusedBorderColor = MediumAquamarine,
                    focusedLabelColor = MediumAquamarine,
                    unfocusedLabelColor = MediumAquamarine
                ),
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                minLines = 3
            )

            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = MediumAquamarine, contentColor = EerieBlack)) {
                Text(text = "Submit")
            }

            Spacer(modifier = Modifier.size(32.dp))

            Text(text = "Some suggestions based on your thoughts", textAlign = TextAlign.Center, style = Typography.titleMedium, color = Color.White)

            Spacer(modifier = Modifier.size(16.dp))

            Row {
                SuggestionItem(painter = painterResource(id = R.drawable.rounded_sentiment_calm_24), title = "Relax", modifier = Modifier.padding(horizontal = 12.dp))
                SuggestionItem(painterResource(id = R.drawable.outline_mindfulness_24), title = "Improve Memory", modifier = Modifier.padding(horizontal = 12.dp))
            }
        }
    }
}

@Composable
fun SuggestionItem(painter: Painter, title: String, modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Box(modifier = Modifier
            .clip(shape = RoundedCornerShape(percent = 10))
            .background(color = MediumAquamarine)) {
            Icon(painter = painter, contentDescription = null, tint = EerieBlack, modifier = Modifier.size(80.dp))
        }
        Text(text = title, style = Typography.labelSmall, color = Color.White)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodCheckTopBar(modifier: Modifier = Modifier, onNavigateUp: () -> Unit) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = EerieBlack),
        modifier = modifier
            .shadow(elevation = 8.dp, spotColor = Color.Gray),
        navigationIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = MediumAquamarine,
                modifier = Modifier
                    .padding(16.dp)
                    .size(30.dp)
                    .clickable { onNavigateUp() },
            )
        },
        title = {}
    )
}
