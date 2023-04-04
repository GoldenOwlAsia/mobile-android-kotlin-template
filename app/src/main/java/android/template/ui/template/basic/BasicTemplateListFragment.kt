/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.ui.template.basic

import android.os.Bundle
import android.template.R
import android.template.ui.base.BaseFragment
import android.template.ui.viewmodel.TemplateViewModel
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

@AndroidEntryPoint
class BasicTemplateListFragment: BaseFragment(R.layout.fragment_template_list) {
     val viewModel by viewModels<TemplateViewModel>()
     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
          viewModel.uiState.collectWhenCreated {
               // do sth
          }
     }

}