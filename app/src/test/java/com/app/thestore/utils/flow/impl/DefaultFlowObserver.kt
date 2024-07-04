package com.app.thestore.utils.flow.impl

import com.app.thestore.utils.flow.FlowObserver
import com.google.common.truth.Truth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DefaultFlowObserver<T>(
    private val flow: Flow<T>,
    private val scope: CoroutineScope,
) : FlowObserver<T> {
    private val values: MutableList<T> by lazy { ArrayList() }

    private val job =
        scope.launch {
            flow.collect {
                values.add(it)
            }
        }

    override fun finish(): FlowObserver<T> {
        job.cancel()
        return this
    }

    override fun assertSize(size: Int): FlowObserver<T> {
        Truth.assertThat(values.size).isEqualTo(size)
        return this
    }

    override fun assert(function: (List<T>) -> Unit): FlowObserver<T> {
        function.invoke(values)
        return this
    }
}

internal fun <T> Flow<T>.test(scope: CoroutineScope): FlowObserver<T> {
    return DefaultFlowObserver(this, scope)
}
