package dev.mayaqq.scorebar.mixin;

import dev.mayaqq.scorebar.Scorebar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.hud.BossBarHud.class)
public class BossBarHud {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    protected void $TurnOffBossBar(CallbackInfo ci) {
        if (!Scorebar.getConfig().enabledBossbar) {
            ci.cancel();
        }
    }
}
