package net.i2p.android.router;

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
        mVpnManager.handleIntent(new Builder(),intent);
        return Service.START_STICKY;
    }
}
