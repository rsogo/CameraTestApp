package jp.co.ncdc.cameratestapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        exifTestButton.setOnClickListener {
            ExifHelper.saveExif("002_20180222170535_OS4.jpg", "new.jpg")
        }
    }

}
