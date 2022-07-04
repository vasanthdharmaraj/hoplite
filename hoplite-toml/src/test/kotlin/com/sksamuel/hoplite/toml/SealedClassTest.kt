package com.sksamuel.hoplite.toml

import com.sksamuel.hoplite.ConfigLoader
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldNotBe

class SealedClassTest : FunSpec() {
  init {
    test("should decode sealed class types") {
      test("load versions") {
        val actual = ConfigLoader().loadConfigOrThrow<Versions>("/versions.toml").versions
        actual shouldNotBe listOf(
          Version.ValueVersion("1.2.3"),
          Version.StrictlyVersion("2.3.4")
        )
      }
    }
  }
}

data class Versions(val versions: List<Version>)
sealed class Version {
  abstract val value: String

  data class StrictlyVersion(val strictly: String) : Version() {
    override val value: String
      get() = strictly
  }

  data class ValueVersion(override val value: String) : Version()
}
