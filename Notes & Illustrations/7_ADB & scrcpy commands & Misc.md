## ADB commands
### Wifi
- adb shell svc wifi enable
- adb shell svc wifi disable
- adb shell dumpsys wifi | grep "enabled|disabled"

### Connect, Reboot, Install & uninstall
- adb connect localhost:5555
- adb reboot
- adb logcat | grep string_to_search_on_logs
- adb install -r -d abc.apk // force install anduse this on failed "inversion downgrade install", build an apk and use it to install
- adb shell dumpsys package com.company.appname | grep version //checks the version of an app
- adb shell am force-stop com.company.appname
- pm dump com.company.appname | grep Path
- pm install -r --user 0 /system/priv-app/appname/appname.apk //Failure [INSTALL_FAILED_INVALID_APK: Package com.company.appname is a persistent app. Persistent apps are not updateable.]
- - adb shell pm list packages | grep appname // checks if appname is installed, prints something, if it's installed

### Other commands
- adb shell pidof com.company.appname // get process ID
```
https://www.baeldung.com/linux/ps-command
- adb shell ps | grep com.company.appname
-   UID         PID    PPID     C(PU)   STIME   TTY                TIME CMD
- u12_a116      7142   394   14206724 123904 0                   0 S com.company.appname
```
- adb shell input keyevent KEYCODE_BACK // press back button
- adb shell pm grant com.company.appname android.permission.READ_EXTERNAL_STORAGE
- adb shell input text_you_wanna_paste //useful to copy paste complex text into the emulator
- adb logcat | grep -F "!!!" //listen to logcat with a string
- adb shell dumpsys display // to list all displays 
- adb shell pm list features // list device features, mostly related to hardware

### Scrcpy
- scrcpy --tcpip=127.0.0.1
- scrcpy --display «displayId»

## Misc
- Apparent max log string lenght 1136
