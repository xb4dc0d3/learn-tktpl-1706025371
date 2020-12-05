//
// Created by nux on 12/5/20.
//

#include <jni.h>
#include <cstdlib>
#include <cstring>

extern "C"
JNIEXPORT jstring JNICALL
Java_id_ac_ui_cs_mobileprogramming_nux_helloworld_activity_WelcomeActivity_setUsername(JNIEnv *env,
        jobject thiz, jstring username) {

    return username;
}

