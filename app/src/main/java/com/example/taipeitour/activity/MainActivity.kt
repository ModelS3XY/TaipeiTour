package com.example.taipeitour.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.taipeitour.R
import com.example.taipeitour.databinding.ActivityMainBinding
import com.example.taipeitour.viewmodel.SpotViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private lateinit var viewModel: SpotViewModel
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val job = Job() + Dispatchers.IO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[SpotViewModel::class.java]

        val navController = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_zh_tw -> {
                viewModel.selectedLang("zh-tw")
                true
            }
            R.id.menu_zh_cn -> {
                viewModel.selectedLang("zh-cn")
                true
            }
            R.id.menu_en -> {
                viewModel.selectedLang("en")
                true
            }
            R.id.menu_ja -> {
                viewModel.selectedLang("ja")
                true
            }
            R.id.menu_ko -> {
                viewModel.selectedLang("ko")
                true
            }
            R.id.menu_es -> {
                viewModel.selectedLang("es")
                true
            }
            R.id.menu_id -> {
                viewModel.selectedLang("id")
                true
            }
            R.id.menu_th -> {
                viewModel.selectedLang("th")
                true
            }
            R.id.menu_vi -> {
                viewModel.selectedLang("vi")
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }
}