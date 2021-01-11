package com.badmitry.testwebview

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient


class SimpleWebViewClientImpl(activity: Activity) : WebViewClient() {
    private var activity: Activity? = null

    init {
        this.activity = activity
    }

    override fun shouldOverrideUrlLoading(webView: WebView?, url: String): Boolean {
        // все ссылки, в которых содержится 'javadevblog.com'
        // будут открываться внутри приложения
        if (url.contains("yandex.ru")) {
            return false
        }
        // все остальные ссылки будут спрашивать какой браузер открывать
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        activity?.startActivity(intent)
        return true
    }
}
