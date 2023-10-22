package com.app.whatspapclone

data class Chat(
    val id: Int,
    val name: String,
    val time: String,
    val date: String?,
    val lastMessage: String?,
    val imageUrl: String
)

data class Call(
    val id: Int,
    val name: String,
    val date: String,
    val imageUrl: String,
    val isMissCall: Boolean,
    val isIncoming: Boolean,
)

data class Message(
    val message: String,
    val isPeer: Boolean
)

object DummyData {
    val listChat = listOf(
        Chat(
            id = 0,
            name = "Tanmay Panda",
            time = "08:46",
            date = "17 Sep",
            lastMessage = "Okk",
            imageUrl = "https://randomuser.me/api/portraits/men/12.jpg"
        ),
        Chat(
            id = 1,
            name = "Puranjeet",
            time = "12:45",
            date = null,
            lastMessage = "Contrary to popular belief",
            imageUrl = "https://randomuser.me/api/portraits/men/85.jpg"
        ),
        Chat(
            id = 2,
            name = "Soubhagya",
            time = "Yesterday",
            date = "17 Sep",
            lastMessage = "kouthi kire",
            imageUrl = "https://randomuser.me/api/portraits/men/31.jpg"
        ),
        Chat(
            id = 3,
            name = "Jitendriya",
            time = "23:56",
            date = "17 Oct",
            lastMessage = "Thanks",
            imageUrl = "https://randomuser.me/api/portraits/women/76.jpg"
        ),
        Chat(
            id = 4,
            name = "Biswajit",
            time = "10/06/2023",
            date = "17 june",
            lastMessage = "nosense",
            imageUrl = "https://randomuser.me/api/portraits/women/67.jpg"
        ),
        Chat(
            id = 5,
            name = "+91 8917677691",
            time = "Yesterday",
            date = "21 Oct",
            lastMessage = "maribi",
            imageUrl = "https://randomuser.me/api/portraits/men/41.jpg"
        ),
        Chat(
            id = 6,
            name = "Me",
            time = "09/06/2022",
            date = "17 june",
            lastMessage = "when an unknown printer took",
            imageUrl = "https://randomuser.me/api/portraits/women/31.jpg"
        ),
        Chat(
            id = 7,
            name = "NOTES",
            time = "08:46",
            date = "19 July",
            lastMessage = "ILU",
            imageUrl = "https://cdns.klimg.com/bola.net/library/upload/21/2018/07/mo-salah-l_a7e5e57.jpg"
        ),
    )

    val listCall = listOf(
        Call(
            id = 0,
            name = "NOTES",
            date = "8 Aug 08.46",
            imageUrl = "https://randomuser.me/api/portraits/men/31.jpg",
            isIncoming = true,
            isMissCall = false
        )
    )

    val listMessage = listOf(
        Message("Hi SD how are you ?", false),
        Message("Iam fine, how are you ?", true),
        Message("Iam fine too", false),
        Message("What do you do now ?", true),
        Message("Write a book, and doing my work", false),
        Message("Wow, its so good man", true),
        Message("Yeah", false),
    )
}