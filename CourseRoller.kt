package com.example.compose.course

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.courseroller.R
import com.example.courseroller.ui.theme.CourseRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseRollerTheme {

            }
        }
    }

    @Composable
    fun CourseRoller(
        modifier: Modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        /**
         * 1. 添加修饰符
         * 2. 全画幅
         * 3. 给垂直水平居中*/
    ) {
        var result by remember {
            mutableStateOf(1)
        }
        val imageResource = when (result) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "课堂模拟器之大富翁基础功能：掷骰子")
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = result.toString()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { result = (1..6).random() }) {
                Text(text = stringResource(id = R.string.roll))
            }
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun CourseRollerApp() {
        CourseRoller()
    }
}


