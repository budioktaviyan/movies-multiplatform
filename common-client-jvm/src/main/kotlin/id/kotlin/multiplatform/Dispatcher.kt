package id.kotlin.multiplatform

import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.Dispatchers

internal actual val ApplicationDispatcher: CoroutineDispatcher = Dispatchers.Default
internal actual val UIDispatcher: CoroutineDispatcher = Dispatchers.Main