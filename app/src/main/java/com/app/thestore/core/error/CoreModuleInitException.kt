package com.app.thestore.core.error

import java.lang.RuntimeException

class CoreModuleInitException(
    moduleName: String
) : RuntimeException("Core Module $moduleName Not Initialized")
