package com.bitecode.autobite.screens.wallet.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bitecode.autobite.R
import com.bitecode.autobite.screens.shared.core.User
import com.bitecode.autobite.screens.wallet.core.UiOrder
import com.bitecode.autobite.screens.wallet.core.WalletViewModel
import com.bitecode.autobite.screens.wallet.core.WalletViewModelFactory
import kotlinx.android.synthetic.main.fra_wallet.view.addMoneyBTN
import kotlinx.android.synthetic.main.fra_wallet.view.balanceLBL
import kotlinx.android.synthetic.main.fra_wallet.view.idLBL
import kotlinx.android.synthetic.main.fra_wallet.view.nameLBL

class WalletFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this, WalletViewModelFactory())[WalletViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootPOV = inflater.inflate(R.layout.fra_wallet, container, false)

        rootPOV.addMoneyBTN.setOnClickListener {
            Toast.makeText(context, "Work in progress", Toast.LENGTH_SHORT).show()
        }

        viewModel.orderData.observe(this, Observer { order ->
            when(order) {
                is UiOrder.ShowWorking -> showWorkingState(order.user)
            }
        })

        return rootPOV
    }


    private fun showWorkingState(user: User) {
        view?.let { view ->
            view.nameLBL.text = user.name
            view.idLBL.text = user.id.toString()
            view.balanceLBL.text = "₹${user.balance}"
        }
    }
}