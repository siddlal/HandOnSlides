package com.example.slide;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] first_images = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4
    };
    //list of  titles
    public String[] first_titles ={
            "COSMONAUT",
            "SATELITE",
            "GALAXY",
            "ROCKET"
    };
    // list of descriptions
    public String[] first_description ={
            "An astronaut or cosmonaut is a person trained by a human spaceflight program to command, pilot, or serve as a crew member of a spacecraft.",
            " a satellite is an object that has been intentionally placed into orbit ",
            "A galaxy is a gravitationally bound system of stars, stellar remnants, interstellar gas, dust, and dark matter.",
            "A rocket is a missile, spacecraft, aircraft or other vehicle that obtains thrust from a rocket engine",

    };



    //list of backgroundcolors
    public  int[] first_backgroudcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };

    public SlideAdapter(Context context) {
        this.context = context;
    }







    @Override
    public int getCount() {
        return first_titles.length;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = view.findViewById(R.id.slidelinearlayout);
        ImageView imageslide = (ImageView) view.findViewById(R.id.slideimage);
        TextView texttitle = (TextView) view.findViewById(R.id.texttitle);
        TextView desription = (TextView) view.findViewById(R.id.txtdescription);

        layoutslide.setBackgroundColor(first_backgroudcolor[position]);
        imageslide.setImageResource(first_images[position]);
        texttitle.setText(first_titles[position]);
        desription.setText(first_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view,Object object) {
        return (view ==(LinearLayout)object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position,Object object) {
    container.removeView((LinearLayout)object);
    }
}
