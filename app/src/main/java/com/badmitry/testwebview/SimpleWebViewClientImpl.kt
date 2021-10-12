package com.badmitry.testwebview

import android.app.Activity
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request


class SimpleWebViewClientImpl(activity: Activity) : WebViewClient() {
    private var activity: Activity? = null
    private val TAG = "!!!"

    init {
        this.activity = activity
    }

    override fun shouldOverrideUrlLoading(webView: WebView?, url: String): Boolean {
        Log.d(TAG, "urlLoading: $url")
        webView?.loadUrl(url)
        return false
        // все ссылки, в которых содержится 'javadevblog.com'
        // будут открываться внутри приложения
//        if (url.contains("yandex.ru")) {
//            return false
//        }
//        // все остальные ссылки будут спрашивать какой браузер открывать
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//        activity?.startActivity(intent)
//        return true
    }

//    override fun shouldInterceptRequest(
//        view: WebView?,
//        request: WebResourceRequest?
//    ): WebResourceResponse? {
//        request?.let {
//            Log.d(TAG, "request: ${it.method}, ${it.url}, ${it.requestHeaders}")
//// Create okhttp3 request builder.
//            // Create okhttp3 request builder.
//            var builder: Request.Builder = Request.Builder()
//// Set url.
//// Set url.
//            builder = builder.url(it.url.toString())
//            for (header in it.requestHeaders) {
//                builder.addHeader(header.key, header.value)
//            }
//// Create request object.
//// Create request object.
//            val request: Request = builder.build()
//// Create a new Call object.
//// Create a new Call object.
//            val okHttpClient = OkHttpClient()
//            val call: Call = okHttpClient.newCall(request)
//            try {
//                val response = call.execute()
//                Log.d(
//                    TAG,
//                    "response: ${response.code}, ${response.headers}, ${response.body?.string()}"
//                )
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//        return super.shouldInterceptRequest(view, request)
//    }
}
