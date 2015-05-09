package com.example.zura.hijabstermediator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentTabHost;


    public class MainActivity extends ActionBarActivity {

        private static final String TAB_1_TAG = "one";
        private static final String TAB_2_TAG = "two";
        private static final String TAB_3_TAG = "three";
        private static final String TAB_4_TAG = "four";
        private static final String TAB_5_TAG = "five";
        private FragmentTabHost mTabHost;
        private Menu mainMenu;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.bottom_tabs);
            mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
            mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
            Bundle b = new Bundle();
            b.putString("key", "One");
            mTabHost.addTab(mTabHost.newTabSpec(TAB_1_TAG).setIndicator("", getResources().getDrawable(R.drawable.tab_one)), com.example.zura.hijabstermediator.FirstContainerFragment.class, b);

            b = new Bundle();
            b.putString("key", "Two");
            mTabHost.addTab(mTabHost.newTabSpec(TAB_2_TAG).setIndicator("", getResources().getDrawable(R.drawable.tab_two)), SecondContainerFragment.class, b);

            b = new Bundle();
            b.putString("key", "Three");
            mTabHost.addTab(mTabHost.newTabSpec(TAB_3_TAG).setIndicator("", getResources().getDrawable(R.drawable.tab_three)), ThirdContainerFragment.class, b);

            b = new Bundle();
            b.putString("key", "Four");
            mTabHost.addTab(mTabHost.newTabSpec(TAB_4_TAG).setIndicator("", getResources().getDrawable(R.drawable.tab_four)), FourthContainerFragment.class, b);

            b = new Bundle();
            b.putString("key", "Five");
            mTabHost.addTab(mTabHost.newTabSpec(TAB_5_TAG).setIndicator("", getResources().getDrawable(R.drawable.tab_five)), FifthContainerFragment.class, b);
        }


        @Override
        public void onBackPressed() {
            boolean isPopFragment = false;
            String currentTabTag = mTabHost.getCurrentTabTag();
            if (currentTabTag.equals(TAB_1_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_1_TAG)).popFragment();
            } else if (currentTabTag.equals(TAB_2_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_2_TAG)).popFragment();
            } else if (currentTabTag.equals(TAB_3_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_3_TAG)).popFragment();
            } else if (currentTabTag.equals(TAB_4_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_4_TAG)).popFragment();
            } else if (currentTabTag.equals(TAB_5_TAG)) {
                isPopFragment = ((BaseContainerFragment) getSupportFragmentManager().findFragmentByTag(TAB_5_TAG)).popFragment();
            }
            if (!isPopFragment) {
                finish();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }


    }
