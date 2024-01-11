package com.example.fish



import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fish.activity.SigninActivity
import com.example.fish.fragment.AccountFragment
import com.example.fish.fragment.Cart
import com.example.fish.fragment.Favourite
import com.example.fish.fragment.ProductListing
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth
    private lateinit var bottomNav: BottomNavigationView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav= findViewById(R.id.bottom_nav)

        mAuth = FirebaseAuth.getInstance()
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> loadFragment(ProductListing())
                R.id.favourite -> loadFragment(Favourite())
                R.id.cart -> loadFragment(Cart())
                R.id.account-> loadFragment(AccountFragment())
            }
            true
        }

        // Load the initial fragment
        loadFragment(ProductListing())




    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)



        val textView = findViewById<TextView>(R.id.name)

        val auth = Firebase.auth
        val user = auth.currentUser

        if (user != null) {
            val userName = user.displayName
            textView.text = "Welcome, " + userName
        } else {
            // Handle the case where the user is not signed in
        }


// Inside onCreate() method
        val sign_out_button = findViewById<ImageView>(R.id.logout)
        sign_out_button.setOnClickListener {
            signOutAndStartSignInActivity()
        }




    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.Fragment_container, fragment)
            .commit()
    }
    private fun signOutAndStartSignInActivity() {
        mAuth.signOut()

        mGoogleSignInClient.signOut().addOnCompleteListener(this) {
            // Optional: Update UI or show a message to the user
            val intent = Intent(this@MainActivity, SigninActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
