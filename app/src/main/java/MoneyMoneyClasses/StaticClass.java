package MoneyMoneyClasses;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dangkhoa.moneymoney.MainActivity;
import com.example.dangkhoa.moneymoney.R;

/**
 * Created by dangkhoa on 8/9/17.
 */

public class StaticClass {
    public static ImageButton initNavButton(final Context context, View view) {
        ImageButton button = new ImageButton(context);

        button.setMinimumWidth(30);
        button.setMinimumHeight(30);
        button.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_menu));
        button.setBackgroundColor(ContextCompat.getColor(context, R.color.transparent));

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(50, 40, 50, 40);
//
        button.setLayoutParams(params);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.drawer.openDrawer(Gravity.LEFT);
            }
        });

        return  button;
    }
}
