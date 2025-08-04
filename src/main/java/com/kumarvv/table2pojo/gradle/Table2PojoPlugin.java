package com.kumarvv.table2pojo.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class Table2PojoPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        var ext = project.getExtensions().create("table2pojo", Table2PojoExt.class, project);
        project.getTasks().create("table2pojo", Table2PojoTask.class, task -> task.setExtension(ext));
    }
}
