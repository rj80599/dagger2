package com.example.mvvmdager2.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.mvvmdager2.models.Product
import com.example.mvvmdager2.viewmodel.MainViewModel

@Composable
fun ProductScreen(mainViewModel: MainViewModel) {
    // Convert LiveData to Compose State
    val products by mainViewModel.productLiveData.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Display list of products
        if (products.isEmpty()) {
            // Show loading state if products are not loaded yet
            Text(
                text = "Loading...",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            ProductList(products = products)
        }
    }
}

@Composable
fun ProductList(products: List<Product>) {
    // Create a scrollable LazyColumn
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(products) { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                Log.d("ProductItem", "Title: ${product.title}")
            }
    ) {
        // Product Title
        Text(
            text = "Title: ${product.title}",
            style = androidx.compose.material3.MaterialTheme.typography.titleMedium
        )

        // Product Price
        Text(
            text = "Price: $${product.price}",
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
        )

        // Product Description
        Text(
            text = "Description: ${product.description}",
            style = androidx.compose.material3.MaterialTheme.typography.bodySmall
        )

        // Product Category
        Text(
            text = "Category: ${product.category}",
            style = androidx.compose.material3.MaterialTheme.typography.labelSmall
        )

        // Product Image (Optional)
        Image(
            painter = rememberAsyncImagePainter(model = product.image),
            contentDescription = product.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(top = 8.dp),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
    }
}


//@Composable
//fun ProductScreen(mainViewModel: MainViewModel) {
//    // Convert LiveData to Compose State
//    val products by mainViewModel.productLiveData.observeAsState(initial = emptyList())
//
//    // Determine UI state based on products
//    val state = if (products.isEmpty()) {
//        "Loading..."
//    } else {
//        products.joinToString { "\n"+it.title }
//    }
//
//    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Text(text = state)
//    }
//}
