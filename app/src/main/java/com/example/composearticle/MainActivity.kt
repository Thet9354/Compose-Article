package com.example.composearticle

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val navController = rememberNavController()
                    if (intent?.action == Intent.ACTION_VIEW) {
                        // The code below handles the deep link here
                        val deepLinkUri = intent.data
                        if (deepLinkUri != null) {
                            val deepLink = deepLinkUri.toString()
                            if (deepLink == "https://www.betrbeta.com/#start") {
                                navController.navigate("main") // Navigate to the desired screen
                            }
                        }
                    }

                    NavHost(navController, startDestination = "main") {
                        composable("main") { Article() }
//                        composable("main") { Article() }

                    }
                }
            }
        }
    }
}

@Composable
fun Article() {
    Column {
        ArticleImage()
        ArticleText()
    }
}

@Composable
fun ArticleImage() {
    val articleImage = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = articleImage,
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ArticleText(modifier: Modifier = Modifier) {
    Column {

        Text(text = stringResource(R.string.article_title),
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
        )

        Text(text = stringResource(R.string.article_text_1),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            stringResource(id = R.string.article_text_2),
            Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        Article()
    }
}


