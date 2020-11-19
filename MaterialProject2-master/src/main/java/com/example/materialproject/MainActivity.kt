package com.example.materialproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



     




//glide view for loading image....

        Glide.with(this)

            .load("http://images6.fanpop.com/image/photos/41700000/Cox-s-Bazar-Bangladesh-bangladesh-41724944-550-321.jpg")
            .override(300, 200)
            .into(ma_Image_View);




        //camera button
        ma_camera_button.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }





















        //email set up.............



        ma_email_button.setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: Example@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL, "test")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello World")

            startActivity(intent)

        }


        //listview set up.........

        val values = arrayOf("One", "Two", "Three", "Four", "Five")
        val mListView = findViewById<ListView>(R.id.ma_listview_id)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)
        mListView.adapter = adapter


        mListView.setOnItemClickListener { parent, view, position, id ->

            //Toast.makeText(this@MainActivity, "You have Clicked " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show()

            if (position == 0) {
                Toast.makeText(this@MainActivity, "One (odd)", Toast.LENGTH_SHORT).show()
            }
            if (position == 1) {
                Toast.makeText(this@MainActivity, "Two (even)", Toast.LENGTH_SHORT).show()
            }
            if (position == 2) {
                Toast.makeText(this@MainActivity, "Three (odd)", Toast.LENGTH_SHORT).show()
            }
            if (position == 3) {
                Toast.makeText(this@MainActivity, "Four (even)", Toast.LENGTH_SHORT).show()
            }
            if (position == 4) {
                Toast.makeText(this@MainActivity, "Five (odd)", Toast.LENGTH_SHORT).show()
            }

        }


        }

        fun call(view: View) {
            val button = Intent(Intent.ACTION_DIAL)
            button.data = Uri.parse("tel:" + "01858985731")
            startActivity(button)
        }












    }




