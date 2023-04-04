/*
 * Created by: glynn.nguyen.goldenowl@gmail.com
 * Copyright © 2015 - 2023 Golden Owl Consulting
 * Contact us: https://goldenowl.asia/
 */

package android.template.ui.state

abstract class UiState<T>{
    abstract var isLoading: Boolean
    abstract var error: Throwable?
    abstract var data: T
}