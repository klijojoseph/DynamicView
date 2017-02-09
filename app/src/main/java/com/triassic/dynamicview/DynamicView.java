package com.triassic.dynamicview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Lijo Joseph on 08-02-2017.
 */

public class DynamicView extends LinearLayout {


    public DynamicView(Context context) {
        super(context);
    }

    public DynamicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DynamicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }




    public void setAdapter(BaseAdapter adapter){

        if(this.getChildCount() > 0)
            this.removeAllViews();

        DynamicRowColumn dynamicRowColumn = new DynamicRowColumn(adapter.getCount());
        ArrayList<View> viewList = new ArrayList<>();
        if(adapter.getCount()!=0){
            for (int i = 0; i <adapter.getCount() ; i++) {
                View childView = adapter.getView(i,null,null);
                LayoutParams childLayoutParams = new LayoutParams(0, LayoutParams.MATCH_PARENT);
                childLayoutParams.weight = dynamicRowColumn.getColumn();
                childView.setLayoutParams(childLayoutParams);
                viewList.add(childView);
            }

            int position = 0;
            for (int i = 0; i < dynamicRowColumn.getRow(); i++) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                LayoutParams baseLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,0);
                baseLayoutParams.weight = dynamicRowColumn.getRow();
                linearLayout.setLayoutParams(baseLayoutParams);
                this.addView(linearLayout);
                for (int j = 0; j <dynamicRowColumn.getColumn() ; j++) {
                    if(adapter.getCount()>position) {
                        linearLayout.addView(viewList.get(position));
                        position++;
                    }
                }
            }

        }

    }

}
