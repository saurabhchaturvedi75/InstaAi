package com.example.appinstaai.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material.icons.outlined.ModeComment
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appinstaai.R
import com.example.appinstaai.navigation.Routes
import com.example.appinstaai.ui.theme.iconbg


@Composable
fun HomeScreen(navController: NavHostController) {

    Column {
        InstagramTopBar(navController)
        StoriesRow()
        //  HorizontalDivider(thickness = 0.5.dp, color = Color.Gray)
        PostFeedPlaceholder()
    }
}

@Composable
fun InstagramTopBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(


        ) {
            Icon(
                Icons.Outlined.Notifications,
                contentDescription = "Notifications",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                Icons.Filled.AddCircleOutline,
                contentDescription = "Add Post",
                modifier = Modifier.size(24.dp)
            )
        }
        Text(
            text = "ɑi",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Row(

        ) {
            Icon(
                Icons.Filled.Search,

                contentDescription = "Search",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                Icons.Outlined.Message,

                contentDescription = "Messages",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        navController.navigate(Routes.Message.route)
                    }
            )
        }
    }
}

@Composable
fun StoriesRow() {
    val sampleStories = listOf(
        //   Pair(R.drawable.profile, "Your Story"),
        Pair(R.drawable.profile, "Aemond"),
        Pair(R.drawable.profile, "Aegon"),
        Pair(R.drawable.profile, "Daemon"),
        Pair(R.drawable.profile, "Otto Hightower"),
        Pair(R.drawable.profile, "Queen Rhaenyra"),
        Pair(R.drawable.profile, "Alicent")
    )



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Spacer(modifier = Modifier.width(8.dp))
        StoryItem(
            imageRes = R.drawable.profile,
            name = "Your Story",
            isYourStory = true
        )

        Spacer(modifier = Modifier.width(8.dp))


        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(sampleStories) { (imageRes, name) ->
                StoryItem(
                    imageRes = imageRes,
                    name = name,
                    isYourStory = false
                )
            }
        }
    }

}

@Composable
fun StoryItem(imageRes: Int, name: String, isYourStory: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Story Image",
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Blue, Color.Cyan)
                        ), shape = CircleShape
                    ),
                contentScale = ContentScale.Crop
            )
            if (isYourStory) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add Story",
                    tint = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            iconbg, CircleShape
                        )
                        .padding(2.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = name, fontSize = 12.sp)
    }
}


@Composable
fun PostFeedPlaceholder() {
    PostFeed()

}

@Composable
fun PostItem(
    profileImageRes: Int,
    profileName: String,
    postImageRes: Int,
    likesCount: Int,
    postDescription: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = profileImageRes),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = profileName,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.weight(1f)
            )
            Icon(Icons.Default.MoreHoriz, contentDescription = null)

        }


        Image(
            painter = painterResource(id = postImageRes),
            contentDescription = "Post Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* TODO: Handle like action */ },
                modifier = Modifier.weight(0.3f)
            ) {
                Icon(
                    Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like",
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(
                onClick = { /* TODO: Handle comment action */ },
                modifier = Modifier.weight(0.3f)
            ) {
                Icon(
                    Icons.Outlined.ModeComment,
                    contentDescription = "Comment",
                    modifier = Modifier.size(24.dp)
                )
            }

            IconButton(
                onClick = { /* TODO: Handle send action */ },
                modifier = Modifier.weight(0.3f)
            ) {
                Icon(
                    Icons.Outlined.Send,
                    contentDescription = "Send",
                    modifier = Modifier
                        .size(24.dp)

                )
            }
            Spacer(
                modifier = Modifier
                    .width(118.dp)
                    .weight(1f)
            )
            IconButton(
                onClick = { /* TODO: Handle bookmark action */ },

                ) {
                Icon(
                    Icons.Outlined.BookmarkBorder,
                    contentDescription = "Bookmark",
                    modifier = Modifier.size(24.dp),
                )
            }
        }

        Column {


            Spacer(modifier = Modifier.height(1.dp))
            Text(
                text = "$likesCount likes",
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Color.Gray,
                fontSize = 16.sp,
            )

            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                Text(
                    text = "$profileName ",

                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(
                    text = " $postDescription",


                    fontSize = 16.sp,
                )
            }


            Text(
                text = "View all comments",
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 14.sp,
                color = Color.Gray
            )


            Text(
                text = "13 hours ago",
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
fun ReelsSection() {
    val reels = listOf(
        R.drawable.profile,
        R.drawable.profile,
        R.drawable.profile,
        R.drawable.profile,
        R.drawable.profile,
        R.drawable.profile
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items(reels) { reelImage ->
            Column {
                Card(
                    modifier = Modifier
                        .height(180.dp)
                        .width(140.dp)
                        .padding(4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

                    ) {


                    Image(
                        painter = painterResource(id = reelImage),
                        contentDescription = "Reel Image",
                        modifier = Modifier
                            .height(180.dp)
                            .width(140.dp)
                            .clip(RectangleShape),
                        contentScale = ContentScale.Crop
                    )

                }
                Text(
                    text = "Most Trending Reels", modifier = Modifier.padding(2.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .weight(0.1f)
                )
                Text(
                    text = "1.1M Views",
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 0.dp),
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun PostFeed() {
    val posts = listOf(
        PostData(R.drawable.profile, R.drawable.profile, "Alicent Hightower", 123, "Awesome post!"),
        PostData(R.drawable.profile, R.drawable.profile, "Daemon Targaryen", 456, "Great photo!"),
        PostData(R.drawable.profile, R.drawable.profile, "Otto Hightower", 956, "Great photo!"),
        PostData(R.drawable.profile, R.drawable.profile, "Ser Criston Cole", 656, "Great photo!"),

        )
    val posts2 = listOf(
        PostData(R.drawable.profile, R.drawable.profile, "Aemond Targaryen", 123, "Awesome post!"),
        PostData(
            R.drawable.profile,
            R.drawable.profile,
            "Queen Rhaenyra Targaryen",
            456,
            "Great photo!"
        ),
        PostData(R.drawable.profile, R.drawable.profile, "Jacaerys Velaryon", 656, "Great photo!"),
        PostData(
            R.drawable.profile,
            R.drawable.profile,
            "Lord Corlys Velaryon",
            356,
            "Great photo!"
        ),

        )

    LazyColumn {
        itemsIndexed(posts) { index, post ->
            PostItem(
                profileImageRes = post.profileImage,
                profileName = post.profileName,
                postImageRes = post.postImage,
                likesCount = post.likesCount,
                postDescription = post.description
            )


            if ((index + 1) % 2 == 0) {
                //     AdBanner()
            }
        }


        item {
            ReelsSection()
        }
        itemsIndexed(posts2) { index, post ->
            PostItem(
                profileImageRes = post.profileImage,
                profileName = post.profileName,
                postImageRes = post.postImage,
                likesCount = post.likesCount,
                postDescription = post.description
            )


            if ((index + 1) % 2 == 0) {
                //  AdBanner()
            }
        }
    }
}

@Composable
fun AdBanner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.LightGray, shape = MaterialTheme.shapes.medium)
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Ad Banner", color = Color.Black)
    }
}

data class PostData(
    val profileImage: Int,
    val postImage: Int,
    val profileName: String,
    val likesCount: Int,
    val description: String
)
