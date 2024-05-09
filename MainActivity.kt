package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier, color = MaterialTheme.colorScheme.background){
        if (shouldShowOnboarding){
            OnboardingScreen(onContinueClicked={ shouldShowOnboarding = false})
        }else{
            Greetings()
        }
    }
}
@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Hello晚上好")
        Button(
            modifier = modifier.padding(vertical = 24.dp),
            onClick =  onContinueClicked
        ) {
            Text( "继续")
        }
    }
}
@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(100){"$it"},
){
    LazyColumn (modifier = modifier.padding(vertical = 4.dp)){
        items(items = names){name ->
            Greeting(name = name)
        }
    }
}
@Composable
private fun Greeting(name:String,modifier: Modifier = Modifier){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ){
        CardContent()
    }
}
@Composable
private fun CardContent() {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Row (
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ){
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ){
            Text(text = "Hello,")
            Text(
                text = "嘻嘻嘻、嘻嘻嘻、嘻嘻嘻"+"惺惺惜惺惺".repeat(10),
            )
        }
    }
    IconButton(onClick = { expanded = !expanded }) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = if (expanded){
                stringResource(R.string.zhuyanghao)
            } else{
                stringResource(R.string.zhuyanghao)
            }
        )
    }
}