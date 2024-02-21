package com.example.lumen.ui.screens.meditate

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lumen.R
import com.example.lumen.ui.theme.EerieBlack
import com.example.lumen.ui.theme.MediumAquamarine
import com.example.lumen.ui.theme.Typography

@Composable
fun MeditateScreen(modifier: Modifier) {
    Scaffold(modifier = modifier, topBar = { MeditateTopBar() }) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            MeditateContent(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = EerieBlack)
                    .padding(8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeditateTopBar() {
    TopAppBar(
        modifier = Modifier.shadow(elevation = 8.dp, spotColor = Color.Gray),
        title = {
            Text(
                text = "MEDITATION",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = Typography.titleLarge,
                color = MediumAquamarine,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = EerieBlack)
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MeditateContent(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "What do you want to focus on today?",
            style = Typography.titleMedium,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(32.dp))

        LazyVerticalGrid(
            horizontalArrangement = Arrangement.Center,
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            item {
                MeditationTypeItem(
                    painter = painterResource(id = R.drawable.outline_relax_24),
                    title = "Relax"
                )
            }
            item {
                MeditationTypeItem(
                    painter = painterResource(id = R.drawable.baseline_self_improvement_24),
                    title = "Concentrate"
                )
            }
            item {
                MeditationTypeItem(
                    painter = painterResource(id = R.drawable.outline_bedtime_24),
                    title = "Sleep"
                )
            }
            item {
                MeditationTypeItem(
                    painter = painterResource(id = R.drawable.outline_mindfulness_24),
                    title = "Reduce stress"
                )
            }
            item {
                MeditationTypeItem(
                    painter = painterResource(id = R.drawable.rounded_person_celebrate_24),
                    title = "Improve memory"
                )
            }
        }

        Spacer(modifier = Modifier.size(32.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            AssistChip(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, color = MediumAquamarine),
                label = { Text(text = "1m", style = Typography.labelMedium, color = MediumAquamarine, modifier = Modifier.padding(8.dp),) }
            )
            Spacer(modifier = Modifier.size(8.dp))
            AssistChip(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, color = MediumAquamarine),
                label = { Text(text = "2m", style = Typography.labelMedium, color = MediumAquamarine, modifier = Modifier.padding(8.dp),) }
            )
            Spacer(modifier = Modifier.size(8.dp))

            AssistChip(
                onClick = { /*TODO*/ },
                border = BorderStroke(1.dp, color = MediumAquamarine),
                label = { Text(text = "3m", style = Typography.labelMedium, color = MediumAquamarine, modifier = Modifier.padding(8.dp),) }
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(containerColor = MediumAquamarine, contentColor = EerieBlack)) {
            Text(text = "START")
        }
    }
}

@Composable
fun MeditationTypeItem(painter: Painter, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(percent = 10))
                .background(color = MediumAquamarine)
        ) {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = EerieBlack,
                modifier = Modifier.size(100.dp)
            )
        }
        Text(text = title, style = Typography.labelSmall, color = Color.White)
    }
}


@Preview
@Composable
fun MedPreview() {
    MeditateScreen(modifier = Modifier)
}