package com.kumarvv.table2pojo.gradle;

import com.kumarvv.table2pojo.Table2Pojo;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class Table2PojoTask extends DefaultTask {

    private Table2PojoExt extension;

    public void setExtension(Table2PojoExt extension) {
        this.extension = extension;
    }

    @TaskAction
    public void generateAll() {
        new Table2Pojo().process(extension.getUserPrefs(), extension.getConnectionPrefs());
    }
}
