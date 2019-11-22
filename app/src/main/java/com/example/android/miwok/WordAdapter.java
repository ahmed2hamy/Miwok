package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {


    private int mColorResourceId;


    WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);
        TextView miwokTextView = listItemView.findViewById(R.id.miwokWord);

        if (currentWord != null) {
            miwokTextView.setText(currentWord.getMiwokTranslation());
        }

        TextView defaultTextView = listItemView.findViewById(R.id.englishWord);
        if (currentWord != null) {
            defaultTextView.setText(currentWord.getDefaultTranslation());
        }


        ImageView imageView = listItemView.findViewById(R.id.image);
        if (currentWord != null) {
            if (currentWord.hasImage()) {
                imageView.setImageResource(currentWord.getImageResourceId());
                imageView.setVisibility(View.VISIBLE);
            } else {
                imageView.setVisibility(View.GONE);
            }
        }
        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}