package xar.mvvm.xarlib

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class XarActivity<DB : ViewDataBinding, VM : XarViewModel>(@LayoutRes val resLayoutID: Int) : AppCompatActivity(
    resLayoutID
) {

    lateinit var mBinding:DB
    abstract val mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, resLayoutID)
        mBinding.lifecycleOwner = this
        setContentView(mBinding.root)
    }

    fun addFragment(frameContainer: Int, fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .add(frameContainer,fragment,fragment.javaClass.canonicalName)
            .commit()
    }

    fun replaceFragment(frameContainer: Int, fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(frameContainer, fragment, fragment.javaClass.canonicalName)
            .commit()
    }
}