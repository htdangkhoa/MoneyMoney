package fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.dangkhoa.moneymoney.R;
import com.github.mikephil.charting.charts.PieChart;
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

import MoneyMoneyClasses.StaticClass;

/**
 * Created by dangkhoa on 7/30/17.
 */

public class CardManageFragment extends android.support.v4.app.Fragment {
    RelativeLayout moneyNav;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_manage, container, false);

        initialize(view);

        return  view;
    }

    private void initialize(View view) {
        moneyNav = (RelativeLayout) view.findViewById(R.id.moneyNav);
        moneyNav.addView(StaticClass.initNavButton(view.getContext(), view));
    }
}