package com.tryingoutsomething.loginapp.service;

import java.util.Collection;

public interface HumanReadableStringFormat<T> {
    String formatString(String text);

    Collection<String> format(T t);
}
