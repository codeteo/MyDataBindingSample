package com.data.binding.dagger;

import android.content.Context;

import com.data.binding.utils.DatabaseScope;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

/**
 * Dagger Module to provide permanent storage dependencies.
 */
@Module
public class DataModule {

    private static final int DATABASE_VERSION = 1;

    @Provides
    @DatabaseScope
    RealmConfiguration provideRealmConfig(Context context) {
        Realm.init(context);

        return new RealmConfiguration.Builder()
                .schemaVersion(DATABASE_VERSION)
                .build();
    }

    @Provides
    @DatabaseScope
    Realm provideRealm(RealmConfiguration config) {
        Realm.setDefaultConfiguration(config);
        try {
            return Realm.getDefaultInstance();
        } catch (Exception e) {
            Timber.e(e, "");
            Realm.deleteRealm(config);
            Realm.setDefaultConfiguration(config);
            return Realm.getDefaultInstance();
        }
    }

}
