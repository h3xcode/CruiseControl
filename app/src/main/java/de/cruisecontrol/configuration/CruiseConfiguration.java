package de.cruisecontrol.configuration;

import android.content.Context;
import android.util.Log;

import java.io.File;

import de.cruisecontrol.cardata.CarPool;
import de.cruisecontrol.util.Res;

/**
 * Created by Moik on 19.10.2015.
 */
public class CruiseConfiguration {
    private static final String TAG = "CruiseConfiguration";

    //
    private enum ConfigStatus { LOAD };
    private static Context context = null;

    // **********
    // Attributes
    // **********
    private boolean isEmpty = false;
    private CarPool carPool = null;
    private String password = null;
    private String lastCarUsed = null;


    // *********
    // Singleton
    // *********
    private static CruiseConfiguration _instance = null;

    /**
     * Private constructor for singleton. Don't use this one!
     */
    private CruiseConfiguration(){}

    /**
     * Get instance method for singleton.
     */
    public static CruiseConfiguration getInstance(Context context){
        // Set context
        CruiseConfiguration.context = context;

        // If there is no configuration...
        if(_instance == null){
            // create one...
            _instance = load();
        }
        // and return it
        return _instance;
    }


    /**
     * Loads CruiseConfiguration.
     * @return CruiseConfiguration loaded from configuration file.
     */
    private static CruiseConfiguration load(){
        // Check if config file is there
        File configFile = new File(context.getFilesDir(), Res.CONFIG_PATH);

        if(!configFile.exists()) {
            // make one

        }

        return JsonFactory.getCruiseConfiguration(configFile);
    }

    public boolean save(){
        return false;
    }
}
