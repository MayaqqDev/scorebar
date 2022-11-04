package dev.mayaqq.scorebar.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.hud.BossBarHud.class)
public class BossBarHud {
    @Inject(method = "handlePacket", at = @At("HEAD"), cancellable = true)
    protected void $TurnOffBossBar(CallbackInfo ci) {
        ci.cancel();
    }
}
