package com.example.ebook

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ebook.ui.BookPoster
import com.example.ebook.ui.theme.EbookTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        var books = listOf<Book>();
        var book = Book();
        book.title = "Milk & Honey";
        book.author = "Rupi Kaur";
        book.description = "test";
        book.imageUrl =
            "https://images.unsplash.com/photo-1544947950-fa07a98d237f?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";

        var book2 = Book();
        book2.title = "Psychology Of Money";
        book2.author = "Morgan Housel";
        book2.description = "test2";
        book2.imageUrl =
            "https://images.unsplash.com/photo-1592496431122-2349e0fbc666?q=80&w=1212&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";

        var book3 = Book();
        book3.title = "How Innovation Works";
        book3.author = "Matt Riddley";
        book3.description = "test3";
        book3.imageUrl =
            "https://images.unsplash.com/photo-1589829085413-56de8ae18c73?q=80&w=1212&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";

        books = listOf(book, book2, book3);
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EbookTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                    TopAppBar(
                        title = { AppBarCustom() }
                    )
                }) { innerPadding ->
                    Column {
                        Column(modifier = Modifier.padding(innerPadding)) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Text("Recommendation", style = MaterialTheme.typography.titleMedium)
                                Spacer(modifier = Modifier.width(8.dp))
                                EbookListScreen(books, onBookClick = {})
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
@Preview(backgroundColor = 0xFFF0EAE2, showBackground = true)
fun AppBarCustom(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(end = 8.dp).fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text("Discover", style = MaterialTheme.typography.titleLarge)
        Icon(
            imageVector = Icons.Filled.Notifications,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun EbookListScreen(book: List<Book>, onBookClick: (Book) -> Unit) {
    LazyRow {
        items(book.size) { i ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onBookClick(book[i]) }
            ) {
                Box {
                    BookPoster(
                        title = book[i].title,
                        author = book[i].author,
                        imageUrl = book[i].imageUrl
                    )
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(4.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(color = androidx.compose.ui.graphics.Color(Color.WHITE))
                            .padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Icon(
                            imageVector = Icons.Filled.Star,
                            contentDescription = null,
                            tint = androidx.compose.ui.graphics.Color(Color.YELLOW),
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            "4.5",
                            color = androidx.compose.ui.graphics.Color.Black,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    var books = listOf<Book>();

    var book = Book();
    book.title = "Milk & Honey";
    book.author = "Rupi Kaur";
    book.description = "test";
    book.imageUrl =
        "https://images.unsplash.com/photo-1544947950-fa07a98d237f?q=80&w=687&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";

    var book2 = Book();
    book2.title = "Psychology Of Money";
    book2.author = "Morgan Housel";
    book2.description = "test2";
    book2.imageUrl =
        "https://images.unsplash.com/photo-1592496431122-2349e0fbc666?q=80&w=1212&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";

    var book3 = Book();
    book3.title = "How Innovation Works";
    book3.author = "Matt Riddley";
    book3.description = "test3";
    book3.imageUrl =
        "https://images.unsplash.com/photo-1589829085413-56de8ae18c73?q=80&w=1212&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";

    books = listOf(book, book2, book3);

    EbookTheme {
        EbookListScreen(book = books, onBookClick = {})
    }
}