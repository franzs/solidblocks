package de.solidblocks.base.lookups

import de.solidblocks.api.resources.infrastructure.IResourceLookupProvider
import de.solidblocks.api.resources.infrastructure.InfrastructureProvisioner

class ResourceLookupProvider<RuntimeType>(private val provisioner: InfrastructureProvisioner) :
    IResourceLookupProvider<ResourceLookup<RuntimeType>, String> {

    override fun lookup(lookup: ResourceLookup<RuntimeType>): de.solidblocks.core.Result<String> {
        return this.provisioner.lookup(lookup.resource).mapResult {
            lookup.call(it as RuntimeType)
        }
    }

    override val lookupType = ResourceLookup::class.java
}
