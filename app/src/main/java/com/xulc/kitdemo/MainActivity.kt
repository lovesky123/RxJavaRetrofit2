package com.xulc.kitdemo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.xulc.kitdemo.base.BaseObserver
import com.xulc.kitdemo.base.BaseResponse
import com.xulc.kitdemo.bean.ArticleData
import com.xulc.kitdemo.network.RetrofitManager
import com.xulc.kitdemo.network.RxSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {
    private val disposable =  CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.setOnClickListener {
            RetrofitManager.getApiService()
                    .getHomeArticles(1)
                    .compose(RxSchedulers.applySchedulers())
                    .subscribe(object :BaseObserver<ArticleData>(disposable) {
                        override fun onFail(tBaseResponse: BaseResponse<ArticleData>?) {
                            Log.e("data","失败--code"+tBaseResponse?.errorCode+tBaseResponse?.errorMsg)
                        }

                        override fun onSuccess(tBaseResponse: BaseResponse<ArticleData>?) {
                            val  data = tBaseResponse?.data
                            Log.e("成功-----data",data.toString())

                        }
                    })

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.clear()//在页面结束后  中断事件序列
    }
}
