# IAK-Advance
Study resources from Advance Class Indonesia Android Kejar Batch 3 Period 3

### Fragment
* Add fragment to activity
* Add more fragment
* Navigate through fragment
* Send data to fragment
* Reuse fragment
* Communicate via interface

### Service
#### Started
* startService()
* Just To Accomplish Task
* onBind returns null
* Still run even if the calling component destroyed

#### Bounded
* bindService()
* For long standing connection
* onBind returns IBinder
* Destroyed if calling component gets destroyed

### Intent Service
#### Service
* Run On Main Thread
* Have to call stopSelf() or stopService() to stop service

#### Intent Service
* Run on Separate Thread
* Stopped after all start requests have been handled

### Broadcast Receiver
* If your app targets API level 26 or higher, you cannot use the manifest to declare a receiver for implicit broadcasts (broadcasts that do not target your app specifically), except for a few implicit broadcasts that are exempted from that restriction. In most cases, you can use scheduled jobs instead.
[Android Developer Guide - Broadcast Receiver](https://developer.android.com/guide/components/broadcast-exceptions.html "Broadcast Receiver")

### Content Provider
* Use content providers if you plan to share data. If you don’t plan to share data, you may still use them because they provide a nice abstraction, but you don’t have to.
