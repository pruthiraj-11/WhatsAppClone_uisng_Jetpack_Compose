package com.app.whatspapclone

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.whatspapclone.AppTabBar
import com.app.whatspapclone.AppTabs
import com.app.whatspapclone.ui.theme.WhatspApCloneTheme
import com.app.whatspapclone.CallView
import com.app.whatspapclone.ChatView
import com.app.whatspapclone.StatusView

enum class HomeTab {
    CHAT, STATUS, CALL
}

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatspApCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeView(this)
                }
            }
        }
    }
}

@Composable
fun HomeView(mContext: Context) {
    var showMenu by remember { mutableStateOf(false) }
    var tabSelected by remember { mutableStateOf(HomeTab.CHAT) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("WhatsApp") },
                elevation = 0.dp,
                actions = {
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = {}) {
                            Text(text = "Whatsapp web")
                        }
                        DropdownMenuItem(onClick = {}) {
                            Text(text = "Settings")
                        }
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Search, contentDescription = null)
                    }

                    IconButton(onClick = { showMenu = showMenu != true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = {
            when (tabSelected) {
                HomeTab.CHAT -> {
                    FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Color.Green) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_message),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
                HomeTab.STATUS -> {
                    Column {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            backgroundColor = Color.White,
                            modifier = Modifier.size(40.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_create),
                                contentDescription = null,
                                tint = Color.DarkGray
                            )
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            backgroundColor = Color.Green
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_camera),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
                HomeTab.CALL -> {
                    FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Color.Green) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add_call),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        Column(Modifier.fillMaxSize()) {
            HomeTabBar(
                tabSelected,
                onTabSelected = { tabSelected = it }
            )
            when (tabSelected) {
                HomeTab.CHAT -> ChatView(mContext)
                HomeTab.STATUS -> StatusView()
                HomeTab.CALL -> CallView()
            }
        }
    }
}

@Composable
fun HomeTabBar(
    tabSelected: HomeTab,
    onTabSelected: (HomeTab) -> Unit
) {
    AppTabBar { tabBarModifier ->
        AppTabs(
            modifier = tabBarModifier,
            titles = HomeTab.values().map { it.name },
            tabSelected = tabSelected,
            onTabSelected = { newTab ->
                onTabSelected(HomeTab.values()[newTab.ordinal])
            }
        )
    }
}
