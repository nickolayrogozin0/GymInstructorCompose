package com.example.gyminstructorcompose.ui.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.gyminstructorcompose.R

@Composable
fun UserAccountScreen() {

    Column {
        UserAccountTopBar()
        UserAccountCard()
        Column() {
            UserAccountButton(
                Icons.Default.Straighten,
                "User measurements",
                "Your maxes, body measurements"
            )
            UserAccountButton(
                Icons.Default.FitnessCenter,
                "User measurements",
                "Your maxes, body measurements"
            )
            UserAccountButton(
                Icons.Default.Calculate,
                "User measurements",
                "Your maxes, body measurements"
            )
            UserAccountButton(
                Icons.Default.StickyNote2,
                "User measurements",
                "Your maxes, body measurements"
            )
        }
    }

}

@Composable
fun UserAccountCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            Modifier.padding(16.dp)
        ) {
            Image(
//                painter = painterResource(R.drawable.sample_avatar),
                imageVector = Icons.Default.Person,
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)                       // clip to the circle shape
//                    .border(2.dp, Color.Gray, CircleShape)   // add a border (optional)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.height(64.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Robert Beringer")
                Spacer(Modifier.height(4.dp))
                Text(text = "+7 921 917 2989")
            }
        }
    }
}

@Composable
fun UserAccountButton(
    icon : ImageVector,
    header : String,
    subheader : String
) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(header, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subheader, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun UserAccountTopBar() {
    SmallTopAppBar(
        title = { Text("Account") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "more button"
                )
            }
        }
    )
}