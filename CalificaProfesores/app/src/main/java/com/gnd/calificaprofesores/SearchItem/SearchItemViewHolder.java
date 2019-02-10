package com.gnd.calificaprofesores.SearchItem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gnd.calificaprofesores.R;

/** Aqui administramos la parte gráfica de un comentario **/

public class SearchItemViewHolder extends RecyclerView.ViewHolder{
    View mView;

    public SearchItemViewHolder(View _mView){
        super(_mView);
        mView = _mView;
    }

    public void setDetails(String name, String details, Long score){
        TextView mAuthorText = mView.findViewById(R.id.Title);
        TextView mCommentText = mView.findViewById(R.id.Detail);
        RatingBar mScore = mView.findViewById(R.id.ratingBar);

        mAuthorText.setText(name);

        mCommentText.setText(details);
        mScore.setRating( score.floatValue() / 2f);
    }

}
