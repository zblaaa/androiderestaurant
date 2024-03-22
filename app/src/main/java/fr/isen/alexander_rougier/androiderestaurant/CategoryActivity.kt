package fr.isen.alexander_rougier.androiderestaurant

//import coil.compose.AsyncImage
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.alexander_rougier.androiderestaurant.model.DataResult
import fr.isen.alexander_rougier.androiderestaurant.model.Items
import fr.isen.alexander_rougier.androiderestaurant.ui.theme.AndroidERestaurantTheme
import org.json.JSONObject

class CategoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val category = intent.getStringExtra("category") ?: ""

        val fakeDishes = when {
            category == getString(R.string.home_starters) -> resources.getStringArray(R.array.fake_starters)
            category == getString(R.string.home_dish) -> resources.getStringArray(R.array.fake_dish)
            category == getString(R.string.home_desserts) -> resources.getStringArray(R.array.fake_desserts)
            else -> resources.getStringArray(R.array.fake_dish)
        }

        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val itemToDisplay = remember {
                        mutableStateListOf<Items>()
                    }
                    fetchData(category, itemToDisplay)
                    CategoryComponent(category, itemToDisplay) {
                        onDishClicked(it)
                    }
                }
            }
        }
    }

    private fun onDishClicked(dish: Items) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("dish", dish)
        startActivity(intent)
    }

    private fun fetchData(category: String, items: MutableList<Items>) {
        val url = "http://test.api.catering.bluecodegames.com/menu"
        val param = JSONObject()
        param.put("id_shop", "1")
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.POST, url, param,
            { response ->
                val result = Gson().fromJson(response.toString(), DataResult::class.java)
                val dishesFromCategory =
                    result.data.find { it.nameFr == category }?.items ?: emptyList()
                items.addAll(dishesFromCategory)
                Log.d("CategoryActivity", "result : $response")
            },
            { error ->
                Log.d("CategoryActivity", "result : $error")
            }
        )
        Volley.newRequestQueue(this).add(jsonObjectRequest)
    }
}

@Composable
fun CategoryComponent(category: String, dishes: List<Items>, onDishClicked: (Items)->Unit) {
    Column {
        Text(
            text = "Hello $category",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(32.dp)
                .fillMaxWidth()
        )
        LazyColumn(Modifier.padding(24.dp)) {
            items(dishes) {
                Text(
                    text = "",
                    Modifier.padding(0.dp, 8.dp)
                        .clickable { onDishClicked(it) }
                )
            }
        }
        AsyncImage(
            model = "https://example.com/image.jpg",
            contentDescription = null,
        )
    }
}

@Composable
fun AsyncImage(model: String, contentDescription: Nothing?) {
    //TODO("Not yet implemented")
}
