package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModBlocks;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;
import net.mcreator.jujutsucraft.procedures.PlayAnimationEntityGuardProcedure;
import net.mcreator.jujutsucraftaddon.entity.PartialRikaEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import software.bernie.geckolib.animatable.GeoEntity;

@Mixin(value = PlayAnimationEntityGuardProcedure.class, priority = -10000)
public abstract class PlayAnimationEntityGuardMixin {

    /**
     * @author Satushi
     * @reason Changes playing Animations
     */

    @Inject(at = @At("HEAD"), method = "execute", remap = false, cancellable = true)
    private static void execute(Entity entityiterator, CallbackInfo ci) {
        ci.cancel();

        if (entityiterator != null) {
            Entity entity_a = null;
            entity_a = entityiterator;
            if (entity_a instanceof LivingEntity) {
                LivingEntity _livEnt0 = (LivingEntity)entity_a;
                if (_livEnt0.hasEffect((MobEffect) JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                    return;
                }
            }

            if (entity_a.getPersistentData().getDouble("skill") == 0.0) {
                LivingEntity _entGetArmor;
                if (entity_a instanceof Player) {
                    ItemStack var10000;
                    if (entity_a instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity_a;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                        Entity _entity = entity_a;
                        if (_entity instanceof Player) {
                            Player _player = (Player)_entity;
                            _player.getInventory().armor.set(3, new ItemStack((ItemLike) JujutsucraftModBlocks.IN_BARRIER.get()));
                            _player.getInventory().setChanged();
                        } else if (_entity instanceof LivingEntity) {
                            LivingEntity _living = (LivingEntity)_entity;
                            _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModBlocks.IN_BARRIER.get()));
                        }
                    }

                    if (entity_a instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity_a;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    var10000.getOrCreateTag().putDouble("P_ANIME1", -9.0);
                    if (entity_a instanceof LivingEntity) {
                        _entGetArmor = (LivingEntity)entity_a;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    var10000.getOrCreateTag().putDouble("P_ANIME2", 0.0);
                } else if (entity_a instanceof GeoEntity) {
                    if (entity_a instanceof PandaNormalEntity) {
                        ((PandaNormalEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof PandaGorillaEntity) {
                        ((PandaGorillaEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof TodoAoiEntity) {
                        ((TodoAoiEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof ZeninChojuroEntity) {
                        ((ZeninChojuroEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof UroTakakoEntity) {
                        ((UroTakakoEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof MiguelDancerEntity) {
                        ((MiguelDancerEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade21Entity) {
                        ((CursedSpiritGrade21Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade22Entity) {
                        ((CursedSpiritGrade22Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade24Entity) {
                        ((CursedSpiritGrade24Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade25Entity) {
                        ((CursedSpiritGrade25Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade26Entity) {
                        ((CursedSpiritGrade26Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade27Entity) {
                        ((CursedSpiritGrade27Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade28Entity) {
                        ((CursedSpiritGrade28Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade29Entity) {
                        ((CursedSpiritGrade29Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade210Entity) {
                        ((CursedSpiritGrade210Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade211Entity) {
                        ((CursedSpiritGrade211Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade212Entity) {
                        ((CursedSpiritGrade212Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade15Entity) {
                        ((CursedSpiritGrade15Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade16Entity) {
                        ((CursedSpiritGrade16Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade17Entity) {
                        ((CursedSpiritGrade17Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade18Entity) {
                        ((CursedSpiritGrade18Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade02Entity) {
                        ((CursedSpiritGrade02Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade03Entity) {
                        ((CursedSpiritGrade03Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade05Entity) {
                        ((CursedSpiritGrade05Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade06Entity) {
                        ((CursedSpiritGrade06Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade07Entity) {
                        ((CursedSpiritGrade07Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade08Entity) {
                        ((CursedSpiritGrade08Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof CursedSpiritGrade09Entity) {
                        ((CursedSpiritGrade09Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof Dagon2Entity) {
                        ((Dagon2Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof JogoEntity) {
                        ((JogoEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof MergedBeastAgitoEntity) {
                        ((MergedBeastAgitoEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof MoonDregsEntity) {
                        ((MoonDregsEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
                        ((EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)entity_a).setAnimation("sword_to_right");
                    }

                    if (entity_a instanceof ShikigamiHeterocephalusGlaberEntity) {
                        ((ShikigamiHeterocephalusGlaberEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof RikaEntity) {
                        ((RikaEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof Rika2Entity) {
                        ((Rika2Entity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof PartialRikaEntity) {
                        ((PartialRikaEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof RozetsuEntity) {
                        ((RozetsuEntity)entity_a).setAnimation("guard");
                    }

                    if (entity_a instanceof Doll1Entity) {
                        ((Doll1Entity)entity_a).setAnimation("guard");
                    }
                } else if (entity_a instanceof LivingEntity) {
                    _entGetArmor = (LivingEntity)entity_a;
                    _entGetArmor.swing(InteractionHand.MAIN_HAND, true);
                }
            }

        }
    }
}
