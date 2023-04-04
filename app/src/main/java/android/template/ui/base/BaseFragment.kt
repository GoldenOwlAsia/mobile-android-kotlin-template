/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.ui.base

import android.template.util.collectLatestWhenOwnerStarted
import android.template.util.collectWhenOwnerCreated
import android.template.util.collectWhenOwnerResumed
import android.template.util.collectWhenOwnerStarted
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.Flow

abstract class BaseFragment(resId: Int): Fragment(resId) {
    fun <T> Flow<T>.collectWhenStarted(action: suspend (T) -> Unit) {
        collectWhenOwnerStarted(viewLifecycleOwner, action)
    }

    fun <T> Flow<T>.collectLatestWhenStarted(action: suspend (T) -> Unit) {
        collectLatestWhenOwnerStarted(viewLifecycleOwner, action)
    }

    fun <T> Flow<T>.collectWhenResumed(action: suspend (T) -> Unit) {
        collectWhenOwnerResumed(viewLifecycleOwner, action)
    }

    fun <T> Flow<T>.collectWhenCreated(action: suspend (T) -> Unit) {
        collectWhenOwnerCreated(viewLifecycleOwner, action)
    }
}