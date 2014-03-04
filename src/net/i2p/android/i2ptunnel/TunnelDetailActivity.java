package net.i2p.android.i2ptunnel;

import net.i2p.android.router.I2PActivityBase;
import net.i2p.android.router.R;
import android.os.Bundle;

public class TunnelDetailActivity extends I2PActivityBase implements
        TunnelDetailFragment.OnTunnelDeletedListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDrawerToggle.setDrawerIndicatorEnabled(false);

        if (savedInstanceState == null) {
            int tunnelId = getIntent().getIntExtra(TunnelDetailFragment.TUNNEL_ID, 0);
            TunnelDetailFragment detailFrag = TunnelDetailFragment.newInstance(tunnelId);
            getSupportFragmentManager().beginTransaction()
                .add(R.id.main_fragment, detailFrag).commit();
        }
    }

    // TunnelDetailFragment.OnTunnelDeletedListener

    public void onTunnelDeleted(int tunnelId, int numTunnelsLeft) {
        finish();
    }
}