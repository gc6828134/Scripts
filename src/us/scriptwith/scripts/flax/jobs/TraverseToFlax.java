package us.scriptwith.scripts.flax.jobs;

import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;
import us.scriptwith.core.script.generic.Traversal;
import us.scriptwith.scripts.flax.Flax;

/**
 * Date: 10/17/13
 * Time: 12:07 AM
 */

public class TraverseToFlax extends Traversal<Flax> {
    public TraverseToFlax(Flax script) {
        super(script, new TilePath(script.getContext(), new Tile[]{
                new Tile(2725, 3492, 0),
                new Tile(2725, 3479, 0),
                new Tile(2725, 3457, 0),
                new Tile(2742, 3445, 0)
        }));
    }

    @Override
    public boolean activate() {
        final GameObject flax = ctx.objects.select().id(2646).poll();
        return ctx.backpack.select().count() < 28
                && (!flax.isValid() || !flax.isOnScreen());
    }
}
