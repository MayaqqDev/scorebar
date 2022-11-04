package dev.mayaqq.scorebar.mixin;

import dev.mayaqq.scorebar.Scorebar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.client.gui.hud.InGameHud.class)
public class InGameHud {
    @Inject(method = "renderScoreboardSidebar", at = @At("HEAD"), cancellable = true)
    protected void $turnOffScoreboard(CallbackInfo ci) {
        if (!Scorebar.getConfig().enableScoreboard) {
            ci.cancel();
        }
    }
}

