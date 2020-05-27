package com.example.android.newsfeed;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each earthquake
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    private int mColorResourceId;

    /**
     * The part of the location string from the USGS service that we use to determine
     * whether or not there is a location offset present ("5km N of Cairo, Egypt").
     */
    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news is the list of news, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the earthquake at the given position
     * in the list of earthquakes.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentNews = (News) getItem(position);

        if (currentNews != null) {

            // Find the ImageView in the list_item.xml layout with the ID
            ImageView placeImage = (ImageView) listItemView.findViewById(R.id.img_newspic);
            // Get the news image from the current News and set this image on the imageView
            if (currentNews.getThumbnail() != null) {
                placeImage.setVisibility(View.VISIBLE);
            } else {
                placeImage.setVisibility(View.GONE);
            }
        }

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView headerTextView = (TextView) listItemView.findViewById(R.id.tv_header);
        // Get the news header from the current News object and
        // set this text on the header TextView
        headerTextView.setText(currentNews.getNewsHeader());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView bodyTextView = (TextView) listItemView.findViewById(R.id.tv_body);
        // Get the news body from the current News object and
        // set this text on the body TextView
        bodyTextView.setText(currentNews.getNewsBody());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.tv_section);
        // Get the Section from the current News object and
        // set this text on the Section TextView
        sectionTextView.setText(currentNews.getSection());
        // Set the theme color for the news section text
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        sectionTextView.setTextColor(color);


        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentNews.getTimeInMilliseconds());


        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.tv_date_time);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the color for the magnitude circle based on the intensity of the earthquake.
     *
     * @param sectionName of the news
     */
    private int getSectionName(String sectionName) {
        int sectionColorResourceId;
        switch (sectionName) {
            case "UK news":
                sectionColorResourceId = R.color.section_uk;
                break;
            case "Opinion":
                sectionColorResourceId = R.color.section_opinion;
                break;
            case "Music":
                sectionColorResourceId = R.color.section_music;
                break;
            case "Business":
                sectionColorResourceId = R.color.section_business;
                break;
            case "World news":
                sectionColorResourceId = R.color.section_world;
                break;
            case "US news":
                sectionColorResourceId = R.color.section_us;
                break;
            case "Politics":
                sectionColorResourceId = R.color.section_politics;
                break;
            default:
                sectionColorResourceId = R.color.text_color;
                break;
        }

        return ContextCompat.getColor(getContext(), sectionColorResourceId);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984, 4:30 PM") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy, h:mm a");
        return dateFormat.format(dateObject);
    }
}