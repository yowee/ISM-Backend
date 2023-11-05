package com.mengistu.ism.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.IOException

@Configuration
class FirebaseConfig {

    @Bean
    fun firebaseApp(): FirebaseApp {
        try {
            val options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(this::class.java.getResourceAsStream("/ismm-firebase-adminsdk-oa5vq-0f4870d9d4.json")))
                    .build()
            return FirebaseApp.initializeApp(options)
        } catch (e: IOException) {
            throw RuntimeException("Error initializing Firebase", e)
        }
    }
}
