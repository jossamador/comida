package com.example.comida

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage

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

        // Restaurantes Populares
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
                modifier = Modifier.size(80.dp),
                loading = {
                    Box(modifier = Modifier
                        .size(80.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant))
                },
                failure = {
                    Box(modifier = Modifier
                        .size(80.dp)
                        .background(MaterialTheme.colorScheme.errorContainer))
                }
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
                modifier = Modifier.size(100.dp),
                loading = {
                    Box(modifier = Modifier
                        .size(100.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant))
                },
                failure = {
                    Box(modifier = Modifier
                        .size(100.dp)
                        .background(MaterialTheme.colorScheme.errorContainer))
                }
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
                modifier = Modifier.size(120.dp),
                loading = {
                    Box(modifier = Modifier
                        .size(120.dp)
                        .background(MaterialTheme.colorScheme.surfaceVariant))
                },
                failure = {
                    Box(modifier = Modifier
                        .size(120.dp)
                        .background(MaterialTheme.colorScheme.errorContainer))
                }
            )
            Text(food.name, style = MaterialTheme.typography.bodyMedium)
            Text("Rating: ${food.rating}", style = MaterialTheme.typography.bodySmall)
            Text("${food.price} $", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

fun getCategories() = listOf(
    Category("Fast Food", "https://images.unsplash.com/photo-1655195672440-c8c62902a05c?q=80&w=2671&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"), // Hamburguesa
    Category("Chinese", "https://images.unsplash.com/photo-1563245372-f21724e3856d?q=80&w=2762&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"), // Comida china
    Category("Italian", "https://images.unsplash.com/photo-1609582848349-215e8bf397d3?q=80&w=2787&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"), // Pasta italiana
    Category("Mexican", "https://images.unsplash.com/photo-1628394029816-1dc524670f60?q=80&w=2391&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"), // Tacos mexicanos
    Category("Japanese", "https://images.unsplash.com/photo-1602273660127-a0000560a4c1?q=80&w=2385&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")  // Sushi japonés
)

fun getRestaurants() = listOf(
    Restaurant("Burger King", "https://images.unsplash.com/photo-1703424575944-3f8dd76c8ca9?q=80&w=2787&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"), // Hamburguesa
    Restaurant("McDonald's", "https://images.unsplash.com/photo-1619881589316-56c7f9e6b587?q=80&w=2748&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"), // Logotipo o comida
    Restaurant("KFC", "https://images.unsplash.com/photo-1513639776629-7b61b0ac49cb?q=80&w=2667&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"), // Pollo frito
    Restaurant("Pizza Hut", "https://images.unsplash.com/photo-1590133728822-cc311f9c280f?q=80&w=2670&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"), // Pizza
    Restaurant("Subway", "https://images.unsplash.com/photo-1705895362931-7f522d0bfbed?q=80&w=2680&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")  // Sándwich
)

fun getRecommendedFoods() = listOf(
    Food("Hamburger", "https://images.unsplash.com/photo-1610970878459-a0e464d7592b?q=80&w=2724&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 4.5f, 5.99),
    Food("Pizza", "https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?q=80&w=2676&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 4.8f, 8.99),
    Food("Fried Chicken", "https://plus.unsplash.com/premium_photo-1683139918895-06f8f3b9939e?q=80&w=2787&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 4.3f, 6.99),
    Food("Sushi", "https://images.unsplash.com/photo-1579584425555-c3ce17fd4351?q=80&w=2270&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 4.7f, 12.99),
    Food("Tacos", "https://images.unsplash.com/photo-1599974579688-8dbdd335c77f?q=80&w=2694&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 4.6f, 4.99)
)