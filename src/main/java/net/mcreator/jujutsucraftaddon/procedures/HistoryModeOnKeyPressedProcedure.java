package net.mcreator.jujutsucraftaddon.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeSukuna7Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeSukuna6Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeSukuna5Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeSukuna4Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeSukuna3Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeSukuna2Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeSukuna1Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeGojo6Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeGojo4Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeGojo3Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeGojo2Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.StoryModeGojo1Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest9Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest8Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest7Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest6Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest5Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest4Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest3Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest2Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest1Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest14Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest13Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest12Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest11Menu;
import net.mcreator.jujutsucraftaddon.world.inventory.Quest10Menu;
import net.mcreator.jujutsucraftaddon.network.JujutsucraftaddonModVariables;
import net.mcreator.jujutsucraftaddon.init.JujutsucraftaddonModGameRules;
import net.mcreator.jujutsucraft.network.JujutsucraftModVariables;
import net.mcreator.jujutsucraft.init.JujutsucraftModMobEffects;

import io.netty.buffer.Unpooled;

public class HistoryModeOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(JujutsucraftaddonModGameRules.JJKU_HISTORY_MODE) == true) {
			if (!entity.isShiftKeyDown()) {
				if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History <= 1) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest1");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 2) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest2");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 3) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest3");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 4) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest4");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest4Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 5) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest5");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest5Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 6) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest6");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest6Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 7) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest7");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest7Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 8) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest8");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest8Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 9) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest9");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest9Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 10) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest10");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest10Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 11) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest11");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest11Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 12) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest12");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest12Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 13) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest13");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest13Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).History == 14) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Quest14");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new Quest14Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 2) {
					if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Gojo")) {
						if (entity instanceof LivingEntity && ((LivingEntity) entity).hasEffect(JujutsucraftModMobEffects.SIX_EYES.get())) {
							if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 0) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StoryModeGojo1");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StoryModeGojo1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 1) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StoryModeGojo2");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StoryModeGojo2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 2) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StoryModeGojo3");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StoryModeGojo3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 3) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StoryModeGojo4");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StoryModeGojo4Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).GH == 4) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StoryModeGojo6");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StoryModeGojo6Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							}
						}
					}
				} else if ((entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 1) {
					if (((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).Clans).equals("Sukuna")) {
						if (entity instanceof ServerPlayer && ((ServerPlayer) entity).level() instanceof ServerLevel
								&& ((ServerPlayer) entity).getAdvancements().getOrStartProgress(((ServerPlayer) entity).server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraft:sukuna_finger_3"))).isDone()) {
							if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 0) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StoryModeSukuna1");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StoryModeSukuna1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 1) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StoryModeSukuna2");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StoryModeSukuna2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 2) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StoryModeSukuna3");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StoryModeSukuna3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 3) {
								if (entity instanceof ServerPlayer _ent) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StoryModeSukuna4");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StoryModeSukuna4Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _bpos);
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 4) {
								if (entity instanceof ServerPlayer _plr30 && _plr30.level() instanceof ServerLevel
										&& _plr30.getAdvancements().getOrStartProgress(_plr30.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:bath_ritual"))).isDone()) {
									if (entity instanceof ServerPlayer _ent) {
										BlockPos _bpos = BlockPos.containing(x, y, z);
										NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
											@Override
											public Component getDisplayName() {
												return Component.literal("StoryModeSukuna5");
											}

											@Override
											public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
												return new StoryModeSukuna5Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
											}
										}, _bpos);
									}
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 5) {
								if (entity instanceof ServerPlayer _plr32 && _plr32.level() instanceof ServerLevel
										&& _plr32.getAdvancements().getOrStartProgress(_plr32.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:bath_ritual"))).isDone()) {
									if (entity instanceof ServerPlayer _ent) {
										BlockPos _bpos = BlockPos.containing(x, y, z);
										NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
											@Override
											public Component getDisplayName() {
												return Component.literal("StoryModeSukuna6");
											}

											@Override
											public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
												return new StoryModeSukuna6Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
											}
										}, _bpos);
									}
								}
							} else if ((entity.getCapability(JujutsucraftaddonModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JujutsucraftaddonModVariables.PlayerVariables())).SH == 6) {
								if (entity instanceof ServerPlayer _plr34 && _plr34.level() instanceof ServerLevel
										&& _plr34.getAdvancements().getOrStartProgress(_plr34.server.getAdvancements().getAdvancement(new ResourceLocation("jujutsucraftaddon:bath_ritual"))).isDone()) {
									if (entity instanceof ServerPlayer _ent) {
										BlockPos _bpos = BlockPos.containing(x, y, z);
										NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
											@Override
											public Component getDisplayName() {
												return Component.literal("StoryModeSukuna7");
											}

											@Override
											public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
												return new StoryModeSukuna7Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
											}
										}, _bpos);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
