//
// Created by nux on 12/5/20.
//

#include <jni.h>
#include <stdlib.h>
#include <time.h>


jint Jniint() {
    srand((unsigned int) time(0));
    int intrandom = (rand() % (990 - 101)) + 101;
    return intrandom;
}