package com.kumarvv.table2pojo.gradle;

import com.kumarvv.table2pojo.model.ConnectionPrefs;
import com.kumarvv.table2pojo.model.UserPrefs;
import org.gradle.api.Project;

public class Table2PojoExt {

    public Table2PojoExt(Project project) {
    }

    private UserPrefs userPrefs;
    private ConnectionPrefs connectionPrefs;

    public ConnectionPrefs getConnectionPrefs() {
        return connectionPrefs;
    }

    public void setConnectionPrefs(ConnectionPrefs connectionPrefs) {
        this.connectionPrefs = connectionPrefs;
    }

    public UserPrefs getUserPrefs() {
        return userPrefs;
    }

    public void setUserPrefs(UserPrefs userPrefs) {
        this.userPrefs = userPrefs;
    }
}
