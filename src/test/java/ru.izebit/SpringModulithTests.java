package ru.izebit;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class SpringModulithTests {
    private final ApplicationModules modules = ApplicationModules.of(ApplicationLauncher.class);

    @Test
    void shouldBeCompliant() {
        ApplicationModules.of(ApplicationLauncher.class).verify();
    }

    @Test
    void writeDocumentationSnippets() {
        new Documenter(modules)
                .writeModuleCanvases()
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml();
    }
}
