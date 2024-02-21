package com.example.lumen.ui.screens.alarm

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.unit.sp
import com.example.lumen.R
import com.example.lumen.ui.theme.EerieBlack
import com.example.lumen.ui.theme.MediumAquamarine
import com.example.lumen.ui.theme.Typography

@Composable
@Preview
fun AlarmScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier, topBar = { AlarmTopBar() }) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            AlarmContent(
                modifier = Modifier
                    .background(EerieBlack)
                    .fillMaxSize()
                    .padding(top = 8.dp)
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmTopBar() {
    TopAppBar(
        modifier = Modifier.shadow(elevation = 8.dp, spotColor = Color.Gray),
        title = {
            Text(
                text = "Alarm",
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
fun AlarmContent(modifier: Modifier = Modifier) {
    var selectedPosition by remember {
        mutableIntStateOf(2)
    }

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.size(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween) {

            AlarmTopOptionItem(
                title = "Alarm",
                painter = painterResource(id = R.drawable.outline_access_alarm_24),
                modifier = Modifier.weight(1f),
                isSelected = selectedPosition == 0,
                onSelect = { selectedPosition = 0 }
            )
            Spacer(modifier = Modifier.size(8.dp))
            AlarmTopOptionItem(
                title = "Sleep calc",
                painter = painterResource(id = R.drawable.outline_calendar_clock_24),
                modifier = Modifier.weight(1f),
                isSelected = selectedPosition == 1,
                onSelect = { selectedPosition = 1 }
            )
            Spacer(modifier = Modifier.size(8.dp))

            AlarmTopOptionItem(
                title = "Sheep count",
                painter = painterResource(id = R.drawable.outline_bedtime_24),
                modifier = Modifier.weight(1f),
                isSelected = selectedPosition == 2,
                onSelect = { selectedPosition = 2 }
            )
        }

        Spacer(modifier = Modifier.size(64.dp))

        if (selectedPosition == 0)
            AlarmOption()
        else if (selectedPosition == 1)
            SleepCalculator()
        else
            SheepCount()
    }
}

@Composable
fun SheepCount(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.sheep), contentDescription = null)
        Spacer(modifier = Modifier.size(32.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = MediumAquamarine,
                contentColor = EerieBlack
            )
        ) {
            Text(text = "New picture")
        }
    }
}

@Composable
fun SleepCalculator(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "I have to wake up at",
            textAlign = TextAlign.Center,
            style = Typography.titleMedium,
            color = MediumAquamarine,
        )

        AssistChip(
            onClick = { /*TODO*/ },
            border = BorderStroke(2.dp, color = MediumAquamarine),
            label = {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "8:30 AM",
                    textAlign = TextAlign.Center,
                    style = Typography.labelMedium,
                    color = MediumAquamarine,
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    tint = MediumAquamarine
                )
            })

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = MediumAquamarine,
                contentColor = EerieBlack
            )
        ) {
            Text(text = "Calculate time")
        }

        Spacer(modifier = Modifier.size(32.dp))

        Text(
            text = "You should go to bed at:",
            textAlign = TextAlign.Center,
            style = Typography.titleMedium,
            color = MediumAquamarine,
        )

        Spacer(modifier = Modifier.size(16.dp))

        Row() {
            Column(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = EerieBlack)
                    .border(
                        width = 2.dp,
                        color = MediumAquamarine,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "10:15 PM\n~ 4 sleep cycle",
                    textAlign = TextAlign.Center,
                    style = Typography.labelMedium,
                    color = MediumAquamarine,
                )
            }

            Spacer(modifier = Modifier.size(16.dp))

            Column(
                modifier = modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(color = EerieBlack)
                    .border(
                        width = 2.dp,
                        color = MediumAquamarine,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "11:45 PM\n~ 3 sleep cycle",
                    textAlign = TextAlign.Center,
                    style = Typography.labelMedium,
                    color = MediumAquamarine,
                )
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = MediumAquamarine,
                contentColor = EerieBlack
            )
        ) {
            Text(text = "Set this as your alarm")
        }
    }
}

@Composable
fun AlarmTopOptionItem(
    title: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean = true,
    onSelect: () -> Unit,
    painter: Painter
) {

    Column(
        modifier = modifier
            .clickable { onSelect() }
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = if (isSelected) MediumAquamarine else EerieBlack)
            .border(
                width = 2.dp,
                color = MediumAquamarine,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = if (!isSelected) MediumAquamarine else EerieBlack,
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            style = Typography.labelMedium,
            color = if (!isSelected) MediumAquamarine else EerieBlack,
        )
    }
}

@Composable
fun AlarmOption(modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Overall sleeping score",
            textAlign = TextAlign.Center,
            style = Typography.titleLarge,
            color = Color.White,
        )

        Spacer(modifier = Modifier.size(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "\uD83E\uDD70", fontSize = 50.sp)
            Spacer(modifier = Modifier.size(8.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Excellent, your AVG sleeping time is:",
                    style = Typography.bodyLarge,
                    color = MediumAquamarine
                )
                Text(text = "50", style = Typography.titleLarge, color = MediumAquamarine)
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        Text(text = "Your alarm", style = Typography.titleLarge, color = Color.White)

        Spacer(modifier = Modifier.size(16.dp))

        AlarmItem()
    }
}

@Composable
fun AlarmItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = EerieBlack)
            .border(
                width = 2.dp,
                color = MediumAquamarine,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "12:30",
            style = Typography.titleMedium,
            color = MediumAquamarine,
        )
        Spacer(modifier = Modifier.size(8.dp))
        Column {
            Text(
                text = "daily",
                style = Typography.bodySmall,
                color = MediumAquamarine,
            )
            Text(
                text = "p.m",
                style = Typography.bodyLarge,
                color = MediumAquamarine,
            )
        }
        Spacer(modifier = Modifier.width(100.dp))

        var switchState by remember {
            mutableStateOf(true)
        }
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = !switchState },
            colors = SwitchDefaults.colors(
                checkedTrackColor = MediumAquamarine,
                checkedThumbColor = Color.White
            )
        )
    }
}