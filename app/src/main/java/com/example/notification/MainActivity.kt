package com.example.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        binding.apply {

            var id1 = 1
            var id2 = 2

            btnShow.setOnClickListener {
                val builder = NotificationCompat.Builder(this@MainActivity,"1")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Android 10")
                    .setContentText("Bugun 10-gruppadan hamma darsga keldi")

                val notificaion = builder.build()

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    val name = getString(R.string.app_name)
                    val descriptionText = getString(R.string.app_name)
                    val importance = NotificationManager.IMPORTANCE_DEFAULT
                    val channel = NotificationChannel("1",name,importance).apply {
                        description = descriptionText
                    }
                    //Register the channel with the system
                    notificationManager.createNotificationChannel(channel)
                }


                notificationManager.notify(1,notificaion)


                val builder1 = NotificationCompat.Builder(this@MainActivity,"2")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Android 10(2)")
                    .setContentText("Bugun 10-gruppadan hamma darsga keldi 2-note")

                val notificaion1 = builder1.build()

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    val name = getString(R.string.app_name)
                    val descriptionText = getString(R.string.app_name)
                    val importance = NotificationManager.IMPORTANCE_DEFAULT
                    val channel = NotificationChannel("2",name,importance).apply {
                        description = descriptionText
                    }
                    //Register the channel with the system
                    notificationManager.createNotificationChannel(channel)
                }


                notificationManager.notify(2,notificaion1)
            }

            btnHide.setOnClickListener {
                notificationManager.cancel(1)
                notificationManager.cancel(2)
            }
        }
    }
}