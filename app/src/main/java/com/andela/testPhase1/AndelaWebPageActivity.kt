package com.andela.testPhase1

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_andela_web_page.*
import android.net.http.SslError
import android.os.Build
import android.util.Log
import android.webkit.*


class AndelaWebPageActivity : AppCompatActivity() {

    private val ANDELA_HOME_PAGE = "https://andela.com/alc/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_andela_web_page)

        setWebView()

    }

    private fun setWebView(){
        if (Build.VERSION.SDK_INT >= 19) {
            web_view.settings.cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK;
        }

        web_view.settings.allowUniversalAccessFromFileURLs = true
        web_view.settings.javaScriptEnabled = true
        web_view.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        web_view.settings.setAppCacheEnabled(false)
        web_view.settings.domStorageEnabled = true
        web_view.webViewClient = CustomWebViewClient()
        web_view.loadUrl(ANDELA_HOME_PAGE)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
    private inner class CustomWebViewClient : WebViewClient() {

        override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
            handler.proceed() // Ignore SSL certificate errors
        }

    }
}
