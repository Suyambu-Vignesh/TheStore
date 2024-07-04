package com.app.thestore.utils.flow

interface FlowObserver<T> {
    /**
     * Help to finish the Flow
     *
     * @return [FlowObserver]
     */
    fun finish(): FlowObserver<T>

    /**
     * Call the argument function with provided funcation
     *
     * @param function
     *
     * @return [FlowObserver]
     */
    fun assert(function: (List<T>) -> Unit): FlowObserver<T>

    /**
     * Will assert the size of the collected values with the input
     *
     * @return [FlowObserver]
     */
    fun assertSize(size: Int): FlowObserver<T>
}
