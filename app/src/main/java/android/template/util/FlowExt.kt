/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.util

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * The given flow is only collected when the [owner] is in the
 * [Lifecycle.State.STARTED].
 *
 * As soon as the [owner] leaves that state, the flow collection
 * is cancelled. It will restart if it returns to that state.
 *
 * Note: This is the exact same behaviour as a LiveData observer
 * has it.
 */
inline fun <T> Flow<T>.collectWhenOwnerStarted(
    owner: LifecycleOwner,
    crossinline action: suspend (T) -> Unit
) {
    owner.lifecycleScope.launch {
        owner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            collect {
                action(it)
            }
        }
    }
}

inline fun <T> Flow<T>.collectLatestWhenOwnerStarted(
    owner: LifecycleOwner,
    crossinline action: suspend (T) -> Unit
) {
    owner.lifecycleScope.launch {
        owner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            collectLatest {
                action(it)
            }
        }
    }
}

/**
 * The given flow is only collected when the [owner] is in the
 * [Lifecycle.State.RESUMED].
 *
 * As soon as the [owner] leaves that state, the flow collection
 * is cancelled. It will restart if it returns to that state.
 */
inline fun <T> Flow<T>.collectWhenOwnerResumed(
    owner: LifecycleOwner,
    crossinline action: suspend (T) -> Unit
) {
    owner.lifecycleScope.launch {
        owner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            collect {
                action(it)
            }
        }
    }
}

/**
 * The given flow is only collected when the [owner] is in the
 * [Lifecycle.State.CREATED].
 *
 * As soon as the [owner] leaves that state, the flow collection
 * is cancelled. It will restart if it returns to that state.
 */
inline fun <T> Flow<T>.collectWhenOwnerCreated(
    owner: LifecycleOwner,
    crossinline action: suspend (T) -> Unit
) {
    owner.lifecycleScope.launch {
        owner.repeatOnLifecycle(Lifecycle.State.CREATED) {
            collect {
                action(it)
            }
        }
    }
}