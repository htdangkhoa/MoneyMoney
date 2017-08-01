package fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.dangkhoa.moneymoney.R;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by dangkhoa on 7/30/17.
 */

public class ExpenseIncomeFragment extends android.support.v4.app.Fragment {
    ImageButton btnToggle;
    PieChart pie_chart;

    float rainfall[] = {2500000, 2200000, 1500000, 3800000, 200000};
    String monthNames[] = {"Food", "Sport", "Education", "Housing", "Health"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expense_income, container, false);

        initialize(view);

        setupChart();

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Hello", Toast.LENGTH_SHORT).show();
            }
        });

        return  view;
    }

    private void initialize(View view) {
        btnToggle = (ImageButton) view.findViewById(R.id.btnToggle);
        pie_chart = (PieChart) view.findViewById(R.id.pie_chart);
    }

    private void setupChart() {
        float sum = 0;
        List<PieEntry> pieEntryList = new ArrayList<>();
        for (int i = 0; i < rainfall.length; i++) {
            pieEntryList.add(new PieEntry(rainfall[i], monthNames[i]));
            sum = sum + rainfall[i];
        }
        PieDataSet pieDataSet = new PieDataSet(pieEntryList, null);
        PieData pieData = new PieData(pieDataSet);
        pieData.setValueFormatter(new PercentFormatter());
        pie_chart.setData(pieData);
        pie_chart.invalidate();
        pie_chart.setUsePercentValues(true);

        DecimalFormatSymbols symbol = new DecimalFormatSymbols();
        symbol.setDecimalSeparator(',');
        symbol.setGroupingSeparator('.');
        DecimalFormat format = (DecimalFormat) NumberFormat.getInstance();
        format.setDecimalFormatSymbols(symbol);
        pie_chart.setCenterText(format.format(sum));

        pie_chart.setCenterTextSize(22);

        pie_chart.setDrawHoleEnabled(true);
        pie_chart.setHoleRadius(80);

        pieDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        pieData.setValueTextSize(14f);
        pieData.setValueTextColor(Color.DKGRAY);

        pie_chart.animateXY(1000, 1000);
        pie_chart.setDescription(null);
        pie_chart.setEntryLabelTextSize(12f);

        pie_chart.setRotationAngle(0);
        pie_chart.setRotationEnabled(true);

        pieDataSet.setSliceSpace(3f);
        pieDataSet.setSelectionShift(5f);

        pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        pieDataSet.setValueLinePart1Length(0.2f);
        pieDataSet.setValueLinePart2Length(0.3f);
        pieDataSet.setValueLineColor(Color.parseColor("#525252"));

        pie_chart.setExtraTopOffset(10f);
        pie_chart.setExtraBottomOffset(20f);
        pie_chart.setExtraLeftOffset(10f);
        pie_chart.setExtraRightOffset(10f);

        pie_chart.getLegend().setEnabled(false);

        pie_chart.setHoleColor(Color.parseColor("#66c6b0"));
        pie_chart.setCenterTextColor(Color.parseColor("#FFFFFF"));
    }
}