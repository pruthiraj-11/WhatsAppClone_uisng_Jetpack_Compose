package com.app.whatspapclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.coil.rememberCoilPainter
import com.app.whatspapclone.Chat
import com.app.whatspapclone.DummyData
import com.app.whatspapclone.Message
import com.app.whatspapclone.ui.theme.WhatspApCloneTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatspApCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val chatId = intent.getIntExtra("extra_chatid", 0)
                    DetailView(chatId)
                }
            }
        }
    }
}

@Composable
fun DetailView(chatId: Int) {
    val chat = DummyData.listChat.filter { it.id == chatId }[0]
    Scaffold(
        backgroundColor = Color(0xFFEDEDED),
        topBar = { MessageTopBar(chat = chat) },
        bottomBar = { MessageBox() },
        content = { MessageList() }
    )
}

@Composable
fun MessageTopBar(chat: Chat) {
    TopAppBar(
        title = {
            Column(Modifier.padding(start = 16.dp)) {
                Text(chat.name, fontSize = 17.sp)
                Text(chat.time, fontSize = 14.sp, fontWeight = FontWeight.Light)
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = null,
                    tint = Color.White
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        navigationIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 4.dp, vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                Image(
                    painter = rememberCoilPainter(request = chat.imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
            }
        },
    )
}

@Composable
fun MessageList() {
    val listMessage = DummyData.listMessage

    LazyColumn {
        items(listMessage.size) {index ->
            Spacer(modifier = Modifier.height(8.dp))
            if(listMessage[index].isPeer) {
                PeerBubble(listMessage[index])
            } else {
                UserBubble(listMessage[index])
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun UserBubble(message: Message) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(80.dp, end = 10.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = Color(0Xffd0ffc4)),
    ) {
        Row(modifier = Modifier.padding(all = 10.dp)) {
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(
                    text = message.message,
                    fontSize = 16.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun PeerBubble(message: Message) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, end = 80.dp)
            .background(color = Color.White)
            .clip(RoundedCornerShape(8.dp)),
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(
                    text = message.message,
                    fontSize = 16.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun MessageBox() {

    val textState = remember { mutableStateOf(TextFieldValue()) }
    val scrollState = rememberScrollState()

    Box(Modifier.background(MaterialTheme.colors.primary)) {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            BasicTextField(
                value = textState.value,
                modifier = Modifier.weight(1f, true),
                onValueChange = {
                    textState.value = it
                })
            Spacer(modifier = Modifier.size(12.dp))

            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Send, contentDescription = null)
            }
        }
    }
}