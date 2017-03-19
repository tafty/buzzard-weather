package com.sixtyfourthpixel.buzzardweather.ui.forecasts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sixtyfourthpixel.buzzardweather.BuzzardWeatherApplication;
import com.sixtyfourthpixel.buzzardweather.R;
import com.sixtyfourthpixel.buzzardweather.model.local.DayForecast;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DayForecastFragment extends Fragment {
	private static final String TAG = DayForecastFragment.class.getSimpleName();

	private static final String BUNDLE_KEY_DAY_FORECAST = TAG + ".BUNDLE_KEY_DAY_FORECAST";

	@Inject
	Picasso picasso;

	@BindView(R.id.recycler_view)
	RecyclerView recyclerView;

	public static Fragment newInstance(DayForecast dayForecast) {
		Bundle bundle = new Bundle();
		bundle.putParcelable(BUNDLE_KEY_DAY_FORECAST, dayForecast);

		Fragment fragment = new DayForecastFragment();
		fragment.setArguments(bundle);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_day_forecast, container, false);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((BuzzardWeatherApplication) getActivity().getApplication()).getAppComponent().inject(this);
	}

	@Override
	public void onViewCreated(final View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		ButterKnife.bind(this, view);

		Bundle bundle = savedInstanceState != null ? savedInstanceState : getArguments();

		recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
		recyclerView.setAdapter(new DayForecastRecyclerViewAdapter(getContext(), picasso, bundle.getParcelable(BUNDLE_KEY_DAY_FORECAST)));
	}
}
