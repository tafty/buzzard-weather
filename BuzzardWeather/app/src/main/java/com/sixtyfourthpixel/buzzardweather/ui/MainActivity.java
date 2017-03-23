package com.sixtyfourthpixel.buzzardweather.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.sixtyfourthpixel.buzzardweather.BuzzardWeatherApplication;
import com.sixtyfourthpixel.buzzardweather.R;
import com.sixtyfourthpixel.buzzardweather.model.local.MultiDayForecast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContracts.View {
	@Inject
	MainContracts.Presenter presenter;

	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.view_pager)
	ViewPager viewPager;
	@BindView(R.id.tabs)
	TabLayout tabLayout;

	private MainFragmentPagerAdapter mainFragmentPagerAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		((BuzzardWeatherApplication) getApplication()).getAppComponent().inject(this);

		presenter.attachView(this);

		mainFragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(mainFragmentPagerAdapter);
		tabLayout.setupWithViewPager(viewPager);

		setSupportActionBar(toolbar);
	}

	@Override
	protected void onResume() {
		super.onResume();

		presenter.loadData();
	}

	@Override
	public void onDataLoaded(MultiDayForecast forecast) {
		mainFragmentPagerAdapter.setForecast(forecast);
		viewPager.clearOnPageChangeListeners();
		tabLayout.setupWithViewPager(viewPager);
	}

	@Override
	public void showError(String message) {
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
	}
}
