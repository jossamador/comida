package com.example.comida

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage // Import de Landscapist

@Composable
fun HomeScreen(userName: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header con saludo y botón de logout
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hola, $userName!",
                style = MaterialTheme.typography.headlineMedium
            )
            Button(onClick = { /* Logout logic */ }) {
                Text("Cerrar Sesión")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Categorías
        Text("Categorías", style = MaterialTheme.typography.titleLarge)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(getCategories()) { category ->
                CategoryItem(category)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Restaurantes populares
        Text("Restaurantes Populares", style = MaterialTheme.typography.titleLarge)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(getRestaurants()) { restaurant ->
                RestaurantItem(restaurant)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Comidas recomendadas
        Text("Recomendadas", style = MaterialTheme.typography.titleLarge)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(getRecommendedFoods()) { food ->
                FoodItem(food)
            }
        }
    }
}

@Composable
fun CategoryItem(category: Category) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .padding(4.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            GlideImage(
                imageModel = { category.imageUrl },
                modifier = Modifier.size(80.dp)
            )
            Text(category.name, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun RestaurantItem(restaurant: Restaurant) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .padding(4.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            GlideImage(
                imageModel = { restaurant.imageUrl },
                modifier = Modifier.size(100.dp)
            )
            Text(restaurant.name, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun FoodItem(food: Food) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .padding(4.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            GlideImage(
                imageModel = { food.imageUrl },
                modifier = Modifier.size(120.dp)
            )
            Text(food.name, style = MaterialTheme.typography.bodyMedium)
            Text("Rating: ${food.rating}", style = MaterialTheme.typography.bodySmall)
            Text("${food.price} $", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

fun getCategories() = listOf(
    Category("Fast Food", "https://images.unsplash.com/photo-1550317138-10000687a72b"),
    Category("Chinese", "https://images.unsplash.com/photo-1600585154340-be6161a56a0c"), // Nueva URL
    Category("Italian", "https://images.unsplash.com/photo-1600585154526-990d71b8f166"), // Nueva URL
    Category("Mexican", "https://images.unsplash.com/photo-1600585154527-8a6e2f0f3c9f"), // Nueva URL
    Category("Japanese", "https://images.unsplash.com/photo-1600585154528-8a6e2f0f3c9e")  // Nueva URL
)

fun getRestaurants() = listOf(
    Restaurant("Burger King", "https://images.unsplash.com/photo-1553979459-d2229ba7433b"),
    Restaurant("McDonald's", "https://images.unsplash.com/photo-1600585154340-be6161a56a0c"), // Nueva URL
    Restaurant("KFC", "https://images.unsplash.com/photo-1600585154526-990d71b8f166"), // Nueva URL
    Restaurant("Pizza Hut", "https://images.unsplash.com/photo-1600585154527-8a6e2f0f3c9f"), // Nueva URL
    Restaurant("Subway", "https://images.unsplash.com/photo-1600585154528-8a6e2f0f3c9e")  // Nueva URL
)

fun getRecommendedFoods() = listOf(
    Food("Hamburger", "https://images.unsplash.com/photo-1550317138-10000687a72b", 4.5f, 5.99),
    Food("Pizza", "https://images.unsplash.com/photo-1600585154340-be6161a56a0c", 4.8f, 8.99), // Nueva URL
    Food("Fried Chicken", "https://images.unsplash.com/photo-1600585154526-990d71b8f166", 4.3f, 6.99), // Nueva URL
    Food("Sushi", "https://images.unsplash.com/photo-1600585154527-8a6e2f0f3c9f", 4.7f, 12.99), // Nueva URL
    Food("Tacos", "https://images.unsplash.com/photo-1600585154528-8a6e2f0f3c9e", 4.6f, 4.99)  // Nueva URL
)