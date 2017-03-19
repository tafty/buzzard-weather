package com.sixtyfourthpixel.buzzardweather.ui.forecasts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sixtyfourthpixel.buzzardweather.R;
import com.sixtyfourthpixel.buzzardweather.model.local.DayForecast;
import com.sixtyfourthpixel.buzzardweather.model.local.TimeForecast;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


class DayForecastRecyclerViewAdapter extends RecyclerView.Adapter<DayForecastRecyclerViewAdapter.ForecastHolder> {
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("kk:mm", Locale.getDefault());

	private final Context context;
	private final Picasso picasso;
	private final DayForecast dayForecast;

	DayForecastRecyclerViewAdapter(Context context, Picasso picasso, DayForecast dayForecast) {
		this.context = context;
		this.picasso = picasso;
		this.dayForecast = dayForecast;
	}

	@Override
	public ForecastHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_forecast, parent, false);
		return new ForecastHolder(view);
	}

	@Override
	public void onBindViewHolder(ForecastHolder holder, int position) {
		if (position < 0 || position >= dayForecast.timeForecasts.size()) {
			return;
		}

		TimeForecast forecast = dayForecast.timeForecasts.get(position);
		holder.time.setText(TIME_FORMAT.format(forecast.time.getTime()).replace("24:00", "00:00"));

		picasso.load(forecast.iconUrl).into(holder.icon);

		holder.temperature.setText(context.getString(R.string.temperature, forecast.temperature));

		StringBuilder description = new StringBuilder(forecast.description);
		description.setCharAt(0, Character.toUpperCase(description.charAt(0)));
		holder.description.setText(description.toString());
		holder.icon.setContentDescription(description.toString());
	}

	@Override
	public int getItemCount() {
		return dayForecast == null ? 0 : dayForecast.timeForecasts.size();
	}

	class ForecastHolder extends RecyclerView.ViewHolder {
		@BindView(R.id.time)
		TextView time;
		@BindView(R.id.icon)
		ImageView icon;
		@BindView(R.id.temperature)
		TextView temperature;
		@BindView(R.id.description)
		TextView description;

		ForecastHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
