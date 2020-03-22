package com.zuhlke.nhscovid

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import com.zuhlke.nhscovid.data.model.MainEntityOfPage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_page.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ListDelegationAdapter<List<MainEntityOfPage>>
    val model: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeUpdates()
        loadData()
        setupAdapter()
    }

    private fun loadData() {
        model.loadData()
    }

    private fun observeUpdates() {
        model.entities.observe(this, Observer {
            display(it)
        })
    }

    private fun display(entities: List<MainEntityOfPage>) {
        adapter.items = entities
        adapter.notifyDataSetChanged()
    }

    private fun setupAdapter() {
        adapter = ListDelegationAdapter(
            mainPageAdapterDelegate()
        )

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun mainPageAdapterDelegate() = adapterDelegateLayoutContainer<MainEntityOfPage, MainEntityOfPage>(R.layout.item_page) {
        bind {
            headline.text = item.headline
            headline.isVisible = !item.headline.isNullOrEmpty()
            val itemText = item.text
            if (itemText != null) {
                text.text = HtmlCompat.fromHtml(itemText, HtmlCompat.FROM_HTML_MODE_LEGACY)
                text.movementMethod = LinkMovementMethod.getInstance()
            } else {
                text.text = ""
            }
        }
    }
}
