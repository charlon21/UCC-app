package com.example.majorproject

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webView = findViewById<WebView>(R.id.webview)
        val url = intent.getStringExtra("URL") ?: "https://www.google.com"

        // Configure WebView settings
        webView.webViewClient = WebViewClient() // Ensures links open in the WebView instead of a browser
        webView.settings.javaScriptEnabled = true // Enable JavaScript if needed

        // Load the URL passed from MainActivity
        webView.loadUrl(url)
    }
}
