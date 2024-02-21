package com.example.lumen.ui.screens.challenges

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumen.R
import com.example.lumen.ui.theme.EerieBlack
import com.example.lumen.ui.theme.MediumAquamarine
import com.example.lumen.ui.theme.Typography

@Composable
fun ChallengeScreen(modifier: Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = { ChallengeTopBar() },
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            ChallengeContent(
                modifier = Modifier
                    .background(EerieBlack)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChallengeTopBar() {
    TopAppBar(
        modifier = Modifier.shadow(elevation = 8.dp, spotColor = Color.Gray),
        title = {
            Text(
                text = "CHALLENGES",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = Typography.titleLarge,
                color = MediumAquamarine,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = EerieBlack)
    )
}

@Composable
fun ChallengeContent(modifier: Modifier) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180.dp),
        modifier = modifier
    ) {
        item {
            ChallengeItem("Tiger Cup")
        }
        item {
            ChallengeItem("Meditate4Life")
        }
        item {
            ChallengeItem("Moving4Good")
        }
        item {
            ChallengeItem("Bed On Time Cup")
        }
    }
}

@Composable
fun ChallengeItem(title: String) {
    Card(
        modifier = Modifier
            .width(140.dp)
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .border(2.dp, Color(0xff5bf5ab), shape = RoundedCornerShape(12.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 18.dp)
                    .size(70.dp)
            )
            Text(
                title, color = Color(91, 245, 171),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .offset(y = (-10).dp)
            )

            Divider(
                color = Color(91, 245, 171),
                thickness = 3.dp,
                modifier = Modifier.padding(top = 8.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Add a little bit of body textAdd a little bit of body",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 11.sp,
                )
                Button(
                    colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0, 0, 0)),
                    onClick = {}) {
                    Text(
                        "Join",
                        color = Color(91, 245, 171)
                    )
                }
            }
        }
    }

}
