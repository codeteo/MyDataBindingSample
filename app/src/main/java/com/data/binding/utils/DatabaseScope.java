package com.data.binding.utils;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Dagger scope for Database.
 */

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseScope {
}