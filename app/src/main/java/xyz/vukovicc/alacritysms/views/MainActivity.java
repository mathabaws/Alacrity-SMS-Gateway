package xyz.vukovicc.alacritysms.views;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.vukovicc.alacritysms.R;
import xyz.vukovicc.alacritysms.managers.MailService;
import xyz.vukovicc.alacritysms.views.adapters.MainPagerAdapter;

public class MainActivity extends AppCompatActivity implements ActivityLogFragment.OnFragmentInteractionListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.tabs) TabLayout tabs;
    @BindView(R.id.pager) ViewPager pager;

    MainPagerAdapter mainPagerAdapter;
    CharSequence Titles[] = {
            "Triggers",
            "Activity",
            "Statistic"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("");
        //init the fa
        Iconify.with(new FontAwesomeModule());

        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        setUpTabs();
        setUpClick();

        new MailService().execute();

    }

    private void setUpClick() {
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setUpTabs() {
        mainPagerAdapter = new MainPagerAdapter(this.getSupportFragmentManager(),
                Titles, Titles.length);
        pager.setAdapter(mainPagerAdapter);
        tabs.setupWithViewPager(pager);
        setupTabIcons();
    }

    private void setupTabIcons() {
        tabs.getTabAt(0).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_bolt).colorRes(R.color.textIcon));
        tabs.getTabAt(1).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_exchange).colorRes(R.color.textIcon));
        tabs.getTabAt(2).setIcon(new IconDrawable(this, FontAwesomeIcons.fa_bar_chart).colorRes(R.color.textIcon));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
/*        if (id == R.id.ac) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("MAIN", "OnFragmentInteraction called with URI: " + uri.toString());
    }
}
