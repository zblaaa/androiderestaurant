package fr.isen.alexander_rougier.androiderestaurant

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.isen.alexander_rougier.androiderestaurant.ui.theme.AndroidERestaurantTheme

class PlatsActivity : AppCompatActivity() {

    private lateinit var textCategory: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.)

        // Récupérer le nom de la catégorie passé en argument
        val category = intent.getStringExtra("category")

        // Initialiser la vue de titre avec le nom de la catégorie
        //textCategory = findViewById(R.id.textCategory)
        textCategory.text = category ?: "Catégorie non spécifiée"
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AndroidERestaurantTheme {
        Greeting2("Android")
    }
}