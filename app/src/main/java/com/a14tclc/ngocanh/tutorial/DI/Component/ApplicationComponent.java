package com.a14tclc.ngocanh.tutorial.DI.Component;

import com.a14tclc.ngocanh.tutorial.DI.Module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

// Scope using it for everywhere, module has anythings. YOu have permission to access it form whatever place.
@Singleton
@Component (
        modules = {ApplicationModule.class}
)
public interface ApplicationComponent {
}
