package com.example.simplynote.utils;

import io.reactivex.Scheduler;

public interface BaseScheduler {
    Scheduler io();
    Scheduler computation();
    Scheduler main();
    Scheduler single();
}
