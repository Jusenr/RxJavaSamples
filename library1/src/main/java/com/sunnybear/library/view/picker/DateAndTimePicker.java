package com.sunnybear.library.view.picker;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sunnybear.library.view.picker.util.DateUtils;
import com.sunnybear.library.view.picker.widget.WheelView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by riven_chris on 16/7/19.
 */
public class DateAndTimePicker extends WheelPicker {
    private OnDateAndTimePickListener onDateAndTimePickListener;
    private String yearLabel = "", monthLabel = "", dayLabel = "", hourLabel = ":", minuteLabel = "";
    private int startYear = 1970, endYear = 2050;
    private String selectedYear = "", selectedMonth = "", selectedDay = "", selectedHour = "", selectedMinute = "";
    private int defaultYear = 0, defaultMonth = 0, defaultDay = 0, defaultHour = 0, defaultMinute = 0;
    private boolean yearInit = true, monthInit = true;
    private int selectedDayIndex;

    public DateAndTimePicker(Activity activity) {
        super(activity);
        setDefault(System.currentTimeMillis());
    }

    public void setDefault(long mills) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mills);
        this.defaultYear = calendar.get(Calendar.YEAR);
        this.defaultMonth = calendar.get(Calendar.MONTH);
        this.defaultDay = calendar.get(Calendar.DAY_OF_MONTH) - 1;
        this.defaultHour = calendar.get(Calendar.HOUR_OF_DAY);
        this.defaultMinute = calendar.get(Calendar.MINUTE);
        yearInit = true;
        monthInit = true;
    }

    public void setRange(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public void setOnDateAndTimePickListener(OnDateAndTimePickListener listener) {
        this.onDateAndTimePickListener = listener;
    }

    @Override
    protected View initContentView() {
        LinearLayout layout = new LinearLayout(activity);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER);
        WheelView yearView = new WheelView(activity);
        yearView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        yearView.setTextSize(textSize);
        yearView.setTextColor(textColorNormal, textColorFocus);
        yearView.setLineVisible(lineVisible);
        yearView.setLineColor(lineColor);
        yearView.setOffset(offset);
        layout.addView(yearView);
        TextView yearTextView = new TextView(activity);
        yearTextView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        yearTextView.setTextSize(textSize);
        yearTextView.setTextColor(textColorFocus);
        if (!TextUtils.isEmpty(yearLabel)) {
            yearTextView.setText(yearLabel);
        }
        layout.addView(yearTextView);

        WheelView monthView = new WheelView(activity);
        monthView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        monthView.setTextSize(textSize);
        monthView.setTextColor(textColorNormal, textColorFocus);
        monthView.setLineVisible(lineVisible);
        monthView.setLineColor(lineColor);
        monthView.setOffset(offset);
        layout.addView(monthView);
        TextView monthTextView = new TextView(activity);
        monthTextView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        monthTextView.setTextSize(textSize);
        monthTextView.setTextColor(textColorFocus);
        if (!TextUtils.isEmpty(monthLabel)) {
            monthTextView.setText(monthLabel);
        }
        layout.addView(monthTextView);

        final WheelView dayView = new WheelView(activity);
        dayView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        dayView.setTextSize(textSize);
        dayView.setTextColor(textColorNormal, textColorFocus);
        dayView.setLineVisible(lineVisible);
        dayView.setLineColor(lineColor);
        dayView.setOffset(offset);
        layout.addView(dayView);
        TextView dayTextView = new TextView(activity);
        dayTextView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        dayTextView.setTextSize(textSize);
        dayTextView.setTextColor(textColorFocus);
        if (!TextUtils.isEmpty(dayLabel)) {
            dayTextView.setText(dayLabel);
        }
        layout.addView(dayTextView);

        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER);
        WheelView hourView = new WheelView(activity);
        hourView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        hourView.setTextSize(textSize);
        hourView.setTextColor(textColorNormal, textColorFocus);
        hourView.setLineVisible(lineVisible);
        hourView.setLineColor(lineColor);
        layout.addView(hourView);
        TextView hourTextView = new TextView(activity);
        hourTextView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        hourTextView.setTextSize(textSize);
        hourTextView.setTextColor(textColorFocus);
        if (!TextUtils.isEmpty(hourLabel)) {
            hourTextView.setText(hourLabel);
        }
        layout.addView(hourTextView);

        WheelView minuteView = new WheelView(activity);
        minuteView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        minuteView.setTextSize(textSize);
        minuteView.setTextColor(textColorNormal, textColorFocus);
        minuteView.setLineVisible(lineVisible);
        minuteView.setLineColor(lineColor);
        minuteView.setOffset(offset);
        layout.addView(minuteView);
        TextView minuteTextView = new TextView(activity);
        minuteTextView.setLayoutParams(new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        minuteTextView.setTextSize(textSize);
        minuteTextView.setTextColor(textColorFocus);
        if (!TextUtils.isEmpty(minuteLabel)) {
            minuteTextView.setText(minuteLabel);
        }
        layout.addView(minuteTextView);

        if (!TextUtils.isEmpty(yearLabel)) {
            yearTextView.setText(yearLabel);
        }
        ArrayList<String> years = new ArrayList<String>();
        for (int i = startYear; i <= endYear; i++) {
            years.add(String.valueOf(i));
        }
        yearView.setItems(years, defaultYear - startYear);//TODO:设置默认值
        yearView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                selectedYear = item;
                //需要根据年份及月份动态计算天数
                int maxDays = DateUtils.calculateDaysInMonth(
                        stringToYearMonthDay(selectedYear), stringToYearMonthDay(selectedMonth));
                ArrayList<String> days = new ArrayList<>();
                for (int i = 1; i <= maxDays; i++) {
                    days.add(DateUtils.fillZore(i));
                }
                if (yearInit) {
                    yearInit = false;
                    dayView.setItems(days, defaultDay);
                } else {
                    resetDays(days, dayView);
                }
            }
        });

        if (!TextUtils.isEmpty(monthLabel)) {
            monthTextView.setText(monthLabel);
        }
        final ArrayList<String> months = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            months.add(DateUtils.fillZore(i));
        }
        monthView.setItems(months, defaultMonth);
        monthView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                selectedMonth = item;
                //需要根据年份及月份动态计算天数
                int maxDays = DateUtils.calculateDaysInMonth(
                        stringToYearMonthDay(selectedYear), stringToYearMonthDay(selectedMonth));
                ArrayList<String> days = new ArrayList<String>();
                for (int i = 1; i <= maxDays; i++) {
                    days.add(DateUtils.fillZore(i));
                }

                if (monthInit) {
                    monthInit = false;
                    dayView.setItems(days, defaultDay);
                } else {
                    resetDays(days, dayView);
                }
            }
        });

        if (!TextUtils.isEmpty(dayLabel)) {
            dayTextView.setText(dayLabel);
        }
        //年月日选择时，最大天数根据年月来计算
        int maxDays = DateUtils.calculateDaysInMonth(
                stringToYearMonthDay(selectedYear), stringToYearMonthDay(selectedMonth));
        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= maxDays; i++) {
            days.add(DateUtils.fillZore(i));
        }
        dayView.setItems(days, defaultDay);
        dayView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                if (TextUtils.isEmpty(item)) {
                    return;
                }
                selectedDay = item;
                selectedDayIndex = selectedIndex;
            }
        });

        ArrayList<String> hours = new ArrayList<String>();
        for (int i = 0; i < 24; i++) {
            hours.add(DateUtils.fillZore(i));
        }
        hourView.setItems(hours, defaultHour);
        ArrayList<String> minutes = new ArrayList<String>();
        for (int i = 0; i < 60; i++) {
            minutes.add(DateUtils.fillZore(i));
        }
        minuteView.setItems(minutes, defaultMinute);
        hourView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                if (TextUtils.isEmpty(item)) {
                    return;
                }
                selectedHour = item;
            }
        });
        minuteView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                if (TextUtils.isEmpty(item)) {
                    return;
                }
                selectedMinute = item;
            }
        });
        return layout;
    }

    private void resetDays(List<String> days, WheelView dayView) {
        if (days.size() > selectedDayIndex) {
            dayView.setItems(days);
            dayView.setSelection(selectedDayIndex - 1);
        } else {
            dayView.setItems(days);
            int index = days.size() - 1;
            dayView.setSelection(index);
        }
    }

    private int stringToYearMonthDay(String text) {
        if (text.startsWith("0"))
            //截取掉前缀0以便转换为整数
            text = text.substring(1);
        if (TextUtils.isEmpty(text))
            return 0;
        return Integer.parseInt(text);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        super.setContentViewAfter(contentView);
        super.setOnConfirmListener(new OnConfirmListener() {
            @Override
            public void onConfirm() {
                if (onDateAndTimePickListener != null) {
                    onDateAndTimePickListener.onDatePicked(selectedYear, selectedMonth, selectedDay, selectedHour, selectedMinute);
                }
            }
        });
    }

    public interface OnDateAndTimePickListener {

        void onDatePicked(String year, String month, String day, String hour, String minute);
    }
}
