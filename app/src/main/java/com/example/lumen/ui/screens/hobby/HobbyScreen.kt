package com.example.lumen.ui.screens.hobby

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lumen.ui.components.LumenDivider
import com.example.lumen.ui.theme.EerieBlack
import com.example.lumen.ui.theme.MediumAquamarine
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun HobbyScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.background(EerieBlack)) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            GoogleMapView(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
            )

            ActivitySpec(modifier = Modifier.weight(0.6f))

        }
    }
}

@Composable
fun GoogleMapView(modifier: Modifier = Modifier) {
    var isMapLoaded by remember { mutableStateOf(false) }
    val vietnam = LatLng(20.980722, 105.7871001)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(vietnam, 18f)
    }

    Box(modifier = modifier) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            onMapLoaded = { isMapLoaded = true })

        if (!isMapLoaded) {
            AnimatedVisibility(
                modifier = Modifier
                    .fillMaxSize(),
                visible = !isMapLoaded,
                enter = EnterTransition.None,
                exit = fadeOut()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.wrapContentSize()
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xff1f1f1f)
fun ActivitySpec(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "00:01:00", fontSize = 48.sp, color = MediumAquamarine)
        Text(text = "Time", fontSize = 14.sp, color = MediumAquamarine)

        LumenDivider(modifier = Modifier.padding(8.dp))

        Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(0.45f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "2.1 Km", fontSize = 36.sp, color = MediumAquamarine)
                Text(text = "Distance", fontSize = 14.sp, color = MediumAquamarine)
            }

            LumenDivider(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight(0.5f)
            )

            Column(
                modifier = Modifier.weight(0.45f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "58", fontSize = 36.sp, color = MediumAquamarine)
                Text(text = "Kcal", fontSize = 14.sp, color = MediumAquamarine)
            }
        }

        LumenDivider(modifier = Modifier.padding(16.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier= Modifier.size(100.dp),
            border= BorderStroke(1.dp, MediumAquamarine),
            shape = CircleShape,
            colors = ButtonDefaults.outlinedButtonColors(contentColor = MediumAquamarine)
        ) {
            Text(text = "GO", fontSize = 28.sp)
        }
    }
}