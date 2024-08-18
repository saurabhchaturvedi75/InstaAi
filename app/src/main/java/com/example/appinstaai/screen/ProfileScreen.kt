package com.example.appinstaai.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.BorderAll
import androidx.compose.material.icons.outlined.DomainVerification
import androidx.compose.material.icons.outlined.MoreHoriz
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.OndemandVideo
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material.icons.outlined.PersonPin
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appinstaai.R


@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        ProfileTopBar()
        ProfileHeader(
            profileImageRes = R.drawable.profile,
            postsCount = 120,
            followersCount = 1500,
            followingCount = 300
        )
        NameAndStatus(
            name = "Helena ",
            status = "Traveler | Foodie | Photographer"
        )
        Spacer(modifier = Modifier.height(8.dp))
        ProfileActionsRow()
        Spacer(modifier = Modifier.height(8.dp))
        StoriesRow()
        Spacer(modifier = Modifier.height(8.dp))
        ProfileTabsRow()
        Spacer(modifier = Modifier.height(8.dp))
      //  Divider(color = Color.Gray, thickness = 0.5.dp)
        ImageGrid(
            imageList = listOf(
                R.drawable.profile, R.drawable.profile, R.drawable.profile,
                R.drawable.profile, R.drawable.profile, R.drawable.profile,
                R.drawable.profile, R.drawable.profile, R.drawable.profile,
                R.drawable.profile, R.drawable.profile, R.drawable.profile

            )
        )
    }
}

@Composable
fun ProfileTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {

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
            IconButton(onClick = { /* TODO: Handle trending action */ }) {
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = "Trending",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* TODO: Handle more action */ }) {
                Icon(
                    Icons.Outlined.MoreHoriz,
                    contentDescription = "More",
                    modifier = Modifier.size(24.dp)
                )
            }
            //  Spacer(modifier = Modifier.width(8.dp))


        }
    }
}

@Composable
fun ProfileHeader(
    profileImageRes: Int,
    postsCount: Int,
    followersCount: Int,
    followingCount: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.size(80.dp)
        ) {
            Image(
                painter = painterResource(id = profileImageRes),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Icon(
                Icons.Outlined.Add,
                contentDescription = "Add Icon",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.BottomEnd)
                    .background(Color.White, CircleShape)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "$postsCount", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "Posts", fontSize = 14.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "$followersCount", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "Followers", fontSize = 14.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "$followingCount", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "Following", fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun NameAndStatus(name: String, status: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = status, fontSize = 14.sp)
    }
}

@Composable
fun ProfileActionsRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = { /* TODO: Handle edit profile */ },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(text = "Edit Profile", color = Color.Black)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(
            onClick = { /* TODO: Handle share profile */ },
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)

        ) {
            Text(text = "Share Profile", color = Color.Black)
        }
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { /* TODO: Handle add friend */ }) {
            Icon(

                Icons.Outlined.PersonAddAlt,
                contentDescription = "Add Friend",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ProfileTabsRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Icon(
            Icons.Outlined.BorderAll,
            contentDescription = "Person Icon",
            modifier = Modifier.size(24.dp)
        )
        Icon(
            Icons.Outlined.OndemandVideo,
            contentDescription = "Person Icon",
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
        Icon(
            Icons.Outlined.PersonPin,
            contentDescription = "Person Icon",
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
    }
}


@Composable
fun ImageGrid(imageList: List<Int>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        //   contentPadding = PaddingValues(4.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        items(imageList) { imageRes ->
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Grid Image",
                modifier = Modifier
                    //  .padding(4.dp)
                    .size(140.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}
