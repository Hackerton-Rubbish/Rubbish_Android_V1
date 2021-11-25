package com.example.rubbiish_android.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.example.rubbiish_android.R
import java.text.SimpleDateFormat
import java.util.*

class AddPostUserActivity : AppCompatActivity() {
    var pick_photo = 0
    var photouri : Uri? = null
    val addphoto:ImageButton = findViewById(R.id.btn_addphoto)
    var addedphoto:ImageView = findViewById(R.id.added_photo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post_user)

        //open album
        var photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = "image/*"
        startActivityForResult(photoPickerIntent, pick_photo)

        //add photo upload
        addphoto.setOnClickListener {
            contentUpload()

            //addphoto 버튼 사라지게

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == pick_photo){
            if (resultCode == Activity.RESULT_OK){
                //이미지의 경로가 넘어감.
                photouri = data?.data
                addedphoto.setImageURI(photouri)

            }
        } else{
            //취소 버튼을 눌렀을 때 작동.
            finish()
        }
    }

    fun contentUpload() {
        //파일 이름 만들기
        var timestamp = SimpleDateFormat("yyyyMMdd_HHmmSS").format(Date())
        var photo_name = "IMAGE_" + timestamp + "_.png"


    }
}