package com.example.mvvmdager2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdager2.db.ProductDataBase
import com.example.mvvmdager2.retrofit.ApiInterface
import com.example.mvvmdager2.models.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiInterface: ApiInterface,
    private val productDataBase: ProductDataBase
) {

    private val _productList = MutableLiveData<List<Product>>()

    val product: LiveData<List<Product>>
        get() = _productList

    suspend fun getProducts() {
        val result = apiInterface.getProducts() // getting data from server
        if (result.isSuccessful && result.body() != null) {
            productDataBase.getProductDao().addData(result.body()!!)
            _productList.postValue(result.body())
        }

//        // Fetch data from the local database
//        val localData = withContext(Dispatchers.IO) {
//            productDataBase.getProductDao().getData()
//        }
//        // Update LiveData with the data fetched from the local database
//        _productList.postValue(localData)
    }
}