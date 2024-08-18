package com.example.appinstaai.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Camera
import androidx.compose.material.icons.outlined.DomainVerification
import androidx.compose.material.icons.outlined.LocalSee
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appinstaai.R
import com.example.appinstaai.ui.theme.iconbg


@Composable
fun MessageScreen(navController: NavHostController) {


    Column {
        MessagesTopBar()
        SearchBarWithFilter()
        StoriesRow()
        MessageTabs()
        Divider(color = Color.Gray, thickness = 0.5.dp)
        MessagesList()
    }
}

@Composable
fun MessagesTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        IconButton(onClick = { /* TODO: Handle back action */ }) {
            Icon(
                Icons.Outlined.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = "R.R. Martin",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
                    modifier = Modifier.weight(1f)
        )
        Row(
            horizontalArrangement = Arrangement.End
        )
        {
            IconButton(onClick = { /* TODO: Handle more action */ }) {
                Icon(
                    Icons.Outlined.MoreHoriz,
                    contentDescription = "More",
                    modifier = Modifier.size(24.dp)
                )
            }
          //  Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { /* TODO: Handle trending action */ }) {
                Icon(
                    Icons.Outlined.TrendingUp,
                    contentDescription = "Trending",
                    modifier = Modifier.size(24.dp)
                )
            }
           // Spacer(modifier = Modifier.width(8.dp))
            IconButton(onClick = { /* TODO: Handle write post action */ }) {
                Icon(
                  Icons.Outlined.DomainVerification,
                    contentDescription = "Write Post",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarWithFilter() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = { /* TODO: Handle search query */ },
            placeholder = { Text("Search") },
            leadingIcon = {
                Icon(
                    Icons.Outlined.Search,
                    contentDescription = null,
                    tint = Color.Gray
                )
            },
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 6.dp),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = Color.LightGray
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text= "Filter",
            color = iconbg,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}
@Composable
fun MessageTabs() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Primary",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = iconbg,
        )
        Text(
            text = "General",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = "Requests",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}
@Composable
fun MessageItem(
    profileImageRes: Int,
    username: String,
    newMessage: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = profileImageRes),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(Color.Red, Color.Black)
                    ),  shape = CircleShape
                ),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = username,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = newMessage,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        IconButton(onClick = { /* TODO: Handle camera action */ }) {
            Icon(
               Icons.Outlined.LocalSee,
                contentDescription = "Camera",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
@Composable
fun MessagesList() {
    val messages = listOf(
        MessageData(R.drawable.profile, "Alicent Hightower", "2 + New messages"),
        MessageData(R.drawable.profile, "Daemon Targaryen", "2 + New messages"),
        MessageData(R.drawable.profile, "Otto Hightower", "2 + New messages"),
        MessageData(R.drawable.profile, "Ser Criston Cole", "2 + New messages"),
        MessageData(R.drawable.profile, "Aemond Targaryen", "2 + New messages"),
        MessageData(R.drawable.profile, "Queen Rhaenyra Targaryen", "2 + New messages"),
        MessageData(R.drawable.profile, "Jacaerys Velaryon", "2 + New messages"),
        MessageData(R.drawable.profile, "Lord Corlys Velaryon", "2 + New messages"),

    )

    LazyColumn {
        items(messages) { message ->
            MessageItem(
                profileImageRes = message.profileImage,
                username = message.username,
                newMessage = message.newMessage
            )
        }
    }
}
data class MessageData(
    val profileImage: Int,
    val username: String,
    val newMessage: String
)
