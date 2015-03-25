package me.kashyap.theverge;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/23/2015.
 */
public class RssApplication extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(getModules().toArray());
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
}
