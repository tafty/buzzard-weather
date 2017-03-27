package com.sixtyfourthpixel.buzzardweather.ui.widget;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.sixtyfourthpixel.buzzardweather.R;

public class WindView extends View {
	private final Rect textBounds = new Rect();

	private Paint symbolPaint;
	private Paint textPaint;
	private Path path;

	private float centreX;
	private float centreY;
	private float circleRadius;
	private float triangleSize;
	private float rectangleSize;
	private float yOffset;

	private String windSpeed;
	private double windAngle;

	public WindView(Context context) {
		super(context);

		init(context);
	}

	public WindView(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);

		init(context);
	}

	public WindView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		init(context);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public WindView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);

		init(context);
	}

	@Override
	protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
		centreX = width / 2;
		centreY = height / 2;
		float size = Math.min(width, height);
		yOffset = (height - size) / 2;
		circleRadius = size / 4;
		triangleSize = size / 6;
		rectangleSize = triangleSize / 2;
		textPaint.setTextSize(circleRadius);

		super.onSizeChanged(width, height, oldWidth, oldHeight);
	}

	private void init(Context context) {
		symbolPaint = new Paint();
		symbolPaint.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
		symbolPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		symbolPaint.setAntiAlias(true);

		textPaint = new Paint();
		textPaint.setColor(ContextCompat.getColor(context, android.R.color.white));
		textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		textPaint.setAntiAlias(true);
		textPaint.setTextAlign(Paint.Align.CENTER);

		path = new Path();
	}

	public void setWind(double windSpeed, double windAngle) {
		this.windSpeed = getContext().getString(R.string.wind_speed, windSpeed);
		this.windAngle = windAngle;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawCircle(centreX, centreY, circleRadius, symbolPaint);

		path.moveTo(centreX, yOffset);
		path.lineTo(centreX + triangleSize, yOffset + triangleSize);
		path.lineTo(centreX - triangleSize, yOffset + triangleSize);
		path.close();

		canvas.save();
		canvas.rotate((float) windAngle, centreX, centreY);
		canvas.drawRect(centreX - rectangleSize, yOffset + triangleSize, centreX + rectangleSize, centreY, symbolPaint);
		canvas.drawPath(path, symbolPaint);
		canvas.restore();

		textPaint.getTextBounds(windSpeed, 0, windSpeed.length(), textBounds);
		canvas.drawText(windSpeed, centreX, centreY - textBounds.exactCenterY(), textPaint);
	}
}
