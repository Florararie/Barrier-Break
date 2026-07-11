# Barrier Break

Makes `minecraft:barrier` instantly breakable in survival, by hand or with any tool.

## Why

Barrier is normally hardness `-1` (flatly unbreakable in survival, same category as bedrock). This
mod overrides just that one block's hardness to `0` (instant break) via a mixin into
`BlockBehaviour.Properties#setId`, leaving its blast resistance untouched so it still won't get
blown up by accident. It's meant as an invisible, solid, but player-removable collision block for
things like model-entity builds, without fighting other mods (looking at you Polymer) for a vanilla-block disguise slot

For more context when specifically using Polymer, Polymer Patch Bundle, Terrestria- and a neat datapack called Bubblellaneous- a pretty frustrating issue arises. Bubblellaneous uses `minecraft:petrified_oak_slab` as their collision marker for entities leveraging a resource pack to make it invisible. However a quirk with Polymer is that the slab's half slabs stay visible while only doubles are invisible. This kinda ruins some of the builds. So I instead opted to replace them with barriers and make them breakable so that functionality is retained in survival. 

Built against Fabric for Minecraft 26.1.2, based on the same project layout as
[function-permission-level](https://github.com/Dahesor/function-permission-level).