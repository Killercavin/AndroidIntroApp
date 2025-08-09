package com.example.androidintroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidintroapp.ui.theme.AndroidIntroAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidIntroAppTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AndroidIntroApp()
                }
            }
        }
    }
}

@Composable
fun AndroidIntroApp() {
    ArticleCard(
        title = stringResource(R.string.title),
        shortDescription = stringResource(R.string.short_description),
        longDescription = stringResource(R.string.long_description)
    )
}

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter = painterResource(R.drawable.bg_compose_background)
) {
    Column(modifier = modifier) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 45.dp)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )

        Text(
            text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
        )

        Text(
            text = longDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun AndroidIntroPreview() {
    ArticleCard(
        title = stringResource(R.string.title),
        shortDescription = stringResource(R.string.short_description),
        longDescription = stringResource(R.string.long_description)
    )
}