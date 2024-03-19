package fr.isen.alexander_rougier.androiderestaurant

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.alexander_rougier.androiderestaurant.ui.theme.AndroidERestaurantTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidERestaurantTheme {
                // A surface container using the 'background' color from the theme
                AndroidERestaurantTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        //color = MaterialTheme.colorScheme.background
                    ) {
                        texteBienvenueEntrePlatsDessert(name = "John Doe")
                    }
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
}



@Composable
fun texteBienvenueEntrePlatsDessert(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.weight(1f)
            ) {
                Spacer(modifier = Modifier.height(16.dp)) // Espace sous la barre d'action
                Text(
                    text = "\nBienvenue\nchez",
                    color = Color(0xFFF44336), // couleur du texte
                    fontSize = 30.sp, // taille du texte
                    textAlign = TextAlign.End, // alignement du texte
                    modifier = Modifier.padding(horizontal = 16.dp) // Marge horizontale
                )
                Text(
                    text = "DroidRestaurant",
                    color = Color(0xFF804000),
                    fontSize = 34.sp, // taille du texte
                    textAlign = TextAlign.End,
                    fontFamily = FontFamily(Font(R.font.magicsparkle)),
                    // alignement du texte
                    modifier = Modifier.padding(horizontal = 16.dp) // Marge horizontale
                )

            }
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = "Description de l'image",
                modifier = Modifier.size(135.dp) // Modifier la taille de l'image selon vos besoins
                .padding(top = 16.dp, bottom = 16.dp) // Marge horizontale
            )
        }

        Text(
            text = "Entrées",
            color = Color(0xFFF44336),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp) // Marge verticale
                .padding(vertical = 8.dp)
                .fillMaxWidth() // Remplir la largeur de la ligne
                .clickable {
                    Toast
                        .makeText(
                            context,
                            "Vous avez cliqué sur Entrées",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }


        )

        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .padding(start = 50.dp, end = 50.dp) // Ajouter des marges à gauche et à droite
        )

        Text(
            text = "Plats",
            color = Color(0xFFF44336),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp) // Marge verticale
                .padding(vertical = 8.dp)
                .fillMaxWidth() // Remplir la largeur de la ligne
                .clickable {
                    Toast
                        .makeText(
                            context,
                            "Vous avez cliqué sur Plats",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
        )

            Divider(
                color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
                    .padding(start = 50.dp, end = 50.dp) // Ajouter des marges à gauche et à droite
            )

        Text(
            text = "Desserts",
            color = Color(0xFFF44336),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp) // Marge verticale
                .padding(vertical = 8.dp)
                .fillMaxWidth() // Remplir la largeur de la ligne
                .clickable {
                    Toast
                        .makeText(
                            context,
                            "Vous avez cliqué sur Desserts",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
        )
    }
}

