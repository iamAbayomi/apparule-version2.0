package com.cuesoft.io.apparule.views

import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.cuesoft.io.apparule.R
import kotlinx.android.synthetic.main.activity_add_item.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class AddItemActivity : AppCompatActivity() {

    private val PERMISSION_CODE = 1000
    val REQUEST_IMAGE_CAPTURE = 1
    var currentPhotoPath: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        addImageCardView.setOnClickListener{
            dispatchTakePictureIntent()
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED ||
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED) {
                 //permission was not enabled
                 val permission = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                 //show popup to request permission
                 requestPermissions(permission, PERMISSION_CODE)
                }else{
                    dispatchTakePictureIntent()
                }
            }else{
                dispatchTakePictureIntent()
            }
        }
    }


    private fun dispatchTakePictureIntent(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also{takePictureIntent ->
            //Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also{
               //Create the File where te photo should go
                val photoFile: File? = try{
                    createImageFile()
                }catch (ex: IOException){
                    // Error occurred while creating the file
                    null
                }
                //Continue only if the File was successfully created
                photoFile?.also{
                    val photoURI: Uri = FileProvider.getUriForFile(
                            this,
                                "com.cuesoft.io.apparule.fileprovider",
                                it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }


            }
        }
        galleryAddPic()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap
        }
    }

    @Throws(IOException::class)
    fun createImageFile(): File {
        //Create an image file
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /*prefix*/
            ".jpg", /*suffix*/
            storageDir /*directory*/
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }


    }

    fun galleryAddPic(){
        Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).also{ mediaScanIntent ->
            val f = File(currentPhotoPath)
            mediaScanIntent.data = Uri.fromFile(f)
            sendBroadcast(mediaScanIntent)
        }
    }

}
