package com.ausichenko.regextools.viewmodel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.ausichenko.regextools.database.DatabaseCreator;
import com.ausichenko.regextools.database.entity.PatternEntity;

import java.util.List;

public class PatternListViewModel extends AndroidViewModel {
    private static final MutableLiveData ABSENT = new MutableLiveData();
    static {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    private final LiveData<List<PatternEntity>> mObservablePatterns;

    public PatternListViewModel(@NonNull Application application) {
        super(application);

        final DatabaseCreator databaseCreator = DatabaseCreator.getInstance(this.getApplication());

        mObservablePatterns = Transformations.switchMap(databaseCreator.isDatabaseCreated(),
                (Function<Boolean, LiveData<List<PatternEntity>>>) isDbCreated -> {
                    if (!Boolean.TRUE.equals(isDbCreated)) { // Not needed here, but watch out for null
                        //noinspection unchecked
                        return ABSENT;
                    } else {
                        //noinspection ConstantConditions
                        return databaseCreator.getDatabase().patternDao().getAll();
                    }
                });

        databaseCreator.createDb(this.getApplication());

    }
    /**
     * Expose the LiveData Comments query so the UI can observe it.
     */

    public LiveData<List<PatternEntity>> getPatterns() {
        return mObservablePatterns;
    }
}
