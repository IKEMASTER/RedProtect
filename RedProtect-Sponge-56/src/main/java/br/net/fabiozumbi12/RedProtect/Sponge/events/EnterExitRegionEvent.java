/*
 Copyright @FabioZumbi12

 This class is provided 'as-is', without any express or implied warranty. In no event will the authors be held liable for any
  damages arising from the use of this class.

 Permission is granted to anyone to use this class for any purpose, including commercial plugins, and to alter it and
 redistribute it freely, subject to the following restrictions:
 1 - The origin of this class must not be misrepresented; you must not claim that you wrote the original software. If you
 use this class in other plugins, an acknowledgment in the plugin documentation would be appreciated but is not required.
 2 - Altered source versions must be plainly marked as such, and must not be misrepresented as being the original class.
 3 - This notice may not be removed or altered from any source distribution.

 Esta classe é fornecida "como está", sem qualquer garantia expressa ou implícita. Em nenhum caso os autores serão
 responsabilizados por quaisquer danos decorrentes do uso desta classe.

 É concedida permissão a qualquer pessoa para usar esta classe para qualquer finalidade, incluindo plugins pagos, e para
 alterá-lo e redistribuí-lo livremente, sujeito às seguintes restrições:
 1 - A origem desta classe não deve ser deturpada; você não deve afirmar que escreveu a classe original. Se você usar esta
  classe em um plugin, uma confirmação de autoria na documentação do plugin será apreciada, mas não é necessária.
 2 - Versões de origem alteradas devem ser claramente marcadas como tal e não devem ser deturpadas como sendo a
 classe original.
 3 - Este aviso não pode ser removido ou alterado de qualquer distribuição de origem.
 */

package br.net.fabiozumbi12.RedProtect.Sponge.events;

import br.net.fabiozumbi12.RedProtect.Sponge.RedProtect;
import br.net.fabiozumbi12.RedProtect.Sponge.Region;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.impl.AbstractEvent;


/**
 * This event is called when a player enter or exit a region.
 * <p>
 * The cancellable state cancels all flags and effects when
 * player enter/exit a region and nothing will happen, but
 * code can be added here and will work normally, and the flags
 * can be used too. Only default actions is cancelled.
 *
 * @author FabioZumbi12
 * @returns <b>null</b> if the ExitedRegion or EnteredRegion is wilderness.
 */
public class EnterExitRegionEvent extends AbstractEvent implements Cancellable, Event {

    private final Player player;
    private final Region ExitedRegion;
    private final Region EnteredRegion;
    private boolean cancelled;


    public EnterExitRegionEvent(Region ExitedRegion, Region EnteredRegion, Player player) {
        this.player = player;
        this.ExitedRegion = ExitedRegion;
        this.EnteredRegion = EnteredRegion;
    }

    public Region getExitedRegion() {
        return this.ExitedRegion;
    }

    public Region getEnteredRegion() {
        return this.EnteredRegion;
    }

    public Player getPlayer() {
        return this.player;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean arg0) {
        this.cancelled = arg0;

    }

    @Override
    public Cause getCause() {
        return RedProtect.get().getPVHelper().getCause(player);
    }
}
