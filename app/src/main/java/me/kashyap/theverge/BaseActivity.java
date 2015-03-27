package me.kashyap.theverge;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created on 3/26/2015.
 */
public abstract class BaseActivity extends ActionBarActivity {

    private UiComponent uiComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uiComponent = Dagger_UiComponent.builder()
                .apiModule(new ApiModule())
                .vergeModule(new VergeModule())
                .uiModule(new UiModule()).build();
    }

    UiComponent getUiComponent() {
        return uiComponent;
    }
}
