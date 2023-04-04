/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.util

sealed class Async<out T> {
    object Loading : Async<Nothing>()

    data class Error(val throwable: Throwable) : Async<Nothing>()

    data class Success<out T>(val data: T) : Async<T>()
}