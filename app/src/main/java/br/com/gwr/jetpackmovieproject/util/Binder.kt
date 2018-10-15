package br.com.gwr.jetpackmovieproject.util

import com.squareup.picasso.Picasso
import android.databinding.BindingAdapter
import android.widget.ImageView
import br.com.gwr.jetpackmovieproject.domain.remote.ApiConstants


@BindingAdapter("app:urlImagem")
fun loadImage(view: ImageView, url: String?) {
    var url2 = url
    url2 = if (url2 == null || url2.isEmpty())
        "http://www.physiotherapyns.ca/images/default_news.png"
    else
        ApiConstants.IMAGE_URL + url2
    Picasso.get().load(url2).fit().into(view)
}