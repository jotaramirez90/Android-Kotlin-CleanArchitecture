package com.jota.sunshine.view.fragment

import com.jota.sunshine.R

class InfoFragment : BaseFragment() {

    override fun getLayoutResource(): Int {
        return R.layout.fragment_info
    }

    companion object {
        fun newInstance(): InfoFragment {
            return InfoFragment()
        }
    }

    override fun initialize() {
    }
}