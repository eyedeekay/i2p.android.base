package net.i2p.android.router;

/* Note: provided because I copy-pasted some of this code from the equivalent
 * module in Orbot. Apache2 is actually the default license for this project also.
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.app.Service;
import android.content.Intent;
import android.net.VpnService;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class I2PVpnService extends VpnService {

  I2PVpnManager mVpnManager;

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }
  public int onStartCommand(Intent intent, int flags, int startId) {
    mVpnManager.handleIntent(new Builder(), intent);
    return Service.START_STICKY;
  }
}
