package us.scriptwith.util.defined;

import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Npc;
import us.scriptwith.core.job.Job;
import us.scriptwith.core.script.Script;

/**
 * Date: 8/18/13
 * Time: 3:33 PM
 */

public class RandomCameraMovement<T extends Script> extends Job<T> {
    public RandomCameraMovement(T ctx) {
        super(ctx);
    }

    @Override
    public int priority() {
        return -1;
    }

    @Override
    public boolean activate() {
        return Math.random() > .95;
    }

    @Override
    public void execute() {
        if (Math.random() > .5) {
            for (Npc n : ctx.npcs.select().shuffle().first()) {
                ctx.camera.turnTo(n);
            }
        } else {
            for (GameObject n : ctx.objects.select().shuffle().first()) {
                ctx.camera.turnTo(n);
            }
        }
    }

    @Override
    public String status() {
        return "Camera Antipattern";
    }
}
