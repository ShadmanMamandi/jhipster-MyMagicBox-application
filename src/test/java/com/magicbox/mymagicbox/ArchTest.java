package com.magicbox.mymagicbox;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.magicbox.mymagicbox");

        noClasses()
            .that()
            .resideInAnyPackage("com.magicbox.mymagicbox.service..")
            .or()
            .resideInAnyPackage("com.magicbox.mymagicbox.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.magicbox.mymagicbox.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
