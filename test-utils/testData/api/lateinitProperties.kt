/*
 * Copyright 2022 Google LLC
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// WITH_RUNTIME
// TEST PROCESSOR: LateinitPropertiesProcessor
// EXPECTED:
// getter, [PRIVATE, FINAL], prop1
// getter, [PRIVATE, FINAL], propSource1
// getter, [PUBLIC, FINAL], prop2
// getter, [PUBLIC, FINAL], prop3
// getter, [PUBLIC, FINAL], propSource2
// getter, [PUBLIC, FINAL], propSource3
// prop1
// prop2
// prop3
// propSource1
// propSource2
// propSource3
// setter, [PRIVATE, FINAL], prop1
// setter, [PRIVATE, FINAL], propSource1
// setter, [PUBLIC, FINAL], prop2
// setter, [PUBLIC, FINAL], prop3
// setter, [PUBLIC, FINAL], propSource2
// setter, [PUBLIC, FINAL], propSource3
// END
// MODULE: lib
// FILE: compiledProperties.kt
package test.compiled

open class Foo {
    lateinit private var prop1: Any
    companion object {
        lateinit var prop2: Any
    }
}

object Bar : Foo() {
    lateinit var prop3: Any
}

// MODULE: main(lib)
// FILE: sourceProperties.kt
package test.source

open class FooSource {
    lateinit private var propSource1: Any
    companion object {
        lateinit var propSource2: Any
    }
}

object BarSource : Foo() {
    lateinit var propSource3: Any
}
