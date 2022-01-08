package de.solidblocks.base.lookups

import de.solidblocks.api.resources.infrastructure.IResourceLookupProvider
import de.solidblocks.core.Result

class ConstantResourceLookupProvider : IResourceLookupProvider<ConstantDataSource, String> {

    override fun lookup(datasource: ConstantDataSource): Result<String> {
        return Result(datasource.content)
    }

    override val lookupType = ConstantDataSource::class.java
}
