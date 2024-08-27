package de.solidblocks.infra.test

import de.solidblocks.infra.test.command.CommandBuilder
import de.solidblocks.infra.test.script.ScriptBuilder
import java.io.Closeable

interface TestContext<C : CommandBuilder, S : ScriptBuilder> : Closeable {

    fun command(vararg command: String): C

    fun script(): S
}