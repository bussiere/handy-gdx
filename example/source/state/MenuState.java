package example.source.state;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import example.source.App;
import source.core.State.AbstractState;
import source.core.State.StateManager;
import source.extensions.TextHelper.TextHelper;
import source.core.Transition.HorizontalSlideTransition;
import source.core.Transition.HorizontalSlideTransition.Motion;
import source.core.Transition.Transition;

public class MenuState extends AbstractState {

    private static final String SAMPLE_TEXT = "This is the menu state!";

    private final BitmapFont font;
    private final Vector2 textPosition;

    public MenuState() {
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        textPosition = TextHelper.centerOnScreen(font, SAMPLE_TEXT, App.WORLD_WIDTH, App.WORLD_HEIGHT);
    }

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        /* Transition 1: Fading transition. */
//        final Transition transition = new FadingTransition();
        /* Transition 2: HorizontalSlide transition, left-to-right. */
        final Transition transition = new HorizontalSlideTransition(Motion.LEFT_TO_RIGHT, 0.2f);
        StateManager.getInstance().setState(new PlayState(), transition);
        return true;
    }


    @Override
    public void update(float delta) {
        /* Update stuff here... */
    }

    @Override
    public void render(Batch batch) {
        batch.begin();
        font.draw(batch, SAMPLE_TEXT, textPosition.x, textPosition.y);
        batch.end();
    }

    @Override
    public void dispose() {
        /* Dispose stuff here... */
    }
}
