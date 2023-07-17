package com.example.composearticle

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
                    Article()
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
