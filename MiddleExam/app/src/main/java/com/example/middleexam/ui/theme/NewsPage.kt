package com.example.middleexam.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun NewsPage(navController: NavHostController,NewsList:List<News>){
    Column {
        for (i in 1 .. 3){
            Text(text = NewsList[0].title)
            Text(text = "新闻标题")
            Text(text = "新闻正文")
            Button(onClick =  {
                navController.navigate("index")
            }){
                Text(text = "返回首页")
            }
        }
    }
}
