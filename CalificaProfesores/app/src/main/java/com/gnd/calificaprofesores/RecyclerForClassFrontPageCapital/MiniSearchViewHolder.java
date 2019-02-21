package com.gnd.calificaprofesores.RecyclerForClassFrontPageCapital;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.gnd.calificaprofesores.NetworkSearchQueriesHandler.UniData;
import com.gnd.calificaprofesores.R;
import com.gnd.calificaprofesores.SearchItem.AdapterSearch;

/** layout_item_mini_search.xml **/

public class MiniSearchViewHolder extends RecyclerView.ViewHolder {
    private View view;
    private AdapterSearch adapter;

    public MiniSearchViewHolder(View _view){
        super(_view);
        view = _view;
    }
    public void SetDetails(final MiniSearchData model, String showText, String switchText) {
        EditText text = view.findViewById(R.id.TextInput);
        text.setHint(showText);

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                model.getSearchCalledListener().onSearchCalled(s.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final RecyclerView recyclerView = view.findViewById(R.id.RecyclerView);
        final ConstraintLayout Constraint1 = view.findViewById(R.id.Constraint1);
        final ConstraintLayout Constraint2 = view.findViewById(R.id.Constraint2);

        Switch sw = view.findViewById(R.id.Swtich);

        if (model.isAllowSwitch()) {
            sw.setText(switchText);
            sw.setEnabled(true);
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        recyclerView.setVisibility(View.GONE);
                        Constraint1.setVisibility(View.GONE);
                        Constraint2.setVisibility(View.GONE);
                        model.setEnabled(false);
                    } else {
                        recyclerView.setVisibility(View.VISIBLE);
                        Constraint1.setVisibility(View.VISIBLE);
                        Constraint2.setVisibility(View.VISIBLE);
                        model.setEnabled(true);
                    }
                }
            });
        }else{
            sw.setVisibility(View.GONE);
        }


        FloatingActionButton addButton = view.findViewById(R.id.AddButton);
        final LinearLayout linear1 = view.findViewById(R.id.Linear1);

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                UniData selected = model.clickedAddButton();
                if (selected != null){

                }
            }
        });



    }
}
