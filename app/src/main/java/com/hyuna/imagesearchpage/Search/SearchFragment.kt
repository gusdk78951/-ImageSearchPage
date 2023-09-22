package com.hyuna.imagesearchpage.Search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyuna.imagesearchpage.Data.ImageSearch
import com.hyuna.imagesearchpage.Data.NetWorkClient.apiService
import com.hyuna.imagesearchpage.R
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class SearchFragment : Fragment() {
    private val authHeader = "KakaoAk 9cf48add9148d504abfa2fa30717db38"
    private var resultItem: ArrayList<SearchItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    companion object {

    }

    private fun searchImage(query: String) {
        apiService.getImage(authHeader, query, sort = "recency", page = 1, size = 80)
            ?.enqueue(object : Callback<ImageSearch?> {
                override fun onResponse(
                    call: Call<ImageSearch?>, response: Response<ImageSearch?>
                ) {
                    response.body()?.imageSearchMeta?.let { meta ->
                        if (meta.totalCount > 0) {
                            response.body()!!.imageSearchDocuments.forEach { document ->
                                val title = document.displaySitename
                                val datetime = document.datetime
                                val url = document.thumbnailUrl
                                resultItem.add(SearchItem(title, datetime, url))
                            }
                        }
                    }

                }
            })
    }
}