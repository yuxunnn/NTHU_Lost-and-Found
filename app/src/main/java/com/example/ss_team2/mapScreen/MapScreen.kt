package com.example.ss_team2.mapScreen

import android.content.res.Configuration
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.ss_team2.homepage.SchoolFlag
import com.example.ss_team2.ui.theme.SSteam2Theme
import com.example.ss_team2.utility.TopBarButton
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.launch

private val schoolPositionList: List<LatLng> = listOf(
    LatLng(24.796216802267217, 120.99668480810016),
    LatLng(24.786945096427186, 120.99749859318587),
    LatLng(25.017473169825568, 121.5397521708148),
    LatLng(24.988096573881222, 121.57738748320742)
)

private val tempToolList: List<Tool> = listOf(
    Tool(image = 1, 24.79, 120.99)
)

const val InitialZoom = 15f

@Composable
fun MapScreen(
    modifier: Modifier
) {

    var currentSchool by remember { mutableStateOf(0) }
    val flagTransition = updateTransition(targetState = currentSchool, label = "Flag indicator")

    val offsetX: List<Dp> = listOf(0.dp, (-60).dp, 0.dp, 60.dp)
    val offsetY: List<Dp> = listOf(20.dp, 0.dp, (-10).dp, 0.dp)
    val flagOffsetX: List<Dp> = listOf(
        flagTransition.animateDp(label = "NTHUX") { school ->
            offsetX[school]
        }.value,
        flagTransition.animateDp(label = "NCTUX") { school ->
            offsetX[(school + 3) % 4]
        }.value,
        flagTransition.animateDp(label = "NTUX") { school ->
            offsetX[(school + 2) % 4]
        }.value,
        flagTransition.animateDp(label = "NCCUX") { school ->
            offsetX[(school + 1) % 4]
        }.value,
    )
    val flagOffsetY: List<Dp> = listOf(
        flagTransition.animateDp(label = "NTHUY") { school ->
            offsetY[school]
        }.value,
        flagTransition.animateDp(label = "NCTUY") { school ->
            offsetY[(school + 3) % 4]
        }.value,
        flagTransition.animateDp(label = "NTUY") { school ->
            offsetY[(school + 2) % 4]
        }.value,
        flagTransition.animateDp(label = "NCCUY") { school ->
            offsetY[(school + 1) % 4]
        }.value,
    )


    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(schoolPositionList[0], InitialZoom)
    }
    val scope = rememberCoroutineScope()

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {
            TopBarButton(
                imageVector = Icons.Default.ArrowBack,
                onClick = {}
            )
            Box(modifier = Modifier) {
                repeat(4) {
                    if (it != (currentSchool+2)%4){
                        SchoolFlag(
                            school = it,
                            selected = it == currentSchool,
                            onClick = {
                                scope.launch {
                                    cameraPositionState.animate(
                                        update = CameraUpdateFactory.newLatLngZoom(
                                            schoolPositionList[it],
                                            InitialZoom
                                        ),
                                        durationMs = 1000,
                                    )
                                }
                                currentSchool = it
                            },
                            modifier = Modifier.offset(x = flagOffsetX[it], y = flagOffsetY[it])
                        )
                    }
                }
            }
            TopBarButton(
                imageVector = Icons.Default.ShoppingCart,
                onClick = {}
            )
        }

        Divider(
            color = MaterialTheme.colors.onBackground,
            thickness = 2.dp,
            modifier = Modifier.padding(top = 12.dp)
        )

        Map(
            cameraPositionState = cameraPositionState,
            currentSchool = currentSchool,
            tools = tempToolList,
            modifier = Modifier
                .height(420.dp)
                .fillMaxWidth()
        )

        Divider(
            color = MaterialTheme.colors.onBackground,
            thickness = 2.dp,
            modifier = Modifier
        )

        ToolList(modifier = Modifier)
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "MapPreviewDark",
    showSystemUi = true
)
@Preview(
    showBackground = true,
    name = "MapPreviewLight",
    showSystemUi = true
)
@Composable
fun MapPreview() {
    SSteam2Theme {
        Scaffold { padding ->
            MapScreen(
                modifier = Modifier.padding(padding)
            )
        }
    }
}