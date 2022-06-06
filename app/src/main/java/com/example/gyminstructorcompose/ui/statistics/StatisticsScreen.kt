package com.example.gyminstructorcompose.ui.statistics


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.bytebeats.views.charts.line.LineChart
import me.bytebeats.views.charts.line.LineChartData
import me.bytebeats.views.charts.line.render.line.SolidLineDrawer
import me.bytebeats.views.charts.line.render.point.FilledCircularPointDrawer
import me.bytebeats.views.charts.line.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.line.render.yaxis.SimpleYAxisDrawer
import me.bytebeats.views.charts.simpleChartAnimation

@Composable
fun StatisticsScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    )
    {
        StatisticsScreenTopBar()
        Text("КПШ")
        LineChartView()
        Text("Тоннаж")
        LineChartView()
        Text("ОИ")
        LineChartView()
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun LineChartView() {
    LineChart(
        lineChartData = LineChartData(
            points = listOf(
                LineChartData.Point(324f, "Week 1"),
                LineChartData.Point(297f, "Week 2"),
                LineChartData.Point(192f, "Week 3"),
                LineChartData.Point(268f, "Week 4"),
            )
        ),
        // Optional properties.
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(16.dp),
        animation = simpleChartAnimation(),
        pointDrawer = FilledCircularPointDrawer(),
        lineDrawer = SolidLineDrawer(),
        xAxisDrawer = SimpleXAxisDrawer(),
        yAxisDrawer = SimpleYAxisDrawer(drawLabelEvery = 5),
        horizontalOffset = 5f
    )
}

@Composable
fun StatisticsScreenTopBar() {
    SmallTopAppBar(
        title = { Text("Statistics") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "more button"
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "more button"
                )
            }
        }
    )
}