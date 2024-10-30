package net.mcreator.jujutsucraftaddon.mixins;

import net.mcreator.jujutsucraft.entity.*;
import net.mcreator.jujutsucraft.init.JujutsucraftModAttributes;
import net.mcreator.jujutsucraft.procedures.PlayAnimationEntityProcedure;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import software.bernie.geckolib.animatable.GeoEntity;

import java.util.Objects;

@Mixin(value = PlayAnimationEntityProcedure.class, remap = false)
public abstract class AIRikaNewMixin {
    public AIRikaNewMixin() {

    }

    /**
     * @author Sat
     * @reason Changes
     */
    @Overwrite
    public static void execute(Entity entity) {
        if (entity != null) {
            boolean sword = false;
            double NUM2 = 0.0;
            double NUM3 = 0.0;
            double rnd = 0.0;
            double NUM1 = 0.0;
            String STR1 = "";
            String ANIME_NAME = "";
            Entity entiry_a = null;
            if (entity instanceof GeoEntity) {
                NUM1 = ((LivingEntity)entity).getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION1.get()).getBaseValue();
                NUM2 = ((LivingEntity)entity).getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION2.get()).getBaseValue();
                if (NUM1 <= -50.0 && NUM1 >= -100.0) {
                    NUM1 += 100.0;
                }

                NUM3 = NUM1 >= 0.0 ? NUM1 % 100.0 : 100.0;
                STR1 = Math.random() > 0.5 ? "right" : "left";
                ANIME_NAME = "";
                if (NUM3 >= 0.0 && NUM3 <= 4.0) {
                    ItemStack var10000;
                    if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    LivingEntity _livEnt;
                    boolean var18;
                    label324: {
                        if (!(var10000.getItem() instanceof SwordItem)) {
                            if (entity instanceof LivingEntity) {
                                _livEnt = (LivingEntity) entity;
                                var10000 = _livEnt.getMainHandItem();
                            } else {
                                var10000 = ItemStack.EMPTY;
                            }

                            if (!(var10000.getItem() instanceof AxeItem)) {
                                if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity) entity;
                                    var10000 = _livEnt.getMainHandItem();
                                } else {
                                    var10000 = ItemStack.EMPTY;
                                }

                                if (!var10000.is(ItemTags.create(new ResourceLocation("forge:metallic")))) {
                                    if (entity instanceof LivingEntity) {
                                        _livEnt = (LivingEntity)entity;
                                        var10000 = _livEnt.getMainHandItem();
                                    } else {
                                        var10000 = ItemStack.EMPTY;
                                    }

                                    if (!var10000.is(ItemTags.create(new ResourceLocation("forge:sword")))) {
                                        if (entity instanceof LivingEntity) {
                                            _livEnt = (LivingEntity)entity;
                                            var10000 = _livEnt.getMainHandItem();
                                        } else {
                                            var10000 = ItemStack.EMPTY;
                                        }

                                        if (!var10000.is(ItemTags.create(new ResourceLocation("forge:whip")))) {
                                            var18 = false;
                                            break label324;
                                        }
                                    }
                                }
                            }
                        }

                        var18 = true;
                    }

                    sword = var18;
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                    } else {
                        var10000 = ItemStack.EMPTY;
                    }

                    Item var19 = var10000.getItem();
                    ItemStack var10001;
                    if (entity instanceof LivingEntity) {
                        _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getOffhandItem();
                    } else {
                        var10001 = ItemStack.EMPTY;
                    }

                    if (var19 == var10001.getItem()) {
                        sword = false;
                    }

                    if (NUM2 != 0.0 && !(NUM2 >= 100.0)) {
                        if (sword) {
                            ANIME_NAME = "sword_to_" + STR1;
                        } else {
                            ANIME_NAME = "punch_" + STR1;
                        }
                    } else if (sword) {
                        ANIME_NAME = "sword_to_" + STR1;
                    } else {
                        String var20 = Math.random() > 0.25 ? "kick_" : "punch_";
                        ANIME_NAME = var20 + STR1;
                    }
                } else if (NUM3 == 20.0) {
                    ANIME_NAME = "domain_expansion1";
                } else if (NUM1 >= -5.0) {
                    if (NUM1 == -1.0) {
                        ANIME_NAME = "backstep";
                    } else if (NUM1 == -2.0) {
                        ANIME_NAME = "death";
                    } else if (NUM1 == -3.0) {
                        ANIME_NAME = "right_arm_up";
                    } else if (NUM1 == -4.0) {
                        ANIME_NAME = "both_arm_front";
                    } else if (NUM1 == -5.0) {
                        ANIME_NAME = "sword_to_right";
                    }
                } else if (NUM1 >= -10.0) {
                    if (NUM1 == -6.0) {
                        ANIME_NAME = "kick_" + STR1;
                    } else if (NUM1 == -7.0) {
                        ANIME_NAME = "punch_" + STR1;
                    } else if (NUM1 == -8.0) {
                        if (NUM2 == 0.0) {
                            ANIME_NAME = "sword_overhead";
                        } else {
                            ANIME_NAME = "rotation2";
                        }
                    }
                } else if (NUM1 >= -15.0) {
                    ANIME_NAME = "dance" + Math.round(NUM1 + 16.0);
                } else if (NUM1 >= -20.0) {
                    if (NUM1 == -16.0) {
                        ANIME_NAME = NUM2 == 0.0 ? "simple_domain1" : "simple_domain2";
                    } else if (NUM1 == -17.0) {
                        ANIME_NAME = "clap";
                    } else if (NUM1 == -18.0) {
                        ANIME_NAME = "fly";
                    }
                } else if (NUM1 == 406.0) {
                    ANIME_NAME = "burn_out";
                } else if (NUM1 == 415.0) {
                    ANIME_NAME = "meteor";
                }

                if (!ANIME_NAME.isEmpty()) {
                    if (entity instanceof PandaNormalEntity) {
                        ((PandaNormalEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof PandaGorillaEntity) {
                        ((PandaGorillaEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof TodoAoiEntity) {
                        ((TodoAoiEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof ZeninChojuroEntity) {
                        ((ZeninChojuroEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof UroTakakoEntity) {
                        ((UroTakakoEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof MiguelDancerEntity) {
                        ((MiguelDancerEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade21Entity) {
                        ((CursedSpiritGrade21Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade22Entity) {
                        ((CursedSpiritGrade22Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade24Entity) {
                        ((CursedSpiritGrade24Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade25Entity) {
                        ((CursedSpiritGrade25Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade26Entity) {
                        ((CursedSpiritGrade26Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade27Entity) {
                        ((CursedSpiritGrade27Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade28Entity) {
                        ((CursedSpiritGrade28Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade29Entity) {
                        ((CursedSpiritGrade29Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade210Entity) {
                        ((CursedSpiritGrade210Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade211Entity) {
                        ((CursedSpiritGrade211Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade212Entity) {
                        ((CursedSpiritGrade212Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade213Entity) {
                        ((CursedSpiritGrade213Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade214Entity) {
                        ((CursedSpiritGrade214Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade215Entity) {
                        ((CursedSpiritGrade215Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade15Entity) {
                        ((CursedSpiritGrade15Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade16Entity) {
                        ((CursedSpiritGrade16Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade17Entity) {
                        ((CursedSpiritGrade17Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade18Entity) {
                        ((CursedSpiritGrade18Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade02Entity) {
                        ((CursedSpiritGrade02Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade03Entity) {
                        ((CursedSpiritGrade03Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade05Entity) {
                        ((CursedSpiritGrade05Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade06Entity) {
                        ((CursedSpiritGrade06Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade07Entity) {
                        ((CursedSpiritGrade07Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade08Entity) {
                        ((CursedSpiritGrade08Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof CursedSpiritGrade09Entity) {
                        ((CursedSpiritGrade09Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof Dagon2Entity) {
                        ((Dagon2Entity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof JogoEntity) {
                        ((JogoEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof TakadaEntity) {
                        ((TakadaEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof MergedBeastAgitoEntity) {
                        ((MergedBeastAgitoEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof MoonDregsEntity) {
                        ((MoonDregsEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity) {
                        ((EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof ShikigamiHeterocephalusGlaberEntity) {
                        ((ShikigamiHeterocephalusGlaberEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof RikaEntity) {
                        if (entity.getPersistentData().getBoolean("Final") == true) {
                            ((RikaEntity) entity).setAnimation(ANIME_NAME + "2");
                        } else {
                            ((RikaEntity) entity).setAnimation(ANIME_NAME);
                        }
                    }

                    if (entity instanceof Rika2Entity) {
                        if (entity.getPersistentData().getBoolean("Final") == true) {
                            ((Rika2Entity) entity).setAnimation(ANIME_NAME + "2");
                        } else {
                            ((Rika2Entity) entity).setAnimation(ANIME_NAME);
                        }
                    }
                    if (entity instanceof RozetsuEntity) {
                        ((RozetsuEntity)entity).setAnimation(ANIME_NAME);
                    }

                    if (entity instanceof Doll1Entity) {
                        ((Doll1Entity)entity).setAnimation(ANIME_NAME);
                    }
                }

                Objects.requireNonNull(((LivingEntity) entity).getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION1.get())).setBaseValue(0.0);
                Objects.requireNonNull(((LivingEntity) entity).getAttribute((Attribute) JujutsucraftModAttributes.ANIMATION2.get())).setBaseValue(0.0);
            }

        }
    }
}
